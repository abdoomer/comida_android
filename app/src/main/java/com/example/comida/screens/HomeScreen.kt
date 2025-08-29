package com.example.comida.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comida.R
import com.example.comida.models.FoodCategory
import com.example.comida.models.SpecialOffer
import com.example.comida.models.foodCategories
import com.example.comida.models.restaurants
import com.example.comida.models.specialOffers
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.HomeFoodCategoryCurrentSelectedColor
import com.example.comida.ui.theme.HomeFoodCategoryTitleColor
import com.example.comida.ui.theme.IconButtonColor
import com.example.comida.ui.theme.IconsColor
import com.example.comida.ui.theme.OfferBuyNowButtonColor
import com.example.comida.ui.theme.OfferSmallLabelColor
import com.example.comida.ui.theme.OnboardingBackgroundColor3
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.SearchLabelTextColor
import com.example.comida.ui.theme.SecondaryTextColor
import com.example.comida.ui.theme.SmallIconLabelColor
import com.example.comida.ui.theme.SmallLabelColor
import com.example.comida.ui.theme.TextFieldBackgroundColor
import com.example.comida.ui.theme.bebasFamily
import com.example.comida.ui.theme.poppinsFamily


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues
){

    val searchText by remember { mutableStateOf("") }
    val currentSelectedFoodCategory by remember { mutableStateOf<FoodCategory>(foodCategories[0]) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.White)
    ) {
        TopTitleBar()

        Text(
            "Good Afternoon!",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            fontFamily = poppinsFamily,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFE724D),
                        Color(0xFFFFC529),
                    )
                )
            ),
            modifier = Modifier
                .padding(start = 16.dp)
        )

        CustomSearchTextField(
            searchText = searchText,
            onSearchTextChanged = {},
            onSearchButtonClicked = {}
        )

        FoodCategoriesSelectionMenu(
            currentCategory = currentSelectedFoodCategory,
            onNewCategorySelected = {}
        )

        AvailableSpecialOffers(
            onSpecialOfferTapped = {},
            onViewAllOfferTapped = {},
            onBuyNowClicked = {}
        )

        AvailableRestaurants(
            onRestaurantTapped = {},
            onViewAllRestaurantsTapped = {},
            onToggleIsFavoriteTapped = {}
        )
    }
}


@Composable
private fun TopTitleBar(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp),
            elevation = ButtonDefaults.buttonElevation(4.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.menu_button_icon),
                contentDescription = "Menu Icon Button",
                tint = IconButtonColor,
                modifier = Modifier
                    .width(41.6.dp)
                    .height(40.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row {
                Text(
                    "Deliver to",
                    fontFamily = poppinsFamily,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = SmallLabelColor
                )

                Icon(
                    painter = painterResource(R.drawable.down_arrow_icon),
                    contentDescription = "Down Arrow Chevron Icon",
                    tint = SmallLabelColor,
                    modifier = Modifier
                        .size(20.dp)
                )
            }

            Text(
                text = "387  Merdina",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 13.sp,
                color = SecondaryTextColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(0.3f),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(R.drawable.profile_picture),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Text(
                text = "2",
                fontFamily = poppinsFamily,
                fontSize = 9.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .offset(x = 8.dp, y = (-6).dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(OnboardingBackgroundColor3)
                    .padding(horizontal = 8.dp)
                    .align(Alignment.TopEnd)
            )
        }
    }
}


@Composable
private fun CustomSearchTextField(
    modifier: Modifier = Modifier,
    searchText: String,
    onSearchTextChanged: (String) -> Unit,
    onSearchButtonClicked: () -> Unit,
){
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        value = searchText,
        shape = RoundedCornerShape(16.dp),
        onValueChange = onSearchTextChanged,
        placeholder = {
            Text(
                text = "Search dishes, restaurants",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = SearchLabelTextColor
            )
        },
        leadingIcon = {
            Button(
                onClick = onSearchButtonClicked,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Icon(
                    painter = painterResource(R.drawable.search_icon),
                    contentDescription = "Search TextField Icon",
                    tint = IconsColor,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = TextFieldBackgroundColor,
            unfocusedContainerColor = TextFieldBackgroundColor,
            focusedBorderColor = PrimaryButtonColor,
            unfocusedBorderColor = Color.Transparent,
            errorBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
        )
    )
}


@Composable
private fun FoodCategoriesSelectionMenu(
    modifier: Modifier = Modifier,
    currentCategory: FoodCategory,
    onNewCategorySelected: (FoodCategory) -> Unit
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterHorizontally)
    ) { 
        items(foodCategories){ category ->
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 2.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(if (category == currentCategory) HomeFoodCategoryCurrentSelectedColor else Color.Transparent)
                    .clickable{
                        onNewCategorySelected(category)
                    },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(category.image),
                    contentDescription = category.title,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(80.dp)
                )

                Text(
                    text = category.title,
                    fontFamily = poppinsFamily,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    color = HomeFoodCategoryTitleColor
                )
            }
        }
    }
}


