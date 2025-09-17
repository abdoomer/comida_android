package com.example.comida.models.profile

import androidx.annotation.DrawableRes
import com.example.comida.R


data class SettingsHeaderTile(
    val title: String,
    var showOptions: Boolean = false,
    val type: SettingsHeaderTileType,
    @DrawableRes val image: Int
)


val settingsHeaderTile = listOf<SettingsHeaderTile>(
    SettingsHeaderTile(
        title = "Appearance",
        type = SettingsHeaderTileType.Appearance,
        image = R.drawable.ic_appearance_settings_icon
    ),
    SettingsHeaderTile(
        title = "Notification",
        type = SettingsHeaderTileType.Notification,
        image = R.drawable.notification_icon
    )
)