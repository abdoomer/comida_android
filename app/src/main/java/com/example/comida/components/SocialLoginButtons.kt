package com.example.comida.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comida.R
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.poppinsFamily


@Composable
fun SocialLoginButtons(
    modifier: Modifier = Modifier,
    onFacebookButtonClicked: () -> Unit,
    onGoogleButtonClicked: () -> Unit,
){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onFacebookButtonClicked,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(25.dp),
            elevation = ButtonDefaults.buttonElevation(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.35f),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.facebook_icon),
                    contentDescription = "Facebook Button",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(40.dp)
                )

                Text(
                    text = "FACEBOOK",
                    fontFamily = poppinsFamily,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            }
        }

        Spacer(
            modifier = Modifier
                .width(16.dp)
        )

        Button(
            onClick = onGoogleButtonClicked,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(25.dp),
            elevation = ButtonDefaults.buttonElevation(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.65f),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.google_icon),
                    contentDescription = "Google Button",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .size(40.dp)
                )

                Text(
                    text = "GOOGLE",
                    fontFamily = poppinsFamily,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun SocialLoginButtonsPreview(){
    ComidaTheme {
        SocialLoginButtons(
            onGoogleButtonClicked = {},
            onFacebookButtonClicked = {}
        )
    }
}