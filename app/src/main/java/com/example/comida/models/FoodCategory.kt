package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R

data class FoodCategory(
    val categoryID: String,
    val title: String,
    val foodItems: List<FoodItem>,
    @DrawableRes val image: Int
)


val foodCategories = listOf<FoodCategory>(
    FoodCategory(
        categoryID = "1",
        title = "Burger",
        image = R.drawable.burger_menu_image,
        foodItems = emptyList<FoodItem>()
    ),
    FoodCategory(
        categoryID = "2",
        title = "Donats",
        image = R.drawable.donats_menu_image,
        foodItems = emptyList<FoodItem>()
    ),
    FoodCategory(
        categoryID = "3",
        title = "Pizza",
        image = R.drawable.pizza_slice_menu_image,
        foodItems = emptyList<FoodItem>()
    ),
    FoodCategory(
        categoryID = "4",
        title = "Hot Dog",
        image = R.drawable.hotdog_menu_image,
        foodItems = emptyList<FoodItem>()
    ),
    FoodCategory(
        categoryID = "5",
        title = "Pasta",
        image = R.drawable.pasta_menu_image,
        foodItems = emptyList<FoodItem>()
    ),
)
