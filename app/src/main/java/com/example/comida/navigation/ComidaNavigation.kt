package com.example.comida.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.comida.screens.navigation.ComidaAppScreen
import com.example.comida.screens.home.FoodCategoryScreen
import com.example.comida.screens.home.FoodDetailsScreen
import com.example.comida.screens.auth.ForgetPasswordScreen
import com.example.comida.screens.profile.MyAccount
import com.example.comida.screens.notifications.NotificationDetailsScreen
import com.example.comida.screens.auth.OTPVerificationScreen
import com.example.comida.screens.home.OfferScreen
import com.example.comida.screens.onboarding.OnboardingScreen
import com.example.comida.screens.orders.OrderDetailsScreen
import com.example.comida.screens.orders.OrderStatusScreen
import com.example.comida.screens.payment.PaymentScreen
import com.example.comida.screens.profile.PrivacyPolicyScreen
import com.example.comida.screens.home.RestaurantAvailableFoodsScreen
import com.example.comida.screens.home.RestaurantScreen
import com.example.comida.screens.home.RestaurantsScreen
import com.example.comida.screens.profile.SettingsScreen
import com.example.comida.screens.auth.SignInScreen
import com.example.comida.screens.auth.SignUpScreen
import com.example.comida.screens.home.SpecialOffersScreen
import com.example.comida.screens.profile.TermsOfServiceScreen
import com.example.comida.viewmodels.ComidaViewmodel
import com.example.comida.viewmodels.auth.ForgetPasswordViewModel
import com.example.comida.viewmodels.auth.OTPViewModel
import com.example.comida.viewmodels.auth.SignInViewModel
import com.example.comida.viewmodels.auth.SignUpViewModel


@Composable
fun ComidaNavigation(
    modifier: Modifier = Modifier,
    startDestination: String
){
    val otpViewmodel: OTPViewModel = viewModel()
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
                },
                onMarkAsReadClicked = {}
            )
        }

        composable(
            route = Screens.RestaurantsScreen.route
        ){
            RestaurantsScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                },
                onRestaurantTapped = {
                    navController.navigate(Screens.RestaurantScreen.route)
                },
                onToggleIsFavoriteTapped = {}
            )
        }

        composable(
            route = Screens.SpecialOffersScreen.route
        ){
            SpecialOffersScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                },
                onSpecialOfferTapped = {
                    navController.navigate(Screens.OfferScreen.route)
                },
                onBuyNowClicked = {}
            )
        }

        composable(
            route = Screens.FoodCategoryScreen.route
        ){
            FoodCategoryScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                },
                onFoodItemClicked = {
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
                },
                onToggleFavouritesClicked = {},
                onViewAllFoodsTapped = {
                    navController.navigate(Screens.RestaurantAvailableFoodsScreen.route)
                },
                onFoodItemClicked = {},
                onFoodItemAddToCartClicked = {}
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

        composable(
            route = Screens.RestaurantAvailableFoodsScreen.route
        ){
            RestaurantAvailableFoodsScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                },
                onFoodItemClicked = {
                    navController.navigate(Screens.FoodDetailsScreen.route)
                },
                onFoodItemAddToCartClicked = {}
            )
        }

        composable(
            route = Screens.OrderDetailsScreen.route
        ){
            OrderDetailsScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
    }
}