package com.example.comida.viewmodels.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.services.ComidaSharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch


@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val sharedPreferences: ComidaSharedPreferences,
): ViewModel() {

    fun updateAppFirstTimeRun(){
        viewModelScope.launch {
            sharedPreferences.setAppFirstTimeRun(false)
        }
    }

    fun onGetStartedClicked(){
        
    }
}