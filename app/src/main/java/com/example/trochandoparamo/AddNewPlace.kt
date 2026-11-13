package com.example.trochandoparamo

import android.widget.RadioButton
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldLabelPosition
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.trochandoparamo.data.CatEnum
import com.example.trochandoparamo.data.FilterEnum
import com.example.trochandoparamo.data.ZoneEnum
import com.example.trochandoparamo.model.NewPointUiModel
import com.example.trochandoparamo.model.NewPointUiState
import com.example.trochandoparamo.model.ViewModelParamo
import com.example.trochandoparamo.ui.theme.TrochandoParamoTheme

class AddNewPlace {
}

@Composable
fun AddNewPlaceScreen(
    windowSize: WindowWidthSizeClass,
    newPointModel: NewPointUiModel = NewPointUiModel(),
    saveNewPlace: () -> Unit,
    onCatSelected: (cat: CatEnum) -> Unit,
    onZoneSelected: (zone: ZoneEnum) -> Unit,
    onImgClicked: () -> Unit,
    modifier: Modifier = Modifier
        .fillMaxSize()
){
    val uiState by newPointModel.uiState.collectAsState()
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding)))
        DataInputTextLabel(windowSize = windowSize,R.string.selecciona_una_imagen)
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding)))
        ImgButton(windowSize= windowSize ,onImgClicked)
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding)))

        DataInputTextLabel(windowSize = windowSize,R.string.nombre_del_punto_de_inter_s_label)
        AddPlaceName(
            windowSize = windowSize,
            label = stringResource(R.string.nombre_del_punto_de_inter_s),
            lineLimits = TextFieldLineLimits.SingleLine,
            height = R.dimen.new_place_name_textfield_y,
            width = R.dimen.new_place_name_textfield_x
        )
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding)))

        DataInputTextLabel(windowSize = windowSize,R.string.descripci_n_del_punto_de_inter_s)
        AddPlaceName(
            windowSize = windowSize,
            label = stringResource(R.string.descripci_n_del_lugar),
            lineLimits = TextFieldLineLimits.MultiLine(),
            height = R.dimen.new_place_desc_textfield_y,
            width = R.dimen.new_place_desc_textfield_x
        )
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding)))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = if(windowSize == WindowWidthSizeClass.Expanded){
                modifier.fillMaxWidth()
            }else{
                modifier
            }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                DataInputTextLabel(windowSize = windowSize,R.string.qu_tipo_de_lugar_es, align = TextAlign.Center)
                CatDropdownMenu(
                    newPointUiModel = newPointModel,
                    icon = R.drawable.baseline_filter_vintage_24_light,
                    buttonDescription = R.string.seleccionar_categor_a,
                    onDropDownPressed = {
                        CatEnum.entries
                    },
                    onFilterSelected = onCatSelected,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                DataInputTextLabel(windowSize = windowSize,R.string.en_qu_p_ramo_se_encuentra, align = TextAlign.Center)
                ZoneDropdownMenu(
                    newPointUiModel = newPointModel,
                    icon = R.drawable.baseline_public_24_light,
                    buttonDescription = R.string.seleccionar_p_ramo,
                    onDropDownPressed = {
                        ZoneEnum.entries
                    },
                    onFilterSelected = onZoneSelected,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        DataInputTextLabel(windowSize = windowSize,R.string.ubicaci_n_del_punto_de_inter_s)
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding)))
        Surface(
            Modifier.size(
                height = dimensionResource(R.dimen.dropdown_menu_x),
                width = dimensionResource(R.dimen.dropdown_menu_x)
            )
        ) {
            OsmMapView()
        }
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding)))
        StarRating( windowSize = windowSize,newPointUiModel = newPointModel, {})
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding)))
        SaveCancelButtons(
            saveNewPlace,
            modifier = if(windowSize == WindowWidthSizeClass.Expanded){
                Modifier.fillMaxWidth().weight(1f)
            }else{
                Modifier
            }
        )
    }
}

@Composable
fun StarRating(
    windowSize: WindowWidthSizeClass,
    newPointUiModel: NewPointUiModel,
    onRatingChanged: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by newPointUiModel.uiState.collectAsState()
    Row(modifier = modifier) {
        repeat(5) { index ->
            val isFilled = uiState.rat >= index

            IconButton(
                onClick = {
                    onRatingChanged
                    newPointUiModel.SetRatingStars(index)
                }
            ) {
                Image(
                    painter = if (isFilled) painterResource(R.drawable.baseline_star_24) else painterResource(R.drawable.baseline_star_border_24),
                    contentDescription = "Rating ${index + 1}",
                    modifier = if(windowSize == WindowWidthSizeClass.Expanded){
                        modifier.size(
                            height = 80.dp,
                            width = 80.dp
                        )
                    }else{
                        modifier
                    }
                )
            }
        }
    }
}


