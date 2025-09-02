package com.example.comida.domain.dao

import com.example.comida.models.AppNotification


interface AppNotificationDao {

    fun fetchDummyNotifications()

    fun fetchAppNotifications() : List<AppNotification>

    fun setSelectedNotification(newNotification: AppNotification)

    fun getSelectedNotification(): AppNotification
}