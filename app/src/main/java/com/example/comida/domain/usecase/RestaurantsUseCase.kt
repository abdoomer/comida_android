package com.example.comida.domain.usecase

import android.util.Log
import com.example.comida.dummy.restaurants.availableRestaurants
import com.example.comida.models.ResourceResult
import com.example.comida.models.Restaurant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RestaurantsUseCase @Inject constructor() {
    operator fun invoke(): Flow<ResourceResult<List<Restaurant>>> =
        flow {
            emit(ResourceResult.Loading)

            try {
                emit(ResourceResult.Success(availableRestaurants))

                Log.d("RestaurantsUseCase", "fetching restaurants success")

            } catch (e: Exception){
                emit(ResourceResult.Error(e))

                Log.d("RestaurantsUseCase", "fetching restaurants error, " + e.toString())

            }

        }.flowOn(Dispatchers.IO)
}