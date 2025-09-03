package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R
import com.example.comida.dummy.foodItems.burgersCategory
import java.util.UUID

data class Restaurant(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "",
    val category: RestaurantCategory = RestaurantCategory.Burger,
    val description: String = "",
    val isFreeDelivery: Boolean = false,
    val deliveryTime: Double = 0.0,
    val isFavorites: Boolean = false,
    val ratingValue: Double = 0.0,
    val availableFoods: List<FoodItem> = emptyList<FoodItem>(),
    val reviews: RestaurantReviews = RestaurantReviews(),
    val image: String = "",
)