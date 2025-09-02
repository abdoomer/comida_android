package com.example.comida.domain.repository

import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.CartDao
import com.example.comida.domain.usecase.CartUseCase
import com.example.comida.models.CartItem
import com.example.comida.models.ResourceResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CartRepository @Inject constructor(
    private val cartUseCase: CartUseCase,
    private val appCoroutineScope: AppCoroutineScope
): CartDao {

    private val _cartItems: MutableStateFlow<List<CartItem>> = MutableStateFlow(emptyList())

    init {
        fetchDummyCartItem()
    }

    override fun fetchDummyCartItem(){
        appCoroutineScope.launch {
            cartUseCase().collect { result ->
                when(result) {
                    is ResourceResult.Loading -> {}
                    is ResourceResult.Success -> {
                        _cartItems.emit(result.data)
                    }
                    is ResourceResult.Error -> {}
                    else -> Unit
                }
            }
        }
    }

    override fun getCartItems(): List<CartItem> {
        return _cartItems.value
    }
}