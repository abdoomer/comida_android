package com.example.comida.domain.dao

import com.example.comida.models.FoodItem
import com.example.comida.models.Restaurant


interface RestaurantsDao {

    fun fetchDummyRestaurants()

    fun getAllRestaurants(): List<Restaurant>

    fun getRestaurant(id: String): Restaurant

    fun getRestaurantFoodList(restaurantID: String): List<FoodItem>
}