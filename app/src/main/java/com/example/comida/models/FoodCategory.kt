package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R

data class FoodCategory(
    val title: String,
    @DrawableRes val image: Int
)


val foodCategories = listOf<FoodCategory>(
    FoodCategory(
        title = "Burger",
        image = R.drawable.burger_menu_image
    ),
    FoodCategory(
        title = "Donats",
        image = R.drawable.donats_menu_image
    ),
    FoodCategory(
        title = "Pizza",
        image = R.drawable.pizza_slice_menu_image
    ),
    FoodCategory(
        title = "Hot Dog",
        image = R.drawable.hotdog_menu_image
    ),
    FoodCategory(
        title = "Pasta",
        image = R.drawable.pasta_menu_image
    ),
)
