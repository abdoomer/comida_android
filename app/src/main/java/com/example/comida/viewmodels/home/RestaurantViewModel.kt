package com.example.comida.viewmodels.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.RestaurantsRepository
import com.example.comida.models.FoodItem
import com.example.comida.models.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val restaurantsRepository: RestaurantsRepository,
): ViewModel() {

    private val _restaurant: MutableStateFlow<Restaurant> = MutableStateFlow(Restaurant())
    val restaurant: StateFlow<Restaurant> = _restaurant

    fun fetchRestaurant(restaurantID: String){
        viewModelScope.launch {
            val currentRestaurant = restaurantsRepository.getRestaurant(id = restaurantID)

            _restaurant.emit(currentRestaurant)
        }
    }
}