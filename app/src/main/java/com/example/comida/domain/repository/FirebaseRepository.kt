package com.example.comida.domain.repository

import android.content.Context
import android.util.Log
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.FirebaseDao
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.ClearCredentialException
import com.example.comida.BuildConfig
import com.example.comida.models.FoodAddOn
import com.example.comida.models.Restaurant
import com.example.comida.models.SpecialOffer
import com.example.comida.models.firebase.AuthResponse
import com.example.comida.models.firebase.FBDatabaseResponse
import com.example.comida.models.home.FoodCategory
import com.example.comida.models.profile.PrivacyPolicy
import com.example.comida.models.profile.TermsOfService
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await


@Singleton
class FirebaseRepository @Inject constructor(
    private val appCoroutineScope: AppCoroutineScope,
    private val context: Context,
): FirebaseDao {

    private val _auth: FirebaseAuth = Firebase.auth
    private val _realtimeDatabase: FirebaseDatabase = Firebase.database("https://comida-f25f7-default-rtdb.firebaseio.com/")
    private val credentialManager = CredentialManager.create(context)

    private val _currentUserID: MutableStateFlow<String?> = MutableStateFlow(null)
    val currentUserID: Flow<String?> = _currentUserID

    private val _loggedIn: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loggedIn: Flow<Boolean> = _loggedIn

    override suspend fun createNewUserWithEmailPassword(email: String, password: String): Flow<AuthResponse> = callbackFlow {
        _auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    trySend(AuthResponse.Success)
                } else {
                    trySend(AuthResponse.Error(message = task.exception?.message ?: ""))
                }
            }

        awaitClose()
        }

    override suspend fun signInUserWithGoogle(): Flow<AuthResponse> = callbackFlow {
        val googleIdOption = GetGoogleIdOption.Builder()
            .setServerClientId(BuildConfig.WEB_CLIENT_ID)
            .setFilterByAuthorizedAccounts(false)
            .setAutoSelectEnabled(true)
            .build()

        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        val credentialResponse = credentialManager.getCredential(
            request = request,
            context = context
        )

        var uid: String? = null

        val googleCredential = GoogleIdTokenCredential.createFrom(credentialResponse.credential.data)
        val googleIdToken = googleCredential.idToken

        try {
            val credential = GoogleAuthProvider.getCredential(googleIdToken, null)

            _auth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        trySend(AuthResponse.Success)
                        uid = task.result.user?.uid
                    } else {
                        trySend(AuthResponse.Error(message = task.exception?.message ?: ""))
                    }
                }

            _currentUserID.emit(uid)

            awaitClose()
        } catch (e: Exception) {

        }
    }

    override suspend fun signInUserWithFacebook(): Flow<AuthResponse> = callbackFlow {
        val loginManager = LoginManager.getInstance()

        // Create a callback for Facebook login
        val callbackManager = CallbackManager.Factory.create()

        // Register callback
        loginManager.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                appCoroutineScope.launch {
                    // Handle Facebook login success
                    val credential = FacebookAuthProvider.getCredential(result.accessToken.token)

                        val result = _auth.signInWithCredential(credential).await()

                    trySend(AuthResponse.Success)

                    val uid = result.user?.uid
                    _currentUserID.emit(uid)
                }
            }

            override fun onCancel() {
                trySend(AuthResponse.Cancel)
            }

            override fun onError(error: FacebookException) {
                trySend(AuthResponse.Error(message = error.message ?: ""))
            }
        })
    }

    override suspend fun signInUserWithEmailPassword(email: String, password: String): Flow<AuthResponse> = callbackFlow {
        var uid: String? = null
        _auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    trySend(AuthResponse.Success)
                    uid = task.result.user?.uid
                } else {
                    trySend(AuthResponse.Error(message = task.exception?.message ?: ""))
                }
            }
        _currentUserID.emit(uid)
        awaitClose()
    }

    override suspend fun signOutUserWithEmailPassword(): Flow<AuthResponse> = callbackFlow {
        TODO("Not yet implemented")
    }

    override suspend fun signOutUserWithGoogleSignUp(): Flow<AuthResponse> = callbackFlow {
        appCoroutineScope.launch {
            try {
                val clearRequest = ClearCredentialStateRequest()
                credentialManager.clearCredentialState(clearRequest)
                trySend(AuthResponse.Success)
            } catch (e: ClearCredentialException) {
                trySend(AuthResponse.Error(message = e.message ?: ""))
            }

            awaitClose()
        }
    }

    override suspend fun signOut(): Flow<AuthResponse> = callbackFlow {
        try {
            _auth.signOut()
            trySend(AuthResponse.Success)
        } catch (e: Exception){
            trySend(AuthResponse.Error(message = e.message ?: ""))
        }

        awaitClose()
    }

    override suspend fun getAllCollections() {
        TODO("Not yet implemented")
    }

    override suspend fun getCollection(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateCollection(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removeCollection(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getDocument(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateDocument(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removeDocument(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getRealtimeDatabaseRestaurants(): Flow<FBDatabaseResponse<List<Restaurant>>> = callbackFlow {
        _realtimeDatabase.getReference("restaurants")
            .addValueEventListener(
                object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        snapshot.getValue<List<Restaurant>>()?.let {
                            trySend(FBDatabaseResponse.Success(it))
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.d("FirebaseRepository", "" + error.message)
                    }

                }
            )
    }

    override suspend fun setRealtimeDatabaseRestaurants(restaurants: List<Restaurant>): Flow<FBDatabaseResponse<List<Restaurant>>> = callbackFlow {
        _realtimeDatabase.getReference("restaurants")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
//                    trySend(FBDatabaseResponse.Success())
                } else {
                    trySend(FBDatabaseResponse.Error(message = task.exception?.message ?: ""))
                }
            }

        awaitClose()
    }

    override suspend fun getRealtimeDatabaseSpecialOffers(): Flow<FBDatabaseResponse<List<SpecialOffer>>> = callbackFlow {
        _realtimeDatabase.getReference("special_offers")
            .addValueEventListener(
                object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        snapshot.getValue<List<SpecialOffer>>()?.let {
                            trySend(FBDatabaseResponse.Success(it))
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.d("FirebaseRepository", "" + error.message)
                    }

                }
            )
    }

    override suspend fun setRealtimeDatabaseSpecialOffers(specialOffers: List<SpecialOffer>): Flow<FBDatabaseResponse<List<SpecialOffer>>> = callbackFlow {
        _realtimeDatabase.getReference("special_offers")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
//                    trySend(FBDatabaseResponse.Success())
                } else {
                    trySend(FBDatabaseResponse.Error(message = task.exception?.message ?: ""))
                }
            }

        awaitClose()
    }

    override suspend fun getRealtimeDatabasePrivacyPolicy(): Flow<FBDatabaseResponse<PrivacyPolicy>> = callbackFlow {
        _realtimeDatabase.getReference("privacy_policy")
            .addValueEventListener(
                object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        snapshot.getValue<PrivacyPolicy>()?.let {
                            trySend(FBDatabaseResponse.Success(it))
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.d("FirebaseRepository", "" + error.message)
                    }

                }
            )
    }

    override suspend fun setRealtimeDatabasePrivacyPolicy(privacyPolicy: PrivacyPolicy): Flow<FBDatabaseResponse<PrivacyPolicy>> = callbackFlow {
        _realtimeDatabase.getReference("privacy_policy")
            .child("")
            .setValue("")
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
//                    trySend(FBDatabaseResponse.Success())
                } else {
                    trySend(FBDatabaseResponse.Error(message = task.exception?.message ?: ""))
                }
            }

        awaitClose()
    }

    override suspend fun getRealtimeDatabaseTermsOfService(): Flow<FBDatabaseResponse<TermsOfService>> = callbackFlow {
        _realtimeDatabase.getReference("terms_of_service")
            .addValueEventListener(
                object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        snapshot.getValue<TermsOfService>()?.let {
                            trySend(FBDatabaseResponse.Success(it))
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.d("FirebaseRepository", "" + error.message)
                    }

                }
            )
    }

    override suspend fun setRealtimeDatabaseTermsOfService(termsOfService: TermsOfService): Flow<FBDatabaseResponse<TermsOfService>> = callbackFlow {
        _realtimeDatabase.getReference("terms_of_service")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
//                    trySend(FBDatabaseResponse.Success())
                } else {
                    trySend(FBDatabaseResponse.Error(message = task.exception?.message ?: ""))
                }
            }

        awaitClose()
    }

    override suspend fun getRealtimeDatabaseFoodCategories(): Flow<FBDatabaseResponse<List<FoodCategory>>> = callbackFlow {
        _realtimeDatabase.getReference("food_categories")
            .addValueEventListener(
                object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        snapshot.getValue<List<FoodCategory>>()?.let {
                            trySend(FBDatabaseResponse.Success(it))
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.d("FirebaseRepository", "" + error.message)
                    }

                }
            )
    }

    override suspend fun setRealtimeDatabaseFoodCategories(foodCategories: List<FoodCategory>): Flow<FBDatabaseResponse<List<FoodCategory>>> = callbackFlow {
        _realtimeDatabase.getReference("food_categories")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
//                    trySend(FBDatabaseResponse.Success())
                } else {
                    trySend(FBDatabaseResponse.Error(message = task.exception?.message ?: ""))
                }
            }

        awaitClose()
    }

    override suspend fun getRealtimeDatabaseBurgerFoodAddOns(): Flow<FBDatabaseResponse<List<FoodAddOn>>> = callbackFlow {
        _realtimeDatabase.getReference("burger_food_add_ons")
            .addValueEventListener(
                object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        snapshot.getValue<List<FoodAddOn>>()?.let {
                            trySend(FBDatabaseResponse.Success(it))
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.d("FirebaseRepository", "" + error.message)
                    }

                }
            )
    }

    override suspend fun setRealtimeDatabaseBurgerFoodAddOns(foodAddOns: List<FoodAddOn>): Flow<FBDatabaseResponse<List<FoodAddOn>>> = callbackFlow {
        _realtimeDatabase.getReference("burger_food_add_ons")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
//                    trySend(FBDatabaseResponse.Success())
                } else {
                    trySend(FBDatabaseResponse.Error(message = task.exception?.message ?: ""))
                }
            }

        awaitClose()
    }

    override suspend fun getRealtimeDatabaseDonutsFoodAddOns(): Flow<FBDatabaseResponse<List<FoodAddOn>>> = callbackFlow {
        _realtimeDatabase.getReference("donuts_food_add_ons")
            .addValueEventListener(
                object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        snapshot.getValue<List<FoodAddOn>>()?.let {
                            trySend(FBDatabaseResponse.Success(it))
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.d("FirebaseRepository", "" + error.message)
                    }

                }
            )
    }

    override suspend fun setRealtimeDatabaseDonutsFoodAddOns(foodAddOns: List<FoodAddOn>): Flow<FBDatabaseResponse<List<FoodAddOn>>> = callbackFlow {
        _realtimeDatabase.getReference("donuts_food_add_ons")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
//                    trySend(FBDatabaseResponse.Success())
                } else {
                    trySend(FBDatabaseResponse.Error(message = task.exception?.message ?: ""))
                }
            }

        awaitClose()
    }

    override suspend fun getRealtimeDatabaseHotDogFoodAddOns(): Flow<FBDatabaseResponse<List<FoodAddOn>>> = callbackFlow {
        _realtimeDatabase.getReference("hotdog_food_add_ons")
            .addValueEventListener(
                object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        snapshot.getValue<List<FoodAddOn>>()?.let {
                            trySend(FBDatabaseResponse.Success(it))
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.d("FirebaseRepository", "" + error.message)
                    }

                }
            )
    }

    override suspend fun setRealtimeDatabaseHotDogFoodAddOns(foodAddOns: List<FoodAddOn>): Flow<FBDatabaseResponse<List<FoodAddOn>>> = callbackFlow {
        _realtimeDatabase.getReference("hotdog_food_add_ons")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
//                    trySend(FBDatabaseResponse.Success())
                } else {
                    trySend(FBDatabaseResponse.Error(message = task.exception?.message ?: ""))
                }
            }

        awaitClose()
    }

    override suspend fun getRealtimeDatabasePastaFoodAddOns(): Flow<FBDatabaseResponse<List<FoodAddOn>>> = callbackFlow {
        _realtimeDatabase.getReference("pasta_food_add_ons")
            .addValueEventListener(
                object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        snapshot.getValue<List<FoodAddOn>>()?.let {
                            trySend(FBDatabaseResponse.Success(it))
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.d("FirebaseRepository", "" + error.message)
                    }

                }
            )
    }

    override suspend fun setRealtimeDatabasePastaFoodAddOns(foodAddOns: List<FoodAddOn>): Flow<FBDatabaseResponse<List<FoodAddOn>>> = callbackFlow {
        _realtimeDatabase.getReference("pasta_food_add_ons")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
//                    trySend(FBDatabaseResponse.Success())
                } else {
                    trySend(FBDatabaseResponse.Error(message = task.exception?.message ?: ""))
                }
            }

        awaitClose()
    }

    override suspend fun getRealtimeDatabasePizzaFoodAddOns(): Flow<FBDatabaseResponse<List<FoodAddOn>>> = callbackFlow {
        _realtimeDatabase.getReference("pizza_food_add_ons")
            .addValueEventListener(
                object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        snapshot.getValue<List<FoodAddOn>>()?.let {
                            trySend(FBDatabaseResponse.Success(it))
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.d("FirebaseRepository", "" + error.message)
                    }

                }
            )
    }

    override suspend fun setRealtimeDatabasePizzaFoodAddOns(foodAddOns: List<FoodAddOn>): Flow<FBDatabaseResponse<List<FoodAddOn>>> = callbackFlow {
        _realtimeDatabase.getReference("pizza_food_add_ons")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    task.result.getValue<List<FoodAddOn>>()?.let {
                        trySend(FBDatabaseResponse.Success(it))
                    }
                } else {
                    trySend(FBDatabaseResponse.Error(message = task.exception?.message ?: ""))
                }
            }

        awaitClose()
    }
}