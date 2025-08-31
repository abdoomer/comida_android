package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R
import com.example.comida.dummy.burgersCategory
import com.example.comida.dummy.donutsCategory
import com.example.comida.dummy.hotDogCategory
import com.example.comida.dummy.pastaCategory
import com.example.comida.dummy.pizzaCategory
import java.util.UUID

data class FoodCategory(
    val categoryID: String = UUID.randomUUID().toString(),
    val title: String,
    val foodItems: List<FoodItem>,
    @DrawableRes val image: Int
)


val foodCategories = listOf<FoodCategory>(
    FoodCategory(
        title = "Burger",
        image = R.drawable.burger_menu_image,
        foodItems = burgersCategory
    ),
    FoodCategory(
        title = "Donuts",
        image = R.drawable.donats_menu_image,
        foodItems = donutsCategory
    ),
    FoodCategory(
        title = "Pizza",
        image = R.drawable.pizza_slice_menu_image,
        foodItems = pizzaCategory
    ),
    FoodCategory(
        title = "HotDog",
        image = R.drawable.hotdog_menu_image,
        foodItems = hotDogCategory
    ),
    FoodCategory(
        title = "Pasta",
        image = R.drawable.pasta_menu_image,
        foodItems = pastaCategory
    ),
)
