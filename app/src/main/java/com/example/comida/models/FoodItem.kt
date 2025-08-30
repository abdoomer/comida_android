package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R


data class FoodItem(
    val id: String,
    val categoryID: String,
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
    val price: Double,
    val ratingValue: Double,
    var totalPrice: Double,
    var discountPercentage: Double,
    var discountAmount: Double,
    var weight: Double,
    val isFreeDelivery: Boolean,
    val deliveryTime: Double,
    val deliveryFees: Double,
    val isFavorites: Boolean,
    var addOns: List<FoodAddOn>
)


val foodItems = listOf<FoodItem>(
    FoodItem(
        id = "0",
        categoryID = "0",
        title = "Food 1",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin a vulputate diam. Morbi vel lorem non nisi egestas iaculis eu at quam. Aliquam ullamcorper, nulla eu vulputate congue, felis felis blandit ligula, ut posuere erat justo et nibh. In suscipit lorem tincidunt, ultricies ante et, iaculis neque. Donec tortor erat, porta imperdiet ultrices vitae, rutrum quis nunc. Donec ipsum neque, condimentum sed feugiat fermentum, cursus id est. Aenean fermentum tortor et nisi convallis, et efficitur nunc faucibus. In dictum sapien quis vestibulum auctor. Proin et dapibus sem. Vivamus et ex non purus accumsan ornare ultricies ut lacus.",
        price = 5.0,
        ratingValue = 1.0,
        totalPrice = 0.0,
        deliveryTime = 3.0,
        deliveryFees = 7.0,
        isFavorites = false,
        isFreeDelivery = true,
        discountAmount = 5.0,
        weight = 3.1,
        addOns = foodAddOns,
        discountPercentage = 10.0,
        image = R.drawable.burger_menu_image
    ),
    FoodItem(
        id = "1",
        categoryID = "0",
        title = "Food 2",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin a vulputate diam. Morbi vel lorem non nisi egestas iaculis eu at quam. Aliquam ullamcorper, nulla eu vulputate congue, felis felis blandit ligula, ut posuere erat justo et nibh. In suscipit lorem tincidunt, ultricies ante et, iaculis neque. Donec tortor erat, porta imperdiet ultrices vitae, rutrum quis nunc. Donec ipsum neque, condimentum sed feugiat fermentum, cursus id est. Aenean fermentum tortor et nisi convallis, et efficitur nunc faucibus. In dictum sapien quis vestibulum auctor. Proin et dapibus sem. Vivamus et ex non purus accumsan ornare ultricies ut lacus.",
        price = 20.5,
        ratingValue = 4.2,
        totalPrice = 0.0,
        deliveryTime = 15.0,
        deliveryFees = 5.0,
        isFavorites = false,
        isFreeDelivery = false,
        discountAmount = 3.0,
        weight = 2.0,
        addOns = foodAddOns,
        discountPercentage = 10.0,
        image = R.drawable.burger_menu_image
    ),
    FoodItem(
        id = "1",
        categoryID = "0",
        title = "Food 3",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin a vulputate diam. Morbi vel lorem non nisi egestas iaculis eu at quam. Aliquam ullamcorper, nulla eu vulputate congue, felis felis blandit ligula, ut posuere erat justo et nibh. In suscipit lorem tincidunt, ultricies ante et, iaculis neque. Donec tortor erat, porta imperdiet ultrices vitae, rutrum quis nunc. Donec ipsum neque, condimentum sed feugiat fermentum, cursus id est. Aenean fermentum tortor et nisi convallis, et efficitur nunc faucibus. In dictum sapien quis vestibulum auctor. Proin et dapibus sem. Vivamus et ex non purus accumsan ornare ultricies ut lacus.",
        price = 12.05,
        ratingValue = 3.5,
        totalPrice = 12.05,
        deliveryTime = 5.0,
        deliveryFees = 9.0,
        isFavorites = false,
        isFreeDelivery = false,
        discountAmount = 5.0,
        weight = 1.2,
        addOns = foodAddOns,
        discountPercentage = 10.0,
        image = R.drawable.burger_menu_image
    ),
)
