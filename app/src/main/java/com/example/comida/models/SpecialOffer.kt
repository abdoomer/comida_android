package com.example.comida.models

import androidx.compose.ui.graphics.Color


data class SpecialOffer(
    val title: String = "",
    val restaurantName: String = "",
    val restaurant: Restaurant = Restaurant(),
    val ratingValue: Double = 0.0,
    val isFreeDelivery: Boolean = false,
    val price: Double = 0.0,
    val backgroundColor: Color = Color.White,
    val offerImage: String = "",
    val description: String = "",
    val deliveryTime: Double = 0.0,
    )

