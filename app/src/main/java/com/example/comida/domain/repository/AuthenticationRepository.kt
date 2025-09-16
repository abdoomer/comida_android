package com.example.comida.domain.repository

import android.util.Log
import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.AuthenticationDao
import com.example.comida.models.firebase.AuthResponse
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthenticationRepository @Inject constructor(
    private val firebaseRepository: FirebaseRepository,
    private val appCoroutineScope: AppCoroutineScope,
) : AuthenticationDao {
    override suspend fun registerWithEmailPassword(email: String, password: String) {
        firebaseRepository.createNewUserWithEmailPassword(email = email, password = password).onEach { authResponse ->
            when(authResponse){
                is AuthResponse.Success -> {
                    Log.d("AuthenticationRepository", "register with email success")
                }
                is AuthResponse.Cancel -> {
                    Log.d("AuthenticationRepository", "register with email cancel")
                }
                is AuthResponse.Error -> {
                    Log.d("AuthenticationRepository", "register with email error, " + authResponse.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun loginWithEmailPassword(email: String, password: String) {
        firebaseRepository.signInUserWithEmailPassword(email = email, password = password).onEach { authResponse ->
            when(authResponse){
                is AuthResponse.Success -> {
                    Log.d("AuthenticationRepository", "Login with email success")
                }
                is AuthResponse.Cancel -> {
                    Log.d("AuthenticationRepository", "Login with email cancel")
                }
                is AuthResponse.Error -> {
                    Log.d("AuthenticationRepository", "Login with email error, " + authResponse.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun loginWithGoogle() {
        firebaseRepository.signInUserWithGoogle().onEach { authResponse ->
            when(authResponse){
                is AuthResponse.Success -> {
                    Log.d("AuthenticationRepository", "Login with google success")
                }
                is AuthResponse.Cancel -> {
                    Log.d("AuthenticationRepository", "Login with google cancel")
                }
                is AuthResponse.Error -> {
                    Log.d("AuthenticationRepository", "Login with google error, " + authResponse.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun loginWithFacebook() {
        firebaseRepository.signInUserWithFacebook().onEach { authResponse ->
            when(authResponse){
                is AuthResponse.Success -> {
                    Log.d("AuthenticationRepository", "Login with facebook success")
                }
                is AuthResponse.Cancel -> {
                    Log.d("AuthenticationRepository", "Login with facebook cancel")
                }
                is AuthResponse.Error -> {
                    Log.d("AuthenticationRepository", "Login with facebook error, " + authResponse.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }

    override suspend fun signOutUser() {
        firebaseRepository.signOut().onEach { authResponse ->
            when(authResponse){
                is AuthResponse.Success -> {
                    Log.d("AuthenticationRepository", "Logout with email success")
                }
                is AuthResponse.Cancel -> {
                    Log.d("AuthenticationRepository", "Logout with email cancel")
                }
                is AuthResponse.Error -> {
                    Log.d("AuthenticationRepository", "Logout with email error, " + authResponse.message)
                }
            }
        }.launchIn(appCoroutineScope)
    }
}