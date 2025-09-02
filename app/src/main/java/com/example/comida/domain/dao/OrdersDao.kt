package com.example.comida.domain.dao

import com.example.comida.models.OrderItem


interface OrdersDao {

    fun fetchDummyOrders()

    fun getAllOrders(): List<OrderItem>

    fun setSelectedOrder(newOrder: OrderItem)

    fun getSelectedOrder(): OrderItem
}