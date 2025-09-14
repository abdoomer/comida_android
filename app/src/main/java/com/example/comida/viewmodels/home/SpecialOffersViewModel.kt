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
class SpecialOffersViewModel @Inject constructor(
    private val specialOfferRepository: SpecialOfferRepository,
): ViewModel() {

    private val _searchText: MutableStateFlow<String> = MutableStateFlow("")
    val searchText: StateFlow<String> = _searchText

    private val _specialOffers: MutableStateFlow<List<SpecialOffer>> = MutableStateFlow(emptyList())
    val specialOffers: StateFlow<List<SpecialOffer>> = _specialOffers


    fun fetchAllSpecialOffers(){
        viewModelScope.launch {
            val offersList = specialOfferRepository.fetchAllSpecialOffers()

            _specialOffers.emit(offersList)
        }
    }

    fun onSearchTextValueChanged(newText: String){
        viewModelScope.launch {
            _searchText.emit(newText)
        }
    }

    fun onSearchTextButtonClicked(){}
}