package com.example.trochandoparamo.model

import androidx.annotation.DrawableRes

data class PlaceDisplayUiState(
    val isOnFullScreenImage: Boolean = false,
    @DrawableRes
    val currentImageToDisplayOnFullScreen: Int = 0
)