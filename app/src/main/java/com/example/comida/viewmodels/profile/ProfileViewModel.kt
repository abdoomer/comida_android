package com.example.comida.viewmodels.profile

import androidx.lifecycle.ViewModel
import com.example.comida.domain.repository.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val firebaseRepository: FirebaseRepository
): ViewModel() {
}