@Composable
fun SaveCancelButtons(saveNewPlace: () -> Unit, modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = saveNewPlace, modifier = modifier.padding(
            start = dimensionResource(R.dimen.medium_padding),
            end = dimensionResource(R.dimen.medium_padding),
            bottom = dimensionResource(R.dimen.medium_padding)
        )

        ) {
            Text(
                text = stringResource(R.string.guardar),
                fontFamily = MaterialTheme.typography.labelMedium.fontFamily
            )
        }
        Button(onClick = {  }, modifier = modifier.padding(
            start = dimensionResource(R.dimen.medium_padding),
            end = dimensionResource(R.dimen.medium_padding),
            bottom = dimensionResource(R.dimen.medium_padding)
        ),
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.errorContainer,
                contentColor = MaterialTheme.colorScheme.onSurface,
                disabledContentColor = MaterialTheme.colorScheme.errorContainer,
                disabledContainerColor = MaterialTheme.colorScheme.onTertiary
            )
        ) {
            Text(
                text = stringResource(R.string.cancelar),
                fontFamily = MaterialTheme.typography.labelMedium.fontFamily
            )
        }
    }
}

@Composable
fun ZoneDropdownMenu(
    newPointUiModel: NewPointUiModel,
    @DrawableRes
    icon: Int,
    @StringRes
    buttonDescription: Int,
    onDropDownPressed: () -> List<ZoneEnum>,
    onFilterSelected: (filter: ZoneEnum) -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by newPointUiModel.uiState.collectAsState()
    var expanded by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(
                top = dimensionResource(R.dimen.medium_padding),
                start = dimensionResource(R.dimen.medium_padding)
            )
            .background(
                color = MaterialTheme.colorScheme.onSecondary
            )
            .clip(shape = MaterialTheme.shapes.small)
    ) {
        IconButton(
            shape = MaterialTheme.shapes.medium,
            onClick = { expanded = !expanded },
            modifier = modifier
                .size(
                    width = dimensionResource(R.dimen.dropdown_menu_x),
                    height = dimensionResource(R.dimen.dropdown_menu_y)
                )
                .clip(shape = MaterialTheme.shapes.small)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if(uiState.placeHolderZone.name == ZoneEnum.DEFAULT.name){
                        stringResource(buttonDescription)
                    }else{
                        uiState.placeHolderZone.zoneName
                    },
                    fontSize = 15.sp,
                    fontFamily = MaterialTheme.typography.labelMedium.fontFamily,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(icon),
                    contentDescription = stringResource(buttonDescription),
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.small_padding),
                        end = dimensionResource(R.dimen.small_padding)
                    ))
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            for (filter in onDropDownPressed()){
                DropdownMenuItem(
                    text = { Text(filter.zoneName) },
                    onClick = {
                        newPointUiModel.SetNewPointZone(filter)
                        onFilterSelected(filter)
                        expanded = !expanded
                    },
                    colors = MenuItemColors(
                        textColor = MaterialTheme.colorScheme.primary,
                        leadingIconColor = MaterialTheme.colorScheme.primary,
                        trailingIconColor = MaterialTheme.colorScheme.onPrimary,
                        disabledTextColor = MaterialTheme.colorScheme.tertiary,
                        disabledLeadingIconColor = MaterialTheme.colorScheme.tertiary,
                        disabledTrailingIconColor = MaterialTheme.colorScheme.tertiary
                    )
                )
            }
        }
    }
}

