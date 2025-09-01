package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R
import com.example.comida.navigation.Screens


data class ProfileNavigationTile(
    val title: String,
    val destinationRoute: String,
    @DrawableRes val icon: Int
)


val profileNavigationTiles = listOf<ProfileNavigationTile>(
    ProfileNavigationTile(
        title = "My Account",
        destinationRoute = Screens.MyAccount.route,
        icon = R.drawable.ic_user_account
    ),
    ProfileNavigationTile(
        title = "Settings",
        destinationRoute = Screens.SettingsScreen.route,
        icon = R.drawable.ic_settings
    ),
    ProfileNavigationTile(
        title = "Terms Of Service",
        destinationRoute = Screens.TermsOfServiceScreen.route,
        icon = R.drawable.ic_terms_of_service
    ),
    ProfileNavigationTile(
        title = "Privacy Policy",
        destinationRoute = Screens.PrivacyPolicyScreen.route,
        icon = R.drawable.ic_privacy_policy
    ),
    ProfileNavigationTile(
        title = "Share The App",
        destinationRoute = "",
        icon = R.drawable.ic_share
    ),
)


