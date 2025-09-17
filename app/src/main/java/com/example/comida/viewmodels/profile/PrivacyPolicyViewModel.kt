package com.example.comida.viewmodels.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.PrivacyPolicyRepository
import com.example.comida.models.profile.PrivacyPolicy
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class PrivacyPolicyViewModel @Inject constructor(
    private val privacyPolicyRepository: PrivacyPolicyRepository
): ViewModel() {

    private val _privacyPolicy: MutableStateFlow<PrivacyPolicy> = MutableStateFlow(PrivacyPolicy())
    val privacyPolicy: StateFlow<PrivacyPolicy> = _privacyPolicy


    fun getPrivacyPolicy(){
        viewModelScope.launch {
            val policy = privacyPolicyRepository.getPrivacyPolicy()
            _privacyPolicy.emit(policy)
        }
    }
}