package com.example.comida.domain.dao

import com.example.comida.models.OrderItem


interface OrdersDao {

    fun fetchOrdersHistory() : List<OrderItem>

    fun fetchOrder(id: String) : OrderItem
}