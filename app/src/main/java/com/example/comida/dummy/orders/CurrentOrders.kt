package com.example.comida.dummy.orders

import com.example.comida.dummy.restaurants.availableRestaurants
import com.example.comida.models.OrderItem


val currentOrders = listOf<OrderItem>(
    OrderItem(
        restaurant = availableRestaurants[0],
        orderItems = availableRestaurants[0].availableFoods,
        itemsCount = availableRestaurants[0].availableFoods.size,
        date = "Dec 16, 2025"
    ),
    OrderItem(
        restaurant = availableRestaurants[1],
        orderItems = availableRestaurants[1].availableFoods,
        itemsCount = availableRestaurants[1].availableFoods.size,
        date = "Dec 16, 2025"
    ),
    OrderItem(
        restaurant = availableRestaurants[0],
        orderItems = availableRestaurants[0].availableFoods,
        itemsCount = availableRestaurants[0].availableFoods.size,
        date = "Dec 16, 2025"
    )
)