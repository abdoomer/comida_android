package com.example.comida.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.comida.components.CustomBottomNavigationBar
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.viewmodels.ComidaViewmodel


@Composable
fun ComidaAppScreen(
    modifier: Modifier = Modifier,
    viewmodel: ComidaViewmodel,
    navController: NavHostController,
){
    val currentPage = viewmodel.currentPage.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        bottomBar = {
            CustomBottomNavigationBar(
                modifier = Modifier
                    .padding(bottom = 20.dp),
                currentIndex = currentPage.value,
                onButtonClicked = {
                    viewmodel.updateCurrentPage(it.index)
                }
            )
        }
    ) { innerPadding ->
        when(currentPage.value){
            0 -> {
                HomeScreen(
                    paddingValues = innerPadding,
                    navController = navController
                )
            }
            1 -> {
                CartScreen(
                    paddingValues = innerPadding,
                    navController = navController
                )
            }
            2 -> {
                ProfileScreen(
                    paddingValues = innerPadding,
                    navController = navController
                )
            }
            3 -> {
                NotificationsScreen(
                    paddingValues = innerPadding,
                    navController = navController
                )
            }
        }
    }
}



@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ComidaAppScreenPreview(){
    ComidaTheme {
//        ComidaAppScreen(
//            navController = rememberNavController()
//        )
    }
}