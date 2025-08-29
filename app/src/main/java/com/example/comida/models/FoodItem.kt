package com.example.comida.models



data class FoodItem(
    val id: String,
    val title: String,
    val description: String,
    val price: Double,
    val ratingValue: Double,
    var totalPrice: Double,
    val isFreeDelivery: Boolean,
    val deliveryTime: Double,
    val deliveryFees: Double,
    val isFavorites: Boolean,
    var addOns: List<FoodAddOn>
)
