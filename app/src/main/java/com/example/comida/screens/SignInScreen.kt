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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.input.KeyboardType
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
import com.example.comida.viewmodels.SignInViewModel


@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    viewmodel: SignInViewModel,
    onGoToSignUpClicked: () -> Unit,
    onForgetPasswordClicked: () -> Unit,
){

    val email = viewmodel.email.collectAsStateWithLifecycle()
    val password = viewmodel.password.collectAsStateWithLifecycle()
    val showPassword = viewmodel.showPassword.collectAsStateWithLifecycle()

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
                    .fillMaxSize()
                    .padding(top = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                CustomTextField(
                    labelText = "Email",
                    text = email.value,
                    hintText = "example@gmail.com",
                    keyboardType = KeyboardType.Email,
                    onTogglePasswordStatusClicked = {},
                    onTextValueChanged = {
                       viewmodel.updateEmail(it)
                    }
                )

                CustomTextField(
                    labelText = "Password",
                    text = password.value,
                    hintText = "**********",
                    passwordObscured = showPassword.value,
                    keyboardType = KeyboardType.Password,
                    onTogglePasswordStatusClicked = {
                        viewmodel.updateShowPassword(!showPassword.value)
                    },
                    onTextValueChanged = {
                        viewmodel.updatePassword(it)
                    }
                )

                TextButton(
                    onClick = onForgetPasswordClicked
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
                    onClicked = {
                        viewmodel.onUserLogin()
                    }
                )

                Text(
                    text = "Or login with",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    color = SecondarySmallLabelTextColor,
                )

                SocialLoginButtons(
                    onFacebookButtonClicked = {
                        viewmodel.onFacebookLogin()
                    },
                    onGoogleButtonClicked = {
                        viewmodel.onGoogleLogin()
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
                    text = "Don’t have an account?",
                    color = SmallLabelTextColor,
                    fontFamily = bebasFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )

                TextButton(
                    onClick = onGoToSignUpClicked
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





@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun SignInScreenPreview(){
    ComidaTheme {
//        ComidaThemeSignInScreen(
//            viewmodel = ViewModel(),
//            onForgetPasswordClicked = {},
//            onGoToSignUpClicked = {}
//        )
    }
}