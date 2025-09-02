package com.example.comida.viewmodels.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignUpViewModel @Inject constructor(

): ViewModel() {

    private val _email: MutableStateFlow<String> = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password: MutableStateFlow<String> = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _showPassword: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val showPassword: StateFlow<Boolean> = _showPassword

    private val _fullName: MutableStateFlow<String> = MutableStateFlow("")
    val fullName: StateFlow<String> = _fullName

    fun updateFullName(newName: String){
        viewModelScope.launch {
            _fullName.emit(newName)
        }
    }

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

    fun onUserRegister(){}

    fun onFacebookRegister(){}

    fun onGoogleRegister(){}
}