package com.example.comida.viewmodels.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.models.profile.MyAccountHeaderTile
import com.example.comida.models.profile.myAccountHeaderTile
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@HiltViewModel
class MyAccountViewModel @Inject constructor(

): ViewModel() {

    private val _myAccountHeaderTiles: MutableStateFlow<List<MyAccountHeaderTile>> = MutableStateFlow(myAccountHeaderTile)
    val myAccountHeaderTiles: StateFlow<List<MyAccountHeaderTile>> = _myAccountHeaderTiles


    fun onTileTapped(tile: MyAccountHeaderTile){
        viewModelScope.launch {
            val updatedList = _myAccountHeaderTiles.value.map { currentTile ->
                if (tile == currentTile){
                    tile.copy(showOptions = !tile.showOptions)
                }else {
                    currentTile
                }
            }

            _myAccountHeaderTiles.emit(updatedList)
        }
    }
}