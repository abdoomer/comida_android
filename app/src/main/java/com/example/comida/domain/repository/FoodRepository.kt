package com.example.comida.domain.repository

import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.FoodDao
import com.example.comida.domain.usecase.FoodUseCase
import com.example.comida.dummy.foodItems.burgersCategory
import com.example.comida.models.FoodCategory
import com.example.comida.models.FoodItem
import com.example.comida.models.ResourceResult
import com.example.comida.models.foodCategories
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class FoodRepository @Inject constructor(
    private val foodUseCase: FoodUseCase,
    private val appCoroutineScope: AppCoroutineScope
): FoodDao {

    private val _foodCategories: MutableStateFlow<List<FoodCategory>> = MutableStateFlow<List<FoodCategory>>(emptyList())

    private val _selectedCategory: MutableStateFlow<FoodCategory> = MutableStateFlow<FoodCategory>(foodCategories[0])

    private val _currentSelectedFood: MutableStateFlow<FoodItem> = MutableStateFlow(burgersCategory[0])

    init {
        fetchDummyFoodCategories()
    }

    override fun fetchDummyFoodCategories() {
        appCoroutineScope.launch {
            foodUseCase().collect { result ->
                when(result){
                    is ResourceResult.Loading -> {}
                    is ResourceResult.Success -> {
                        _foodCategories.emit(result.data)
                    }
                    is ResourceResult.Error -> {}
                    else -> Unit
                }
            }
        }
    }

    override fun fetchAllFoodCategories(): List<FoodCategory>{
        return _foodCategories.value
    }

    override fun setSelectedCategory(newCategory: FoodCategory){
        appCoroutineScope.launch {
            _selectedCategory.emit(newCategory)
        }
    }

    override fun getSelectedCategory(): FoodCategory {
        return _selectedCategory.value
    }

    override fun setSelectedFood(newFood: FoodItem) {
        appCoroutineScope.launch {
            _currentSelectedFood.emit(newFood)
        }
    }

    override fun getSelectedFood(): FoodItem {
        return _currentSelectedFood.value
    }
}