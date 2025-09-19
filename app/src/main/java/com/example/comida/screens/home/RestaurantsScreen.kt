package com.example.comida.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comida.components.CustomSearchTextField
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.components.RestaurantCard
import com.example.comida.models.Restaurant
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.viewmodels.home.RestaurantsViewModel


@Composable
fun RestaurantsScreen(
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit,
    onRestaurantTapped: (Restaurant) -> Unit,
){

    val viewModel: RestaurantsViewModel = hiltViewModel()
    val restaurants = viewModel.restaurants.collectAsStateWithLifecycle()
    val searchText = viewModel.searchText.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.fetchAllRestaurant()
    }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CustomTopAppTitleBar(
                title = "Restaurants",
                haveBackButton = true,
                onBackButtonPressed = onBackButtonClicked
            )

            CustomSearchTextField(
                searchText = searchText.value,
                placeHolderText = "Search restaurants",
                onSearchTextChanged = {
                    viewModel.onSearchTextValueChanged(it)
                },
                onSearchButtonClicked = {
                    viewModel.onSearchTextButtonClicked()
                }
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(restaurants.value) { restaurant ->
                    RestaurantCard(
                        restaurant = restaurant,
                        onRestaurantTapped = onRestaurantTapped,
                        onToggleIsFavoriteTapped = {
                            viewModel.onToggleRestaurantIsFavorites(restaurant.id)
                        }
                    )
                }
            }
        }
    }
}



@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun RestaurantsScreenPreview(){
    ComidaTheme {
        RestaurantsScreen(
            onBackButtonClicked = {},
            onRestaurantTapped = {},
        )
    }
}