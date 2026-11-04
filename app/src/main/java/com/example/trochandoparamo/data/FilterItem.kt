package com.example.trochandoparamo.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class FilterItem (
    @StringRes
    val name: Int,
    @DrawableRes
    val img: Int,
    val enumKind: Any
)