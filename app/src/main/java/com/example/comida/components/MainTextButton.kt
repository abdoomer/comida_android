package com.example.comida.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.poppinsFamily


@Composable
fun MainTextButton(
    modifier: Modifier = Modifier,
    title: String,
    onClicked: () -> Unit
){
    Button(
        onClick = onClicked,
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryButtonColor
        ),
        modifier = modifier
            .fillMaxWidth(0.6f)
    ) {
        Text(
            text = title,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .padding(vertical = 8.dp)
        )
    }
}
