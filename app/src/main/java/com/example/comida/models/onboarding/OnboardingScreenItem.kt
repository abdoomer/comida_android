package com.example.comida.models.onboarding


import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.comida.R
import com.example.comida.ui.theme.OnboardingBackgroundColor1
import com.example.comida.ui.theme.OnboardingBackgroundColor2
import com.example.comida.ui.theme.OnboardingBackgroundColor3
import com.example.comida.ui.theme.PrimaryTextColor


data class OnboardingScreenItem(
    val id: Int = 0,
    val descriptionText: String = "",
    val descriptionTextColor: Color = PrimaryTextColor,
    val imageTopRight: Boolean = true,
    val imageWidth: Dp = 0.dp,
    val imageHeight: Dp = 0.dp,
    val backgroundColor: Color = Color.White,
    val displayImageYOffset: Dp = 0.dp,
    val descriptionTextYOffset: Dp = 0.dp,
    @DrawableRes val backgroundImage: Int = 0,
    @DrawableRes val displayImage: Int = 0
)


val onboardingScreenItems = listOf<OnboardingScreenItem>(
    OnboardingScreenItem(
        id = 1,
        descriptionText = "I don't feel like\n cooking. Let's\n order food\n delivery.",
        backgroundImage = R.drawable.onboarding_screen_background_1,
        displayImage = R.drawable.onboarding_screen_image_1,
        imageWidth = 763.66.dp,
        imageHeight = 763.66.dp,
        backgroundColor = OnboardingBackgroundColor1,
        displayImageYOffset = (-150).dp,
        descriptionTextYOffset = (-170).dp,
    ),
    OnboardingScreenItem(
        id = 2,
        descriptionText = "Donut worry, be happy and eat more donuts!",
        backgroundImage = R.drawable.onboarding_screen_background_2,
        displayImage = R.drawable.onboarding_screen_image_2,
        descriptionTextColor = Color.White,
        imageTopRight = false,
        imageWidth = 1023.35.dp,
        imageHeight = 585.22.dp,
        backgroundColor = OnboardingBackgroundColor2,
        displayImageYOffset = 150.dp,
        descriptionTextYOffset = 90.dp,
    ),
    OnboardingScreenItem(
        id = 3,
        descriptionText = "Good music and good food makes me happy.",
        backgroundImage = R.drawable.onboarding_screen_background_3,
        displayImage = R.drawable.onboarding_screen_image_3,
        imageWidth = 641.dp,
        imageHeight = 618.dp,
        backgroundColor = OnboardingBackgroundColor3,
        displayImageYOffset = (-150).dp,
        descriptionTextYOffset = (-170).dp,
    ),
)
