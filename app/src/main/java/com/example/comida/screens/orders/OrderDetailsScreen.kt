package com.example.comida.screens.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.models.OrderItem
import com.example.comida.models.orders
import com.example.comida.ui.theme.ComidaTheme


@Composable
fun OrderDetailsScreen(
    modifier: Modifier = Modifier,
    order: OrderItem,
    onBackButtonClicked: () -> Unit
){
    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            CustomTopAppTitleBar(
                title = "Orders Details",
                haveBackButton = true,
                onBackButtonPressed = onBackButtonClicked
            )
        }
    }
}




@Composable
@Preview(showBackground = true, showSystemUi = true)
fun OrderDetailsScreenPreview(){
    ComidaTheme {
        OrderDetailsScreen(
            order = orders[0],
            onBackButtonClicked = {}
        )
    }
}