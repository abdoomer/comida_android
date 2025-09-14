package com.example.comida.viewmodels.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.FoodRepository
import com.example.comida.models.FoodCategory
import com.example.comida.models.FoodItem
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class FoodCategoryViewModel @Inject constructor(
    private val foodRepository: FoodRepository,
): ViewModel() {

    private val _searchText: MutableStateFlow<String> = MutableStateFlow("")
    val searchText: StateFlow<String> = _searchText

    private val _category: MutableStateFlow<FoodCategory> = MutableStateFlow(FoodCategory())
    val category: StateFlow<FoodCategory> = _category


    fun fetchSelectedFoodCategory(){
        viewModelScope.launch {
            val currentCategory = foodRepository.getSelectedCategory()

            _category.emit(currentCategory)
        }
    }

    fun updateCurrentSelectedFood(item: FoodItem){
        viewModelScope.launch {
            foodRepository.setSelectedFood(item)
        }
    }

    fun onSearchTextValueChanged(newText: String){
        viewModelScope.launch {
            _searchText.emit(newText)
        }
    }

    fun onSearchTextButtonClicked(){}
}