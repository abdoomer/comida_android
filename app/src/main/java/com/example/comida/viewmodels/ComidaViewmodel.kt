package com.example.comida.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.navigation.Screens
import com.example.comida.services.ComidaSharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComidaViewmodel @Inject constructor(
    private val sharedPreferences: ComidaSharedPreferences
) : ViewModel() {

    private val _startDestination: MutableStateFlow<String> = MutableStateFlow("")
    val startDestination: StateFlow<String> = _startDestination

    private val _startDestinationFetched: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val startDestinationFetched: StateFlow<Boolean> = _startDestinationFetched

    private val _currentPage: MutableStateFlow<Int> = MutableStateFlow(0)
    val currentPage: StateFlow<Int> = _currentPage

    init {
        getAppStartDestination()
    }


    private fun getAppStartDestination(){
        viewModelScope.launch {

            val firstTimeAppRun = sharedPreferences.getAppFirstTimeRun()
            if (firstTimeAppRun) {
                _startDestination.emit(Screens.OnboardingScreen.route)
            } else {
                _startDestination.emit(Screens.SignInScreen.route)
            }

            _startDestinationFetched.emit(true)
        }
    }

    fun updateCurrentPage(index: Int){
        viewModelScope.launch {
            _currentPage.emit(index)
        }
    }
}