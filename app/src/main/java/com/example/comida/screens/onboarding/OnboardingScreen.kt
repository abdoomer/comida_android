package com.example.comida.screens.onboarding

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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.comida.models.onboarding.onboardingScreenButtons
import com.example.comida.models.onboarding.onboardingScreenItems
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.ui.theme.sofiaFamily
import kotlinx.coroutines.launch


@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onNavigationButtonClicked: (String) -> Unit,
    onUpdateAppFirstTimeRun: () -> Unit
){

    val pagerState: PagerState = rememberPagerState(initialPage = 0) {
        onboardingScreenItems.size
    }
    val scope = rememberCoroutineScope()


    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){


        HorizontalPager(
            state = pagerState
        ) { index ->
            OnboardingItem(
                currentIndex = index,
                onBackClicked = {
                    if (pagerState.currentPage > 0){
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
                },
                onNextClicked = {
                    if (pagerState.currentPage < onboardingScreenItems.size - 1){
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                },
                onGetStartedClicked = {
                    onUpdateAppFirstTimeRun
                }
            )
        }


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
                    onClick = {
                        onNavigationButtonClicked(button.routeDestination)
                    }
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
    currentIndex: Int,
    onBackClicked: () -> Unit,
    onNextClicked: () -> Unit,
    onGetStartedClicked: () -> Unit,
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(onboardingScreenItems[currentIndex].backgroundColor),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(onboardingScreenItems[currentIndex].backgroundImage),
            contentDescription = "Onboarding Screen Background Image",
            modifier = Modifier
                .fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (onboardingScreenItems[currentIndex].id == 2) {
                Text(
                    text = onboardingScreenItems[currentIndex].descriptionText,
                    color = onboardingScreenItems[currentIndex].descriptionTextColor,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFamily,
                    minLines = 3,
                    lineHeight = 40.sp,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .offset(y = onboardingScreenItems[currentIndex].descriptionTextYOffset)
                )

                Image(
                    painter = painterResource(onboardingScreenItems[currentIndex].displayImage),
                    contentDescription = "Onboarding Screen Display Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(onboardingScreenItems[currentIndex].imageWidth)
                        .height(onboardingScreenItems[currentIndex].imageHeight)
                        .align(Alignment.CenterHorizontally)
                        .offset(y = onboardingScreenItems[currentIndex].displayImageYOffset)
                )
            } else {
                Image(
                    painter = painterResource(onboardingScreenItems[currentIndex].displayImage),
                    contentDescription = "Onboarding Screen Display Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(onboardingScreenItems[currentIndex].imageWidth)
                        .height(onboardingScreenItems[currentIndex].imageHeight)
                        .align(Alignment.End)
                        .offset(y = onboardingScreenItems[currentIndex].displayImageYOffset)
                )

                Text(
                    text = onboardingScreenItems[currentIndex].descriptionText,
                    color = onboardingScreenItems[currentIndex].descriptionTextColor,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFamily,
                    minLines = 3,
                    lineHeight = 40.sp,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .offset(y = onboardingScreenItems[currentIndex].descriptionTextYOffset)
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ){
            OnboardingNavigation(
                modifier = Modifier
                    .offset(y = (-100).dp),
                currentIndex = currentIndex,
                onBackClicked = onBackClicked,
                onNextClicked = onNextClicked,
                onGetStartedClicked = onGetStartedClicked,
            )
        }
    }
}


@Composable
private fun OnboardingNavigation(
    modifier: Modifier = Modifier,
    currentIndex: Int,
    onBackClicked: () -> Unit,
    onNextClicked: () -> Unit,
    onGetStartedClicked: () -> Unit,
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (currentIndex > 0) {
            TextButton(
                onClick = onBackClicked
            ) {
                Text(
                    text = "Back",
                    fontFamily = sofiaFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(0.4f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            repeat(onboardingScreenItems.size){ index ->
                Box(
                    modifier = Modifier
                        .height(16.dp)
                        .width(if (currentIndex == index) 28.dp else 16.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(if (currentIndex == index) Color.White else Color.White.copy(alpha = 0.5f))
                )
            }
        }

        if (onboardingScreenItems.size - 1 != currentIndex){
            TextButton(
                onClick = onNextClicked
            ) {
                Text(
                    text = "Next",
                    fontFamily = sofiaFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )

            }
        } else {
            TextButton(
                onClick = {
                    onGetStartedClicked
                }
            ) {
                Text(
                    text = "Get Started",
                    fontFamily = sofiaFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )

            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun OnboardingScreenPreview(){
    ComidaTheme {
        OnboardingScreen(
            onNavigationButtonClicked = {},
            onUpdateAppFirstTimeRun = {}
        )
    }
}