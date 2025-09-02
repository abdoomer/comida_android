package com.example.comida.viewmodels.home

import androidx.lifecycle.ViewModel
import com.example.comida.domain.repository.SpecialOfferRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class OfferViewModel @Inject constructor(
    private val specialOfferRepository: SpecialOfferRepository,
): ViewModel() {
}