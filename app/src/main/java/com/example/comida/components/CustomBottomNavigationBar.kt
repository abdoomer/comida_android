package com.example.comida.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comida.models.navigation.CustomBottomNavigationBarItem
import com.example.comida.models.navigation.bottomNavigationBarItems
import com.example.comida.ui.theme.BottomNavigationIconsColor
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.OnboardingBackgroundColor3
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.SecondaryTextColor
import com.example.comida.ui.theme.poppinsFamily


@Composable
fun CustomBottomNavigationBar(
    modifier: Modifier = Modifier,
    currentIndex: Int,
    onButtonClicked: (CustomBottomNavigationBarItem) -> Unit
){
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(SecondaryTextColor),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        bottomNavigationBarItems.forEachIndexed { index, item ->
            Column(
                modifier = Modifier
                    .padding(top = 12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier,
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            onButtonClicked(item)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = item.contentDescription,
                            tint = if (index == currentIndex) PrimaryButtonColor else BottomNavigationIconsColor,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }

                    if (item.badgeCount != null ){
                        Text(
                            text = "${item.badgeCount}",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 9.sp,
                            fontFamily = poppinsFamily,
                            color = Color.White,
                            modifier = Modifier
                                .offset(x = (-10).dp, y = (-2).dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(OnboardingBackgroundColor3)
                                .padding(horizontal = 8.dp)
                                .align(Alignment.TopEnd)
                        )
                    }
                }

                if (currentIndex == index){
                    Box(
                        modifier = Modifier
                            .height(3.dp)
                            .width(28.dp)
                            .background(PrimaryButtonColor)
                            .clip(RoundedCornerShape(16.dp))
                    )
                }
            }
        }
    }
}



@Composable
@Preview(showSystemUi = true, showBackground = true)
private fun CustomBottomNavigationBarPreview(){
    ComidaTheme {
        CustomBottomNavigationBar(
            currentIndex = 1,
            onButtonClicked = {}
        )
    }
}