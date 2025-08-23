package com.example.comida.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.comida.R
import com.example.comida.ui.theme.OnboardingBackgroundColor2
import com.example.comida.ui.theme.PrimaryButtonColor


data class SpecialOffer(
    val title: String,
    val ratingValue: Double,
    val isFreeDelivery: Boolean,
    val price: Double,
    val backgroundColor: Color,
    @DrawableRes val offerImage: Int
    )


val specialOffers = listOf<SpecialOffer>(
    SpecialOffer(
        title = "Burger King",
        ratingValue = 4.5,
        isFreeDelivery = true,
        price = 22.00,
        offerImage = R.drawable.fresh_beef_burger,
        backgroundColor = PrimaryButtonColor
    ),
    SpecialOffer(
        title = "McDonald’s",
        ratingValue = 4.5,
        isFreeDelivery = true,
        price = 22.00,
        offerImage = R.drawable.pizza_image,
        backgroundColor = OnboardingBackgroundColor2
    ),
)