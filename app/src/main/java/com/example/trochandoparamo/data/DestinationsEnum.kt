package com.example.trochandoparamo.data

import androidx.annotation.StringRes
import com.example.trochandoparamo.R

enum class DestinationsEnum(@StringRes val screenTittle: Int) {
    HOME(R.string.qu_lugar_quieres_explorar),
    FILTERED(R.string.lugares_filtrados_seg_n),
    NEW(R.string.a_adir_un_lugar_nuevo),
    DETAILS(R.string.detalles_de)
}