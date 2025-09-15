package com.example.comida.domain.dao

import com.example.comida.models.home.FoodCategory
import com.example.comida.models.FoodItem

interface FoodDao {

    fun fetchDummyFoodCategories()

    fun fetchAllFoodCategories(): List<FoodCategory>

    fun setSelectedCategory(newCategory: FoodCategory)

    fun getSelectedCategory(): FoodCategory

    fun setSelectedFood(newFood: FoodItem)

    fun getSelectedFood(): FoodItem
}