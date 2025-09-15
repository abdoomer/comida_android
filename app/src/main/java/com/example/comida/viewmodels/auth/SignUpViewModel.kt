package com.example.comida.viewmodels.auth

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository,
): ViewModel() {

    private val _email: MutableStateFlow<String> = MutableStateFlow("example3@email.com")
    val email: StateFlow<String> = _email

    private val _password: MutableStateFlow<String> = MutableStateFlow("123456")
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

    fun onUserRegister(){
        viewModelScope.launch {
            authenticationRepository.registerWithEmailPassword(email = email.value, password = password.value)
        }
    }

    fun onFacebookRegister(){
        viewModelScope.launch {
            authenticationRepository.loginWithFacebook()
        }
    }

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    fun onGoogleRegister(){
        viewModelScope.launch {
            authenticationRepository.loginWithGoogle()
        }
    }
}