package com.example.trochandoparamo.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.res.painterResource
import com.example.trochandoparamo.R
import com.example.trochandoparamo.data.CatEnum
import com.example.trochandoparamo.data.ZoneEnum
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class NewPointUiModel {
    private val _uiState = MutableStateFlow(NewPointUiState(
        placeHolderImg = R.drawable.img_placeholder,
        placeHolderZone = ZoneEnum.DEFAULT,
        placeHolderCategory = CatEnum.DEFAULT,
        rat = 0
    ))
    val uiState: StateFlow<NewPointUiState> = _uiState

    fun SetNewPointZone(
        zone: ZoneEnum,
    ){
        _uiState.update {
                uiState ->
            uiState.copy(
                placeHolderZone = zone,
            )
        }
    }

    fun SetNewPointCategory(
        cat: CatEnum,
    ){
        _uiState.update {
                uiState ->
            uiState.copy(
                placeHolderCategory = cat,
            )
        }
    }

    fun SetRatingStars(rating: Int){
        _uiState.update {
            uiState ->
            uiState.copy(
                rat = rating
            )
        }
    }
}