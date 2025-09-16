package com.example.comida.screens.profile

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
import com.example.comida.ui.theme.ComidaTheme


@Composable
fun MyAccountScreen(
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit
){
    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            CustomTopAppTitleBar(
                title = "My Account",
                haveBackButton = true,
                onBackButtonPressed = onBackButtonClicked
            )
        }
    }
}



@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun MyAccountPreview(){
    ComidaTheme {
        MyAccountScreen(
            onBackButtonClicked = {}
        )
    }
}