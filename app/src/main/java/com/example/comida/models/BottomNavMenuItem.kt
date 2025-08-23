package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R

data class BottomNavMenuItem(
    val badgeCount: Int? = null,
    @DrawableRes val icon: Int
)


val bottomNavMenuItems = listOf<BottomNavMenuItem>(
    BottomNavMenuItem(
        icon = R.drawable.home_icon,
    ),
    BottomNavMenuItem(
        icon = R.drawable.cart_icon,
    ),
    BottomNavMenuItem(
        icon = R.drawable.profile_icon,
    ),
    BottomNavMenuItem(
        icon = R.drawable.notification_icon,
        badgeCount = 4
    ),
)