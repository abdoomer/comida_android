package com.example.comida.domain.repository

import com.example.comida.domain.dao.FoodDao
import com.example.comida.domain.usecase.FoodUseCase
import com.example.comida.models.FoodCategory
import com.example.comida.models.FoodItem
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class FoodRepository @Inject constructor(
    private val foodUseCase: FoodUseCase
): FoodDao {
    override fun fetchFoodCategory(category: String): FoodCategory {
        TODO("Not yet implemented")
    }

    override fun fetchFoodItem(id: String): FoodItem {
        TODO("Not yet implemented")
    }
}