package com.example.comida.viewmodels

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.dummy.burgersCategory
import com.example.comida.models.AppNotification
import com.example.comida.models.FoodCategory
import com.example.comida.models.FoodItem
import com.example.comida.models.OrderItem
import com.example.comida.models.Restaurant
import com.example.comida.models.SpecialOffer
import com.example.comida.models.appNotifications
import com.example.comida.models.foodCategories
import com.example.comida.models.orders
import com.example.comida.models.restaurants
import com.example.comida.models.specialOffers
import com.example.comida.navigation.Screens
import com.example.comida.services.ComidaSharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComidaViewmodel @Inject constructor(
    private val sharedPreferences: ComidaSharedPreferences
) : ViewModel() {

    private val _startDestination: MutableStateFlow<String> = MutableStateFlow("")
    val startDestination: StateFlow<String> = _startDestination

    private val _startDestinationFetched: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val startDestinationFetched: StateFlow<Boolean> = _startDestinationFetched

    private val _currentPage: MutableStateFlow<Int> = MutableStateFlow(0)
    val currentPage: StateFlow<Int> = _currentPage

    private val _selectedCategory: MutableStateFlow<FoodCategory> = MutableStateFlow<FoodCategory>(foodCategories[0])
    val selectedCategory: StateFlow<FoodCategory> = _selectedCategory

    private val _currentSelectedFood: MutableStateFlow<FoodItem> = MutableStateFlow(burgersCategory[0])
    val currentSelectedFood: StateFlow<FoodItem> = _currentSelectedFood

    private val _selectedSpecialOffer: MutableStateFlow<SpecialOffer> = MutableStateFlow<SpecialOffer>(specialOffers[0])
    val selectedSpecialOffer: StateFlow<SpecialOffer> = _selectedSpecialOffer

    private val _currentSelectedRestaurant: MutableStateFlow<Restaurant> = MutableStateFlow(restaurants[0])
    val currentSelectedRestaurant: StateFlow<Restaurant> = _currentSelectedRestaurant

    private val _currentSelectedNotification: MutableStateFlow<AppNotification> = MutableStateFlow(appNotifications[0])
    val currentSelectedNotification: StateFlow<AppNotification> = _currentSelectedNotification

    private val _currentRestaurantFoodList: MutableStateFlow<List<FoodItem>> = MutableStateFlow(emptyList())
    val currentRestaurantFoodList: StateFlow<List<FoodItem>> = _currentRestaurantFoodList

    private val _currentSelectedOrder: MutableStateFlow<OrderItem> = MutableStateFlow(orders[0])
    val currentSelectedOrder: StateFlow<OrderItem> = _currentSelectedOrder


    init {
        getAppStartDestination()
    }


    private fun getAppStartDestination(){
        viewModelScope.launch {

            val firstTimeAppRun = sharedPreferences.getAppFirstTimeRun()
            if (firstTimeAppRun) {
                _startDestination.emit(Screens.OnboardingScreen.route)
            } else {
                _startDestination.emit(Screens.SignInScreen.route)
            }

            _startDestinationFetched.emit(true)
        }
    }

    fun updateCurrentPage(index: Int){
        viewModelScope.launch {
            _currentPage.emit(index)
        }
    }

    fun updateSelectedCategory(newCategory: FoodCategory){
        viewModelScope.launch {
            _selectedCategory.emit(newCategory)
        }
    }

    fun updateCurrentSelectedFood(item: FoodItem){
        viewModelScope.launch {
            _currentSelectedFood.emit(item)
        }
    }

    fun updateCurrentSelectedSpecialOffer(newOffer: SpecialOffer){
        viewModelScope.launch {
            _selectedSpecialOffer.emit(newOffer)
        }
    }

    fun updateCurrentSelectedRestaurant(newRestaurant: Restaurant){
        viewModelScope.launch {
            _currentSelectedRestaurant.emit(newRestaurant)
        }
    }

    fun updateCurrentNotification(newNotification: AppNotification){
        viewModelScope.launch {
            _currentSelectedNotification.emit(newNotification)
        }
    }

    fun updateCurrentRestaurantFoodList(foodList: List<FoodItem>){
        viewModelScope.launch {
            _currentRestaurantFoodList.emit(foodList)
        }
    }

    fun updateCurrentSelectedOrder(currentOrder: OrderItem){
        viewModelScope.launch {
            _currentSelectedOrder.emit(currentOrder)
        }
    }
}