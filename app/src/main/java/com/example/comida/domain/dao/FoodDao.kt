package com.example.comida.domain.dao

import com.example.comida.models.FoodCategory
import com.example.comida.models.FoodItem

interface FoodDao {

    fun fetchFoodCategory(category: String): FoodCategory

    fun fetchFoodItem(id: String): FoodItem
}