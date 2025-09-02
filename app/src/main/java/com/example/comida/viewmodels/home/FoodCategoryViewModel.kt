package com.example.comida.viewmodels.home

import androidx.lifecycle.ViewModel
import com.example.comida.domain.repository.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class FoodCategoryViewModel @Inject constructor(
    private val foodRepository: FoodRepository,
): ViewModel() {
}