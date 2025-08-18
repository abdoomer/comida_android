package com.example.comida.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.example.comida.models.OnboardingScreenItem
import com.example.comida.models.onboardingScreenButtons
import com.example.comida.models.onboardingScreenItems
import com.example.comida.ui.theme.ComidaTheme
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
            item = onboardingScreenItems[0]
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
                            .border(
                                width = 1.dp,
                                color = if (button.id == 1) Color.White else Color.Transparent,
                                shape = RoundedCornerShape(25.dp)
                            )
                            .clip(RoundedCornerShape(25.dp))
                            .background(button.backgroundColor)
                            .padding(horizontal = 38.dp, vertical = 16.dp)

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
            if (item.id == 2) {
                Text(
                    text = item.descriptionText,
                    color = item.descriptionTextColor,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFamily,
                    minLines = 3,
                    lineHeight = 40.sp,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .offset(y = item.descriptionTextYOffset)
                )

                Image(
                    painter = painterResource(item.displayImage),
                    contentDescription = "Onboarding Screen Display Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(item.imageWidth)
                        .height(item.imageHeight)
                        .align(Alignment.CenterHorizontally)
                        .offset(y = item.displayImageYOffset)
                )
            } else {
                Image(
                    painter = painterResource(item.displayImage),
                    contentDescription = "Onboarding Screen Display Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(item.imageWidth)
                        .height(item.imageHeight)
                        .align(Alignment.End)
                        .offset(y = item.displayImageYOffset)
                )

                Text(
                    text = item.descriptionText,
                    color = item.descriptionTextColor,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFamily,
                    minLines = 3,
                    lineHeight = 40.sp,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .offset(y = item.descriptionTextYOffset)
                )
            }
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