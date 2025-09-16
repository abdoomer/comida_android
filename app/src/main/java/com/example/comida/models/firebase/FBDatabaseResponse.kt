package com.example.comida.models.firebase

sealed class FBDatabaseResponse<out T> {
    data class Success<T>(val data: T): FBDatabaseResponse<T>()
    data class Error(val message: String): FBDatabaseResponse<Nothing>()
}