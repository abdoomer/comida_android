package com.example.comida.viewmodels.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.AuthenticationRepository
import com.example.comida.services.ComidaSharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignInViewModel @Inject constructor(
    private val sharedPreferences: ComidaSharedPreferences,
    private val authenticationRepository: AuthenticationRepository,
): ViewModel() {

    private val _email: MutableStateFlow<String> = MutableStateFlow("example3@email.com")
    val email: StateFlow<String> = _email

    private val _password: MutableStateFlow<String> = MutableStateFlow("123456")
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

    fun updateAppFirstTimeRun(){
        viewModelScope.launch {
            sharedPreferences.setAppFirstTimeRun(false)
        }
    }

    fun validateLoginInformation(){}

    fun onUserLogin(){
        viewModelScope.launch {
            authenticationRepository.loginWithEmailPassword(email = email.value, password = password.value)
        }
    }

    fun onFacebookLogin(){
        viewModelScope.launch {
            authenticationRepository.loginWithFacebook()
        }
    }

    fun onGoogleLogin(){
        viewModelScope.launch {
            authenticationRepository.loginWithGoogle()
        }
    }
}