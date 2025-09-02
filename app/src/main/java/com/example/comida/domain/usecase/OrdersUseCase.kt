package com.example.comida.domain.usecase

import android.util.Log
import com.example.comida.models.OrderItem
import com.example.comida.models.ResourceResult
import com.example.comida.models.orders
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class OrdersUseCase @Inject constructor() {

    operator fun invoke(): Flow<ResourceResult<List<OrderItem>>> =
        flow {
            emit(ResourceResult.Loading)

            try {
                emit(ResourceResult.Success(orders))

                Log.d("OrdersUseCase", "fetching orders success")

            } catch (e: Exception) {
                emit(ResourceResult.Error(e))

                Log.d("OrdersUseCase", "fetching orders error, " + e.toString())

            }

        }.flowOn(Dispatchers.IO)
}