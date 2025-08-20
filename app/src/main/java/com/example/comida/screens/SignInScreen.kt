package com.example.comida.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comida.R
import com.example.comida.components.MainTextButton
import com.example.comida.components.SocialLoginButtons
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.SecondarySmallLabelTextColor
import com.example.comida.ui.theme.SmallLabelTextColor
import com.example.comida.ui.theme.bebasFamily
import com.example.comida.ui.theme.poppinsFamily


@Composable
fun SignInScreen(
    modifier: Modifier = Modifier
){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.login_screen_background_image),
            contentDescription = "Login Screen Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .fillMaxWidth()
                .height(387.dp)
                .background(Color.Black)
        )

        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {},
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

            Text(
                text = "Login",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                fontFamily = poppinsFamily,
            )

            Text(
                text = "Please sign in to your\n existing account",
                color = Color.White,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                modifier = Modifier
                    .alpha(0.8f)
            )
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .background(Color.White)

                .align(Alignment.BottomEnd)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = email,
                    onValueChange = { email = it }
                )

                TextField(
                    value = password,
                    onValueChange = { password = it }
                )

                TextButton(
                    onClick = {}
                ) {
                    Text(
                        text = "Forgot Password",
                        color = PrimaryButtonColor,
                        fontFamily = poppinsFamily,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                MainTextButton(
                    title = "Login",
                    onClicked = {}
                )

                Text(
                    text = "Or login with",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    color = SecondarySmallLabelTextColor
                )

                SocialLoginButtons(
                    onFacebookButtonClicked = {},
                    onGoogleButtonClicked = {}
                )

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "Don’t have an account?",
                        color = SmallLabelTextColor,
                        fontFamily = bebasFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 13.sp
                    )

                    TextButton(
                        onClick = {}
                    ) {
                        Text(
                            text = "Sign Up",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            color = PrimaryButtonColor,
                            fontFamily = bebasFamily
                        )
                    }
                }
            }
        }
    }
}





@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun SignInScreenPreview(){
    ComidaTheme {
        SignInScreen()
    }
}