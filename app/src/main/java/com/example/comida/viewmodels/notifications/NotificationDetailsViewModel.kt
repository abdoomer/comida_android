package com.example.comida.viewmodels.notifications

import androidx.lifecycle.ViewModel
import com.example.comida.domain.repository.AppNotificationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject


@HiltViewModel
class NotificationDetailsViewModel @Inject constructor(
    private val appNotificationRepository: AppNotificationRepository
): ViewModel() {
}