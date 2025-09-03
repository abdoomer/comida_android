package com.example.comida.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.comida.models.Restaurant
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.OnboardingBackgroundColor3
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.SmallIconLabelColor
import com.example.comida.ui.theme.bebasFamily
import com.example.comida.ui.theme.poppinsFamily


@Composable
fun RestaurantCard(
    modifier: Modifier = Modifier,
    restaurant: Restaurant,
    onRestaurantTapped: (Restaurant) -> Unit,
    onToggleIsFavoriteTapped: (Boolean) -> Unit
){

    val context = LocalContext.current

    Card(
        modifier = modifier
            .clickable{
                onRestaurantTapped(restaurant)
            }
            .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    )
    {
        Column(
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                AsyncImage(
                    model = ImageRequest
                        .Builder(context)
                        .data(restaurant.image)
                        .build(),
                    contentDescription = restaurant.name,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                )

                Button(
                    modifier = Modifier
                        .align(Alignment.TopEnd),
                    onClick = {
                        onToggleIsFavoriteTapped(restaurant.isFavorites)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.heart_icon),
                        contentDescription = "Toggle Favorites Icon Button",
                        tint = Color.White,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.3f))
                            .padding(8.dp)
                            .size(24.dp)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,

                ) {
                Text(
                    text = restaurant.name,
                    fontFamily = poppinsFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = PrimaryTextColor,
                )

                Spacer(
                    modifier = Modifier
                        .width(80.dp)
                )

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.star),
                        contentDescription = "Rating Icon",
                        tint = OnboardingBackgroundColor3,
                        modifier = Modifier
                            .size(16.dp)
                    )

                    Text(
                        text = "${restaurant.ratingValue}",
                        fontFamily = bebasFamily,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        color = PrimaryTextColor
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Icon(
                        painter = painterResource(R.drawable.delivery_icon),
                        contentDescription = "Delivery Icon",
                        tint = PrimaryButtonColor,
                        modifier = Modifier
                            .size(16.dp)
                    )

                    Text(
                        text = if (restaurant.isFreeDelivery) "Free delivery" else "$5 Delivery fee",
                        fontWeight = FontWeight.Normal,
                        fontFamily = bebasFamily,
                        fontSize = 12.sp,
                        color = SmallIconLabelColor
                    )
                }

                Spacer(
                    modifier = Modifier
                        .width(150.dp)
                )

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Icon(
                        painter = painterResource(R.drawable.timer_icon),
                        contentDescription = "Delivery Icon",
                        tint = PrimaryButtonColor,
                        modifier = Modifier
                            .size(16.dp)
                    )

                    Text(
                        text = "${restaurant.deliveryTime}",
                        fontWeight = FontWeight.Normal,
                        fontFamily = bebasFamily,
                        fontSize = 12.sp,
                        color = SmallIconLabelColor
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
        }
    }
}




@Composable
@Preview(showBackground = true, showSystemUi = true)
fun RestaurantCardPreview(){
    ComidaTheme {
//        RestaurantCard(
//            onRestaurantTapped = {},
//            onToggleIsFavoriteTapped = {}
//        )
    }
}