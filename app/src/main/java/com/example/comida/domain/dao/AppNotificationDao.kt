package com.example.comida.domain.dao

import com.example.comida.models.AppNotification


interface AppNotificationDao {

    fun fetchAppNotifications() : List<AppNotification>

    fun fetchAppNotification(id: String) : AppNotification
}