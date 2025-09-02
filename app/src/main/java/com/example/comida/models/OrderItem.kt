package com.example.comida.models

import java.util.UUID


data class OrderItem(
    val id: String = UUID.randomUUID().toString(),
    val restaurant: Restaurant = Restaurant(),
    val orderItems: List<FoodItem> = emptyList<FoodItem>(),
    val itemsCount: Int = 0,
    val date: String = "",
)


var orders = listOf<OrderItem>(
    OrderItem(
        restaurant = restaurants[0],
        orderItems = restaurants[0].availableFoods,
        itemsCount = restaurants[0].availableFoods.size,
        date = "Dec 16, 2025"
    ),
    OrderItem(
        restaurant = restaurants[1],
        orderItems = restaurants[1].availableFoods,
        itemsCount = restaurants[1].availableFoods.size,
        date = "Dec 16, 2025"
    ),
    OrderItem(
        restaurant = restaurants[0],
        orderItems = restaurants[0].availableFoods,
        itemsCount = restaurants[0].availableFoods.size,
        date = "Dec 16, 2025"
    )
)