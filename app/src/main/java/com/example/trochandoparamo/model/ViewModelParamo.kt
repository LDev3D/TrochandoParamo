package com.example.trochandoparamo.model

import androidx.annotation.DrawableRes
import com.example.trochandoparamo.data.CatEnum
import com.example.trochandoparamo.data.DataSetParamo
import com.example.trochandoparamo.data.FilterEnum
import com.example.trochandoparamo.data.FilterItem
import com.example.trochandoparamo.data.PuntoInteres
import com.example.trochandoparamo.data.ZoneEnum
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModelParamo {
    private val _uiState = MutableStateFlow(UiStateParamo(
        currentZone = ZoneEnum.DEFAULT,
        currentCat = CatEnum.DEFAULT,
        currentInterestPoint = DataSetParamo().puntos[0],
        currentFilter = FilterEnum.ALL,
        showingFilterList = false,
        currentFilterList = mutableListOf()
    ))

    val UiState: StateFlow<UiStateParamo> = _uiState.asStateFlow()

    fun ReturnFilterEnums(): List<FilterEnum>{
        val filterList = mutableListOf<FilterEnum>()
        for (x in FilterEnum.entries){
            filterList.add(x)
        }
        return filterList
    }

    fun setCurrentFilter(filter: FilterEnum){
        var filtList: List<FilterItem> = mutableListOf()
        when(filter){
            FilterEnum.CATEGORY -> filtList = DataSetParamo().catFilters
            FilterEnum.ZONE -> filtList = DataSetParamo().zoneFilters
            FilterEnum.ALL -> {}
        }
        _uiState.update {
            uiState ->
            uiState.copy(
                currentFilter = filter,
                currentFilterList = filtList,
                showingFilterList = true
            )
        }
    }

    /*fun getFilteredList(): List<PuntoInteres>{
        val filteredList: List<PuntoInteres> = mutableListOf()
        when(UiState.value.currentFilter){
            FilterEnum.ZONE -> {
                for (x in DataSetParamo().puntos){
                    if (x.zona ==)
                }
            }
            FilterEnum.CATEGORY -> {}
            FilterEnum.ALL -> {}
        }
    }*/
}