package com.example.comida.domain.dao

import com.example.comida.models.cart.CartItem

interface CartDao {

    fun fetchDummyCartItem()

    fun getCartItems(): List<CartItem>
}