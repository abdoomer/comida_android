package com.example.comida.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.components.SpecialOfferCard
import com.example.comida.models.SpecialOffer
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.viewmodels.home.SpecialOffersViewModel


@Composable
fun SpecialOffersScreen(
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit,
    onSpecialOfferTapped: (SpecialOffer) -> Unit,
    onBuyNowClicked: (SpecialOffer) -> Unit,
){
    val viewModel: SpecialOffersViewModel = hiltViewModel()
    val specialOffers = viewModel.specialOffers.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.fetchAllSpecialOffers()
    }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            CustomTopAppTitleBar(
                title = "Special Offers",
                haveBackButton = true,
                onBackButtonPressed = onBackButtonClicked
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                items(specialOffers.value){ offer ->
                    SpecialOfferCard(
                        offer = offer,
                        onSpecialOfferTapped = onSpecialOfferTapped,
                        onBuyNowClicked = onBuyNowClicked
                    )
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SpecialOffersScreenPreview(){
    ComidaTheme {
        SpecialOffersScreen(
            onBackButtonClicked = {},
            onSpecialOfferTapped = {},
            onBuyNowClicked = {}
        )
    }
}