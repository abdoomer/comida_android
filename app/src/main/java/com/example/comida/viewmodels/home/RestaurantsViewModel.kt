package com.example.comida.viewmodels.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.RestaurantsRepository
import com.example.comida.models.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class RestaurantsViewModel @Inject constructor(
    private val restaurantsRepository: RestaurantsRepository,
): ViewModel() {

    private val _restaurants: MutableStateFlow<List<Restaurant>> = MutableStateFlow(emptyList())
    val restaurants: StateFlow<List<Restaurant>> = _restaurants


    fun fetchAllRestaurant(){
        viewModelScope.launch {
            val restaurantsList = restaurantsRepository.getAllRestaurants()

            _restaurants.emit(restaurantsList)
        }
    }
}