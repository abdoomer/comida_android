package com.example.comida.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comida.R
import com.example.comida.components.RestaurantCard
import com.example.comida.components.SpecialOfferCard
import com.example.comida.models.FoodCategory
import com.example.comida.models.Restaurant
import com.example.comida.models.SpecialOffer
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.HomeFoodCategoryTitleColor
import com.example.comida.ui.theme.IconButtonColor
import com.example.comida.ui.theme.IconsColor
import com.example.comida.ui.theme.OnboardingBackgroundColor3
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.SearchLabelTextColor
import com.example.comida.ui.theme.SecondaryTextColor
import com.example.comida.ui.theme.SmallLabelColor
import com.example.comida.ui.theme.TextFieldBackgroundColor
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.viewmodels.home.HomeViewModel


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    onCategorySelected: (FoodCategory) -> Unit,
    onSpecialOfferTapped: (SpecialOffer) -> Unit,
    onViewAllOfferTapped: () -> Unit,
    onBuyNowClicked: (SpecialOffer) -> Unit,
    onRestaurantTapped: (Restaurant) -> Unit,
    onViewAllRestaurantsTapped: () -> Unit,
    onToggleIsFavoriteTapped: (Restaurant) -> Unit,
){

    val viewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
    val searchText = viewModel.searchText.collectAsStateWithLifecycle()
    val foodCategories = viewModel.foodCategories.collectAsStateWithLifecycle()
    val specialOffers = viewModel.specialOffers.collectAsStateWithLifecycle()
    val restaurants = viewModel.restaurants.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.fetchData()
    }

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
            searchText = searchText.value,
            onSearchTextChanged = {
                viewModel.onSearchTextValueChanged(it)
            },
            onSearchButtonClicked = {
                viewModel.onSearchTextButtonClicked()
            }
        )

        FoodCategoriesSelectionMenu(
            foodCategories = foodCategories.value,
            onNewCategorySelected = onCategorySelected
        )

        AvailableSpecialOffers(
            specialOffers = specialOffers.value,
            onSpecialOfferTapped = onSpecialOfferTapped,
            onViewAllOfferTapped = onViewAllOfferTapped,
            onBuyNowClicked = onBuyNowClicked
        )

        AvailableRestaurants(
            restaurants = restaurants.value,
            onRestaurantTapped = onRestaurantTapped,
            onViewAllRestaurantsTapped = onViewAllRestaurantsTapped,
            onToggleIsFavoriteTapped = onToggleIsFavoriteTapped
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
            shape = RoundedCornerShape(8.dp),
            elevation = ButtonDefaults.buttonElevation(4.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.menu_button_icon),
                contentDescription = "Menu Icon Button",
                tint = IconButtonColor,
                modifier = Modifier
                    .size(24.dp)
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
    foodCategories: List<FoodCategory>,
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
    specialOffers: List<SpecialOffer>,
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
                SpecialOfferCard(
                    offer = offer,
                    onSpecialOfferTapped = onSpecialOfferTapped,
                    onBuyNowClicked = onBuyNowClicked
                )
            }
        }
    }
}


@Composable
private fun AvailableRestaurants(
    modifier: Modifier = Modifier,
    restaurants: List<Restaurant>,
    onViewAllRestaurantsTapped: () -> Unit,
    onRestaurantTapped: (Restaurant) -> Unit,
    onToggleIsFavoriteTapped: (Restaurant) -> Unit,
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
                RestaurantCard(
                    restaurant = restaurant,
                    onRestaurantTapped = onRestaurantTapped,
                    onToggleIsFavoriteTapped = {
                        onToggleIsFavoriteTapped(restaurant)
                    }
                )
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