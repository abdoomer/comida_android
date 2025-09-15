package com.example.comida.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.comida.R
import com.example.comida.ui.theme.ComidaTheme


@Composable
fun OverlayLoading(
    modifier: Modifier = Modifier
){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ){
        LottieAnimation(
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .fillMaxWidth(0.8f)
                .background(Color.Transparent),
            composition = composition
        )
    }
}



@Composable
@Preview(showBackground = true, showSystemUi = true)
fun OverlayLoadingPreview(){
    ComidaTheme {
        OverlayLoading()
    }
}