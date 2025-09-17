package com.example.comida.viewmodels.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.TermsOfServiceRepository
import com.example.comida.models.profile.TermsOfService
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


@HiltViewModel
class TermsOfServiceViewModel @Inject constructor(
    private val termsOfServiceRepository: TermsOfServiceRepository
): ViewModel() {

    private val _termsOfService: MutableStateFlow<TermsOfService> = MutableStateFlow(TermsOfService())
    val termsOfService: StateFlow<TermsOfService> = _termsOfService


    fun getTermsOfService(){
        viewModelScope.launch {
            val terms = termsOfServiceRepository.getTermsOfService()
            _termsOfService.emit(terms)
        }
    }
}