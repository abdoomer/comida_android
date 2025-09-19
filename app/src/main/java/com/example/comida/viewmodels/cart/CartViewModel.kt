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

    fun removeItemFromCart(id: String){
        viewModelScope.launch {
            val updatedCartItemsList = _cartItems.value.filter { it.id != id }

            _cartItems.emit(updatedCartItemsList)
        }
    }

    fun increaseItemQuantity(id: String){
        viewModelScope.launch {
            val updatedCartItemsList = _cartItems.value.map { item ->
                if (item.id == id){
                    item.copy(quantity = item.quantity + 1)
                } else {
                    item
                }
            }

            _cartItems.emit(updatedCartItemsList)
        }
    }

    fun decreaseItemQuantity(id: String){
        viewModelScope.launch {
            val updatedCartItemsList = _cartItems.value.map { item ->
                if (item.id == id){
                    item.copy(quantity = item.quantity - 1)
                } else {
                    item
                }
            }

            _cartItems.emit(updatedCartItemsList)
        }
    }
}