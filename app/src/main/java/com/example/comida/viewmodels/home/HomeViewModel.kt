package com.example.comida.viewmodels.home

import androidx.lifecycle.ViewModel
import com.example.comida.domain.repository.FoodRepository
import com.example.comida.domain.repository.RestaurantsRepository
import com.example.comida.domain.repository.SpecialOfferRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val foodRepository: FoodRepository,
    private val specialOfferRepository: SpecialOfferRepository,
    private val restaurantsRepository: RestaurantsRepository,
): ViewModel(){}