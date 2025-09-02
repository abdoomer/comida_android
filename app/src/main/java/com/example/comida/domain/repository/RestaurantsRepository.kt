package com.example.comida.domain.repository

import com.example.comida.domain.dao.RestaurantsDao
import com.example.comida.domain.usecase.RestaurantsUseCase
import com.example.comida.models.Restaurant
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RestaurantsRepository @Inject constructor(
    private val restaurantsUseCase: RestaurantsUseCase
): RestaurantsDao {
    override fun fetchRestaurants(): List<Restaurant> {
        TODO("Not yet implemented")
    }

    override fun fetchRestaurant(id: String): Restaurant {
        TODO("Not yet implemented")
    }
}