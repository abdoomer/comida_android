package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R


data class AppNotification(
    val title: String,
    val description: String,
    val date: String,
    val isRead: Boolean = false,
    @DrawableRes val readImage: Int = R.drawable.ic_read_notification,
    @DrawableRes val unreadImage: Int = R.drawable.ic_unread_notification,
)


val appNotifications = listOf<AppNotification>(
    AppNotification(
        title = "Lorem Ipsum",
        description = "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac" +
                " turpis egestas. Praesent rhoncus accumsan ligula, at commodo purus rutrum vitae." +
                " Mauris vitae urna vitae magna volutpat efficitur id in risus." +
                " Cras elementum sapien ac cursus venenatis." +
                " Nunc euismod luctus nunc, eu porta libero maximus sed." +
                " Integer iaculis gravida massa, vitae suscipit mauris lacinia sit amet." +
                " Aenean neque ligula, tincidunt a convallis sed, congue ut neque.",
        date = "Dec 16, 2025",
    ),
    AppNotification(
        title = "Lorem Ipsum",
        description = "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac" +
                " turpis egestas. Praesent rhoncus accumsan ligula, at commodo purus rutrum vitae." +
                " Mauris vitae urna vitae magna volutpat efficitur id in risus." +
                " Cras elementum sapien ac cursus venenatis." +
                " Nunc euismod luctus nunc, eu porta libero maximus sed." +
                " Integer iaculis gravida massa, vitae suscipit mauris lacinia sit amet." +
                " Aenean neque ligula, tincidunt a convallis sed, congue ut neque.",
        date = "Dec 16, 2025",
    ),
    AppNotification(
        title = "Lorem Ipsum",
        description = "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac" +
                " turpis egestas. Praesent rhoncus accumsan ligula, at commodo purus rutrum vitae." +
                " Mauris vitae urna vitae magna volutpat efficitur id in risus." +
                " Cras elementum sapien ac cursus venenatis." +
                " Nunc euismod luctus nunc, eu porta libero maximus sed." +
                " Integer iaculis gravida massa, vitae suscipit mauris lacinia sit amet." +
                " Aenean neque ligula, tincidunt a convallis sed, congue ut neque.",
        date = "Dec 16, 2025",
    ),
    AppNotification(
        title = "Lorem Ipsum",
        description = "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac" +
                " turpis egestas. Praesent rhoncus accumsan ligula, at commodo purus rutrum vitae." +
                " Mauris vitae urna vitae magna volutpat efficitur id in risus." +
                " Cras elementum sapien ac cursus venenatis." +
                " Nunc euismod luctus nunc, eu porta libero maximus sed." +
                " Integer iaculis gravida massa, vitae suscipit mauris lacinia sit amet." +
                " Aenean neque ligula, tincidunt a convallis sed, congue ut neque.",
        date = "Dec 16, 2025",
    ),
    AppNotification(
        title = "Lorem Ipsum",
        description = "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac" +
                " turpis egestas. Praesent rhoncus accumsan ligula, at commodo purus rutrum vitae." +
                " Mauris vitae urna vitae magna volutpat efficitur id in risus." +
                " Cras elementum sapien ac cursus venenatis." +
                " Nunc euismod luctus nunc, eu porta libero maximus sed." +
                " Integer iaculis gravida massa, vitae suscipit mauris lacinia sit amet." +
                " Aenean neque ligula, tincidunt a convallis sed, congue ut neque.",
        date = "Dec 16, 2025",
    ),
    AppNotification(
        title = "Lorem Ipsum",
        description = "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac" +
                " turpis egestas. Praesent rhoncus accumsan ligula, at commodo purus rutrum vitae." +
                " Mauris vitae urna vitae magna volutpat efficitur id in risus." +
                " Cras elementum sapien ac cursus venenatis." +
                " Nunc euismod luctus nunc, eu porta libero maximus sed." +
                " Integer iaculis gravida massa, vitae suscipit mauris lacinia sit amet." +
                " Aenean neque ligula, tincidunt a convallis sed, congue ut neque.",
        date = "Dec 16, 2025",
    ),
)
