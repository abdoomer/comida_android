package com.example.comida.models

import androidx.compose.ui.graphics.Color
import com.example.comida.ui.theme.OnboardingLightButtonColor
import com.example.comida.ui.theme.PrimaryTextColor


data class OnboardingScreenButton(
    val id: Int,
    val text: String,
    val backgroundColor: Color
)


val onboardingScreenButtons = listOf<OnboardingScreenButton>(
    OnboardingScreenButton(
        id = 1,
        text = "Sign Up",
        backgroundColor = OnboardingLightButtonColor
    ),
    OnboardingScreenButton(
        id = 1,
        text = "Log in",
        backgroundColor = PrimaryTextColor
    ),
)
