package com.example.comida.screens.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.comida.components.CustomBottomNavigationBar
import com.example.comida.navigation.Screens
import com.example.comida.screens.cart.CartScreen
import com.example.comida.screens.home.HomeScreen
import com.example.comida.screens.notifications.NotificationsScreen
import com.example.comida.screens.orders.OrdersHistoryScreen
import com.example.comida.screens.profile.ProfileScreen
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.viewmodels.ComidaViewmodel


@Composable
fun ComidaAppScreen(
    modifier: Modifier = Modifier,
    viewmodel: ComidaViewmodel,
    navController: NavHostController,
){
    val currentPage = viewmodel.currentPage.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        bottomBar = {
            CustomBottomNavigationBar(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .background(Color.White),
                currentIndex = currentPage.value,
                onButtonClicked = {
                    viewmodel.updateCurrentPage(it.index)
                }
            )
        }
    ) { innerPadding ->
        when(currentPage.value){
            0 -> {
                HomeScreen(
                    paddingValues = innerPadding,
                    onCategorySelected = {
                        navController.navigate(Screens.FoodCategoryScreen.route)
                    },
                    onBuyNowClicked = {},
                    onSpecialOfferTapped = {
                        navController.navigate(Screens.OfferScreen.route)
                    },
                    onRestaurantTapped = {
                        navController.navigate(Screens.RestaurantScreen.route)
                    },
                    onToggleIsFavoriteTapped = {},
                    onViewAllOfferTapped = {
                        navController.navigate(Screens.SpecialOffersScreen.route)
                    },
                    onViewAllRestaurantsTapped = {
                        navController.navigate(Screens.RestaurantsScreen.route)
                    }
                )
            }
            1 -> {
                CartScreen(
                    paddingValues = innerPadding,
                )
            }
            2 -> {
                OrdersHistoryScreen(
                    paddingValues = innerPadding,
                    onOrderClicked = {
                        navController.navigate(Screens.OrderDetailsScreen.route)
                    }
                )
            }
            3 -> {
                ProfileScreen(
                    paddingValues = innerPadding,
                    navController = navController
                )
            }
            4 -> {
                NotificationsScreen(
                    paddingValues = innerPadding,
                    onNotificationClicked = {
                        navController.navigate(Screens.NotificationDetailsScreen.route)
                    },
                    onBackButtonClicked = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}



@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ComidaAppScreenPreview(){
    ComidaTheme {
        ComidaAppScreen(
            viewmodel = viewModel(),
            navController = rememberNavController()
        )
    }
}