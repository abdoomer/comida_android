package com.example.comida.domain.dao


interface AuthenticationDao {

    suspend fun registerWithEmailPassword(email: String, password: String)

    suspend fun loginWithEmailPassword(email: String, password: String)

    suspend fun loginWithGoogle()

    suspend fun loginWithFacebook()

    suspend fun signOutUser()
}