package com.example.comida.domain.dao

import com.example.comida.models.Restaurant


interface RestaurantsDao {

    fun fetchRestaurants(): List<Restaurant>

    fun fetchRestaurant(id: String): Restaurant
}