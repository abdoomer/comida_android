package com.example.comida.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.comida.screens.CartScreen
import com.example.comida.screens.FoodDetailsScreen
import com.example.comida.screens.ForgetPasswordScreen
import com.example.comida.screens.HomeScreen
import com.example.comida.screens.MyAccount
import com.example.comida.screens.NotificationsScreen
import com.example.comida.screens.OTPVerificationScreen
import com.example.comida.screens.OnboardingScreen
import com.example.comida.screens.OrderStatusScreen
import com.example.comida.screens.OrdersHistory
import com.example.comida.screens.PaymentScreen
import com.example.comida.screens.PrivacyPolicyScreen
import com.example.comida.screens.ProfileScreen
import com.example.comida.screens.SettingsScreen
import com.example.comida.screens.SignInScreen
import com.example.comida.screens.SignUpScreen
import com.example.comida.screens.TermsOfServiceScreen
import com.example.comida.viewmodels.ForgetPasswordViewModel
import com.example.comida.viewmodels.OTPViewmodel
import com.example.comida.viewmodels.SignInViewModel
import com.example.comida.viewmodels.SignUpViewModel


@Composable
fun ComidaNavigation(
    modifier: Modifier = Modifier,
){
    val otpViewmodel: OTPViewmodel = viewModel()
    val signInViewmodel: SignInViewModel = viewModel()
    val signUpViewmodel: SignUpViewModel = viewModel()
    val forgetPasswordViewmodel: ForgetPasswordViewModel = viewModel()
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.OnboardingScreen.route
    ) {

        composable(
            route = Screens.OnboardingScreen.route
        ){
            OnboardingScreen(
                onNavigationButtonClicked = {
                    navController.navigate(it)
                }
            )
        }

        composable(
            route = Screens.SignInScreen.route
        ){
            SignInScreen(
                viewmodel = signInViewmodel,
                onGoToSignUpClicked = {
                    navController.navigate(Screens.SignUpScreen.route)
                },
                onForgetPasswordClicked = {
                    navController.navigate(Screens.ForgetPasswordScreen.route)
                }
            )
        }

        composable(
            route = Screens.SignUpScreen.route
        ){
            SignUpScreen(
                viewmodel = signUpViewmodel,
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screens.ForgetPasswordScreen.route
        ){
            ForgetPasswordScreen(
                viewModel = forgetPasswordViewmodel,
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screens.OTPVerificationScreen.route
        ){
            OTPVerificationScreen(
                viewModel = otpViewmodel,
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screens.HomeScreen.route
        ){
            HomeScreen()
        }

        composable(
            route = Screens.CartScreen.route
        ){
            CartScreen()
        }

        composable(
            route = Screens.ProfileScreen.route
        ){
            ProfileScreen()
        }

        composable(
            route = Screens.NotificationsScreen.route
        ){
            NotificationsScreen()
        }

        composable(
            route = Screens.FoodDetailsScreen.route
        ){
            FoodDetailsScreen()
        }

        composable(
            route = Screens.PaymentScreen.route
        ){
            PaymentScreen()
        }

        composable(
            route = Screens.PrivacyPolicyScreen.route
        ){
            PrivacyPolicyScreen()
        }

        composable(
            route = Screens.TermsOfServiceScreen.route
        ){
            TermsOfServiceScreen()
        }

        composable(
            route = Screens.SettingsScreen.route
        ){
            SettingsScreen()
        }

        composable(
            route = Screens.OrderStatusScreen.route
        ){
            OrderStatusScreen()
        }

        composable(
            route = Screens.OrdersHistory.route
        ){
            OrdersHistory()
        }

        composable(
            route = Screens.MyAccount.route
        ){
            MyAccount()
        }
    }
}