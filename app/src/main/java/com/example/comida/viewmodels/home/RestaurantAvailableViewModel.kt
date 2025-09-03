package com.example.comida.viewmodels.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.RestaurantsRepository
import com.example.comida.models.FoodItem
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class RestaurantAvailableViewModel @Inject constructor(
    private val restaurantsRepository: RestaurantsRepository,
): ViewModel() {

    private val _availableFoods: MutableStateFlow<List<FoodItem>> = MutableStateFlow(emptyList())
    val availableFoods: StateFlow<List<FoodItem>> = _availableFoods

    fun fetchAvailableFoods(){
        viewModelScope.launch {
            val foodList = restaurantsRepository.getRestaurantFoodList()

            _availableFoods.emit(foodList)
        }
    }
}