package com.example.comida.models.profile

import androidx.annotation.DrawableRes
import com.example.comida.R
import com.example.comida.navigation.MyAccountScreenRoute
import com.example.comida.navigation.PrivacyPolicyScreenRoute
import com.example.comida.navigation.SettingsScreenRoute
import com.example.comida.navigation.TechnicalSupportRoute
import com.example.comida.navigation.TermsOfServiceScreenRoute


data class ProfileNavigationTile(
    val title: String = "",
    val destinationRoute: Any,
    @DrawableRes val icon: Int = 0
)


val profileNavigationTiles = listOf<ProfileNavigationTile>(
    ProfileNavigationTile(
        title = "My Account",
        destinationRoute = MyAccountScreenRoute,
        icon = R.drawable.ic_user_account
    ),
    ProfileNavigationTile(
        title = "Settings",
        destinationRoute = SettingsScreenRoute,
        icon = R.drawable.ic_settings
    ),
    ProfileNavigationTile(
        title = "Terms Of Service",
        destinationRoute = TermsOfServiceScreenRoute,
        icon = R.drawable.ic_terms_of_service
    ),
    ProfileNavigationTile(
        title = "Privacy Policy",
        destinationRoute = PrivacyPolicyScreenRoute,
        icon = R.drawable.ic_privacy_policy
    ),
    ProfileNavigationTile(
        title = "Technical Support",
        destinationRoute = TechnicalSupportRoute,
        icon = R.drawable.ic_support_email
    ),
    ProfileNavigationTile(
        title = "Share The App",
        destinationRoute = "",
        icon = R.drawable.ic_share
    ),
)


