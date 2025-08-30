package com.example.comida.models

import androidx.annotation.DrawableRes


data class FoodAddOn(
    val title: String,
    var isAdded: Boolean,
    val price: Double,
    @DrawableRes val image: Int
)


val foodAddOns = listOf<FoodAddOn>()