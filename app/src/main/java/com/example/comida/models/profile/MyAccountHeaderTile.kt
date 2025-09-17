package com.example.comida.models.profile

import androidx.annotation.DrawableRes
import com.example.comida.R


data class MyAccountHeaderTile(
    val title: String,
    val showOptions: Boolean = false,
    val type: MyAccountHeaderTileType,
    @DrawableRes val image: Int
)


val myAccountHeaderTile = listOf<MyAccountHeaderTile>(
    MyAccountHeaderTile(
        title = "Account Information",
        type = MyAccountHeaderTileType.Account,
        image = R.drawable.ic_account_information_icon
    ),
    MyAccountHeaderTile(
        title = "Address Information",
        type = MyAccountHeaderTileType.Address,
        image = R.drawable.ic_address_icon
    ),
    MyAccountHeaderTile(
        title = "Payment Information",
        type = MyAccountHeaderTileType.Payment,
        image = R.drawable.ic_payment_icon
    ),
)
