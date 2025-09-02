package com.example.comida.domain.usecase

import android.util.Log
import com.example.comida.models.OrderPayment
import com.example.comida.models.ResourceResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PaymentUseCase @Inject constructor() {

    operator fun invoke(): Flow<ResourceResult<List<OrderPayment>>> =
        flow {

            emit(ResourceResult.Loading)

            try {

                Log.d("PaymentUseCase", "fetching payments success")

            } catch (e: Exception) {
                emit(ResourceResult.Error(e))

                Log.d("PaymentUseCase", "fetching payments error, " + e.toString())

            }

        }.flowOn(Dispatchers.IO)
}