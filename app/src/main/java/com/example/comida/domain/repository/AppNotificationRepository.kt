package com.example.comida.domain.repository

import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.AppNotificationDao
import com.example.comida.domain.usecase.NotificationsUseCase
import com.example.comida.models.notifications.AppNotification
import com.example.comida.models.ResourceResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppNotificationRepository @Inject constructor(
    private val notificationsUseCase: NotificationsUseCase,
    private val appCoroutineScope: AppCoroutineScope
): AppNotificationDao {

    private val _appNotifications: MutableStateFlow<List<AppNotification>> = MutableStateFlow(emptyList())

    init {
        fetchDummyNotifications()
    }

    override fun fetchDummyNotifications(){
        appCoroutineScope.launch {
            notificationsUseCase().collect { result ->
                when(result) {
                    is ResourceResult.Loading -> {}
                    is ResourceResult.Success -> {
                        _appNotifications.emit(result.data)
                    }
                    is ResourceResult.Error -> {}
                    else -> Unit
                }
            }
        }
    }

    override fun fetchAppNotifications(): List<AppNotification> {
        return _appNotifications.value
    }


    override fun getNotification(id: String): AppNotification {
        return _appNotifications.value.first() { it.id == id}
    }
}