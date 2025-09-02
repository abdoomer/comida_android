package com.example.comida.domain.dao

import com.example.comida.models.Restaurant


interface RestaurantDao {

    fun fetchRestaurants(): List<Restaurant>

    fun fetchRestaurant(id: String): Restaurant
}