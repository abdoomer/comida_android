package com.example.comida.models.orders

import com.example.comida.models.FoodItem
import com.example.comida.models.Restaurant
import java.util.UUID

data class OrderItem(
    val id: String = UUID.randomUUID().toString(),
    val restaurant: Restaurant = Restaurant(),
    val orderItems: List<FoodItem> = emptyList<FoodItem>(),
    val itemsCount: Int = 0,
    val date: String = "",
)