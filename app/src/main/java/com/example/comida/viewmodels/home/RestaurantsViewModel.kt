package com.example.comida.viewmodels.home

import androidx.lifecycle.ViewModel
import com.example.comida.domain.repository.RestaurantsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class RestaurantsViewModel @Inject constructor(
    private val restaurantsRepository: RestaurantsRepository,
): ViewModel() {
}