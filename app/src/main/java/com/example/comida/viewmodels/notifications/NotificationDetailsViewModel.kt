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
class NotificationDetailsViewModel @Inject constructor(
    private val appNotificationRepository: AppNotificationRepository
): ViewModel() {

    private val _notification: MutableStateFlow<AppNotification> = MutableStateFlow(AppNotification())
    val notification: StateFlow<AppNotification> = _notification

    fun fetNotification(id: String){
        viewModelScope.launch {
            val currentNotification = appNotificationRepository.getNotification(id = id)

            _notification.emit(currentNotification)
        }
    }
}