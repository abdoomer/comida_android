package com.example.comida.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comida.R
import com.example.comida.components.CustomSearchTextField
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.components.FoodCategoryItemCard
import com.example.comida.models.FoodItem
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.viewmodels.home.FoodCategoryViewModel


@Composable
fun FoodCategoryScreen(
    modifier: Modifier = Modifier,
    categoryID: String,
    onBackButtonClicked: () -> Unit,
    onFoodItemClicked: (FoodItem) -> Unit,
){

    val viewModel: FoodCategoryViewModel = hiltViewModel()
    val category = viewModel.category.collectAsStateWithLifecycle()
    val searchText = viewModel.searchText.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        Log.d("Category", categoryID)
        viewModel.fetchSelectedFoodCategory(id = categoryID)
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
                title = category.value.title,
                haveBackButton = true,
                onBackButtonPressed = onBackButtonClicked
            )

            CategoryFilter(
                sortBy = "Relevance",
                onSortClicked = {},
                onFilterClicked = {}
            )

            CustomSearchTextField(
                searchText = searchText.value,
                placeHolderText = "Search food category",
                onSearchTextChanged = {
                    viewModel.onSearchTextValueChanged(it)
                },
                onSearchButtonClicked = {
                    viewModel.onSearchTextButtonClicked()
                }
            )

            LazyColumn(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(category.value.getFoodCategoryItems()){ item ->
                    FoodCategoryItemCard(
                        item = item,
                        onItemClicked = {
                            onFoodItemClicked(item)
                        },
                        onAddToCartClicked = {}
                    )
                }
            }
        }
    }
}


@Composable
private fun CategoryFilter(
    modifier: Modifier = Modifier,
    sortBy: String,
    onFilterClicked: () -> Unit,
    onSortClicked: () -> Unit,
){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp)),
            onClick = onFilterClicked,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_filter_icon),
                    contentDescription = "Filter Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(24.dp)
                )

                Spacer(
                    modifier = Modifier
                        .width(8.dp)
                )

                Text(
                    text = "Filter",
                    color = PrimaryTextColor,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(
            modifier = Modifier
                .width(16.dp)
        )

        Button(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp)),
            onClick = onSortClicked,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_sort_icon),
                    contentDescription = "Sort Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(24.dp)
                )

                Spacer(
                    modifier = Modifier
                        .width(8.dp)
                )

                Text(
                    text = "Sort: $sortBy",
                    color = PrimaryTextColor,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun FoodCategoryScreenPreview(){
    ComidaTheme {
        FoodCategoryScreen(
            categoryID = "",
            onBackButtonClicked = {},
            onFoodItemClicked = {}
        )
    }
}