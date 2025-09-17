package com.example.comida.viewmodels.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.models.profile.SettingsHeaderTile
import com.example.comida.models.profile.settingsHeaderTile
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


@HiltViewModel
class SettingsViewModel @Inject constructor(

): ViewModel() {
    private val _settingsHeaderTiles: MutableStateFlow<List<SettingsHeaderTile>> = MutableStateFlow(settingsHeaderTile)
    val settingsHeaderTiles: StateFlow<List<SettingsHeaderTile>> = _settingsHeaderTiles


    fun onTileTapped(tile: SettingsHeaderTile) {
        viewModelScope.launch {
            val updatedList = _settingsHeaderTiles.value.map { currentTile ->
                if (currentTile == tile) {
                    currentTile.copy(showOptions = !currentTile.showOptions)
                } else {
                    currentTile
                }
            }

            _settingsHeaderTiles.emit(updatedList)
        }
    }
}