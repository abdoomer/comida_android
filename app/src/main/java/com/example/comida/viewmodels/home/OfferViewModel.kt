package com.example.comida.viewmodels.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.domain.repository.SpecialOfferRepository
import com.example.comida.models.SpecialOffer
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class OfferViewModel @Inject constructor(
    private val specialOfferRepository: SpecialOfferRepository,
): ViewModel() {

    private val _offer: MutableStateFlow<SpecialOffer> = MutableStateFlow(SpecialOffer())
    val offer: StateFlow<SpecialOffer> = _offer

    fun fetchOffer(){
        viewModelScope.launch {
            val currentOffer = specialOfferRepository.getCurrentSpecialOffer()

            _offer.emit(currentOffer)
        }
    }
}