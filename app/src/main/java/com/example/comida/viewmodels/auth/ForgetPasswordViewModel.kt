package com.example.comida.viewmodels.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ForgetPasswordViewModel(

): ViewModel(){

    private val _email: MutableStateFlow<String> = MutableStateFlow("")
    val email: StateFlow<String> = _email

    fun updateEmail(newEmail: String){
        viewModelScope.launch {
            _email.emit(newEmail)
        }
    }

    fun getOTPCode(){}
}