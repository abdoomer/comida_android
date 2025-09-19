package com.example.comida.domain.dao

import com.example.comida.models.orders.OrderItem


interface OrdersDao {

    fun fetchDummyOrders()

    fun getAllOrders(): List<OrderItem>

    fun getOrder(id: String): OrderItem
}