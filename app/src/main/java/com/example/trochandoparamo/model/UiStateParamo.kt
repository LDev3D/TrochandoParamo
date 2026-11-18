package com.example.trochandoparamo.model

import com.example.trochandoparamo.data.CatEnum
import com.example.trochandoparamo.data.DataSetParamo
import com.example.trochandoparamo.data.FilterEnum
import com.example.trochandoparamo.data.FilterItem
import com.example.trochandoparamo.data.PuntoInteres
import com.example.trochandoparamo.data.ZoneEnum

data class UiStateParamo (
    val currentZone: ZoneEnum = ZoneEnum.DEFAULT,
    val currentCat: CatEnum = CatEnum.DEFAULT,
    val currentInterestPoint: PuntoInteres = DataSetParamo().puntos[0],
    val currentFilter: FilterEnum = FilterEnum.ALL,
    val currentFilterList: List<FilterItem> = DataSetParamo().catFilters,
    val showingFilterList: Boolean = false
)