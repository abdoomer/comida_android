package com.example.comida.viewmodels.profile

import androidx.lifecycle.ViewModel
import com.example.comida.domain.repository.PrivacyPolicyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class PrivacyPolicyViewModel @Inject constructor(
    private val privacyPolicyRepository: PrivacyPolicyRepository
): ViewModel() {
}