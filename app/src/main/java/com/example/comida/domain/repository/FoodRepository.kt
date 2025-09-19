package com.example.comida.domain.repository

import android.util.Log
import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.FoodDao
import com.example.comida.domain.usecase.FoodUseCase
import com.example.comida.dummy.foodItems.burgersCategory
import com.example.comida.models.home.FoodCategory
import com.example.comida.models.FoodItem
import com.example.comida.models.ResourceResult
import com.example.comida.models.home.foodCategories
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

    override fun getFoodCategory(categoryID: String): FoodCategory {
        return _foodCategories.value.first { it.id == categoryID }
    }

    override fun getFoodItem(categoryID: String, foodItemID: String): FoodItem {
        val category = _foodCategories.value.first { it.id == categoryID }

        return category.getFoodCategoryItems().first() {it.id == foodItemID}
    }
}