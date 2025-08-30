package com.example.comida.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.ui.theme.ComidaTheme


@Composable
fun SpecialOffersScreen(
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp)
    ) {
        CustomTopAppTitleBar(
            title = "Special Offers",
            haveBackButton = true,
            onBackButtonPressed = onBackButtonClicked
        )
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SpecialOffersScreenPreview(){
    ComidaTheme {
        SpecialOffersScreen(
            onBackButtonClicked = {}
        )
    }
}