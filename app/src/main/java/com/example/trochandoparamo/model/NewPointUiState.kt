package com.example.trochandoparamo.model

import androidx.annotation.DrawableRes
import com.example.trochandoparamo.data.CatEnum
import com.example.trochandoparamo.data.ZoneEnum

data class NewPointUiState (
    @DrawableRes
    val placeHolderImg: Int,
    val placeHolderZone: ZoneEnum,
    val placeHolderCategory: CatEnum,
    val rat: Int
)