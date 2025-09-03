package com.example.comida.screens.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.viewmodels.orders.OrderDetailsViewModel


@Composable
fun OrderDetailsScreen(
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit
){

    val viewModel: OrderDetailsViewModel = hiltViewModel()
    val order = viewModel.order.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.fetchOrder()
    }

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
            onBackButtonClicked = {}
        )
    }
}