package com.example.comida.viewmodels.orders

import androidx.lifecycle.ViewModel
import com.example.comida.domain.repository.OrdersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject


@HiltViewModel
class OrderStatusViewModel @Inject constructor(
    private val ordersRepository: OrdersRepository
): ViewModel() {
}