package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R
import com.example.comida.dummy.foodItems.burgersCategory
import java.util.UUID

data class Restaurant(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String,
    val isFreeDelivery: Boolean,
    val deliveryTime: Double,
    val isFavorites: Boolean,
    val ratingValue: Double,
    val category: String,
    val availableFoods: List<FoodItem>,
    val reviews: RestaurantReviews,
    @DrawableRes val image: Int,
)


val restaurants = listOf<Restaurant>(
    Restaurant(
        name = "Seafood maki sushi",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = "",
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = R.drawable.sushi_image,
        availableFoods = burgersCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Seafood maki sushi",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = "",
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = R.drawable.seafood_dish_image,
        availableFoods = burgersCategory,
        reviews = RestaurantReviews()
    ),
)