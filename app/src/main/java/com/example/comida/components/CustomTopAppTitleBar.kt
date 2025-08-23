package com.example.comida.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comida.R
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.sofiaFamily


@Composable
fun CustomTopAppTitleBar(
    modifier: Modifier = Modifier,
    title: String,
    haveBackButton: Boolean = false,
    onBackButtonPressed: () -> Unit
){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        if (haveBackButton){
            Button(
                onClick = onBackButtonPressed,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.back_button_icon),
                    contentDescription = "Back Button",
                    tint = Color.Black,
                    modifier = Modifier
                        .width(5.dp)
                        .height(9.68.dp)
                )
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth(0.3f)
            )
        }

        Text(
            text = title,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = sofiaFamily,
            color = PrimaryTextColor
        )

        if (haveBackButton){
            Spacer(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
            )
        }
    }
}