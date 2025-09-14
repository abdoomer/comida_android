package com.example.comida.viewmodels.profile

import androidx.lifecycle.ViewModel
import com.example.comida.domain.repository.TermsOfServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject


@HiltViewModel
class TermsOfServiceViewModel @Inject constructor(
    private val termsOfServiceRepository: TermsOfServiceRepository
): ViewModel() {
}