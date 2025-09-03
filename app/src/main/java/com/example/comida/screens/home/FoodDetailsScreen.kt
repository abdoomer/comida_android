package com.example.comida.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.comida.dummy.foodItems.burgersCategory
import com.example.comida.models.FoodAddOn
import com.example.comida.models.FoodItem
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.OnboardingBackgroundColor3
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.SecondaryTextColor
import com.example.comida.ui.theme.SmallLabelTextColor
import com.example.comida.ui.theme.bebasFamily
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.ui.theme.sofiaFamily
import com.example.comida.viewmodels.home.FoodDetailsViewModel


@Composable
fun FoodDetailsScreen(
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit
){
    
    val viewModel: FoodDetailsViewModel = hiltViewModel()
    val item = viewModel.item.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ){
            FoodDetails(
                modifier = Modifier
                    .align(Alignment.TopCenter),
                item = item.value,
                onBackButtonClicked = onBackButtonClicked,
                onToggleFavouritesClicked = {}
            )


            FoodAddOnItems(
                modifier = Modifier
                    .align(Alignment.BottomCenter),
                addOns = item.value.addOns,
                onAddOnClicked = {},
                onAddItemToCartClicked = {},
                onIncreaseAddOnQuantityClicked = {},
                onDecreaseAddOnQuantityClicked = {}
            )
        }
    }
}


@SuppressLint("DefaultLocale")
@Composable
private fun FoodDetails(
    modifier: Modifier = Modifier,
    item: FoodItem,
    onBackButtonClicked: () -> Unit,
    onToggleFavouritesClicked: () -> Unit
){
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        CustomTopAppTitleBar(
            title = item.title,
            haveBackButton = true,
            onBackButtonPressed = onBackButtonClicked
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ){
            AsyncImage(
                model = ImageRequest
                    .Builder(context)
                    .data(item.image)
                    .crossfade(true)
                    .transformations(CircleCropTransformation())
                    .build(),
                contentDescription = item.title,
                modifier = Modifier
                    .size(250.dp)
            )

            Button(
                modifier = Modifier
                    .align(Alignment.TopEnd),
                onClick = onToggleFavouritesClicked,
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = item.title,
                fontFamily = poppinsFamily,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryTextColor
            )

            Text(
                text = "$${String.format("%.2f", item.price)}",
                color = PrimaryButtonColor,
                fontFamily = poppinsFamily,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

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
                    text = if (item.isFreeDelivery) "Free delivery" else "$5 Delivery fee",
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
                    text = "${String.format("%.2f", item.deliveryTime)} min",
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
                    text = String.format("%.2f", item.ratingValue),
                    fontWeight = FontWeight.Normal,
                    fontFamily = bebasFamily,
                    fontSize = 12.sp,
                    color = SmallLabelTextColor
                )
            }
        }

        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = item.description,
            fontWeight = FontWeight.Normal,
            fontFamily = poppinsFamily,
            fontSize = 14.sp,
            color = SmallLabelTextColor
        )
    }
}


@Composable
private fun FoodAddOnItems(
    modifier: Modifier = Modifier,
    addOns: List<FoodAddOn>,
    onAddOnClicked: (FoodAddOn) -> Unit,
    onAddItemToCartClicked: () -> Unit,
    onIncreaseAddOnQuantityClicked: () -> Unit,
    onDecreaseAddOnQuantityClicked: () -> Unit,
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f),
        shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = SecondaryTextColor
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "AddOns For You",
                fontFamily = poppinsFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )

            LazyColumn {
                items(addOns){ addon ->
                    AddOnCell(
                        addOn = addon,
                        onAddOnToggled = {
                            onAddOnClicked(addon)
                        }
                    )
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Button(
                                onClick = onDecreaseAddOnQuantityClicked
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.minus_icon),
                                    contentDescription = "Minus Icon",
                                    modifier = Modifier
                                        .size(16.dp)
                                )
                            }

                            Text(
                                text = "${addOns[0].quantity}",
                                color = Color.White
                            )

                            Button(
                                onClick = onIncreaseAddOnQuantityClicked
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.plus_icon),
                                    contentDescription = "Minus Icon",
                                    modifier = Modifier
                                        .size(16.dp)
                                )
                            }
                        }
                        Button(
                            onClick = onAddItemToCartClicked,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = PrimaryButtonColor
                            ),
                            modifier = modifier
                                .fillMaxWidth(0.7f)
                        ) {
                            Text(
                                text = "Add to basket",
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = Color.White,
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun AddOnCell(
    modifier: Modifier = Modifier,
    addOn: FoodAddOn,
    onAddOnToggled: () -> Unit
){
    val context = LocalContext.current

    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest
                .Builder(context)
                .data(addOn.image)
                .crossfade(true)
                .transformations(CircleCropTransformation())
                .build(),
            contentDescription = addOn.title,
            modifier = Modifier
                .size(40.dp)
        )

        Spacer(
            modifier = Modifier
                .width(16.dp)
        )

        Text(
            text = addOn.title,
            fontFamily = sofiaFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color.White
        )

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        RadioButton(
            selected = addOn.isAdded,
            onClick = onAddOnToggled
        )
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun FoodDetailsScreenPreview(){
    ComidaTheme {
        FoodDetailsScreen(
            onBackButtonClicked = {}
        )
    }
}