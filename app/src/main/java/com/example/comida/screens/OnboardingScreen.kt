package com.example.comida.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comida.R
import com.example.comida.models.OnboardingScreenItem
import com.example.comida.models.onboardingScreenButtons
import com.example.comida.models.onboardingScreenItems
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.OnboardingBackgroundColor2
import com.example.comida.ui.theme.poppinsFamily


@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){


        OnboardingItem(
            item = OnboardingScreenItem(
                id = 2,
                descriptionText = "Donut worry, be happy and eat more donuts!",
                backgroundImage = R.drawable.onboarding_screen_background_2,
                displayImage = R.drawable.onboarding_screen_image_2,
                descriptionTextColor = Color.White,
                imageTopRight = false,
                imageWidth = 1023.35.dp,
                imageHeight = 585.22.dp,
                backgroundColor = OnboardingBackgroundColor2,
                displayImageAlignment = Alignment.Center as Alignment.Horizontal,
                displayImageYOffset = (-150).dp,
                descriptionTextYOffset = (-170).dp,
            )
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            onboardingScreenButtons.forEach { button ->
                TextButton(
                    onClick = {}
                ) {
                    Text(
                        text = button.text,
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier
                            .clip(RoundedCornerShape(25.dp))
                            .background(button.backgroundColor)
                            .padding(horizontal = 15.dp, vertical = 8.dp)

                    )
                }
            }
        }
    }
}


@Composable
private fun OnboardingItem(
    modifier: Modifier = Modifier,
    item: OnboardingScreenItem
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(item.backgroundColor),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(item.backgroundImage),
            contentDescription = "Onboarding Screen Background Image",
            modifier = Modifier
                .fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(item.displayImage),
                contentDescription = "Onboarding Screen Display Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(item.imageWidth)
                    .height(item.imageHeight)
                    .align(item.displayImageAlignment)
                    .offset(y = item.displayImageYOffset)
            )

            Text(
                text = item.descriptionText,
                color = item.descriptionTextColor,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFamily,
//                style = TextStyle(
//                    lineHeight = 40.sp // Adjust this value to increase or decrease spacing
//                ),
                modifier = Modifier
                    .offset(y = item.descriptionTextYOffset)
            )
        }
    }
}



@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun OnboardingScreenPreview(){
    ComidaTheme {
        OnboardingScreen()
    }
}