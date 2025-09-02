package com.example.comida.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.comida.R
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.models.SpecialOffer
import com.example.comida.models.specialOffers
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.OnboardingBackgroundColor3
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.SmallLabelTextColor
import com.example.comida.ui.theme.bebasFamily
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.ui.theme.sofiaFamily


@Composable
fun OfferScreen(
    modifier: Modifier = Modifier,
    offer: SpecialOffer,
    onBackButtonClicked: () -> Unit
){
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            CustomTopAppTitleBar(
                title = "Offer",
                haveBackButton = true,
                onBackButtonPressed = onBackButtonClicked
            )

            OfferImage(
                offer = offer
            )

            OfferInformation(
                offer = offer
            )
        }
    }
}


@Composable
private fun OfferImage(
    modifier: Modifier = Modifier,
    offer: SpecialOffer,
){
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ){
        AsyncImage(
            model = ImageRequest
                .Builder(context)
                .data(offer.offerImage)
                .crossfade(true)
                .transformations(CircleCropTransformation())
                .build(),
            contentDescription = offer.title,
            modifier = Modifier
                .size(250.dp)
        )

        Image(
            painter = painterResource(R.drawable.ic_limitted_time_offer),
            contentDescription = "Limited Offer Image",
            modifier = Modifier
                .size(90.dp)
                .align(Alignment.BottomStart)
        )
    }
}


@SuppressLint("DefaultLocale")
@Composable
private fun OfferInformation(
    modifier: Modifier = Modifier,
    offer: SpecialOffer,
){
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = offer.title,
            fontFamily = poppinsFamily,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryTextColor
        )

        Text(
            text = offer.description,
            fontFamily = sofiaFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = SmallLabelTextColor
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp, alignment = Alignment.CenterHorizontally)
            ) {

                Icon(
                    painter = painterResource(R.drawable.delivery_icon),
                    contentDescription = "Delivery Icon",
                    tint = PrimaryButtonColor,
                    modifier = Modifier
                        .size(16.dp)
                )

                Text(
                    text = if (offer.isFreeDelivery) "Free delivery" else "$5 Delivery fee",
                    fontWeight = FontWeight.Normal,
                    fontFamily = bebasFamily,
                    fontSize = 12.sp,
                    color = SmallLabelTextColor
                )
            }

            Spacer(
                modifier = Modifier
                    .width(16.dp)
            )

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp, alignment = Alignment.CenterHorizontally)
            ) {

                Icon(
                    painter = painterResource(R.drawable.timer_icon),
                    contentDescription = "Delivery Time Icon",
                    tint = PrimaryButtonColor,
                    modifier = Modifier
                        .size(16.dp)
                )

                Text(
                    text = "${String.format("%.2f", offer.deliveryTime)} min",
                    fontWeight = FontWeight.Normal,
                    fontFamily = bebasFamily,
                    fontSize = 12.sp,
                    color = SmallLabelTextColor
                )
            }

            Spacer(
                modifier = Modifier
                    .weight(1f)
            )

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp, alignment = Alignment.CenterHorizontally)
            ) {

                Icon(
                    painter = painterResource(R.drawable.star),
                    contentDescription = "Delivery Icon",
                    tint = OnboardingBackgroundColor3,
                    modifier = Modifier
                        .size(16.dp)
                )

                Text(
                    text = String.format("%.2f", offer.ratingValue),
                    fontWeight = FontWeight.Normal,
                    fontFamily = bebasFamily,
                    fontSize = 12.sp,
                    color = SmallLabelTextColor
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun OfferScreenPreview(){
    ComidaTheme {
        OfferScreen(
            offer = specialOffers[0],
            onBackButtonClicked = {}
        )
    }
}