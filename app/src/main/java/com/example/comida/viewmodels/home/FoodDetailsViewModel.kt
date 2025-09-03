package com.example.comida.viewmodels.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.FoodRepository
import com.example.comida.models.FoodItem
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class FoodDetailsViewModel @Inject constructor(
    private val foodRepository: FoodRepository,
): ViewModel() {

    private val _item: MutableStateFlow<FoodItem> = MutableStateFlow(FoodItem())
    val item: StateFlow<FoodItem> = _item

    fun fetchFoodItem(){
        viewModelScope.launch {
            val currentFoodItem = foodRepository.getSelectedFood()

            _item.emit(currentFoodItem)
        }
    }
}