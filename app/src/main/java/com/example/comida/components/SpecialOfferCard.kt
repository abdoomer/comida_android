package com.example.comida.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.comida.R
import com.example.comida.models.SpecialOffer
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.OfferBuyNowButtonColor
import com.example.comida.ui.theme.OfferSmallLabelColor
import com.example.comida.ui.theme.OnboardingBackgroundColor3
import com.example.comida.ui.theme.bebasFamily
import com.example.comida.ui.theme.poppinsFamily


@Composable
fun SpecialOfferCard(
    modifier: Modifier = Modifier,
    offer: SpecialOffer,
    onSpecialOfferTapped: (SpecialOffer) -> Unit,
    onBuyNowClicked: (SpecialOffer) -> Unit,
){

    val context = LocalContext.current

    Card(
        modifier = modifier
            .fillMaxWidth(0.85f)
            .clickable{
                onSpecialOfferTapped(offer)
            },
        colors = CardDefaults.cardColors(
            containerColor = offer.backgroundColor
        )
    )
    {
        Row(
            modifier = Modifier
                .padding(end = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterHorizontally)
        ) {
            AsyncImage(
                model = ImageRequest
                    .Builder(context)
                    .data(offer.offerImage)
                    .build(),
                contentDescription = offer.title,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(150.dp)
            )

            Column(
                modifier = Modifier
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterHorizontally)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.star),
                        contentDescription = "Rating Icon",
                        tint = OnboardingBackgroundColor3,
                        modifier = Modifier
                            .size(16.dp)
                    )

                    Text(
                        text = "${offer.ratingValue}",
                        fontFamily = bebasFamily,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        color = OfferSmallLabelColor
                    )
                }

                Text(
                    text = offer.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = poppinsFamily,
                    color = Color.White
                )

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterHorizontally)
                ) {

                    Icon(
                        painter = painterResource(R.drawable.delivery_icon),
                        contentDescription = "Delivery Icon",
                        tint = OfferSmallLabelColor,
                        modifier = Modifier
                            .size(16.dp)
                    )

                    Text(
                        text = if (offer.isFreeDelivery) "Free delivery" else "$5 Delivery fee",
                        fontWeight = FontWeight.Normal,
                        fontFamily = bebasFamily,
                        fontSize = 12.sp,
                        color = OfferSmallLabelColor
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            onBuyNowClicked(offer)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = OfferBuyNowButtonColor
                        )
                    ) {
                        Text(
                            text = "Buy Now",
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 10.sp,
                            color = Color.White
                        )
                    }

                    Text(
                        text = "$${offer.price}",
                        fontFamily = bebasFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = OfferSmallLabelColor
                    )
                }
            }
        }
    }
}





@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SpecialOfferCardPreview(){
    ComidaTheme {
//        SpecialOfferCard(
//            offer = specialOffers[0],
//            onSpecialOfferTapped = {},
//            onBuyNowClicked = {}
//        )
    }
}