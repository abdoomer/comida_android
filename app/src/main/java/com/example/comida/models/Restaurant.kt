package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R

data class Restaurant(
    val name: String,
    val isFreeDelivery: Boolean,
    val deliveryTime: Double,
    val isFavorites: Boolean,
    val ratingValue: Double,
    @DrawableRes val image: Int
)


val restaurants = listOf<Restaurant>(
    Restaurant(
        name = "Seafood maki sushi",
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = R.drawable.sushi_image
    ),
    Restaurant(
        name = "Seafood maki sushi",
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = R.drawable.seafood_dish_image
    ),
)