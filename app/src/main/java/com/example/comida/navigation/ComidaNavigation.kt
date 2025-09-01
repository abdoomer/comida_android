package com.example.comida.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.comida.screens.ComidaAppScreen
import com.example.comida.screens.FoodCategoryScreen
import com.example.comida.screens.FoodDetailsScreen
import com.example.comida.screens.ForgetPasswordScreen
import com.example.comida.screens.MyAccount
import com.example.comida.screens.NotificationDetailsScreen
import com.example.comida.screens.OTPVerificationScreen
import com.example.comida.screens.OfferScreen
import com.example.comida.screens.OnboardingScreen
import com.example.comida.screens.OrderStatusScreen
import com.example.comida.screens.OrdersHistory
import com.example.comida.screens.PaymentScreen
import com.example.comida.screens.PrivacyPolicyScreen
import com.example.comida.screens.RestaurantScreen
import com.example.comida.screens.RestaurantsScreen
import com.example.comida.screens.SettingsScreen
import com.example.comida.screens.SignInScreen
import com.example.comida.screens.SignUpScreen
import com.example.comida.screens.SpecialOffersScreen
import com.example.comida.screens.TermsOfServiceScreen
import com.example.comida.viewmodels.ComidaViewmodel
import com.example.comida.viewmodels.ForgetPasswordViewModel
import com.example.comida.viewmodels.OTPViewmodel
import com.example.comida.viewmodels.SignInViewModel
import com.example.comida.viewmodels.SignUpViewModel


@Composable
fun ComidaNavigation(
    modifier: Modifier = Modifier,
    startDestination: String
){
    val otpViewmodel: OTPViewmodel = viewModel()
    val signInViewmodel: SignInViewModel = viewModel()
    val signUpViewmodel: SignUpViewModel = viewModel()
    val forgetPasswordViewmodel: ForgetPasswordViewModel = viewModel()
    val comidaViewmodel: ComidaViewmodel = viewModel()
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        val currentFoodItem = comidaViewmodel.currentSelectedFood

        composable(
            route = Screens.OnboardingScreen.route
        ){
            OnboardingScreen(
                onNavigationButtonClicked = {
                    navController.navigate(it)
                },
                onUpdateAppFirstTimeRun = {
                    navController.navigate(Screens.SignInScreen.route)
                    signInViewmodel.updateAppFirstTimeRun()
                }
            )
        }

        composable(
            route = Screens.SignInScreen.route
        ){
            SignInScreen(
                viewmodel = signInViewmodel,
                onSignInClicked = {
                    navController.navigate(Screens.ComidaAppScreen.route)
                },
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
            route = Screens.FoodDetailsScreen.route
        ){
            FoodDetailsScreen(
                item = currentFoodItem.collectAsStateWithLifecycle().value,
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screens.PaymentScreen.route
        ){
            PaymentScreen(
            )
        }

        composable(
            route = Screens.PrivacyPolicyScreen.route
        ){
            PrivacyPolicyScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screens.TermsOfServiceScreen.route
        ){
            TermsOfServiceScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screens.SettingsScreen.route
        ){
            SettingsScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screens.OrderStatusScreen.route
        ){
            OrderStatusScreen(
            )
        }

        composable(
            route = Screens.OrdersHistory.route
        ){
            OrdersHistory(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screens.MyAccount.route
        ){
            MyAccount(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screens.ComidaAppScreen.route
        ){
            ComidaAppScreen(
                navController = navController,
                viewmodel = comidaViewmodel
            )
        }

        composable(
            route = Screens.NotificationDetailsScreen.route
        ){
            NotificationDetailsScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screens.RestaurantsScreen.route
        ){
            RestaurantsScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screens.SpecialOffersScreen.route
        ){
            SpecialOffersScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screens.FoodCategoryScreen.route
        ){
            val foodCategory = comidaViewmodel.selectedCategory.collectAsStateWithLifecycle()

            FoodCategoryScreen(
                category = foodCategory.value,
                onBackButtonClicked = {
                    navController.popBackStack()
                },
                onFoodItemClicked = {
                    comidaViewmodel.updateCurrentSelectedFood(it)
                    navController.navigate(Screens.FoodDetailsScreen.route)
                }
            )
        }

        composable(
            route = Screens.RestaurantScreen.route
        ){
            RestaurantScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screens.OfferScreen.route
        ){
            OfferScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
    }
}