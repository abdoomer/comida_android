package com.example.comida.models

sealed class ResourceResult<out T> {
    data class Success<T>(val data: T) : ResourceResult<T>()
    data class Error(val exception: Exception) : ResourceResult<Nothing>()
    data object Loading : ResourceResult<Nothing>()
    data object Idle : ResourceResult<Nothing>()
}