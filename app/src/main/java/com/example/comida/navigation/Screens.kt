package com.example.comida.navigation



sealed class Screens(
    val route: String
) {
    data object CartScreen: Screens(route = "cart_screen")
    data object ForgetPasswordScreen: Screens(route = "forget_password_screen")
    data object HomeScreen: Screens(route = "home_screen")
    data object NotificationsScreen: Screens(route = "notifications_screen")
    data object OnboardingScreen: Screens(route = "onboarding_screen")
    data object OTPVerificationScreen: Screens(route = "otp_verification_screen")
    data object ProfileScreen: Screens(route = "profile_screen")
    data object SignInScreen: Screens(route = "sign_in_screen")
    data object SignUpScreen: Screens(route = "sign_up_screen")
    data object SplashScreen: Screens(route = "splash_screen")
    data object FoodDetailsScreen: Screens(route = "food_details_screen")
    data object PaymentScreen: Screens(route = "payment_screen")
    data object PrivacyPolicyScreen: Screens(route = "privacy_policy_screen")
    data object SettingsScreen: Screens(route = "settings_screen")
    data object TermsOfServiceScreen: Screens(route = "terms_of_service_screen")
}