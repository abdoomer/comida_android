package com.example.comida.domain.dao

interface FBRealtimeDatabaseDao {

    suspend fun getRestaurants()

    suspend fun setRestaurants()

    suspend fun getSpecialOffers()

    suspend fun setSpecialOffers()

    suspend fun getPrivacyPolicy()

    suspend fun setPrivacyPolicy()

    suspend fun getTermsOfService()

    suspend fun setTermsOfService()

    suspend fun getFoodCategories()

    suspend fun setFoodCategories()

    suspend fun getBurgerFoodAddOns()

    suspend fun setBurgerFoodAddOns()

    suspend fun getDonutsFoodAddOns()

    suspend fun setDonutsFoodAddOns()

    suspend fun getHotDogFoodAddOns()

    suspend fun setHotDogFoodAddOns()

    suspend fun getPastaFoodAddOns()

    suspend fun setPastaFoodAddOns()

    suspend fun getPizzaFoodAddOns()

    suspend fun setPizzaFoodAddOns()
}