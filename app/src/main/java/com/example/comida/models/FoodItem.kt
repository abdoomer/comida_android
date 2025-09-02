package com.example.comida.models


import java.util.UUID


data class FoodItem(
    val id: String = UUID.randomUUID().toString(),
    val categoryID: String = "",
    val title: String = "",
    val description: String = "",
    val image: String = "",
    val price: Double = 0.0,
    val ratingValue: Double = 0.0,
    var discountPercentage: Double = 0.0,
    var weight: Double = 0.0,
    val isFreeDelivery: Boolean = false,
    val deliveryTime: Double = 0.0,
    val deliveryFees: Double = 0.0,
    val isFavorites: Boolean = false,
    val restaurant: Restaurant? = null,
    var addOns: List<FoodAddOn> = emptyList<FoodAddOn>()
)


val foodItems = listOf<FoodItem>(
    FoodItem(
        categoryID = "0",
        title = "Food 1",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin a vulputate diam. Morbi vel lorem non nisi egestas iaculis eu at quam. Aliquam ullamcorper, nulla eu vulputate congue, felis felis blandit ligula, ut posuere erat justo et nibh. In suscipit lorem tincidunt, ultricies ante et, iaculis neque. Donec tortor erat, porta imperdiet ultrices vitae, rutrum quis nunc. Donec ipsum neque, condimentum sed feugiat fermentum, cursus id est. Aenean fermentum tortor et nisi convallis, et efficitur nunc faucibus. In dictum sapien quis vestibulum auctor. Proin et dapibus sem. Vivamus et ex non purus accumsan ornare ultricies ut lacus.",
        price = 5.0,
        ratingValue = 1.0,
        deliveryTime = 3.0,
        deliveryFees = 7.0,
        isFavorites = false,
        isFreeDelivery = true,
        weight = 3.1,
        addOns = emptyList(),
        discountPercentage = 10.0,
        image = ""
    ),
    FoodItem(
        categoryID = "0",
        title = "Food 2",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin a vulputate diam. Morbi vel lorem non nisi egestas iaculis eu at quam. Aliquam ullamcorper, nulla eu vulputate congue, felis felis blandit ligula, ut posuere erat justo et nibh. In suscipit lorem tincidunt, ultricies ante et, iaculis neque. Donec tortor erat, porta imperdiet ultrices vitae, rutrum quis nunc. Donec ipsum neque, condimentum sed feugiat fermentum, cursus id est. Aenean fermentum tortor et nisi convallis, et efficitur nunc faucibus. In dictum sapien quis vestibulum auctor. Proin et dapibus sem. Vivamus et ex non purus accumsan ornare ultricies ut lacus.",
        price = 20.5,
        ratingValue = 4.2,
        deliveryTime = 15.0,
        deliveryFees = 5.0,
        isFavorites = false,
        isFreeDelivery = false,
        weight = 2.0,
        addOns = emptyList(),
        discountPercentage = 10.0,
        image = ""
    ),
    FoodItem(
        categoryID = "0",
        title = "Food 3",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin a vulputate diam. Morbi vel lorem non nisi egestas iaculis eu at quam. Aliquam ullamcorper, nulla eu vulputate congue, felis felis blandit ligula, ut posuere erat justo et nibh. In suscipit lorem tincidunt, ultricies ante et, iaculis neque. Donec tortor erat, porta imperdiet ultrices vitae, rutrum quis nunc. Donec ipsum neque, condimentum sed feugiat fermentum, cursus id est. Aenean fermentum tortor et nisi convallis, et efficitur nunc faucibus. In dictum sapien quis vestibulum auctor. Proin et dapibus sem. Vivamus et ex non purus accumsan ornare ultricies ut lacus.",
        price = 12.05,
        ratingValue = 3.5,
        deliveryTime = 5.0,
        deliveryFees = 9.0,
        isFavorites = false,
        isFreeDelivery = false,
        weight = 1.2,
        addOns = emptyList(),
        discountPercentage = 10.0,
        image = ""
    ),
)
