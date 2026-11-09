package com.example.trochandoparamo.model

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
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

class ViewModelParamo: ViewModel() {
    private val _uiState = MutableStateFlow(UiStateParamo()
    )

    val uiState: StateFlow<UiStateParamo> = _uiState.asStateFlow()

    fun ReturnFilterEnums(): List<FilterEnum> {
        val filterList = mutableListOf<FilterEnum>()
        for (x in FilterEnum.entries) {
            filterList.add(x)
        }
        return filterList
    }

    fun SetCurrentFilterList(filter: FilterEnum) {
        var filtList: List<FilterItem> = mutableListOf()
        when (filter) {
            FilterEnum.CATEGORY -> filtList = DataSetParamo().catFilters
            FilterEnum.ZONE -> filtList = DataSetParamo().zoneFilters
            FilterEnum.ALL -> {}
        }
        _uiState.update { uiState ->
            uiState.copy(
                currentFilter = filter,
                currentFilterList = filtList,
                showingFilterList = true
            )
        }
    }

    fun SetZoneOrCatToPerformSearch(cat: CatEnum, zone: ZoneEnum){
        _uiState.update {
            uiState ->
            uiState.copy(
                currentCat = cat,
                currentZone = zone
            )
        }
    }

    fun getFilteredList(): List<PuntoInteres>{
        val filteredList: MutableList<PuntoInteres> = mutableListOf()
        when (_uiState.value.currentFilter) {
            FilterEnum.ZONE -> {
                for (x in DataSetParamo().puntos) {
                    if (x.zona == _uiState.value.currentZone) {
                        filteredList.add(x)
                    }
                }
            }
            FilterEnum.CATEGORY -> {
                for(y in DataSetParamo().puntos){
                    if(y.categoria == _uiState.value.currentCat){
                        filteredList.add(y)
                    }
                }
            }
            FilterEnum.ALL -> {
                filteredList.addAll(DataSetParamo().puntos)
            }
        }
        return filteredList
    }

    fun setCurrentPlace(place: PuntoInteres){
        _uiState.update {
            uiState ->
            uiState.copy(
                currentInterestPoint = place
            )
        }
    }
}