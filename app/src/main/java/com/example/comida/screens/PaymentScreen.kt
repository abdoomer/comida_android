package com.example.comida.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.ui.theme.ComidaTheme


@Composable
fun PaymentScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.White)
    ) {
        CustomTopAppTitleBar(
            title = "Payment",
            haveBackButton = true,
            onBackButtonPressed = {}
        )
    }
}




@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun PaymentScreenPreview(){
    ComidaTheme {
        PaymentScreen(
            paddingValues = PaddingValues(0.dp),
        )
    }
}