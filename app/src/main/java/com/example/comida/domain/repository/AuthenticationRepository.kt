package com.example.comida.domain.repository

import android.util.Log
import com.example.comida.domain.dao.AuthenticationDao
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthenticationRepository @Inject constructor(
    private val firebaseRepository: FirebaseRepository
) : AuthenticationDao {
    override suspend fun registerWithEmailPassword(email: String, password: String) {
        firebaseRepository.createNewUserWithEmailPassword(email = email, password = password){ success, message ->
            if (success){
                Log.d("AuthenticationRepository", "message: " + (message ?: ""))
                Log.d("AuthenticationRepository", "uid: " + firebaseRepository.currentUserID)
            } else {
                Log.d("AuthenticationRepository", message ?: "")
            }
        }
    }

    override suspend fun loginWithEmailPassword(email: String, password: String) {
        firebaseRepository.signInUserWithEmailPassword(email = email, password = password) { success, message ->
            if (success){
                Log.d("AuthenticationRepository", "message: " + (message ?: ""))
                Log.d("AuthenticationRepository", "uid: " + firebaseRepository.currentUserID)
            } else {
                Log.d("AuthenticationRepository", message ?: "")
            }
        }
    }

    override suspend fun loginWithGoogle() {
        firebaseRepository.signInUserWithGoogle() { success, message ->
            if (success){
                Log.d("AuthenticationRepository", "message: " + (message ?: ""))
                Log.d("AuthenticationRepository", "uid: " + firebaseRepository.currentUserID)
            } else {
                Log.d("AuthenticationRepository", message ?: "")
            }
        }
    }

    override suspend fun loginWithFacebook() {
        firebaseRepository.signInUserWithFacebook() { success, message ->
            if (success){
                Log.d("AuthenticationRepository", "message: " + (message ?: ""))
                Log.d("AuthenticationRepository", "uid: " + firebaseRepository.currentUserID)
            } else {
                Log.d("AuthenticationRepository", message ?: "")
            }
        }
    }

    override suspend fun signOutUser() {
        firebaseRepository.signOut() { success, message ->
            if (success){
                Log.d("AuthenticationRepository", "message: " + (message ?: ""))
                Log.d("AuthenticationRepository", "uid: " + firebaseRepository.currentUserID)
            } else {
                Log.d("AuthenticationRepository", message ?: "")
            }
        }
    }
}