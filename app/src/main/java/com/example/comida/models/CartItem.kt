package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R


data class CartItem(
    val name: String = "",
    val itemID: String = "",
    val totalPrice: Double = 0.0,
    val quantity: Int = 0,
    val discountPercentage: Double = 0.0,
    @DrawableRes val image: Int = 0
)