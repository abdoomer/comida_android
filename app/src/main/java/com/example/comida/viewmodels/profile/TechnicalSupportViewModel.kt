package com.example.comida.viewmodels.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


@Singleton
class TechnicalSupportViewModel @Inject constructor(

): ViewModel() {

    private val _messageTitle: MutableStateFlow<String> = MutableStateFlow("")
    val messageTitle: StateFlow<String> = _messageTitle

    private val _messageDescription: MutableStateFlow<String> = MutableStateFlow("")
    val messageDescription: StateFlow<String> = _messageDescription


    fun onMessageTitleValueChanged(title: String){
        viewModelScope.launch {
            _messageTitle.emit(title)
        }
    }


    fun onMessageDescriptionValueChanged(description: String){
        viewModelScope.launch {
            _messageDescription.emit(description)
        }
    }
}