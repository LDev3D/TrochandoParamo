package com.example.trochandoparamo.data

import androidx.annotation.StringRes
import com.example.trochandoparamo.R

enum class FilterEnum (@StringRes val displayText: Int){
    ZONE(R.string.filtrar_por_zonas),
    CATEGORY(R.string.filtrar_por_tipo_de_lugar),
    ALL(R.string.explorar_todos_los_lugares)
}
