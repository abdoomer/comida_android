package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R


data class CustomBottomNavigationBarItem(
    val index: Int,
    val badgeCount: Int? = null,
    val contentDescription: String,
    @DrawableRes val icon: Int
)



val bottomNavigationBarItems = listOf<CustomBottomNavigationBarItem>(
    CustomBottomNavigationBarItem(
        index = 0,
        contentDescription = "Home Icon",
        icon = R.drawable.home_icon
    ),
    CustomBottomNavigationBarItem(
        index = 1,
        contentDescription = "Cart Icon",
        icon = R.drawable.cart_icon
    ),
    CustomBottomNavigationBarItem(
        index = 2,
        contentDescription = "Orders History Icon",
        icon = R.drawable.ic_orders_history
    ),
    CustomBottomNavigationBarItem(
        index = 3,
        contentDescription = "Profile Icon",
        icon = R.drawable.profile_icon
    ),
    CustomBottomNavigationBarItem(
        index = 4,
        contentDescription = "Notifications Icon",
        icon = R.drawable.notification_icon,
        badgeCount = 4
    ),
)
