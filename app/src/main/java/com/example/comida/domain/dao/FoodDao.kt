package com.example.comida.domain.dao

import com.example.comida.models.home.FoodCategory
import com.example.comida.models.FoodItem

interface FoodDao {

    fun fetchDummyFoodCategories()

    fun fetchAllFoodCategories(): List<FoodCategory>

    fun getFoodCategory(categoryID: String): FoodCategory

    fun getFoodItem(categoryID: String, foodItemID: String): FoodItem
}