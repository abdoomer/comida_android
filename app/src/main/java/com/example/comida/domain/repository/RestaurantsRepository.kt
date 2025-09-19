package com.example.comida.domain.repository

import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.RestaurantsDao
import com.example.comida.domain.usecase.RestaurantsUseCase
import com.example.comida.models.FoodItem
import com.example.comida.models.ResourceResult
import com.example.comida.models.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RestaurantsRepository @Inject constructor(
    private val restaurantsUseCase: RestaurantsUseCase,
    private val appCoroutineScope: AppCoroutineScope
): RestaurantsDao {

    private val _restaurants: MutableStateFlow<List<Restaurant>> = MutableStateFlow(emptyList())

    init {
        fetchDummyRestaurants()
    }

    override fun fetchDummyRestaurants(){
        appCoroutineScope.launch {
            restaurantsUseCase().collect { result ->
                when(result){
                    is ResourceResult.Loading -> {}
                    is ResourceResult.Success -> {
                        _restaurants.emit(result.data)
                    }
                    is ResourceResult.Error -> {}
                    else -> Unit
                }
            }
        }
    }

    override fun getAllRestaurants(): List<Restaurant> {
        return _restaurants.value
    }

    override fun getRestaurant(id: String): Restaurant {
        return _restaurants.value.first() {it.id == id}
    }

    override fun getRestaurantFoodList(restaurantID: String): List<FoodItem> {
        val restaurant = _restaurants.value.first() { it.id == restaurantID}
        return restaurant.availableFoods
    }
}