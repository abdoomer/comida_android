package com.example.comida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.comida.screens.SignInScreen
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.viewmodels.AuthenticationViewmodel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()

        setContent {
            ComidaTheme {

                val otpViewmodel: AuthenticationViewmodel = viewModel()

//                OTPVerificationScreen(viewModel = otpViewmodel)

                SignInScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComidaTheme {
    }
}