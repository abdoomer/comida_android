package com.example.comida.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.comida.R
import com.example.comida.models.AppUser
import com.example.comida.models.dummyUser
import com.example.comida.models.profileNavigationTiles
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.IconButtonColor
import com.example.comida.ui.theme.OfferBuyNowButtonColor
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.SmallLabelColor
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.ui.theme.sofiaFamily


@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp)
            .background(Color.White)
    ) {
        LabelTopBar()

        UserInformation(
            userInfo = dummyUser,
            onBarcodeButtonClicked = {}
        )

        NavigationTiles()

        DeleteAccountButton(
            onClicked = {}
        )
    }
}

@Composable
private fun LabelTopBar(
    modifier: Modifier = Modifier,
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "My Account",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = sofiaFamily,
            color = PrimaryTextColor
        )
    }
}


@Composable
private fun UserInformation(
    modifier: Modifier = Modifier,
    userInfo: AppUser,
    onBarcodeButtonClicked: () -> Unit
){
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(userInfo.profilePicture),
            contentDescription = "User Profile Picture",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )

        Row(
            modifier = Modifier
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = userInfo.firstName,
                fontFamily = poppinsFamily,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryTextColor
            )

            Text(
                text = userInfo.lastName,
                fontFamily = poppinsFamily,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryTextColor
            )

            Button(
                onClick = onBarcodeButtonClicked,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp),
                elevation = ButtonDefaults.buttonElevation(4.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_barcode),
                    contentDescription = "Barcode Icon Button",
                    tint = IconButtonColor,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
    }
}

@Composable
private fun NavigationTiles(
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier
            .fillMaxHeight(0.85f)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(profileNavigationTiles){ tile ->
            Card(
                modifier = Modifier
                    .clickable{

                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(tile.icon),
                            contentDescription = tile.title,
                            tint = PrimaryButtonColor,
                            modifier = Modifier
                                .size(20.dp)
                        )

                        Text(
                            text = tile.title,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = poppinsFamily,
                            fontSize = 18.sp,
                            color = SmallLabelColor
                        )
                    }

                    Icon(
                        painter = painterResource(R.drawable.right_arrow_icon),
                        contentDescription = "",
                        tint = SmallLabelColor,
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            }
        }
    }
}


@Composable
private fun DeleteAccountButton(
    modifier: Modifier = Modifier,
    onClicked: () -> Unit
){
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        onClick = onClicked,
        colors = ButtonDefaults.buttonColors(
            containerColor = OfferBuyNowButtonColor
        )
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterHorizontally)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_delete_account),
                contentDescription = "Delete Account Button",
                tint = Color.White,
                modifier = Modifier
                    .size(20.dp)
            )

            Text(
                "Delete My Account",
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFamily,
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun ProfileScreenPreview(){
    ComidaTheme {
        ProfileScreen()
    }
}