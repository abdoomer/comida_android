package com.example.comida.viewmodels.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.CartRepository
import com.example.comida.models.cart.CartItem
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository
): ViewModel() {

    private val _cartItems: MutableStateFlow<List<CartItem>> = MutableStateFlow(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

    fun fetchAllCartItems(){
        viewModelScope.launch {
            val cartList = cartRepository.getCartItems()

            _cartItems.emit(cartList)
        }
    }
}