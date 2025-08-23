package com.example.comida.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun ComidaNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {

        composable(
            route = Screens.OnboardingScreen.route
        ){}

        composable(
            route = Screens.SignInScreen.route
        ){}

        composable(
            route = Screens.SignUpScreen.route
        ){}

        composable(
            route = Screens.ForgetPasswordScreen.route
        ){}

        composable(
            route = Screens.OTPVerificationScreen.route
        ){}

        composable(
            route = Screens.HomeScreen.route
        ){}

        composable(
            route = Screens.CartScreen.route
        ){}

        composable(
            route = Screens.ProfileScreen.route
        ){}

        composable(
            route = Screens.NotificationsScreen.route
        ){}

        composable(
            route = Screens.FoodDetailsScreen.route
        ){}

        composable(
            route = Screens.PaymentScreen.route
        ){}

        composable(
            route = Screens.PrivacyPolicyScreen.route
        ){}

        composable(
            route = Screens.TermsOfServiceScreen.route
        ){}

        composable(
            route = Screens.SettingsScreen.route
        ){}

        composable(
            route = Screens.OrderStatusScreen.route
        ){}

        composable(
            route = Screens.OrdersHistory.route
        ){}

        composable(
            route = Screens.MyAccount.route
        ){}
    }
}