@Composable
private fun AvailableSpecialOffers(
    modifier: Modifier = Modifier,
    onViewAllOfferTapped: () -> Unit,
    onBuyNowClicked: (SpecialOffer) -> Unit,
    onSpecialOfferTapped: (SpecialOffer) -> Unit
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
                text = "Special Offers",
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFamily,
                fontSize = 18.sp,
                color = PrimaryTextColor
            )

            TextButton(
                onClick = onViewAllOfferTapped
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

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(specialOffers){ offer ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.85f),
                    colors = CardDefaults.cardColors(
                        containerColor = offer.backgroundColor
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .padding(end = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(offer.offerImage),
                            contentDescription = offer.title,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .size(150.dp)
                        )

                        Column(
                            modifier = Modifier
                        ) {
                            Row(
                                modifier = Modifier,
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterHorizontally)
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.star),
                                    contentDescription = "Rating Icon",
                                    tint = OnboardingBackgroundColor3,
                                    modifier = Modifier
                                        .size(16.dp)
                                )

                                Text(
                                    text = "${offer.ratingValue}",
                                    fontFamily = bebasFamily,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = OfferSmallLabelColor
                                )
                            }

                            Text(
                                text = offer.title,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = poppinsFamily,
                                color = Color.White
                            )

                            Row(
                                modifier = Modifier,
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterHorizontally)
                            ) {

                                Icon(
                                    painter = painterResource(R.drawable.delivery_icon),
                                    contentDescription = "Delivery Icon",
                                    tint = OfferSmallLabelColor,
                                    modifier = Modifier
                                        .size(16.dp)
                                )

                                Text(
                                    text = if (offer.isFreeDelivery) "Free delivery" else "$5 Delivery fee",
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = bebasFamily,
                                    fontSize = 12.sp,
                                    color = OfferSmallLabelColor
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(
                                    onClick = {
                                        onBuyNowClicked(offer)
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = OfferBuyNowButtonColor
                                    )
                                ) {
                                    Text(
                                        text = "Buy Now",
                                        fontFamily = poppinsFamily,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 10.sp,
                                        color = Color.White
                                    )
                                }

                                Text(
                                    text = "$${offer.price}",
                                    fontFamily = bebasFamily,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 12.sp,
                                    color = OfferSmallLabelColor
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun AvailableRestaurants(
    modifier: Modifier = Modifier,
    onViewAllRestaurantsTapped: () -> Unit,
    onRestaurantTapped: (SpecialOffer) -> Unit,
    onToggleIsFavoriteTapped: (Boolean) -> Unit,
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
                text = "Restaurants",
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFamily,
                fontSize = 18.sp,
                color = PrimaryTextColor
            )

            TextButton(
                onClick = onViewAllRestaurantsTapped
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

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ){
            items(restaurants) { restaurant ->
                Card(
                    modifier = Modifier
                        .wrapContentSize(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(24.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            Image(
                                painter = painterResource(restaurant.image),
                                contentDescription = restaurant.name,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .height(120.dp)
                                    .width(300.dp)
                            )

                            Button(
                                modifier = Modifier
                                    .align(Alignment.TopEnd),
                                onClick = {
                                    onToggleIsFavoriteTapped(restaurant.isFavorites)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.heart_icon),
                                    contentDescription = "Toggle Favorites Icon Button",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(Color.White.copy(alpha = 0.3f))
                                        .padding(8.dp)
                                        .size(24.dp)
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, top = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,

                        ) {
                            Text(
                                text = restaurant.name,
                                fontFamily = poppinsFamily,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = PrimaryTextColor,
                            )

                            Spacer(
                                modifier = Modifier
                                    .width(80.dp)
                            )

                            Row(
                                modifier = Modifier,
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.star),
                                    contentDescription = "Rating Icon",
                                    tint = OnboardingBackgroundColor3,
                                    modifier = Modifier
                                        .size(16.dp)
                                )

                                Text(
                                    text = "${restaurant.ratingValue}",
                                    fontFamily = bebasFamily,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = PrimaryTextColor
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(start = 16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
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
                                    color = SmallIconLabelColor
                                )
                            }

                            Spacer(
                                modifier = Modifier
                                    .width(150.dp)
                            )

                            Row(
                                modifier = Modifier,
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {

                                Icon(
                                    painter = painterResource(R.drawable.timer_icon),
                                    contentDescription = "Delivery Icon",
                                    tint = PrimaryButtonColor,
                                    modifier = Modifier
                                        .size(16.dp)
                                )

                                Text(
                                    text = "${restaurant.deliveryTime}",
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = bebasFamily,
                                    fontSize = 12.sp,
                                    color = SmallIconLabelColor
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier
                                .height(16.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun HomeScreenPreview(){
    ComidaTheme {
//        HomeScreen()
    }
}