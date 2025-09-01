package com.example.comida.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.components.RestaurantCard
import com.example.comida.models.Restaurant
import com.example.comida.models.restaurants
import com.example.comida.ui.theme.ComidaTheme


@Composable
fun RestaurantsScreen(
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit,
    onRestaurantTapped: (Restaurant) -> Unit,
    onToggleIsFavoriteTapped: (Boolean) -> Unit,
){
    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            CustomTopAppTitleBar(
                title = "Restaurants",
                haveBackButton = true,
                onBackButtonPressed = onBackButtonClicked
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(restaurants) { restaurant ->
                    RestaurantCard(
                        restaurant = restaurant,
                        onRestaurantTapped = onRestaurantTapped,
                        onToggleIsFavoriteTapped = onToggleIsFavoriteTapped
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
            onToggleIsFavoriteTapped = {}
        )
    }
}