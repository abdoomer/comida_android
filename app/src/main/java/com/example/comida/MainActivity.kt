package com.example.comida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comida.navigation.ComidaNavigation
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.viewmodels.ComidaViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ComidaViewmodel by viewModels<ComidaViewmodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.startDestinationFetched.value
            }
        }


        setContent {

            val startDestination = viewModel.startDestination.collectAsStateWithLifecycle()

            ComidaTheme {
                ComidaNavigation(
                    startDestination = startDestination.value
                )
            }
        }
    }
}