package com.example.trochandoparamo.data

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.trochandoparamo.R
import com.example.trochandoparamo.data.DataSetParamo

//cat,name,desc,img, ubi, zona
data class DataSetParamo (
    val catFilters: List<FilterItem> = mutableListOf(
        FilterItem(
            name = R.string.filtrar_por_reas_para_acampar,
            img = R.drawable.acampadaapartamento,
            enumKind = CatEnum.ACAMPADA
        ),
        FilterItem(
            name = R.string.filtrar_por_zonas_de_bosque,
            img = R.drawable.bosquesietecueros,
            enumKind = CatEnum.BOSQUE
        ),
        FilterItem(
            name = R.string.filtrar_por_zonas_de_cascada,
            img = R.drawable.cascadakmcatorce,
            enumKind = CatEnum.CASCADA
        ),
        FilterItem(
            name = R.string.filtrar_por_zonas_de_cerros,
            img = R.drawable.filogrande,
            enumKind = CatEnum.CERRO
        ),
        FilterItem(
            name = R.string.filtrar_por_lagunas,
            img = R.drawable.lagunalospatospandeazucar,
            enumKind = CatEnum.LAGUNA
        ),
        FilterItem(
            name = R.string.filtrar_por_rios,
            img = R.drawable.rioconsuelo,
            enumKind = CatEnum.RIACHUELO
        ),
        FilterItem(
            name = R.string.filtrar_por_senderos,
            img = R.drawable.senderoconsuelo,
            enumKind = CatEnum.SENDERO
        )
    ),
    val zoneFilters: List<FilterItem> = mutableListOf(
        FilterItem(
            name = R.string.filtrar_alto,
            img = R.drawable.filoelalto,
            enumKind = ZoneEnum.EL_ALTO
        ),
        FilterItem(
            name = R.string.filtrar_consuelo,
            img = R.drawable.lagunahoyoazul,
            enumKind = ZoneEnum.CONSUELO
        ),
        FilterItem(
            name = R.string.filtrar_pan_de_azucar,
            img = R.drawable.filopandeazucar,
            enumKind = ZoneEnum.PAN_DE_AZUCAR
        ),
        FilterItem(
            name = R.string.filtrar_guinas,
            img = R.drawable.lagunanegraguinas,
            enumKind = ZoneEnum.GUINAS
        ),
        FilterItem(
            name = R.string.filtrar_zarza,
            img = R.drawable.cascadazarza,
            enumKind = ZoneEnum.ZARZA
        ),
        FilterItem(
            name = R.string.filtrar_rusia,
            img = R.drawable.filolajas,
            enumKind = ZoneEnum.LA_RUSIA
        )
    ),
    val puntos: MutableList<PuntoInteres> = mutableListOf(
        PuntoInteres(
            categoria = CatEnum.ACAMPADA,
            name = R.string.acampada_apartamento,
            description = R.string.acampada_apartamento_desc,
            imgs = mutableListOf(
                R.drawable.acampadaapartamento
            ),
            ubi = R.string.acampada_apartamento_ubi,
            zona = ZoneEnum.CONSUELO,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.ACAMPADA,
            name = R.string.acampada_chiticuy,
            description = R.string.acampada_chiticuy_desc,
            imgs = mutableListOf(
                R.drawable.acampadachiticuy
            ),
            ubi = R.string.acampada_chiticuy_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.ACAMPADA,
            name = R.string.acampada_encantadas,
            description = R.string.acampada_encantadas_desc,
            imgs = mutableListOf(
                R.drawable.acampadaencantadas
            ),
            ubi = R.string.acampada_encantadas_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.ACAMPADA,
            name = R.string.acampada_guinas,
            description = R.string.acampada_guinas_desc,
            imgs = mutableListOf(
                R.drawable.acampadaguinas
            ),
            ubi = R.string.acampada_guinas_ubi,
            zona = ZoneEnum.GUINAS,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.ACAMPADA,
            name = R.string.acampada_siete_cueros,
            description = R.string.acampada_siete_cueros_desc,
            imgs = mutableListOf(
                R.drawable.acampadasietecueros
            ),
            ubi = R.string.acampada_siete_cuerros_ubi,
            zona = ZoneEnum.EL_ALTO,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.BOSQUE,
            name = R.string.bosque_chiticuy,
            description = R.string.bosque_chiticuy_desc,
            imgs = mutableListOf(
                R.drawable.bosquechiticuy
            ),
            ubi = R.string.acampada_chiticuy_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.BOSQUE,
            name = R.string.bosque_guinas,
            description = R.string.bosque_guinas_desc,
            imgs = mutableListOf(
                R.drawable.bosqueguinas
            ),
            ubi = R.string.acampada_guinas_ubi,
            zona = ZoneEnum.GUINAS,
            ratingStars = 3
        ),
        PuntoInteres(
            categoria = CatEnum.BOSQUE,
            name = R.string.bosque_pan_de_azucar,
            description = R.string.bosque_pan_de_azucar_desc,
            imgs = mutableListOf(
                R.drawable.bosquepandeazucar
            ),
            ubi = R.string.acampada_apartamento_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.BOSQUE,
            name = R.string.bosque_siete_cueros,
            description = R.string.bosque_siete_cueros_desc,
            imgs = mutableListOf(
                R.drawable.bosquesietecueros
            ),
            ubi = R.string.acampada_siete_cuerros_ubi,
            zona = ZoneEnum.EL_ALTO,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.CASCADA,
            name = R.string.cascada_chiticuy,
            description = R.string.cascada_chiticuy_desc,
            imgs = mutableListOf(
                R.drawable.cascadachiticuy
            ),
            ubi = R.string.cascada_chiticuy_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.CASCADA,
            name = R.string.cascada_km_catorce,
            description = R.string.cascada_km_catorce_desc,
            imgs = mutableListOf(
                R.drawable.cascadakmcatorce
            ),
            ubi = R.string.cascada_km_catorce_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.CASCADA,
            name = R.string.cascada_los_principes,
            description = R.string.cascada_los_principes_desc,
            imgs = mutableListOf(
                R.drawable.cascadalosprincipes
            ),
            ubi = R.string.cascada_los_principes_ubi,
            zona = ZoneEnum.LA_RUSIA,
            ratingStars = 3
        ),
        PuntoInteres(
            categoria = CatEnum.CASCADA,
            name = R.string.cascada_pan_de_azucar,
            description = R.string.cascada_pan_de_azucar_desc,
            imgs = mutableListOf(
                R.drawable.cascadapandeazucar
            ),
            ubi = R.string.cascada_pan_de_azucar_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.CASCADA,
            name = R.string.cascada_zarza,
            description = R.string.cascada_zarza_desc,
            imgs = mutableListOf(
                R.drawable.cascadazarza
            ),
            ubi = R.string.cascada_zarza_ubi,
            zona = ZoneEnum.ZARZA,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.CERRO,
            name = R.string.filo_cazadero,
            description = R.string.filo_cazadero_desc,
            imgs = mutableListOf(
                R.drawable.filocazadero
            ),
            ubi = R.string.filo_cazadero_ubi,
            zona = ZoneEnum.CONSUELO,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.CERRO,
            name = R.string.filo_cerinza,
            description = R.string.filo_cerinza_desc,
            imgs = mutableListOf(
                R.drawable.filocerinza
            ),
            ubi = R.string.filo_cerinza_ubi,
            zona = ZoneEnum.EL_ALTO,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.CERRO,
            name = R.string.filo_el_alto,
            description = R.string.filo_el_alto_desc,
            imgs = mutableListOf(
                R.drawable.filoelalto
            ),
            ubi = R.string.filo_el_alto_ubi,
            zona = ZoneEnum.EL_ALTO,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.CERRO,
            name = R.string.filo_fin_del_mundo,
            description = R.string.filo_fin_del_mundo_desc,
            imgs = mutableListOf(
                R.drawable.filofindelmundo
            ),
            ubi = R.string.filo_fin_del_mundo_ubi,
            zona = ZoneEnum.GUINAS,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.CERRO,
            name = R.string.filo_grande,
            description = R.string.filo_grande_desc,
            imgs = mutableListOf(
                R.drawable.filogrande
            ),
            ubi = R.string.filo_grande_ubi,
            zona = ZoneEnum.CONSUELO,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.CERRO,
            name = R.string.filo_lajas,
            description = R.string.filo_lajas_desc,
            imgs = mutableListOf(
                R.drawable.filolajas
            ),
            ubi = R.string.filo_lajas_ubi,
            zona = ZoneEnum.LA_RUSIA,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.CERRO,
            name = R.string.filo_pan_de_azucar,
            description = R.string.filo_pan_de_azucar_desc,
            imgs = mutableListOf(
                R.drawable.filopandeazucar
            ),
            ubi = R.string.filo_pan_de_azucar_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.CERRO,
            name = R.string.filo_pikacho_consuelo,
            description = R.string.filo_pikacho_consuelo_desc,
            imgs = mutableListOf(
                R.drawable.filopikachoconsuelo
            ),
            ubi = R.string.filo_pikacho_consuelo_ubi,
            zona = ZoneEnum.CONSUELO,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_cazadero,
            description = R.string.laguna_cazadero_desc,
            imgs = mutableListOf(
                R.drawable.lagunacazadero
            ),
            ubi = R.string.laguna_cazadero_ubi,
            zona = ZoneEnum.CONSUELO,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_chica,
            description = R.string.laguna_chica_desc,
            imgs = mutableListOf(
                R.drawable.lagunachica
            ),
            ubi = R.string.laguna_chica_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_de_los_patos,
            description = R.string.laguna_de_los_patos_desc,
            imgs = mutableListOf(
                R.drawable.lagunacruces
            ),
            ubi = R.string.laguna_de_los_patos_ubi,
            zona = ZoneEnum.EL_ALTO,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_el_alto,
            description = R.string.laguna_el_alto_desc,
            imgs = mutableListOf(
                R.drawable.lagunaelalto
            ),
            ubi = R.string.laguna_el_alto_ubi,
            zona = ZoneEnum.EL_ALTO,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_el_filo,
            description = R.string.laguna_el_filo_desc,
            imgs = mutableListOf(
                R.drawable.lagunaelfilo
            ),
            ubi = R.string.laguna_el_filo_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 3
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_el_pozito,
            description = R.string.laguna_el_pozito_desc,
            imgs = mutableListOf(
                R.drawable.lagunaelpozito
            ),
            ubi = R.string.laguna_el_pozito_ubi,
            zona = ZoneEnum.EL_ALTO,
            ratingStars = 3
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_el_venado,
            description = R.string.laguna_el_venado_desc,
            imgs = mutableListOf(
                R.drawable.lagunaelvenado
            ),
            ubi = R.string.laguna_el_venado_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_encantada,
            description = R.string.laguna_encantada_desc,
            imgs = mutableListOf(
                R.drawable.lagunaencantada
            ),
            ubi = R.string.laguna_encantada_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_esmeralda,
            description = R.string.laguna_esmeralda_desc,
            imgs = mutableListOf(
                R.drawable.lagunaesmeralda
            ),
            ubi = R.string.laguna_esmeralda_ubi,
            zona = ZoneEnum.CONSUELO,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_gacha,
            description = R.string.laguna_gacha_desc,
            imgs = mutableListOf(
                R.drawable.lagunagacha,
                R.drawable.lagunagacha2
            ),
            ubi = R.string.laguna_gacha_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 3
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_grande,
            description = R.string.laguna_grande_desc,
            imgs = mutableListOf(
                R.drawable.lagunagrande
            ),
            ubi = R.string.laguna_grande_ubi,
            zona = ZoneEnum.CONSUELO,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_hoyo_azul,
            description = R.string.laguna_hoyo_azul_desc,
            imgs = mutableListOf(
                R.drawable.lagunahoyoazul
            ),
            ubi = R.string.laguna_hoyo_azul_ubi,
            zona = ZoneEnum.CONSUELO,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_la_estrella,
            description = R.string.laguna_la_estrella_desc,
            imgs = mutableListOf(
                R.drawable.lagunalaestrella
            ),
            ubi = R.string.laguna_la_estrella_ubi,
            zona = ZoneEnum.CONSUELO,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_las_lajas,
            description = R.string.laguna_las_lajas_desc,
            imgs = mutableListOf(
                R.drawable.lagunalajas
            ),
            ubi = R.string.laguna_las_lajas_ubi,
            zona = ZoneEnum.LA_RUSIA,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_los_patos_pan_de_azucar,
            description = R.string.laguna_los_patos_pan_de_azucar_desc,
            imgs = mutableListOf(
                R.drawable.lagunalospatospandeazucar
            ),
            ubi = R.string.laguna_de_los_patos_pan_de_azucar_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_los_principes,
            description = R.string.laguna_los_principes_desc,
            imgs = mutableListOf(
                R.drawable.lagunalosprincipes
            ),
            ubi = R.string.laguna_los_patos_principes_ubi,
            zona = ZoneEnum.LA_RUSIA,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_los_patos_principes,
            description = R.string.laguna_los_patos_principes_desc,
            imgs = mutableListOf(
                R.drawable.lagunalospatosprincipes
            ),
            ubi = R.string.laguna_los_patos_principes_ubi,
            zona = ZoneEnum.LA_RUSIA,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_negra,
            description = R.string.laguna_negra_desc,
            imgs = mutableListOf(
                R.drawable.lagunanegra
            ),
            ubi = R.string.laguna_negra_ubi,
            zona = ZoneEnum.CONSUELO,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_negra_guinas,
            description = R.string.laguna_negra_guinas_desc,
            imgs = mutableListOf(
                R.drawable.lagunanegraguinas
            ),
            ubi = R.string.laguna_negra_güinas_ubi,
            zona = ZoneEnum.GUINAS,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_de_pan_de_azucar,
            description = R.string.laguna_los_patos_pan_de_azucar_desc,
            imgs = mutableListOf(
                R.drawable.lagunapandeazucar,
                R.drawable.lagunapandeazucar2
            ),
            ubi = R.string.laguna_de_pan_de_azucar_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_de_las_tres_cruces,
            description = R.string.laguna_de_las_tres_cruces,
            imgs = mutableListOf(
                R.drawable.lagunapatos
            ),
            ubi = R.string.laguna_de_las_tres_cruces_ubi,
            zona = ZoneEnum.EL_ALTO,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_seca,
            description = R.string.laguna_seca_desc,
            imgs = mutableListOf(
                R.drawable.lagunaseca
            ),
            ubi = R.string.laguna_seca_ubi,
            zona = ZoneEnum.EL_ALTO,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_seca_guinas,
            description = R.string.laguna_seca_guinas_desc,
            imgs = mutableListOf(
                R.drawable.lagunasecaguinas
            ),
            ubi = R.string.laguna_seca_guinas_ubi,
            zona = ZoneEnum.GUINAS,
            ratingStars = 3
        ),
        PuntoInteres(
            categoria = CatEnum.RIACHUELO,
            name = R.string.rio_chiticuy,
            description = R.string.rio_chiticuy_desc,
            imgs = mutableListOf(
                R.drawable.riochiticuy
            ),
            ubi = R.string.rio_chiticuy_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.RIACHUELO,
            name = R.string.rio_salguera,
            description = R.string.rio_salguera_desc,
            imgs = mutableListOf(
                R.drawable.rioconsuelo
            ),
            ubi = R.string.rio_salguera_ubi,
            zona = ZoneEnum.CONSUELO,
            ratingStars = 3
        ),
        PuntoInteres(
            categoria = CatEnum.RIACHUELO,
            name = R.string.rio_surba,
            description = R.string.rio_surba_desc,
            imgs = mutableListOf(
                R.drawable.riosurba
            ),
            ubi = R.string.rio_surba_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.SENDERO,
            name = R.string.sendero_consuelo,
            description = R.string.sendero_consuelo_desc,
            imgs = mutableListOf(
                R.drawable.senderoconsuelo
            ),
            ubi = R.string.sendero_consuelo_ubi,
            zona = ZoneEnum.CONSUELO,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.SENDERO,
            name = R.string.sendero_grande,
            description = R.string.sendero_grande_desc,
            imgs = mutableListOf(
                R.drawable.senderogrande
            ),
            ubi = R.string.sendero_grande_ubi,
            zona = ZoneEnum.CONSUELO,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.SENDERO,
            name = R.string.sendero_guinas,
            description = R.string.sendero_guinas_desc,
            imgs = mutableListOf(
                R.drawable.senderoguinas
            ),
            ubi = R.string.sendero_guinas_ubi,
            zona = ZoneEnum.GUINAS,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.SENDERO,
            name = R.string.sendero_km_catorce,
            description = R.string.sendero_km_catorce_desc,
            imgs = mutableListOf(
                R.drawable.senderokmcatorce
            ),
            ubi = R.string.sendero_km_catorce_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 4
        ),
        PuntoInteres(
            categoria = CatEnum.SENDERO,
            name = R.string.sendero_lajas,
            description = R.string.sendero_lajas_desc,
            imgs = mutableListOf(
                R.drawable.senderolajas
            ),
            ubi = R.string.sendero_lajas_ubi,
            zona = ZoneEnum.LA_RUSIA,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.SENDERO,
            name = R.string.sendero_principes,
            description = R.string.sendero_principes_desc,
            imgs = mutableListOf(
                R.drawable.senderoprincipes
            ),
            ubi = R.string.sendero_principes_ubi,
            zona = ZoneEnum.LA_RUSIA,
            ratingStars = 3
        ),
        PuntoInteres(
            categoria = CatEnum.SENDERO,
            name = R.string.sendero_siete_cueros,
            description = R.string.sendero_siete_cueros_desc,
            imgs = mutableListOf(
                R.drawable.senderosietecueros
            ),
            ubi = R.string.sendero_siete_cueros_ubi,
            zona = ZoneEnum.EL_ALTO,
            ratingStars = 5
        ),
        PuntoInteres(
            categoria = CatEnum.SENDERO,
            name = R.string.sendero_zarza,
            description = R.string.sendero_zarza_desc,
            imgs = mutableListOf(
                R.drawable.senderozarza
            ),
            ubi = R.string.sendero_zarza_ubi,
            zona = ZoneEnum.EL_ALTO,
            ratingStars = 3
        ),
    )
)