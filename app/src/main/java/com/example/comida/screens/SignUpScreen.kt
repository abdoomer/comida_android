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
import androidx.compose.runtime.Composable
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comida.R
import com.example.comida.components.CustomTextField
import com.example.comida.components.MainTextButton
import com.example.comida.components.SocialLoginButtons
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.SecondarySmallLabelTextColor
import com.example.comida.ui.theme.SmallLabelTextColor
import com.example.comida.ui.theme.bebasFamily
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.viewmodels.SignUpViewModel


@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    viewmodel: SignUpViewModel,
    onBackButtonClicked: () -> Unit
){
    val email = viewmodel.email.collectAsStateWithLifecycle()
    val fullName = viewmodel.fullName.collectAsStateWithLifecycle()
    val password = viewmodel.password.collectAsStateWithLifecycle()
    val showPassword = viewmodel.showPassword.collectAsStateWithLifecycle()

    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.signup_screen_background_image),
            contentDescription = "Sign Up Screen Background Image",
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
                onClick = onBackButtonClicked,
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
                text = "Sign Up",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                fontFamily = poppinsFamily,
            )

            Text(
                text = "Please sign up to get\n started",
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
                    .fillMaxSize()
                    .padding(top = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CustomTextField(
                    labelText = "Full Name",
                    text = fullName.value,
                    hintText = "your full name",
                    onTogglePasswordStatusClicked = {},
                    onTextValueChanged = {
                        viewmodel.updateFullName(it)
                    }
                )

                CustomTextField(
                    labelText = "Email",
                    text = email.value,
                    hintText = "example@gmail.com",
                    onTogglePasswordStatusClicked = {},
                    onTextValueChanged = {
                        viewmodel.updateEmail(it)
                    }
                )

                CustomTextField(
                    labelText = "Password",
                    text = password.value,
                    passwordObscured = showPassword.value,
                    hintText = "**********",
                    onTogglePasswordStatusClicked = {
                        viewmodel.updateShowPassword(!showPassword.value)
                    },
                    onTextValueChanged = {
                        viewmodel.updatePassword(it)
                    }
                )

                MainTextButton(
                    title = "Sign Up",
                    onClicked = {
                        viewmodel.onUserRegister()
                    }
                )

                Text(
                    text = "Or Sign up with",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    color = SecondarySmallLabelTextColor
                )

                SocialLoginButtons(
                    onFacebookButtonClicked = {
                        viewmodel.onFacebookRegister()
                    },
                    onGoogleButtonClicked = {
                        viewmodel.onGoogleRegister()
                    }
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ){
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Already have an account?",
                    color = SmallLabelTextColor,
                    fontFamily = bebasFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )

                TextButton(
                    onClick = onBackButtonClicked
                ) {
                    Text(
                        text = "Login",
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





@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun SignUpScreenPreview(){
    ComidaTheme {
//        SignUpScreen()
    }
}