package com.example.comida.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comida.R
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.SmallLabelTextColor
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.ui.theme.sofiaFamily
import com.example.comida.viewmodels.profile.TermsOfServiceViewModel


@Composable
fun TermsOfServiceScreen(
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit
){

    val viewModel: TermsOfServiceViewModel = hiltViewModel()
    val terms = viewModel.termsOfService.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.getTermsOfService()
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
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CustomTopAppTitleBar(
                title = "Terms Of Service",
                haveBackButton = true,
                onBackButtonPressed = onBackButtonClicked
            )

            Image(
                painter = painterResource(R.drawable.ic_terms_of_use_icon),
                contentDescription = "Privacy Policy Screen image"
            )

            Text(
                text = terms.value.title,
                fontFamily = poppinsFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryTextColor,
                modifier = Modifier
                    .padding(top = 16.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(terms.value.terms) { termItem ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start)
                    ) {
                        Text(
                            text = "\u2022",
                            fontFamily = sofiaFamily,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal,
                            color = SmallLabelTextColor
                        )

                        Text(
                            text = termItem.term,
                            fontFamily = sofiaFamily,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal,
                            color = SmallLabelTextColor
                        )
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun TermsOfServiceScreenPreview(){
    ComidaTheme {
        TermsOfServiceScreen(
            onBackButtonClicked = {}
        )
    }
}