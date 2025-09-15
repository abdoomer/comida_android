package com.example.comida.viewmodels.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.FoodRepository
import com.example.comida.domain.repository.RestaurantsRepository
import com.example.comida.domain.repository.SpecialOfferRepository
import com.example.comida.models.home.FoodCategory
import com.example.comida.models.Restaurant
import com.example.comida.models.SpecialOffer
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val foodRepository: FoodRepository,
    private val specialOfferRepository: SpecialOfferRepository,
    private val restaurantsRepository: RestaurantsRepository,
): ViewModel(){

    private val _foodCategories: MutableStateFlow<List<FoodCategory>> = MutableStateFlow(emptyList())
    val foodCategories: StateFlow<List<FoodCategory>> = _foodCategories

    private val _specialOffers: MutableStateFlow<List<SpecialOffer>> = MutableStateFlow(emptyList())
    val specialOffers: StateFlow<List<SpecialOffer>> = _specialOffers

    private val _restaurants: MutableStateFlow<List<Restaurant>> = MutableStateFlow(emptyList())
    val restaurants: StateFlow<List<Restaurant>> = _restaurants


    fun fetchData(){
        viewModelScope.launch {
            fetchFoodCategories()
            fetchSpecialOffers()
            fetchRestaurant()
        }
    }

    private fun fetchFoodCategories(){
        viewModelScope.launch {
            val categories = foodRepository.fetchAllFoodCategories()

            _foodCategories.emit(categories)
        }
    }

    private fun fetchSpecialOffers(){
        viewModelScope.launch {
            val offers = specialOfferRepository.fetchAllSpecialOffers()

            _specialOffers.emit(offers)
        }
    }

    private fun fetchRestaurant(){
        viewModelScope.launch {
            val restaurantsList = restaurantsRepository.getAllRestaurants()

            _restaurants.emit(restaurantsList)
        }
    }

    fun updateSelectedFoodCategory(newCategory: FoodCategory){
        viewModelScope.launch {
            foodRepository.setSelectedCategory(newCategory)
        }
    }

    fun updateCurrentSelectedSpecialOffer(newOffer: SpecialOffer){
        viewModelScope.launch {
            specialOfferRepository.setCurrentSpecialOffer(newOffer)
        }
    }

    fun updateCurrentSelectedRestaurant(newRestaurant: Restaurant){
        viewModelScope.launch {
            restaurantsRepository.setSelectedRestaurant(newRestaurant)
        }
    }
}