@Composable
fun CatDropdownMenu(
    newPointUiModel: NewPointUiModel,
    @DrawableRes
    icon: Int,
    @StringRes
    buttonDescription: Int,
    onDropDownPressed: () -> List<CatEnum>,
    onFilterSelected: (filter: CatEnum) -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by newPointUiModel.uiState.collectAsState()
    var expanded by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(
                top = dimensionResource(R.dimen.medium_padding),
                start = dimensionResource(R.dimen.medium_padding)
            )
            .background(
                color = MaterialTheme.colorScheme.onSecondary
            )
            .clip(shape = MaterialTheme.shapes.small)
    ) {
        IconButton(
            shape = MaterialTheme.shapes.medium,
            onClick = { expanded = !expanded },
            modifier = modifier.size(
                width = dimensionResource(R.dimen.dropdown_menu_x),
                height = dimensionResource(R.dimen.dropdown_menu_y)
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if(uiState.placeHolderCategory.name == CatEnum.DEFAULT.name){
                        stringResource(buttonDescription)
                    }else{
                        uiState.placeHolderCategory.nameOfCat
                    },
                    fontSize = 15.sp,
                    fontFamily = MaterialTheme.typography.labelMedium.fontFamily,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(icon),
                    contentDescription = stringResource(buttonDescription),
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.small_padding),
                        end = dimensionResource(R.dimen.small_padding)
                    ))
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            for (filter in onDropDownPressed()){
                DropdownMenuItem(
                    text = { Text(filter.nameOfCat) },
                    onClick = {
                        newPointUiModel.SetNewPointCategory(filter)
                        onFilterSelected(filter)
                        expanded = !expanded },
                    colors = MenuItemColors(
                        textColor = MaterialTheme.colorScheme.primary,
                        leadingIconColor = MaterialTheme.colorScheme.primary,
                        trailingIconColor = MaterialTheme.colorScheme.onPrimary,
                        disabledTextColor = MaterialTheme.colorScheme.tertiary,
                        disabledLeadingIconColor = MaterialTheme.colorScheme.tertiary,
                        disabledTrailingIconColor = MaterialTheme.colorScheme.tertiary
                    )
                )
            }
        }
    }
}

@Composable
fun DataInputTextLabel(
    windowSize: WindowWidthSizeClass,
    @StringRes text: Int,
    align: TextAlign = TextAlign.Start,
    modifier: Modifier = Modifier){
    Text(
        text = stringResource(text),
        fontFamily = MaterialTheme.typography.labelSmall.fontFamily,
        color = MaterialTheme.colorScheme.primary,
        lineHeight = 30.sp,
        fontSize = if(windowSize == WindowWidthSizeClass.Expanded){
            35.sp
        }else{
            20.sp
        },
        textAlign = align,
        modifier = Modifier
            .padding(
                start = dimensionResource(R.dimen.medium_padding),
                end = dimensionResource(R.dimen.medium_padding),
                top = dimensionResource(R.dimen.medium_padding),
                bottom = dimensionResource(R.dimen.small_padding)
            )
            .fillMaxWidth()
    )
}

@Composable
fun ImgButton(
    windowSize: WindowWidthSizeClass,
    onImgClicked: () -> Unit,
    modifier: Modifier = Modifier){
    TextButton(
        onClick = onImgClicked,
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding))
    ) {
        Image(
            painter = painterResource(R.drawable.img_placeholder),
            contentDescription = stringResource(R.string.add_image_for_new_place_button),
            contentScale = ContentScale.None,
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(4f)
                .scale(
                    if (windowSize == WindowWidthSizeClass.Expanded) {
                        4.5f
                    } else {
                        2.6f
                    }
                )
        )
    }
}

@Composable
fun AddPlaceName(
    windowSize: WindowWidthSizeClass,
    label: String,
    lineLimits: TextFieldLineLimits,
    @DimenRes height: Int,
    @DimenRes width: Int,
    modifier: Modifier = Modifier
){
    TextField(
        state = rememberTextFieldState(initialText = ""),
        label = {
            Text(
                text = label,
                fontFamily = MaterialTheme.typography.labelSmall.fontFamily,
                fontSize = if(windowSize == WindowWidthSizeClass.Expanded){
                    20.sp
                }else{
                    10.sp
                }
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        labelPosition = TextFieldLabelPosition.Attached(),
        textStyle = MaterialTheme.typography.labelMedium,
        lineLimits = lineLimits,
        modifier = if(windowSize == WindowWidthSizeClass.Expanded){
            modifier
                .padding(
                    start = dimensionResource(R.dimen.medium_padding),
                    end = dimensionResource(R.dimen.medium_padding)
                )
                .fillMaxWidth()
                .size(
                    width = dimensionResource(width),
                    height = dimensionResource(height)
                )
        }else{
            modifier
                .padding(
                    start = dimensionResource(R.dimen.medium_padding),
                    end = dimensionResource(R.dimen.medium_padding)
                )
                .size(
                    width = dimensionResource(width),
                    height = dimensionResource(height)
                )
        }
    )
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun AddNewPlacePre(){
    TrochandoParamoTheme(darkTheme = true) {
        AddNewPlaceScreen(windowSize = WindowWidthSizeClass.Expanded, saveNewPlace = {}, onCatSelected = {}, onImgClicked = {}, onZoneSelected = {})
    }
}

/*@Preview(showBackground = true)
@Composable
fun StarRatingPre(){
    TrochandoParamoTheme() {
        StarRating(newPointUiModel = NewPointUiModel(), {})
    }
}*/