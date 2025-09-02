package com.example.comida.viewmodels.payment

import androidx.lifecycle.ViewModel
import com.example.comida.domain.repository.PaymentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val paymentRepository: PaymentRepository
): ViewModel() {
}