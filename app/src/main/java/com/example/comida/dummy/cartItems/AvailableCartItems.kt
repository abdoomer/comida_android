package com.example.comida.dummy.cartItems

import com.example.comida.R
import com.example.comida.models.cart.CartItem


val availableCartItems = listOf<CartItem>(
    CartItem(
        name = "Pizza margarita European ",
        totalPrice = 50.0,
        quantity = 2,
        discountPercentage = 15.5,
        image = R.drawable.pizza_margarita
    ),
    CartItem(
        name = "Spaghetti with shrimp and basil",
        totalPrice = 50.0,
        quantity = 1,
        discountPercentage = 15.5,
        image = R.drawable.spaghetti
    ),
    CartItem(
        name = "Burger King",
        totalPrice = 50.0,
        quantity = 3,
        discountPercentage = 15.5,
        image = R.drawable.fresh_beef_burger
    ),
)