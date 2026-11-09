package com.example.trochandoparamo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trochandoparamo.data.DestinationsEnum
import com.example.trochandoparamo.data.FilterEnum
import com.example.trochandoparamo.data.FilterItem
import com.example.trochandoparamo.model.ViewModelParamo
import com.example.trochandoparamo.ui.theme.TrochandoParamoTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.trochandoparamo.data.CatEnum
import com.example.trochandoparamo.data.ZoneEnum

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrochandoAppBar(canNavigateBack: Boolean, navigateUp: () -> Unit,modifier: Modifier = Modifier){
    TopAppBar(
        title = {
            Surface(
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Text(
                        text = stringResource(R.string.app_name),
                        fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.bar_padding),
                            end = dimensionResource(R.dimen.bar_padding)
                        )
                    )
                    Image(
                        painter = painterResource(R.drawable.icon),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(dimensionResource(R.dimen.small_logo))
                    )
                }
            }
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_arrow_back_24_dark),
                        contentDescription = stringResource(R.string.bot_n_para_ir_atr_s)
                    )
                }
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TrochandoAppScreen(
    viewModel: ViewModelParamo = viewModel(),
    navHostController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier){
    val uiState by viewModel.uiState.collectAsState()
    val backStackEntry by navHostController.currentBackStackEntryAsState()
    val currentScreen = DestinationsEnum.valueOf(
        backStackEntry?.destination?.route?: DestinationsEnum.HOME.name
    )

    Scaffold(
        topBar = {
            TrochandoAppBar(
                canNavigateBack = currentScreen.name != DestinationsEnum.HOME.name,
                navigateUp = {
                    navHostController.navigateUp()
                }
            )
        }
    ) {it ->
        NavHost(
            navController = navHostController,
            startDestination = DestinationsEnum.HOME.name,
            modifier = Modifier.padding(it)
        ) {
            composable(
                route = DestinationsEnum.HOME.name
            ){
                TrochandoHome(
                    viewModel = viewModel,
                    onFilterKindSelected = {
                        viewModel.SetCurrentFilterList(it)
                        if (viewModel.uiState.value.currentFilter == FilterEnum.ALL){
                            navHostController.navigate(route = DestinationsEnum.FILTERED.name)
                        }
                    },
                    onSpecificFilterSelected = {
                        viewModel.SetZoneOrCatToPerformSearch(GetZoneOrCatToPerformSearch(it).first, GetZoneOrCatToPerformSearch(it).second)
                        navHostController.navigate(route = DestinationsEnum.FILTERED.name)
                    },
                    onNewPlacePressed = {
                        navHostController.navigate(DestinationsEnum.NEW.name)
                    }
                )
            }
            composable(
                route = DestinationsEnum.FILTERED.name
            ){
                FilteredList(points = viewModel.getFilteredList(), onPointClick = {
                    viewModel.setCurrentPlace(it)
                    navHostController.navigate(DestinationsEnum.DETAILS.name)
                })
            }
            composable(
                route = DestinationsEnum.DETAILS.name
            ){
                PlaceDisplayScreen(placeToDisplay = uiState.currentInterestPoint)
            }
            composable (
                route = DestinationsEnum.NEW.name
            ){
                AddNewPlaceScreen(
                    saveNewPlace = {},
                    onImgClicked = {},
                    onZoneSelected = {},
                    onCatSelected = {}
                )
            }
        }
    }
}

fun GetZoneOrCatToPerformSearch(filterItem: FilterItem): Pair<CatEnum, ZoneEnum>{
    var cat: CatEnum = CatEnum.DEFAULT
    var zone: ZoneEnum = ZoneEnum.DEFAULT
    for(x in CatEnum.entries){
        if (filterItem.enumKind.toString() == x.name){
            cat = x
        }
    }
    for(y in ZoneEnum.entries){
        if(filterItem.enumKind.toString() == y.name){
            zone = y
        }
    }
    return cat to zone
}

