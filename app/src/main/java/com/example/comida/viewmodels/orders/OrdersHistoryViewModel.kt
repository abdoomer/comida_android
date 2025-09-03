package com.example.comida.viewmodels.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.OrdersRepository
import com.example.comida.models.OrderItem
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class OrdersHistoryViewModel @Inject constructor(
    private val ordersRepository: OrdersRepository
) : ViewModel(){

    private val _orders: MutableStateFlow<List<OrderItem>> = MutableStateFlow(emptyList())
    val orders: StateFlow<List<OrderItem>> = _orders


    fun fetchOrdersHistory(){
        viewModelScope.launch {
            val ordersList = ordersRepository.getAllOrders()

            _orders.emit(ordersList)
        }
    }

    fun updateCurrentSelectedOrder(currentOrder: OrderItem){
        viewModelScope.launch {
            ordersRepository.setSelectedOrder(currentOrder)
        }
    }
}