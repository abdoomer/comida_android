package com.example.comida.navigation

import kotlinx.serialization.Serializable


@Serializable
object ForgetPasswordScreenRoute

@Serializable
object OnboardingScreenRoute

@Serializable
object OTPVerificationScreenRoute

@Serializable
object SignInScreenRoute

@Serializable
object SignUpScreenRoute

@Serializable
data class FoodDetailsScreenRoute(val id: String)

@Serializable
object PaymentScreenRoute

@Serializable
object PrivacyPolicyScreenRoute

@Serializable
object SettingsScreenRoute

@Serializable
object TermsOfServiceScreenRoute

@Serializable
data class OrderStatusScreenRoute(val id: String)

@Serializable
object MyAccountScreenRoute

@Serializable
object ComidaAppScreenRoute

@Serializable
data class NotificationDetailsScreenRoute(val id: String)

@Serializable
object RestaurantsScreenRoute

@Serializable
object SpecialOffersScreenRoute

@Serializable
data class FoodCategoryScreenRoute(val id: String)

@Serializable
data class RestaurantScreenRoute(val id: String)

@Serializable
data class OfferScreenRoute(val id: String)

@Serializable
data class RestaurantAvailableFoodsScreenRoute(val id: String)

@Serializable
data class OrderDetailsScreenRoute(val id: String)

@Serializable
object TechnicalSupportRoute