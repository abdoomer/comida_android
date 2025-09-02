package com.example.comida.domain.usecase

import android.util.Log
import com.example.comida.models.ResourceResult
import com.example.comida.models.SpecialOffer
import com.example.comida.models.specialOffers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SpecialOffersUseCase @Inject constructor() {

    operator fun invoke(): Flow<ResourceResult<List<SpecialOffer>>> =
        flow {

            emit(ResourceResult.Loading)

            try {
                emit(ResourceResult.Success(specialOffers))

                Log.d("SpecialOffersUseCase", "fetching special offers success")

            } catch (e: Exception){
                emit(ResourceResult.Error(e))

                Log.d("SpecialOffersUseCase", "fetching special offers error, " + e.toString())

            }

        }.flowOn(Dispatchers.IO)
}