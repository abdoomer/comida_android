package com.example.comida.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.comida.dummy.foodItems.burgersCategory
import com.example.comida.models.FoodItem
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.SmallLabelTextColor
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.ui.theme.sofiaFamily


@SuppressLint("DefaultLocale")
@Composable
fun FoodCategoryItemCard(
    modifier: Modifier = Modifier,
    item: FoodItem,
    onAddToCartClicked: (FoodItem) -> Unit,
    onItemClicked: (FoodItem) -> Unit,
){
    val context = LocalContext.current

    Box(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 16.dp)
                .clickable{
                    onItemClicked(item)
                },
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(24.dp),
            border = BorderStroke(1.5.dp, PrimaryButtonColor),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                AsyncImage(
                    model = ImageRequest
                        .Builder(context)
                        .data(item.image)
                        .build(),
                    contentDescription = item.title,
                    contentScale = ContentScale.FillBounds,
                    placeholder = painterResource(R.drawable.ic_placeholder_image),
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .size(140.dp)
                )

                Spacer(
                    modifier = Modifier
                        .width(8.dp)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = item.title,
                        fontFamily = poppinsFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Text(
                        text = item.description,
                        maxLines = 2,
                        fontFamily = sofiaFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = SmallLabelTextColor
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "${String.format("%.2f", item.weight)}gm",
                            fontFamily = sofiaFamily,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Green.copy(alpha = 0.7f)
                        )

                        Spacer(
                            modifier = Modifier
                                .width(8.dp)
                        )

                        Text(
                            text = "${String.format("%.2f", item.discountPercentage)}%",
                            fontFamily = sofiaFamily,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Red.copy(alpha = 0.5f)
                        )
                    }

                    Row() {
                        Text(
                            text = "$${String.format("%.2f", item.price)}",
                            fontSize = 16.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = PrimaryButtonColor
                        )

                        Spacer(
                            modifier = Modifier
                                .width(8.dp)
                        )

//                        Text(
//                            text = String.format("%.2f", discountAmount)
//                        )
                    }
                }
            }
        }

        Button(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = (-16).dp, y = 2.dp)
                .clip(RoundedCornerShape(16.dp)),
            onClick = {
                onAddToCartClicked(item)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryButtonColor
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_plus),
                contentDescription = "Add To Cart Icon",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}



@Composable
@Preview(showBackground = true, showSystemUi = true)
fun FoodCategoryItemCardPreview(){
    ComidaTheme {
        FoodCategoryItemCard(
            item = burgersCategory[0],
            onAddToCartClicked = {},
            onItemClicked = {},
        )
    }
}