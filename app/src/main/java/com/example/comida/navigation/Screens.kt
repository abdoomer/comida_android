package com.example.comida.navigation



sealed class Screens(
    val route: String
) {
    data object ForgetPasswordScreen: Screens(route = "forget_password_screen")
    data object OnboardingScreen: Screens(route = "onboarding_screen")
    data object OTPVerificationScreen: Screens(route = "otp_verification_screen")
    data object SignInScreen: Screens(route = "sign_in_screen")
    data object SignUpScreen: Screens(route = "sign_up_screen")
    data object FoodDetailsScreen: Screens(route = "food_details_screen")
    data object PaymentScreen: Screens(route = "payment_screen")
    data object PrivacyPolicyScreen: Screens(route = "privacy_policy_screen")
    data object SettingsScreen: Screens(route = "settings_screen")
    data object TermsOfServiceScreen: Screens(route = "terms_of_service_screen")
    data object OrderStatusScreen: Screens(route = "order_status_screen")
    data object MyAccount: Screens(route = "my_account")

    data object ComidaAppScreen: Screens(route = "comida_app_screen")

    data object NotificationDetailsScreen: Screens(route = "notification_details_screen")

    data object RestaurantsScreen: Screens(route = "restaurants_screen")

    data object SpecialOffersScreen: Screens(route = "special_offers_screen")

    data object FoodCategoryScreen: Screens(route = "food_category_screen")

    data object RestaurantScreen: Screens(route = "restaurant_screen")

    data object OfferScreen: Screens(route = "offer_screen")

    data object RestaurantAvailableFoodsScreen: Screens(route = "restaurant_available_foods_screen")
}