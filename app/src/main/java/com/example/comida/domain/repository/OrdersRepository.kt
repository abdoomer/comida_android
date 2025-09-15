package com.example.comida.domain.repository

import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.OrdersDao
import com.example.comida.domain.usecase.OrdersUseCase
import com.example.comida.models.orders.OrderItem
import com.example.comida.models.ResourceResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class OrdersRepository @Inject constructor(
    private val ordersUseCase: OrdersUseCase,
    private val appCoroutineScope: AppCoroutineScope
): OrdersDao {

    private val _orders: MutableStateFlow<List<OrderItem>> = MutableStateFlow(emptyList())

    private val _currentSelectedOrder: MutableStateFlow<OrderItem> = MutableStateFlow(OrderItem())

    init {
        fetchDummyOrders()
    }


    override fun fetchDummyOrders(){
        appCoroutineScope.launch {
            ordersUseCase().collect { result ->
                when(result) {
                    is ResourceResult.Loading -> {}
                    is ResourceResult.Success -> {
                        _orders.emit(result.data)
                    }
                    is ResourceResult.Error -> {}
                    else -> Unit
                }
            }
        }
    }

    override fun getAllOrders(): List<OrderItem> {
        return _orders.value
    }

    override fun setSelectedOrder(newOrder: OrderItem) {
        appCoroutineScope.launch {
            _currentSelectedOrder.emit(newOrder)
        }
    }

    override fun getSelectedOrder(): OrderItem {
        return _currentSelectedOrder.value
    }
}