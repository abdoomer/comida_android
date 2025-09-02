package com.example.comida.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.comida.R
import com.example.comida.ui.theme.OnboardingBackgroundColor2
import com.example.comida.ui.theme.PrimaryButtonColor


data class SpecialOffer(
    val title: String = "",
    val ratingValue: Double = 0.0,
    val isFreeDelivery: Boolean = false,
    val price: Double = 0.0,
    val backgroundColor: Color = Color.White,
    @DrawableRes val offerImage: Int = 0,
    val description: String = "",
    val deliveryTime: Double = 0.0,
    )


val specialOffers = listOf<SpecialOffer>(
    SpecialOffer(
        title = "Burger King",
        ratingValue = 4.5,
        isFreeDelivery = true,
        price = 22.00,
        offerImage = R.drawable.fresh_beef_burger,
        backgroundColor = PrimaryButtonColor,
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin a vulputate diam. Morbi vel lorem non nisi egestas iaculis eu at quam. Aliquam ullamcorper, nulla eu vulputate congue, felis felis blandit ligula, ut posuere erat justo et nibh. In suscipit lorem tincidunt, ultricies ante et, iaculis neque. Donec tortor erat, porta imperdiet ultrices vitae, rutrum quis nunc. Donec ipsum neque, condimentum sed feugiat fermentum, cursus id est. Aenean fermentum tortor et nisi convallis, et efficitur nunc faucibus. In dictum sapien quis vestibulum auctor. Proin et dapibus sem. Vivamus et ex non purus accumsan ornare ultricies ut lacus.",
        deliveryTime = 45.0,
        ),
    SpecialOffer(
        title = "McDonald’s",
        ratingValue = 4.5,
        isFreeDelivery = true,
        price = 22.00,
        offerImage = R.drawable.pizza_image,
        backgroundColor = OnboardingBackgroundColor2,
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin a vulputate diam. Morbi vel lorem non nisi egestas iaculis eu at quam. Aliquam ullamcorper, nulla eu vulputate congue, felis felis blandit ligula, ut posuere erat justo et nibh. In suscipit lorem tincidunt, ultricies ante et, iaculis neque. Donec tortor erat, porta imperdiet ultrices vitae, rutrum quis nunc. Donec ipsum neque, condimentum sed feugiat fermentum, cursus id est. Aenean fermentum tortor et nisi convallis, et efficitur nunc faucibus. In dictum sapien quis vestibulum auctor. Proin et dapibus sem. Vivamus et ex non purus accumsan ornare ultricies ut lacus.",
        deliveryTime = 45.0,
        ),
)