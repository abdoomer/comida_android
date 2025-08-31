package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R
import com.example.comida.dummy.burgersCategory
import com.example.comida.dummy.donutsCategory
import com.example.comida.dummy.hotDogCategory
import com.example.comida.dummy.pastaCategory
import com.example.comida.dummy.pizzaCategory

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
        foodItems = burgersCategory
    ),
    FoodCategory(
        categoryID = "2",
        title = "Donuts",
        image = R.drawable.donats_menu_image,
        foodItems = donutsCategory
    ),
    FoodCategory(
        categoryID = "3",
        title = "Pizza",
        image = R.drawable.pizza_slice_menu_image,
        foodItems = pizzaCategory
    ),
    FoodCategory(
        categoryID = "4",
        title = "Hot Dog",
        image = R.drawable.hotdog_menu_image,
        foodItems = hotDogCategory
    ),
    FoodCategory(
        categoryID = "5",
        title = "Pasta",
        image = R.drawable.pasta_menu_image,
        foodItems = pastaCategory
    ),
)
