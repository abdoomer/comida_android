package com.example.comida.domain.usecase

import android.util.Log
import com.example.comida.models.CartItem
import com.example.comida.models.ResourceResult
import com.example.comida.models.cartItems
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CartUseCase @Inject constructor() {

    operator fun invoke(): Flow<ResourceResult<List<CartItem>>> =
        flow {

            emit(ResourceResult.Loading)

            try {
                emit(ResourceResult.Success(cartItems))

                Log.d("CartUseCase", "fetching cart items success")

            } catch (e: Exception) {
                emit(ResourceResult.Error(e))

                Log.d("CartUseCase", "fetching cart items error, " + e.toString())

            }
        }.flowOn(Dispatchers.IO)
}