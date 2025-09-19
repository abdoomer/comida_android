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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.comida.components.CustomBottomNavigationBar
import com.example.comida.navigation.FoodCategoryScreenRoute
import com.example.comida.navigation.NotificationDetailsScreenRoute
import com.example.comida.navigation.OfferScreenRoute
import com.example.comida.navigation.OrderDetailsScreenRoute
import com.example.comida.navigation.RestaurantScreenRoute
import com.example.comida.navigation.RestaurantsScreenRoute
import com.example.comida.navigation.SpecialOffersScreenRoute
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
    navController: NavHostController,
){
    val viewmodel: ComidaViewmodel = hiltViewModel()
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
                        navController.navigate(FoodCategoryScreenRoute(id = it.id))
                    },
                    onBuyNowClicked = {},
                    onSpecialOfferTapped = {
                        navController.navigate(OfferScreenRoute(id = it.id))
                    },
                    onRestaurantTapped = {
                        navController.navigate(RestaurantScreenRoute(id = it.id))
                    },
                    onViewAllOfferTapped = {
                        navController.navigate(SpecialOffersScreenRoute)
                    },
                    onViewAllRestaurantsTapped = {
                        navController.navigate(RestaurantsScreenRoute)
                    }
                )
            }
            1 -> {
                CartScreen(
                    paddingValues = innerPadding,
                    onCartItemClicked = {
                    }
                )
            }
            2 -> {
                OrdersHistoryScreen(
                    paddingValues = innerPadding,
                    onOrderClicked = {
                        navController.navigate(OrderDetailsScreenRoute(id = it.id))
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
                        navController.navigate(NotificationDetailsScreenRoute(id = it.id))
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
            navController = rememberNavController()
        )
    }
}