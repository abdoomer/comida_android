package com.example.comida.domain.dao

import com.example.comida.models.FoodAddOn
import com.example.comida.models.Restaurant
import com.example.comida.models.SpecialOffer
import com.example.comida.models.firebase.AuthResponse
import com.example.comida.models.firebase.FBDatabaseResponse
import com.example.comida.models.home.FoodCategory
import com.example.comida.models.profile.PrivacyPolicy
import com.example.comida.models.profile.TermsOfService
import kotlinx.coroutines.flow.Flow

interface FirebaseDao {

    // Auth
    suspend fun createNewUserWithEmailPassword(email: String, password: String): Flow<AuthResponse>

    suspend fun signInUserWithEmailPassword(email: String, password: String): Flow<AuthResponse>

    suspend fun signInUserWithGoogle(): Flow<AuthResponse>

    suspend fun signInUserWithFacebook(): Flow<AuthResponse>

    suspend fun signOutUserWithEmailPassword(): Flow<AuthResponse>

    suspend fun signOutUserWithGoogleSignUp(): Flow<AuthResponse>

    suspend fun signOut(): Flow<AuthResponse>


    // Database
    suspend fun getAllCollections()

    suspend fun getCollection(id: String)

    suspend fun updateCollection(id: String)

    suspend fun removeCollection(id: String)

    suspend fun getDocument(id: String)

    suspend fun updateDocument(id: String)

    suspend fun removeDocument(id: String)

    // Realtime
    suspend fun getRealtimeDatabaseRestaurants(): Flow<FBDatabaseResponse<List<Restaurant>>>

    suspend fun setRealtimeDatabaseRestaurants(restaurants: List<Restaurant>): Flow<FBDatabaseResponse<List<Restaurant>>>

    suspend fun getRealtimeDatabaseSpecialOffers(): Flow<FBDatabaseResponse<List<SpecialOffer>>>

    suspend fun setRealtimeDatabaseSpecialOffers(specialOffers: List<SpecialOffer>): Flow<FBDatabaseResponse<List<SpecialOffer>>>

    suspend fun getRealtimeDatabasePrivacyPolicy(): Flow<FBDatabaseResponse<PrivacyPolicy>>

    suspend fun setRealtimeDatabasePrivacyPolicy(privacyPolicy: PrivacyPolicy): Flow<FBDatabaseResponse<PrivacyPolicy>>

    suspend fun getRealtimeDatabaseTermsOfService(): Flow<FBDatabaseResponse<TermsOfService>>

    suspend fun setRealtimeDatabaseTermsOfService(termsOfService: TermsOfService): Flow<FBDatabaseResponse<TermsOfService>>

    suspend fun getRealtimeDatabaseFoodCategories(): Flow<FBDatabaseResponse<List<FoodCategory>>>

    suspend fun setRealtimeDatabaseFoodCategories(foodCategories: List<FoodCategory>): Flow<FBDatabaseResponse<List<FoodCategory>>>

    suspend fun getRealtimeDatabaseBurgerFoodAddOns(): Flow<FBDatabaseResponse<List<FoodAddOn>>>

    suspend fun setRealtimeDatabaseBurgerFoodAddOns(foodAddOns: List<FoodAddOn>): Flow<FBDatabaseResponse<List<FoodAddOn>>>

    suspend fun getRealtimeDatabaseDonutsFoodAddOns(): Flow<FBDatabaseResponse<List<FoodAddOn>>>

    suspend fun setRealtimeDatabaseDonutsFoodAddOns(foodAddOns: List<FoodAddOn>): Flow<FBDatabaseResponse<List<FoodAddOn>>>

    suspend fun getRealtimeDatabaseHotDogFoodAddOns(): Flow<FBDatabaseResponse<List<FoodAddOn>>>

    suspend fun setRealtimeDatabaseHotDogFoodAddOns(foodAddOns: List<FoodAddOn>): Flow<FBDatabaseResponse<List<FoodAddOn>>>

    suspend fun getRealtimeDatabasePastaFoodAddOns(): Flow<FBDatabaseResponse<List<FoodAddOn>>>

    suspend fun setRealtimeDatabasePastaFoodAddOns(foodAddOns: List<FoodAddOn>): Flow<FBDatabaseResponse<List<FoodAddOn>>>

    suspend fun getRealtimeDatabasePizzaFoodAddOns(): Flow<FBDatabaseResponse<List<FoodAddOn>>>

    suspend fun setRealtimeDatabasePizzaFoodAddOns(foodAddOns: List<FoodAddOn>): Flow<FBDatabaseResponse<List<FoodAddOn>>>
}