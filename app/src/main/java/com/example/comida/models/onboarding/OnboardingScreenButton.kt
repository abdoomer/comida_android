package com.example.comida.models.onboarding

import androidx.compose.ui.graphics.Color
import com.example.comida.navigation.SignInScreenRoute
import com.example.comida.navigation.SignUpScreenRoute
import com.example.comida.ui.theme.OnboardingLightButtonColor
import com.example.comida.ui.theme.PrimaryTextColor


data class OnboardingScreenButton(
    val id: Int = 0,
    val text: String = "",
    val backgroundColor: Color = Color.White,
    val routeDestination: Any
)


val onboardingScreenButtons = listOf<OnboardingScreenButton>(
    OnboardingScreenButton(
        id = 1,
        text = "Sign Up",
        backgroundColor = OnboardingLightButtonColor,
        routeDestination = SignUpScreenRoute
    ),
    OnboardingScreenButton(
        id = 2,
        text = "Log in",
        backgroundColor = PrimaryTextColor,
        routeDestination = SignInScreenRoute
    ),
)