@Composable
fun TrochandoHome(
    viewModel: ViewModelParamo,
    onNewPlacePressed: () -> Unit,
    onFilterKindSelected: (filter: FilterEnum) -> Unit,
    onSpecificFilterSelected: (filter: FilterItem) -> Unit,
    modifier: Modifier = Modifier){
    val uiState by viewModel.uiState.collectAsState()
    Column() {
        Text(
            text = stringResource(DestinationsEnum.HOME.screenTittle),
            textAlign = TextAlign.Start,
            fontFamily = MaterialTheme.typography.labelSmall.fontFamily,
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    top = dimensionResource(R.dimen.medium_padding),
                    start = dimensionResource(R.dimen.medium_padding)
                )
        )
        MinimalDropdownMenu(
            onDropDownPressed = {
                viewModel.ReturnFilterEnums()
            },
            onFilterSelected = onFilterKindSelected)

        Spacer(modifier = modifier.padding(top = dimensionResource(R.dimen.filter_image)))
        if (uiState.showingFilterList){
            FiltersList(onFilterSelected = onSpecificFilterSelected, uiState.currentFilterList)
        }
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.add_new_place_btn_to_bottom)))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
            modifier = modifier.fillMaxWidth()
        ) {
            Button(
                onClick = onNewPlacePressed
            ) {
                Icon(
                    painterResource(R.drawable.baseline_add_location_alt_24_dark),
                    contentDescription = stringResource(R.string.a_adir_un_nuevo_lugar)
                )
                Text(
                    text = stringResource(R.string.a_adir_un_nuevo_lugar),
                    fontFamily = MaterialTheme.typography.labelSmall.fontFamily
                )
            }
        }
    }
}

@Composable
fun MinimalDropdownMenu(
    onDropDownPressed: () -> List<FilterEnum>,
    onFilterSelected: (filter: FilterEnum) -> Unit,
    modifier: Modifier = Modifier
    ) {
    var expanded by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                top = dimensionResource(R.dimen.medium_padding),
                start = dimensionResource(R.dimen.medium_padding)
            )
    ) {
        IconButton(
            shape = MaterialTheme.shapes.medium,
            onClick = { expanded = !expanded },
            modifier = Modifier.size(
                width = dimensionResource(R.dimen.dropdown_menu_x),
                height = dimensionResource(R.dimen.dropdown_menu_y)
            )
        ) {
            Row() {
                Icon(
                    painter = painterResource(R.drawable.baseline_explore_24_light),
                    contentDescription = "More options",
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.small_padding),
                        end = dimensionResource(R.dimen.small_padding)
                    ))
                Text(
                    text = stringResource(R.string.quiero_buscar_lugares_por),
                    fontFamily = MaterialTheme.typography.labelMedium.fontFamily
                )
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            for (filter in onDropDownPressed()){
                DropdownMenuItem(
                    text = { Text(stringResource(filter.displayText)) },
                    onClick = {
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
fun FiltersList(
    onFilterSelected: (filter: FilterItem) -> Unit,
    filters: List<FilterItem>,
    modifier: Modifier = Modifier
){
    LazyRow(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(dimensionResource(R.dimen.medium_padding))
    ) {
        items(filters){
            filterElement ->
            FilterButton(onClick = {onFilterSelected(filterElement)}, filterItem = filterElement)
        }
    }
}

@Composable
fun FilterButton(
    onClick: () -> Unit,
    filterItem: FilterItem,
    modifier: Modifier = Modifier
){
    Button(
        modifier = modifier.padding(dimensionResource(R.dimen.small_padding)),
        shape = MaterialTheme.shapes.large,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 4.dp,
            focusedElevation = 6.dp
        ),
        onClick = onClick) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(filterItem.img),
                contentDescription = stringResource(filterItem.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.filter_image))
                    .clip(shape = MaterialTheme.shapes.medium)
                )
            Text(
                text = stringResource(filterItem.name),
                fontFamily = MaterialTheme.typography.labelMedium.fontFamily
            )
        }
    }
}

/*@Preview()
@Composable
fun filtersListPre(){
    TrochandoParamoTheme() {
        filtersList(onFilterSelected = {}, filters = DataSetParamo().catFilters)
    }
}*/

/*@Preview(showBackground = true)
@Composable
fun FilterButtonPre(){
    TrochandoParamoTheme(darkTheme = true) {
        FilterButton(onClick = {}, DataSetParamo().catFilters[1])
    }
}*/

/*@Preview(showBackground = true)
@Composable
fun TrochandoPre(){
    TrochandoParamoTheme(darkTheme = true ) {
        Scaffold(
            topBar = {
                TrochandoAppBar(canNavigateBack = true, navigateUp = {})
            }
        ) {it ->
            TrochandoHome(viewModel = ViewModelParamo(), onNewPlacePressed = {}, onSpecificFilterSelected = {}, onFilterKindSelected = {},  modifier = Modifier
                .fillMaxSize()
                .padding(it))
        }
    }
}*/

@Preview(showBackground = true)
@Composable
fun AppBarPre(){
    TrochandoParamoTheme() {
        TrochandoAppBar(
            canNavigateBack = true,
            navigateUp = {}
        )
    }
}
