package com.example.comida.viewmodels.notifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.AppNotificationRepository
import com.example.comida.models.notifications.AppNotification
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


@HiltViewModel
class NotificationsViewModel @Inject constructor(
    private val appNotificationRepository: AppNotificationRepository
): ViewModel() {

    private val _appNotifications: MutableStateFlow<List<AppNotification>> = MutableStateFlow(emptyList())
    val appNotifications: StateFlow<List<AppNotification>> = _appNotifications


    fun fetchAllNotifications(){
        viewModelScope.launch {
            val notifications = appNotificationRepository.fetchAppNotifications()

            _appNotifications.emit(notifications)
        }
    }

    fun updateCurrentNotification(newNotification: AppNotification){
        viewModelScope.launch {
            appNotificationRepository.setSelectedNotification(newNotification)
        }
    }
}