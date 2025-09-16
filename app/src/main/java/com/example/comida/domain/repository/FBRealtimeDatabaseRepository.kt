package com.example.comida.domain.repository

import android.util.Log
import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.FBRealtimeDatabaseDao
import com.example.comida.models.FoodAddOn
import com.example.comida.models.Restaurant
import com.example.comida.models.SpecialOffer
import com.example.comida.models.firebase.FBDatabaseResponse
import com.example.comida.models.home.FoodCategory
import com.example.comida.models.profile.PrivacyPolicy
import com.example.comida.models.profile.TermsOfService
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class FBRealtimeDatabaseRepository @Inject constructor(
    private val firebaseRepository: FirebaseRepository,
    private val appCoroutineScope: AppCoroutineScope,
): FBRealtimeDatabaseDao {
    override suspend fun getRestaurants() {
        firebaseRepository.getRealtimeDatabaseRestaurants().onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "get restaurants success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun setRestaurants() {
        val restaurants: List<Restaurant> = emptyList()
        firebaseRepository.setRealtimeDatabaseRestaurants(restaurants = restaurants).onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "set restaurants success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun getSpecialOffers() {
        firebaseRepository.getRealtimeDatabaseSpecialOffers().onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "get special offers success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun setSpecialOffers() {
        val specialOffers: List<SpecialOffer> = emptyList()
        firebaseRepository.setRealtimeDatabaseSpecialOffers(specialOffers = specialOffers).onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "set special offers success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun getPrivacyPolicy() {
        firebaseRepository.getRealtimeDatabasePrivacyPolicy().onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "get privacy policy success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun setPrivacyPolicy() {
        val privacyPolicy = PrivacyPolicy()
        firebaseRepository.setRealtimeDatabasePrivacyPolicy(privacyPolicy = privacyPolicy).onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "set privacy policy success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun getTermsOfService() {
        firebaseRepository.getRealtimeDatabaseTermsOfService().onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "get terms of service success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun setTermsOfService() {
        val termsOfService = TermsOfService()
        firebaseRepository.setRealtimeDatabaseTermsOfService(termsOfService = termsOfService).onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "set terms of service success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun getFoodCategories() {
        firebaseRepository.getRealtimeDatabaseFoodCategories().onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "get food categories success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun setFoodCategories() {
        val foodCategories: List<FoodCategory> = emptyList()
        firebaseRepository.setRealtimeDatabaseFoodCategories(foodCategories = foodCategories).onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "set food categories success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun getBurgerFoodAddOns() {
        firebaseRepository.getRealtimeDatabaseBurgerFoodAddOns().onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "get burger food add ons success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun setBurgerFoodAddOns() {
        val burgerFoodAddOns: List<FoodAddOn> = emptyList()
        firebaseRepository.setRealtimeDatabaseBurgerFoodAddOns(foodAddOns = burgerFoodAddOns).onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "set burger food add ons success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun getDonutsFoodAddOns() {
        firebaseRepository.getRealtimeDatabaseDonutsFoodAddOns().onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "get donuts food add ons success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun setDonutsFoodAddOns() {
        val donutsFoodAddOns: List<FoodAddOn> = emptyList()
        firebaseRepository.setRealtimeDatabaseDonutsFoodAddOns(foodAddOns = donutsFoodAddOns).onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "set donuts food add ons success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun getHotDogFoodAddOns() {
        firebaseRepository.getRealtimeDatabaseHotDogFoodAddOns().onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "get hotdog food add ons success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun setHotDogFoodAddOns() {
        val hotdogFoodAddOns: List<FoodAddOn> = emptyList()
        firebaseRepository.setRealtimeDatabaseHotDogFoodAddOns(foodAddOns = hotdogFoodAddOns).onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "set hotdog food add ons success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun getPastaFoodAddOns() {
        firebaseRepository.getRealtimeDatabasePastaFoodAddOns().onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "get pasta food add ons success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun setPastaFoodAddOns() {
        val pastaFoodAddOns: List<FoodAddOn> = emptyList()
        firebaseRepository.setRealtimeDatabasePastaFoodAddOns(foodAddOns = pastaFoodAddOns).onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "set pasta food add ons success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun getPizzaFoodAddOns() {
        firebaseRepository.getRealtimeDatabasePizzaFoodAddOns().onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "get pizza food add ons success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun setPizzaFoodAddOns() {
        val pizzaFoodAddOns: List<FoodAddOn> = emptyList()
        firebaseRepository.setRealtimeDatabasePizzaFoodAddOns(foodAddOns = pizzaFoodAddOns).onEach { response ->
            when(response){
                is FBDatabaseResponse.Success -> {
                    Log.d("FBRealtimeDatabaseRepository", "set pizza food add ons success")
                }
                is FBDatabaseResponse.Error -> {
                    Log.d("FBRealtimeDatabaseRepository", response.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }
}