package com.example.comida.domain.repository

import android.content.Context
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.FirebaseDao
import com.google.android.gms.auth.api.identity.SignInClient
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
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await


@Singleton
class FirebaseRepository @Inject constructor(
    private val appCoroutineScope: AppCoroutineScope,
    private val context: Context,
    private val oneTapClient: SignInClient
): FirebaseDao {

    private val _auth: FirebaseAuth = Firebase.auth
    private val credentialManager = CredentialManager.create(context)

    private val _currentUserID: MutableStateFlow<String?> = MutableStateFlow(null)
    val currentUserID: Flow<String?> = _currentUserID

    private val _loggedIn: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loggedIn: Flow<Boolean> = _loggedIn

    override suspend fun createNewUserWithEmailPassword(email: String, password: String, onComplete: (Boolean, String?) -> Unit){
        appCoroutineScope.launch {
            try {
                val result = _auth.createUserWithEmailAndPassword(email, password).await()

                val uid = result.user?.uid
                _currentUserID.emit(uid)

                onComplete(true, "Sign-up with email successful!")
            } catch (e: Exception){
                onComplete(false, "Sign-up with email failed, " + e.message)
            }
        }
    }

    override suspend fun signInUserWithGoogle(onComplete: (Boolean, String?) -> Unit) {
        try {
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

            val googleCredential = GoogleIdTokenCredential.createFrom(credentialResponse.credential.data)
            val googleIdToken = googleCredential.idToken

            val credential = GoogleAuthProvider.getCredential(googleIdToken, null)

            val result = _auth.signInWithCredential(credential).await()

            onComplete(true, "Sign-up with google successful!")

            val uid = result.user?.uid
            _currentUserID.emit(uid)
        } catch (e: Exception){
            onComplete(false, "Sign-up with google failed, " + e.message)
        }

    }

    override suspend fun signInUserWithFacebook(onComplete: (Boolean, String?) -> Unit) {
        try {
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

                        onComplete(true, "Sign-in with Facebook successful!")

                        val uid = result.user?.uid
                        _currentUserID.emit(uid)
                    }
                }

                override fun onCancel() {
                    onComplete(false, "Facebook login was cancelled")
                }

                override fun onError(error: FacebookException) {
                    onComplete(false, "Facebook login failed: ${error.message}")
                }
            })
        } catch (e: Exception){
            onComplete(false, "Sign-up with facebook failed, " + e.message)
        }
    }

    override suspend fun signInUserWithEmailPassword(email: String, password: String, onComplete: (Boolean, String?) -> Unit) {
        appCoroutineScope.launch {
            try {
                _auth.signInWithEmailAndPassword(email, password)
                onComplete(true, "Sign-in with email successful!")
            } catch (e: Exception){
                onComplete(false, "Sign-in with email failed, " + e.message)
            }
        }
    }

    override suspend fun signOutUserWithEmailPassword(onComplete: (Boolean, String?) -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun signOutUserWithGoogleSignUp(onComplete: (Boolean, String?) -> Unit) {
        appCoroutineScope.launch {
            try {
                val clearRequest = ClearCredentialStateRequest()
                credentialManager.clearCredentialState(clearRequest)
                onComplete(true, "Sign-out with google successful!")
            } catch (e: ClearCredentialException) {
                onComplete(false, "Sign-out with facebook failed, " + e.message)
            }
        }
    }

    override suspend fun signOut(onComplete: (Boolean, String?) -> Unit) {
        try {
            _auth.signOut()
            onComplete(true, "Sign-out with facebook successful!")
        } catch (e: Exception){
            onComplete(false, "Sign-out with facebook failed, " + e.message)
        }
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
}