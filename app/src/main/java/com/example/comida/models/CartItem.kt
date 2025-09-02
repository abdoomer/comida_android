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


val cartItems = listOf<CartItem>(
    CartItem(
        name = "Pizza margarita European ",
        itemID = "",
        totalPrice = 50.0,
        quantity = 2,
        discountPercentage = 15.5,
        image = R.drawable.pizza_margarita
    ),
    CartItem(
        name = "Spaghetti with shrimp and basil",
        itemID = "",
        totalPrice = 50.0,
        quantity = 1,
        discountPercentage = 15.5,
        image = R.drawable.spaghetti
    ),
    CartItem(
        name = "Burger King",
        itemID = "",
        totalPrice = 50.0,
        quantity = 3,
        discountPercentage = 15.5,
        image = R.drawable.fresh_beef_burger
    ),
)