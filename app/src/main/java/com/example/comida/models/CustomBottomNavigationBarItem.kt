package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R


data class CustomBottomNavigationBarItem(
    val badgeCount: Int? = null,
    val contentDescription: String,
    @DrawableRes val icon: Int
)



val bottomNavigationBarItems = listOf<CustomBottomNavigationBarItem>(
    CustomBottomNavigationBarItem(
        contentDescription = "Home Icon",
        icon = R.drawable.home_icon
    ),
    CustomBottomNavigationBarItem(
        contentDescription = "Cart Icon",
        icon = R.drawable.cart_icon
    ),
    CustomBottomNavigationBarItem(
        contentDescription = "Profile Icon",
        icon = R.drawable.profile_icon
    ),
    CustomBottomNavigationBarItem(
        contentDescription = "Notifications Icon",
        icon = R.drawable.notification_icon,
        badgeCount = 4
    ),
)
