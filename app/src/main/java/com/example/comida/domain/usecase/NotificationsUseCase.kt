package com.example.comida.domain.usecase

import android.util.Log
import com.example.comida.models.AppNotification
import com.example.comida.models.ResourceResult
import com.example.comida.models.appNotifications
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationsUseCase @Inject constructor() {

    operator fun invoke(): Flow<ResourceResult<List<AppNotification>>> =
        flow {

            emit(ResourceResult.Loading)

            try {
                emit(ResourceResult.Success(appNotifications))

                Log.d("NotificationsUseCase", "fetching app notifications success")

            } catch (e: Exception) {
                emit(ResourceResult.Error(e))

                Log.d("NotificationsUseCase", "fetching app notifications error, " + e.toString())

            }

        }.flowOn(Dispatchers.IO)
}