package com.example.comida.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comida.R
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.models.FoodItem
import com.example.comida.models.foodItems
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.poppinsFamily


@Composable
fun FoodCategoryScreen(
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp)
    ) {
        CustomTopAppTitleBar(
            title = "Category",
            haveBackButton = true,
            onBackButtonPressed = onBackButtonClicked
        )

        CategoryFilter(
            sortBy = "Relevance",
            onSortClicked = {},
            onFilterClicked = {}
        )

        LazyColumn(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(foodItems){ item ->
                FoodCategoryItem(
                    item = item,
                    onItemClicked = {},
                    onAddToCartClicked = {}
                )
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
private fun FoodCategoryItem(
    modifier: Modifier = Modifier,
    item: FoodItem,
    onAddToCartClicked: (FoodItem) -> Unit,
    onItemClicked: (FoodItem) -> Unit,
){
    Box(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 16.dp)
                .clickable{
                    onItemClicked(item)
                },
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(24.dp),
            border = BorderStroke(1.5.dp, PrimaryButtonColor)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(item.image),
                    contentDescription = item.title,
                    modifier = Modifier
                        .size(140.dp)
                )

                Column() {
                    Text(
                        text = item.title
                    )

                    Text(
                        text = item.description,
                        maxLines = 2
                    )

                    Row() {
                        Text(
                            text = "${item.weight}"
                        )

                        Spacer(
                            modifier = Modifier
                                .width(8.dp)
                        )

                        Text(
                            text = "${item.discountPercentage}"
                        )
                    }

                    Row() {
                        Text(
                            text = "${item.price}"
                        )

                        Spacer(
                            modifier = Modifier
                                .width(8.dp)
                        )

                        Text(
                            text = "${item.discountAmount}"
                        )
                    }
                }
            }
        }

        Button(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = (-16).dp, y = 2.dp)
                .clip(RoundedCornerShape(16.dp)),
            onClick = {
                onAddToCartClicked(item)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryButtonColor
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_plus),
                contentDescription = "Add To Cart Icon",
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun FoodCategoryScreenPreview(){
    ComidaTheme {
        FoodCategoryScreen(
            onBackButtonClicked = {}
        )
    }
}