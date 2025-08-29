package com.example.comida.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class SignInViewModel(

): ViewModel() {

    private val _email: MutableStateFlow<String> = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password: MutableStateFlow<String> = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _showPassword: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val showPassword: StateFlow<Boolean> = _showPassword

    fun updateEmail(newEmail: String){
        viewModelScope.launch {
            _email.emit(newEmail)
        }
    }

    fun updatePassword(newPassword: String){
        viewModelScope.launch {
            _password.emit(newPassword)
        }
    }

    fun updateShowPassword(newShowPassword: Boolean){
        viewModelScope.launch {
            _showPassword.emit(newShowPassword)
        }
    }

    fun onUserLogin(){}

    fun onFacebookLogin(){}

    fun onGoogleLogin(){}
}