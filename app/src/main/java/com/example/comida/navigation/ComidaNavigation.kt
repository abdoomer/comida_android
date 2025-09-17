package com.example.comida.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.comida.screens.navigation.ComidaAppScreen
import com.example.comida.screens.home.FoodCategoryScreen
import com.example.comida.screens.home.FoodDetailsScreen
import com.example.comida.screens.auth.ForgetPasswordScreen
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
import com.example.comida.screens.profile.MyAccountScreen
import com.example.comida.screens.profile.TechnicalSupportScreen
import com.example.comida.screens.profile.TermsOfServiceScreen


@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun ComidaNavigation(
    modifier: Modifier = Modifier,
//    startDestination: String
){
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = OnboardingScreenRoute
    ) {
        composable<OnboardingScreenRoute>{
            OnboardingScreen(
                onNavigationButtonClicked = {
                    navController.navigate(it)
                },
                onUpdateAppFirstTimeRun = {
                    navController.navigate(SignInScreenRoute)
                }
            )
        }

        composable<SignInScreenRoute>{
            SignInScreen(
                onSignInClicked = {
                    navController.navigate(ComidaAppScreenRoute)
                },
                onGoToSignUpClicked = {
                    navController.navigate(SignUpScreenRoute)
                },
                onForgetPasswordClicked = {
                    navController.navigate(ForgetPasswordScreenRoute)
                }
            )
        }

        composable<SignUpScreenRoute>{
            SignUpScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable<ForgetPasswordScreenRoute>{
            ForgetPasswordScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable<OTPVerificationScreenRoute>{
            OTPVerificationScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable<FoodDetailsScreenRoute>{
            val args = it.toRoute<FoodDetailsScreenRoute>()
            FoodDetailsScreen(
                foodID = args.id,
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable<PaymentScreenRoute>{
            PaymentScreen(
            )
        }

        composable<PrivacyPolicyScreenRoute>{
            PrivacyPolicyScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable<TermsOfServiceScreenRoute>{
            TermsOfServiceScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable<SettingsScreenRoute>{
            SettingsScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable<OrderStatusScreenRoute>{
            val args = it.toRoute<OrderStatusScreenRoute>()
            OrderStatusScreen(
                orderID = args.id
            )
        }

        composable<MyAccountScreenRoute>{
            MyAccountScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable<ComidaAppScreenRoute>{
            ComidaAppScreen(
                navController = navController,
            )
        }

        composable<NotificationDetailsScreenRoute>{
            val args = it.toRoute<NotificationDetailsScreenRoute>()
            NotificationDetailsScreen(
                notificationID = args.id,
                onBackButtonClicked = {
                    navController.popBackStack()
                },
                onMarkAsReadClicked = {}
            )
        }

        composable<RestaurantsScreenRoute>{
            RestaurantsScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                },
                onRestaurantTapped = {
                    navController.navigate(RestaurantScreenRoute)
                },
                onToggleIsFavoriteTapped = {}
            )
        }

        composable<SpecialOffersScreenRoute>{
            SpecialOffersScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                },
                onSpecialOfferTapped = {
                    navController.navigate(OfferScreenRoute(id = it.id))
                },
                onBuyNowClicked = {}
            )
        }

        composable<FoodCategoryScreenRoute>{
            val args = it.toRoute<FoodCategoryScreenRoute>()
            FoodCategoryScreen(
                categoryID = args.id,
                onBackButtonClicked = {
                    navController.popBackStack()
                },
                onFoodItemClicked = {
                    navController.navigate(FoodDetailsScreenRoute(id = args.id))
                }
            )
        }

        composable<RestaurantScreenRoute>{
            val args = it.toRoute<RestaurantScreenRoute>()
            RestaurantScreen(
                restaurantID = args.id,
                onBackButtonClicked = {
                    navController.popBackStack()
                },
                onToggleFavouritesClicked = {},
                onViewAllFoodsTapped = {
                    navController.navigate(RestaurantAvailableFoodsScreenRoute(id = it.id))
                },
                onFoodItemClicked = {},
                onFoodItemAddToCartClicked = {}
            )
        }

        composable<OfferScreenRoute>{
            val args = it.toRoute<OfferScreenRoute>()
            OfferScreen(
                offerID = args.id,
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable<RestaurantAvailableFoodsScreenRoute>{
            val args = it.toRoute<RestaurantAvailableFoodsScreenRoute>()
            RestaurantAvailableFoodsScreen(
                restaurantID = args.id,
                onBackButtonClicked = {
                    navController.popBackStack()
                },
                onFoodItemClicked = {
                    navController.navigate(FoodDetailsScreenRoute)
                },
                onFoodItemAddToCartClicked = {}
            )
        }

        composable<OrderDetailsScreenRoute>{
            val args = it.toRoute<OrderDetailsScreenRoute>()
            OrderDetailsScreen(
                orderID = args.id,
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable<TechnicalSupportRoute>{
            TechnicalSupportScreen(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
    }
}