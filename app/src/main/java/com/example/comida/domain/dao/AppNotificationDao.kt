package com.example.comida.domain.dao

import com.example.comida.models.notifications.AppNotification


interface AppNotificationDao {

    fun fetchDummyNotifications()

    fun fetchAppNotifications() : List<AppNotification>

    fun getNotification(id: String): AppNotification
}