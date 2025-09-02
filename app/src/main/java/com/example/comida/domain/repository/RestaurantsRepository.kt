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

    private val _restaurant: MutableStateFlow<List<Restaurant>> = MutableStateFlow(emptyList())

    private val _currentSelectedRestaurant: MutableStateFlow<Restaurant> = MutableStateFlow(Restaurant())

    private val _currentRestaurantFoodList: MutableStateFlow<List<FoodItem>> = MutableStateFlow(emptyList())

    init {
        fetchDummyRestaurants()
    }

    override fun fetchDummyRestaurants(){
        appCoroutineScope.launch {
            restaurantsUseCase().collect { result ->
                when(result){
                    is ResourceResult.Loading -> {}
                    is ResourceResult.Success -> {
                        _restaurant.emit(result.data)
                    }
                    is ResourceResult.Error -> {}
                    else -> Unit
                }
            }
        }
    }

    override fun getAllRestaurants(): List<Restaurant> {
        return _restaurant.value
    }

    override fun setSelectedRestaurant(selectedRestaurant: Restaurant) {
        appCoroutineScope.launch {
            _currentSelectedRestaurant.emit(selectedRestaurant)
        }
    }

    override fun getSelectedRestaurant(): Restaurant {
        return _currentSelectedRestaurant.value
    }

    override fun setRestaurantFoodList(newList: List<FoodItem>){
        appCoroutineScope.launch {
            _currentRestaurantFoodList.emit(newList)
        }
    }

    override fun getRestaurantFoodList(): List<FoodItem> {
        return _currentRestaurantFoodList.value
    }
}