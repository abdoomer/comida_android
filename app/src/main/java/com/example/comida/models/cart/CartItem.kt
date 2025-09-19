package com.example.comida.models.cart

import androidx.annotation.DrawableRes
import java.util.UUID

data class CartItem(
    val name: String = "",
    val id: String = UUID.randomUUID().toString(),
    val totalPrice: Double = 0.0,
    val quantity: Int = 0,
    val discountPercentage: Double = 0.0,
    @DrawableRes val image: Int = 0
)