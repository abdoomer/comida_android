package com.example.comida.viewmodels.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.OrdersRepository
import com.example.comida.models.orders.OrderItem
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class OrderDetailsViewModel @Inject constructor(
    private val ordersRepository: OrdersRepository
): ViewModel() {

    private val _order: MutableStateFlow<OrderItem> = MutableStateFlow(OrderItem())
    val order: StateFlow<OrderItem> = _order


    fun fetchOrder(orderID: String){
        viewModelScope.launch {
            val currentOrder = ordersRepository.getOrder(id = orderID)

            _order.emit(currentOrder)
        }
    }
}