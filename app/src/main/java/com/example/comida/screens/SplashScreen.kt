package com.example.comida.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.comida.R
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.PrimaryButtonColor


@Composable
fun SplashScreen(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(PrimaryButtonColor),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(R.drawable.splash_screen_background),
            contentDescription = "Splash Screen Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )

        Image(
            painter = painterResource(R.drawable.comida_app_icon),
            contentDescription = "Comida App Icon",
            modifier = Modifier
                .size(250.dp)
        )
    }
}




@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun SplashScreenPreview(){
    ComidaTheme {
        SplashScreen()
    }
}