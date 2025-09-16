package com.example.comida.models.firebase

interface AuthResponse {
    data object Success: AuthResponse
    data object Cancel: AuthResponse
    data class Error(val message: String): AuthResponse
}