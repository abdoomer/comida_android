package com.example.comida.domain.repository

import com.example.comida.domain.dao.OrdersDao
import com.example.comida.domain.usecase.OrdersUseCase
import com.example.comida.models.OrderItem
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class OrdersRepository @Inject constructor(
    private val ordersUseCase: OrdersUseCase
): OrdersDao {
    override fun fetchOrdersHistory(): List<OrderItem> {
        TODO("Not yet implemented")
    }

    override fun fetchOrder(id: String): OrderItem {
        TODO("Not yet implemented")
    }
}