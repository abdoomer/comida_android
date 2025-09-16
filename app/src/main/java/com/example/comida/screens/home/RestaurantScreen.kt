package com.example.comida.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.comida.R
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.components.FoodCategoryItemCard
import com.example.comida.models.FoodItem
import com.example.comida.models.Restaurant
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.OnboardingBackgroundColor3
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.SmallLabelTextColor
import com.example.comida.ui.theme.bebasFamily
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.ui.theme.sofiaFamily
import com.example.comida.viewmodels.home.RestaurantViewModel


@Composable
fun RestaurantScreen(
    modifier: Modifier = Modifier,
    restaurantID: String,
    onBackButtonClicked: () -> Unit,
    onToggleFavouritesClicked: (Restaurant) -> Unit,
    onViewAllFoodsTapped: (List<FoodItem>) -> Unit,
    onFoodItemClicked: (FoodItem) -> Unit,
    onFoodItemAddToCartClicked: (FoodItem) -> Unit,
){

    val viewModel: RestaurantViewModel = hiltViewModel()
    val restaurant = viewModel.restaurant.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.fetchRestaurant()
    }

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
                title = "Restaurant",
                haveBackButton = true,
                onBackButtonPressed = onBackButtonClicked
            )

            RestaurantImage(
                restaurant = restaurant.value,
                onToggleFavouritesClicked = onToggleFavouritesClicked
            )

            RestaurantInformation(
                restaurant = restaurant.value
            )

            RestaurantAvailableFood(
                availableFoods = restaurant.value.availableFoods,
                onViewAllFoodsTapped = {
                    viewModel.updateCurrentRestaurantFoodList(restaurant.value.availableFoods)
                    onViewAllFoodsTapped(restaurant.value.availableFoods)
                },
                onFoodItemClicked = onFoodItemClicked,
                onFoodItemAddToCartClicked = onFoodItemAddToCartClicked
            )
        }
    }
}



@Composable
private fun RestaurantImage(
    modifier: Modifier = Modifier,
    restaurant: Restaurant,
    onToggleFavouritesClicked: (Restaurant) -> Unit
){
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ){
        AsyncImage(
            model = ImageRequest
                .Builder(context)
                .data(restaurant.image)
                .crossfade(true)
                .transformations(CircleCropTransformation())
                .build(),
            contentDescription = restaurant.name,
            modifier = Modifier
                .size(250.dp)
        )

        Button(
            modifier = Modifier
                .align(Alignment.TopEnd),
            onClick = {
                onToggleFavouritesClicked(restaurant)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            ),
            elevation = ButtonDefaults.buttonElevation(4.dp),
            shape = CircleShape
        ) {
            Icon(
                painter = painterResource(R.drawable.heart_icon),
                contentDescription = "",
                tint = PrimaryButtonColor,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(6.dp)
                    .size(24.dp)
            )
        }
    }
}


@SuppressLint("DefaultLocale")
@Composable
private fun RestaurantInformation(
    modifier: Modifier = Modifier,
    restaurant: Restaurant,
){
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = restaurant.name,
            fontFamily = poppinsFamily,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryTextColor
        )

        Text(
            text = restaurant.description,
            fontFamily = sofiaFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = SmallLabelTextColor
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp, alignment = Alignment.CenterHorizontally)
            ) {

                Icon(
                    painter = painterResource(R.drawable.delivery_icon),
                    contentDescription = "Delivery Icon",
                    tint = PrimaryButtonColor,
                    modifier = Modifier
                        .size(16.dp)
                )

                Text(
                    text = if (restaurant.isFreeDelivery) "Free delivery" else "$5 Delivery fee",
                    fontWeight = FontWeight.Normal,
                    fontFamily = bebasFamily,
                    fontSize = 12.sp,
                    color = SmallLabelTextColor
                )
            }

            Spacer(
                modifier = Modifier
                    .width(16.dp)
            )

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp, alignment = Alignment.CenterHorizontally)
            ) {

                Icon(
                    painter = painterResource(R.drawable.timer_icon),
                    contentDescription = "Delivery Time Icon",
                    tint = PrimaryButtonColor,
                    modifier = Modifier
                        .size(16.dp)
                )

                Text(
                    text = "${String.format("%.2f", restaurant.deliveryTime)} min",
                    fontWeight = FontWeight.Normal,
                    fontFamily = bebasFamily,
                    fontSize = 12.sp,
                    color = SmallLabelTextColor
                )
            }

            Spacer(
                modifier = Modifier
                    .weight(1f)
            )

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp, alignment = Alignment.CenterHorizontally)
            ) {

                Icon(
                    painter = painterResource(R.drawable.star),
                    contentDescription = "Delivery Icon",
                    tint = OnboardingBackgroundColor3,
                    modifier = Modifier
                        .size(16.dp)
                )

                Text(
                    text = String.format("%.2f", restaurant.ratingValue),
                    fontWeight = FontWeight.Normal,
                    fontFamily = bebasFamily,
                    fontSize = 12.sp,
                    color = SmallLabelTextColor
                )
            }
        }
    }
}


@Composable
private fun RestaurantAvailableFood(
    modifier: Modifier = Modifier,
    availableFoods: List<FoodItem>,
    onFoodItemClicked: (FoodItem) -> Unit,
    onFoodItemAddToCartClicked: (FoodItem) -> Unit,
    onViewAllFoodsTapped: () -> Unit,
){
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Available Food",
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFamily,
                fontSize = 18.sp,
                color = PrimaryTextColor
            )

            TextButton(
                onClick = onViewAllFoodsTapped
            ) {
                Text(
                    "View All",
                    fontFamily = poppinsFamily,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = PrimaryButtonColor
                )
            }
        }

        LazyRow {
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


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun RestaurantScreenPreview(){
    ComidaTheme {
        RestaurantScreen(
            restaurantID = "",
            onBackButtonClicked = {},
            onToggleFavouritesClicked = {},
            onViewAllFoodsTapped = {},
            onFoodItemClicked = {},
            onFoodItemAddToCartClicked = {}
        )
    }
}