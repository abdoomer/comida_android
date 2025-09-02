package com.example.comida.domain.usecase

import android.util.Log
import com.example.comida.models.FoodCategory
import com.example.comida.models.ResourceResult
import com.example.comida.models.foodCategories
import jakarta.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


@Singleton
class FoodUseCase @Inject constructor() {
    operator fun invoke(): Flow<ResourceResult<List<FoodCategory>>> =
        flow{
            emit(ResourceResult.Loading)

            try {
                emit(ResourceResult.Success(foodCategories))

                Log.d("FoodUseCase", "fetching food categories success")

            } catch (e: Exception){
                emit(ResourceResult.Error(e))

                Log.d("FoodUseCase", "fetching food categories error, " + e.toString())

            }

        }.flowOn(Dispatchers.IO)
}