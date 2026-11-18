package com.example.trochandoparamo.model

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PlaceDisplayViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(PlaceDisplayUiState())
    val UiStatePlace : StateFlow<PlaceDisplayUiState> = _uiState.asStateFlow()

    fun setFullScreen(state: Boolean){
        _uiState.update {
            uiState ->
            uiState.copy(
                isOnFullScreenImage = state
            )
        }
    }
    fun setCurrentImage(
        @DrawableRes
        img: Int
    ){
        _uiState.update {
            uiState ->
            uiState.copy(
                currentImageToDisplayOnFullScreen = img
            )
        }
    }
}