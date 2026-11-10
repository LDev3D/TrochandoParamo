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
            ratingStars = 4,
            latitud = 6.085309982299805,
            longitud = -72.94218063354492
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
            ratingStars = 4,
            latitud = 5.901803970336914,
            longitud = -73.02131652832031
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
            ratingStars = 4,
            latitud = 5.92138946056366,
            longitud = -73.02180469036102
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
            ratingStars = 4,
            latitud = 6.107368469238281,
            longitud = -72.90149688720703
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
            ratingStars = 5,
            latitud = 5.943517684936523,
            longitud = -72.99556732177734
        ),
        PuntoInteres(
            categoria = CatEnum.BOSQUE,
            name = R.string.bosque_chiticuy,
            description = R.string.bosque_chiticuy_desc,
            imgs = mutableListOf(
                R.drawable.bosquechiticuy
            ),
            ubi = R.string.bosque_chiticuy_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 5,
            latitud = 5.91041,
            longitud =  -73.02559
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
            ratingStars = 3,
            latitud = 6.107368469238281,
            longitud = -72.90149688720703
        ),
        PuntoInteres(
            categoria = CatEnum.BOSQUE,
            name = R.string.bosque_pan_de_azucar,
            description = R.string.bosque_pan_de_azucar_desc,
            imgs = mutableListOf(
                R.drawable.bosquepandeazucar
            ),
            ubi = R.string.bosque_pan_de_azucar_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 4,
            latitud = 5.910558700561523,
            longitud = -73.05135726928711
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
            ratingStars = 5,
            latitud = 5.943517684936523,
            longitud = -72.99556732177734
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
            ratingStars = 4,
            latitud = 5.910558700561523,
            longitud = -73.02595138549805
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
            ratingStars = 5,
            latitud = 5.9017181396484375,
            longitud = -73.06268692016602
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
            ratingStars = 3,
            latitud = 5.963347256183624,
            longitud = -73.0871433019638
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
            ratingStars = 5,
            latitud = 5.911915898323059,
            longitud = -73.05105686187744
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
            ratingStars = 4,
            latitud = 5.854248404502869,
            longitud = -73.09855878353119
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
            ratingStars = 5,
            latitud = 6.084332317113876,
            longitud = -72.94305771589279
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
            ratingStars = 4,
            latitud = 5.942165851593018,
            longitud = -72.9896691441536
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
            ratingStars = 4,
            latitud = 5.93917652964592,
            longitud = -72.99243986606598
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
            ratingStars = 5,
            latitud = 6.108305901288986,
            longitud = -72.90613979101181
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
            ratingStars = 5,
            latitud = 6.044305711984634,
            longitud = -72.9588907957077
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
            ratingStars = 5,
            latitud = 5.931072235107422,
            longitud = -73.06262254714966
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
            ratingStars = 5,
            latitud = 5.936082601547241,
            longitud = -73.02876234054565
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
            ratingStars = 5,
            latitud = 6.09816312789917,
            longitud = -72.92364120483398
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
            ratingStars = 4,
            latitud = 6.08642578125,
            longitud = -72.94048547744751
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
            ratingStars = 4,
            latitud = 5.916933,
            longitud = -73.037195
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
            ratingStars = 4,
            latitud = 5.9458136558532715,
            longitud = -73.00170421600342
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
            ratingStars = 5,
            latitud = 5.940181016921997,
            longitud = -72.9914903640747
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
            ratingStars = 3,
            latitud = 5.933777242898941,
            longitud = -73.03011149168015
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
            ratingStars = 3,
            latitud = 5.943531095981598,
            longitud = -73.00059378147125
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
            ratingStars = 4,
            latitud = 5.923360884189606,
            longitud = -73.020721077919
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
            ratingStars = 4,
            latitud = 5.913360267877579,
            longitud = -73.0288615822792
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
            ratingStars = 5,
            latitud = 6.080082356929779,
            longitud = -72.93822437524796
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_gacha,
            description = R.string.laguna_gacha_desc,
            imgs = mutableListOf(
                R.drawable.lagunagacha,
                R.drawable.lagunagacha2,
                R.drawable.laguna_gacha_3,
                R.drawable.laguna_gacha_4,
                R.drawable.laguna_gacha_5
            ),
            ubi = R.string.laguna_gacha_ubi,
            zona = ZoneEnum.PAN_DE_AZUCAR,
            ratingStars = 3,
            latitud = 5.9120553731918335,
            longitud = -73.02944630384445
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
            ratingStars = 5,
            latitud = 6.050942838191986,
            longitud = -72.97322452068329
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
            ratingStars = 5,
            latitud = 6.097082197666168,
            longitud = -72.91889101266861
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
            ratingStars = 4,
            latitud = 6.040165722370148,
            longitud = -72.95394480228424
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
            ratingStars = 4,
            latitud = 5.931192934513092,
            longitud = -73.06033462285995
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
            ratingStars = 4,
            latitud = 5.924055576324463,
            longitud = -73.02052795886993
        ),
        PuntoInteres(
            categoria = CatEnum.LAGUNA,
            name = R.string.laguna_los_principes,
            description = R.string.laguna_los_principes_desc,
            imgs = mutableListOf(
                R.drawable.lagunalosprincipes
            ),
            ubi = R.string.laguna_de_los_principes_ubi,
            zona = ZoneEnum.LA_RUSIA,
            ratingStars = 4,
            latitud = 5.9623883664608,
            longitud = -73.08558493852615
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
            ratingStars = 4,
            latitud = 5.959110707044601,
            longitud = -73.08483392000198
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
            ratingStars = 5,
            latitud = 6.081860661506653,
            longitud = -72.94952988624573
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
            ratingStars = 5,
            latitud = 6.109388172626495,
            longitud = -72.90836334228516
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
            ratingStars = 4,
            latitud = 5.923332720994949,
            longitud = -73.03225189447403
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
            ratingStars = 4,
            latitud = 5.935666859149933,
            longitud = -73.00655633211136
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
            ratingStars = 4,
            latitud = 5.941359847784042,
            longitud = -72.99905687570572
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
            ratingStars = 3,
            latitud = 6.105666607618332,
            longitud = -72.9011133313179
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
            ratingStars = 4,
            latitud = 5.903110206127167,
            longitud = -73.02075058221817
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
            ratingStars = 3,
            latitud = 6.060971617698669,
            longitud = -72.9290297627449
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
            ratingStars = 4,
            latitud = 5.908555090427399,
            longitud = -73.05761218070984
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
            ratingStars = 4,
            latitud = 6.0533058643341064,
            longitud = -72.89422273635864
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
            ratingStars = 5,
            latitud = 6.034832149744034,
            longitud = -72.95688986778259
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
            ratingStars = 5,
            latitud = 6.099388897418976,
            longitud = -72.88088947534561
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
            ratingStars = 4,
            latitud = 5.902666300535202,
            longitud = -73.06144505739212
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
            ratingStars = 5,
            latitud = 5.911583304405212,
            longitud = -73.08177083730698
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
            ratingStars = 3,
            latitud = 5.944748818874359,
            longitud = -73.07925224304199
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
            ratingStars = 5,
            latitud = 5.95241591334343,
            longitud = -72.98155814409256
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
            ratingStars = 3,
            latitud = 5.84011048078537,
            longitud = -73.08636277914047
        ),
    )
)