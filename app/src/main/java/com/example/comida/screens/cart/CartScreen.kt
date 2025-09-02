package com.example.comida.screens.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.comida.R
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.models.CartItem
import com.example.comida.models.cartItems
import com.example.comida.ui.theme.BottomNavigationIconsColor
import com.example.comida.ui.theme.CellDividerColor
import com.example.comida.ui.theme.CheckoutOverlayBoxColor
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.PromotionTextFieldBorderColor
import com.example.comida.ui.theme.QuantityIconButtonColor
import com.example.comida.ui.theme.SecondarySmallLabelTextColor
import com.example.comida.ui.theme.SmallLabelTextColor
import com.example.comida.ui.theme.bebasFamily
import com.example.comida.ui.theme.poppinsFamily


@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    navController: NavHostController
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.White)
    ) {
        CustomTopAppTitleBar(
            title = "Cart",
            haveBackButton = false,
            onBackButtonPressed = {}
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight(0.6f)
                    .align(Alignment.TopCenter),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(cartItems){ item ->
                    CartFoodItem(
                        item = item,
                        onRemoveItemClicked = {}
                    )
                }
            }

            CartOrderTotalDetails(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = 108.dp),
                subtotal = 12.0,
                taxFees = 4.10,
                delivery = 1.0,
                onPromotionCodeAdded = {}
            )

            DeliveryAddressCard(
                modifier = Modifier
                    .align(Alignment.BottomCenter),
                address = "Avinguda Meridiana, 350, 358, 08027 Barcelona",
                totalAmount = 17.30,
                onCheckoutClicked = {}
            )
        }
    }
}


@Composable
private fun CartFoodItem(
    modifier: Modifier = Modifier,
    item: CartItem,
    onRemoveItemClicked: () -> Unit
){
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(item.image),
                contentDescription = item.name,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(90.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item.name,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        minLines = 2,
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                    )

                    Button(
                        onClick = onRemoveItemClicked,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.close_icon),
                            contentDescription = "Remove Item From Cart",
                            tint = PrimaryButtonColor,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$${item.totalPrice}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = PrimaryButtonColor,
                        fontFamily = poppinsFamily
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.75f),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            )
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.minus_icon),
                                contentDescription = "Minus Icon",
                                tint = QuantityIconButtonColor,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(SecondarySmallLabelTextColor)
                                    .padding(4.dp)
                                    .size(16.dp)
                            )
                        }

                        Text(
                            text = "${item.quantity}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            )
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.plus_icon),
                                contentDescription = "Minus Icon",
                                tint = QuantityIconButtonColor,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(SecondarySmallLabelTextColor)
                                    .padding(4.dp)
                                    .size(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun CartOrderTotalDetails(
    modifier: Modifier = Modifier,
    subtotal: Double,
    taxFees: Double,
    delivery: Double,
    onPromotionCodeAdded: (String) -> Unit
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        PromotionCard(
            onPromotionCodeAdded = {
                onPromotionCodeAdded(it)
            }
        )


        CartOrderTotalDetailsCell(
            title = "Subtotal",
            amount = subtotal
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(CellDividerColor)
        )

        CartOrderTotalDetailsCell(
            title = "Tax and Fees",
            amount = taxFees
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(CellDividerColor)
        )

        CartOrderTotalDetailsCell(
            title = "Delivery",
            amount = delivery
        )
    }
}


@Composable
private fun PromotionCard(
    modifier: Modifier = Modifier,
    onPromotionCodeAdded: (String) -> Unit
){
    var promotionCode by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        OutlinedTextField(
            value = promotionCode,
            onValueChange = {
                promotionCode = it
            },
            placeholder = {
                Text(
                    text = "Promo Code"
                )
            },
            shape = RoundedCornerShape(25.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = PromotionTextFieldBorderColor,
                unfocusedBorderColor = PromotionTextFieldBorderColor,
                errorBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent,
            )
        )

        Button(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 52.dp),
            onClick = {
                onPromotionCodeAdded(promotionCode)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryButtonColor
            )
        ) {
            Text(
                text = "Add",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}


@Composable
private fun CartOrderTotalDetailsCell(
    modifier: Modifier = Modifier,
    title: String,
    amount: Double
){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontFamily = bebasFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = SmallLabelTextColor
        )

        Text(
            text = "$${amount}",
            fontFamily = bebasFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = SmallLabelTextColor
        )
    }
}

@Composable
private fun DeliveryAddressCard(
    modifier: Modifier = Modifier,
    address: String,
    totalAmount: Double,
    onCheckoutClicked: () -> Unit
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .clip(RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp))
            .background(PrimaryTextColor)
    ){
        Column(
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Delivery Address",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Color.White
            )

            Text(
                text = address,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = BottomNavigationIconsColor,
                minLines = 2
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(CheckoutOverlayBoxColor)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Total",
                    fontFamily = bebasFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = BottomNavigationIconsColor,
                )

                Text(
                    "$${totalAmount}",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp,
                    color = Color.White,
                )

                Button(
                    onClick = onCheckoutClicked,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryButtonColor
                    )
                ) {
                    Text(
                        text = "Go to checkout",
                        fontFamily = poppinsFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                    )
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun CartScreenPreview(){
    ComidaTheme {
        CartScreen(
            paddingValues = PaddingValues(0.dp),
            navController = rememberNavController()
        )
    }
}