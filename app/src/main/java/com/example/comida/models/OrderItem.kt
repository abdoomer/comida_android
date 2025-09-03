package com.example.comida.models

import java.util.UUID


data class OrderItem(
    val id: String = UUID.randomUUID().toString(),
    val restaurant: Restaurant = Restaurant(),
    val orderItems: List<FoodItem> = emptyList<FoodItem>(),
    val itemsCount: Int = 0,
    val date: String = "",
)