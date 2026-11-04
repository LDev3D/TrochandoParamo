package com.example.trochandoparamo.model

import com.example.trochandoparamo.data.CatEnum
import com.example.trochandoparamo.data.FilterEnum
import com.example.trochandoparamo.data.FilterItem
import com.example.trochandoparamo.data.PuntoInteres
import com.example.trochandoparamo.data.ZoneEnum

data class UiStateParamo (
    val currentZone: ZoneEnum,
    val currentCat: CatEnum,
    val currentInterestPoint: PuntoInteres,
    val currentFilter: FilterEnum,
    val currentFilterList: List<FilterItem>,
    val showingFilterList: Boolean
)