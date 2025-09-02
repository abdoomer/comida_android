package com.example.comida.domain.repository

import com.example.comida.domain.dao.AppNotificationDao
import com.example.comida.domain.usecase.NotificationsUseCase
import com.example.comida.models.AppNotification
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppNotificationRepository @Inject constructor(
    private val notificationsUseCase: NotificationsUseCase
): AppNotificationDao {
    override fun fetchAppNotifications(): List<AppNotification> {
        TODO("Not yet implemented")
    }

    override fun fetchAppNotification(id: String): AppNotification {
        TODO("Not yet implemented")
    }
}