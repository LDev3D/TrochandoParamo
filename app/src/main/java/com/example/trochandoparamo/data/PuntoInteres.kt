package com.example.trochandoparamo.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PuntoInteres (
    val categoria: CatEnum,
    @StringRes
    val name: Int = 0,
    @StringRes
    val description: Int = 0,
    @DrawableRes
    val imgs: List<Int> = mutableListOf(),
    @StringRes
    val ubi: Int = 0,
    val zona: ZoneEnum,
    val ratingStars : Int
)