package com.example.comida.screens.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.models.OrderItem
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.SmallLabelTextColor
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.ui.theme.sofiaFamily
import com.example.comida.viewmodels.orders.OrdersHistoryViewModel


@Composable
fun OrdersHistoryScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    onOrderClicked: (OrderItem) -> Unit
){

    val viewModel: OrdersHistoryViewModel = hiltViewModel()
    val orders = viewModel.orders.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.fetchOrdersHistory()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.White)
    ) {
        CustomTopAppTitleBar(
            title = "Orders History",
            haveBackButton = false,
            onBackButtonPressed = {}
        )

        OrderItemsList(
            orders = orders.value,
            onOrderItemClicked = {
                viewModel.updateCurrentSelectedOrder(it)
                onOrderClicked
            }
        )
    }
}


@Composable
private fun OrderItemsList(
    modifier: Modifier = Modifier,
    orders: List<OrderItem>,
    onOrderItemClicked:(OrderItem) -> Unit
){
    val context = LocalContext.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(orders){ order ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clickable{
                        onOrderItemClicked(order)
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = ImageRequest
                            .Builder(context)
                            .data(order.restaurant.image)
                            .build(),
                        contentDescription = order.restaurant.name,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .size(120.dp)
                    )

                    Spacer(
                        modifier = Modifier
                            .width(8.dp)
                    )

                    Column() {
                        Text(
                            text = order.restaurant.name,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            color = PrimaryTextColor
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${order.itemsCount} items",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                fontFamily = sofiaFamily,
                                color = SmallLabelTextColor,
                            )

                            Text(
                                text = order.date,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 11.sp,
                                color = PrimaryButtonColor
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun OrdersHistoryPreview(){
    ComidaTheme {
        OrdersHistoryScreen(
            paddingValues = PaddingValues(),
            onOrderClicked = {}
        )
    }
}