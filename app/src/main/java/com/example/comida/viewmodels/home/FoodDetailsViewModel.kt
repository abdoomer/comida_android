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

    private val _quantity: MutableStateFlow<Int> = MutableStateFlow(1)
    val quantity: StateFlow<Int> = _quantity

    fun fetchFoodItem(categoryID: String, foodItemID: String){
        viewModelScope.launch {
            val currentFoodItem = foodRepository.getFoodItem(categoryID = categoryID, foodItemID = foodItemID)

            _item.emit(currentFoodItem)
        }
    }

    fun onAddOnClicked(id: String) {
        viewModelScope.launch {
            val updatedAddOnsList = _item.value.addOns.map { addOn ->
                if (addOn.id == id) {
                    addOn.copy(isAdded = !addOn.isAdded)
                } else {
                    addOn
                }
            }

            _item.emit(_item.value.copy(addOns = updatedAddOnsList))
        }
    }

    fun onItemQuantityUpdated(newValue: Int){
        viewModelScope.launch {
            _quantity.emit(newValue)
        }
    }

    fun onToggleIsFavorites () {
        viewModelScope.launch {
            _item.emit(_item.value.copy(isFavorites = !_item.value.isFavorites))
        }
    }

    fun calculateTotalPrice(){
        viewModelScope.launch {

        }
    }
}