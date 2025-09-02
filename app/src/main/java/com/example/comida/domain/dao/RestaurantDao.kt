package com.example.comida.domain.dao

import com.example.comida.models.FoodItem
import com.example.comida.models.Restaurant


interface RestaurantsDao {

    fun fetchDummyRestaurants()

    fun getAllRestaurants(): List<Restaurant>

    fun setSelectedRestaurant(selectedRestaurant: Restaurant)

    fun getSelectedRestaurant(): Restaurant

    fun setRestaurantFoodList(newList: List<FoodItem>)

    fun getRestaurantFoodList(): List<FoodItem>
}