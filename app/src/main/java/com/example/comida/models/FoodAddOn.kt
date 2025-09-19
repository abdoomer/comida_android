package com.example.comida.models

import java.util.UUID


data class FoodAddOn(
    val id: String = UUID.randomUUID().toString(),
    val title: String = "",
    var isAdded: Boolean = false,
    val price: Double = 0.0,
    val image: String = "",
)











