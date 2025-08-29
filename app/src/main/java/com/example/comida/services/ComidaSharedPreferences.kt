package com.example.comida.services

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ComidaSharedPreferences @Inject constructor(
    private val sharedPreferences: SharedPreferences
): ViewModel() {

    fun clearSharedPreferencesStorage(){
        resetSharedPreferences()
    }

    fun setAppFirstTimeRun(value: Boolean) = saveBoolean(key = FIRST_TIME_APP_RUN, value = value )
    fun getAppFirstTimeRun() = getBoolean(key = FIRST_TIME_APP_RUN)

    private fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, true)
    }

    private fun saveBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    private fun resetSharedPreferences(){
        saveBoolean(key = FIRST_TIME_APP_RUN, value = true)
    }

    companion object {
        const val FIRST_TIME_APP_RUN = "first_time_app_run"
    }
}