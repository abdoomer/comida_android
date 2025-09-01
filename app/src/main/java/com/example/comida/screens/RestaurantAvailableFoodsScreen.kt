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
import com.example.comida.components.FoodCategoryItemCard
import com.example.comida.dummy.burgersCategory
import com.example.comida.models.FoodItem
import com.example.comida.ui.theme.ComidaTheme


@Composable
fun RestaurantAvailableFoodsScreen(
    modifier: Modifier = Modifier,
    availableFoods: List<FoodItem>,
    onBackButtonClicked: () -> Unit,
    onFoodItemClicked: (FoodItem) -> Unit,
    onFoodItemAddToCartClicked: (FoodItem) -> Unit,
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
                title = "Available Foods",
                haveBackButton = true,
                onBackButtonPressed = onBackButtonClicked
            )

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(availableFoods){ food ->
                    FoodCategoryItemCard(
                        item = food,
                        onItemClicked = {
                            onFoodItemClicked(food)
                        },
                        onAddToCartClicked = {
                            onFoodItemAddToCartClicked(food)
                        }
                    )
                }
            }
        }
    }
}




@Composable
@Preview(showBackground = true, showSystemUi = true)
fun RestaurantAvailableFoodsScreenPreview(){
    ComidaTheme {
        RestaurantAvailableFoodsScreen(
            availableFoods = burgersCategory,
            onBackButtonClicked = {},
            onFoodItemClicked = {},
            onFoodItemAddToCartClicked = {}
        )
    }
}