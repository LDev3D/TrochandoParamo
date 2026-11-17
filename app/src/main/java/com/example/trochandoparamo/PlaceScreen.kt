package com.example.trochandoparamo

import androidx.annotation.Dimension
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.trochandoparamo.data.DataSetParamo
import com.example.trochandoparamo.data.PuntoInteres
import com.example.trochandoparamo.model.PlaceDisplayViewModel
import com.example.trochandoparamo.ui.theme.TrochandoParamoTheme

class PlaceScreen {
}

@Composable
fun PlaceDisplayScreen(
    windowSize: WindowWidthSizeClass,
    placeToDisplay: PuntoInteres = DataSetParamo().puntos[0],
    viewModel: PlaceDisplayViewModel = viewModel() ,
    modifier: Modifier = Modifier){
    val uiState by viewModel.UiStatePlace.collectAsState()
    val scrollState = rememberScrollState()
    if(windowSize == WindowWidthSizeClass.Expanded){
        Box(
            modifier = modifier
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .verticalScroll(scrollState)
                    .background(MaterialTheme.colorScheme.secondary)
            ) {
                ExpandedPlaceImg(
                    imgs = placeToDisplay.imgs,
                    onImgClicked = {
                        viewModel.setCurrentImage(it)
                        viewModel.setFullScreen(true)
                    }
                )

                Spacer(Modifier.padding(dimensionResource(R.dimen.medium_padding)))

                TittleText(
                    windowSize = windowSize,
                    name = placeToDisplay.name
                )

                Spacer(Modifier.padding(dimensionResource(R.dimen.medium_padding)))

                PlaceDescDisplay(windowSize = windowSize,placeToDisplay.description)

                Spacer(Modifier.padding(dimensionResource(R.dimen.medium_padding)))

                ZoneCatText(windowSize = windowSize,zone = placeToDisplay.zona.zoneName, cat = placeToDisplay.categoria.nameOfCat)

                Spacer(Modifier.padding(dimensionResource(R.dimen.medium_padding)))

                /*Surface(
                    Modifier.size(
                        height = dimensionResource(R.dimen.dropdown_menu_x),
                        width = dimensionResource(R.dimen.dropdown_menu_x)
                    )
                ) {
                    OsmMapView(latitude = placeToDisplay.latitud, longitude = placeToDisplay.longitud)
                }*/
                Spacer(Modifier.padding(dimensionResource(R.dimen.medium_padding)))
                BigStarsRating(placeToDisplay.ratingStars)
            }
            if(uiState.isOnFullScreenImage){
                PlaceImage(
                    img = uiState.currentImageToDisplayOnFullScreen,
                    onClick = {
                        viewModel.setFullScreen(false)
                    })
            }
        }
    }else{
        Box() {
            Surface(modifier = Modifier.fillMaxSize()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .verticalScroll(scrollState)
                        .background(MaterialTheme.colorScheme.secondary)
                ) {
                    TittleText(windowSize = windowSize,placeToDisplay.name)
                    PlaceCarousel(onImgClicked = {
                        viewModel.setCurrentImage(it)
                        viewModel.setFullScreen(true)
                    },
                        imgs = placeToDisplay.imgs)
                    PlaceDescDisplay(windowSize = windowSize,placeToDisplay.description)
                    Spacer(Modifier.padding(dimensionResource(R.dimen.medium_padding)))
                    ZoneCatText(windowSize = windowSize,zone = placeToDisplay.zona.zoneName, cat = placeToDisplay.categoria.nameOfCat)
                    Spacer(Modifier.padding(dimensionResource(R.dimen.medium_padding)))
                    Surface(
                        Modifier.size(
                            height = dimensionResource(R.dimen.dropdown_menu_x),
                            width = dimensionResource(R.dimen.dropdown_menu_x)
                        )
                    ) {
                        OsmMapView(latitude = placeToDisplay.latitud, longitude = placeToDisplay.longitud)
                    }
                    Spacer(Modifier.padding(dimensionResource(R.dimen.medium_padding)))
                    BigStarsRating(placeToDisplay.ratingStars)
                }
            }
            if(uiState.isOnFullScreenImage){
                PlaceImage(
                    img = uiState.currentImageToDisplayOnFullScreen,
                    onClick = {
                        viewModel.setFullScreen(false)
                    })
            }
        }
    }
}

@Composable
fun ExpandedPlaceImg(
    @DrawableRes
    imgs: List<Int>,
    onImgClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    if(imgs.size > 1){
        LazyRow(
            state = rememberLazyListState()
        ) {
            items(imgs){ img ->
                TextButton(
                    onClick = {onImgClicked(img)},
                    shape = RectangleShape,
                    modifier = modifier.size(
                        height = dimensionResource(R.dimen.filter_image),
                        width = dimensionResource(R.dimen.filter_image)
                    )
                        .padding(
                            start = dimensionResource(R.dimen.very_small_padding),
                            end = dimensionResource(R.dimen.very_small_padding)
                        )
                ) {
                    Image(
                        painter = painterResource(img),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = modifier.scale(3f)
                    )
                }
            }
        }
    }
    else{
        TextButton(
            onClick = {onImgClicked(imgs[0])},
            shape = MaterialTheme.shapes.large
        ) {
            Image(
                painter = painterResource(imgs[0]),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = if(painterResource(imgs[0]).intrinsicSize.width < painterResource(imgs[0]).intrinsicSize.height){
                    modifier.fillMaxSize()
                        .clip(shape = MaterialTheme.shapes.large)
                        .aspectRatio(3f)
                        .scale(
                            scaleX = 1f,
                            scaleY = 4f
                        )
                }else{
                    modifier.fillMaxSize()
                        .clip(shape = MaterialTheme.shapes.large)
                        .aspectRatio(3f)
                        .scale(
                            scaleX = 1f,
                            scaleY = 2f
                        )
                }
            )
        }
    }
}

@Composable
fun BigStarsRating(
    rating: Int,
    modifier: Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.padding(
            bottom = dimensionResource(R.dimen.medium_padding)
        )
    ) {
        repeat(5) { index ->
            val isFilled = rating > index
            Image(
                painter = if (isFilled) painterResource(R.drawable.baseline_star_24) else painterResource(R.drawable.baseline_star_border_24),
                contentDescription = "Rating ${index + 1}",
                modifier.size(
                    height = 50.dp,
                    width = 50.dp
                )
            )
        }
    }
}

@Composable
fun ZoneCatText(
    windowSize: WindowWidthSizeClass,
    zone: String,
    cat: String,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            Text(
                text = "Categoría:",
                color = MaterialTheme.colorScheme.surface,
                fontFamily = MaterialTheme.typography.labelSmall.fontFamily,
                fontSize = if(windowSize == WindowWidthSizeClass.Expanded){
                    40.sp
                }else{
                    25.sp
                },
                modifier = modifier.padding(
                    start = dimensionResource(R.dimen.small_padding),
                )
            )
            Text(
                text = cat,
                color = MaterialTheme.colorScheme.surface,
                textAlign = TextAlign.Start,
                fontFamily = MaterialTheme.typography.labelSmall.fontFamily,
                fontSize = if(windowSize == WindowWidthSizeClass.Expanded){
                    40.sp
                }else{
                    25.sp
                },
                modifier = modifier.padding(
                    start = dimensionResource(R.dimen.small_padding),
                    end = dimensionResource(R.dimen.small_padding)
                )
            )
        }
        Spacer(Modifier.padding(dimensionResource(R.dimen.medium_padding)))
        Text(
            text = zone,
            color = MaterialTheme.colorScheme.surface,
            fontFamily = MaterialTheme.typography.labelSmall.fontFamily,
            fontSize = if(windowSize == WindowWidthSizeClass.Expanded){
                40.sp
            }else{
                25.sp
            },
            modifier = modifier.padding(
                start = dimensionResource(R.dimen.small_padding),
                end = dimensionResource(R.dimen.small_padding)
            )
        )
    }
}

@Composable
fun PlaceDescDisplay(
    windowSize: WindowWidthSizeClass,
    @StringRes
    desc: Int,
    modifier: Modifier = Modifier
){
    Card(
        shape = RectangleShape,
        colors = CardColors(
            contentColor = MaterialTheme.colorScheme.onTertiary,
            containerColor = MaterialTheme.colorScheme.inverseSurface,
            disabledContentColor = MaterialTheme.colorScheme.surface,
            disabledContainerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Text(
            text = stringResource(desc),
            fontFamily = MaterialTheme.typography.labelMedium.fontFamily,
            color = MaterialTheme.colorScheme.surface,
            fontSize = if(windowSize == WindowWidthSizeClass.Expanded){
                30.sp
            }else{
                15.sp
            },
            lineHeight = if(windowSize == WindowWidthSizeClass.Expanded){
                30.sp
            }else{
                15.sp
            },
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(
                start = dimensionResource(R.dimen.medium_padding),
                end = dimensionResource(R.dimen.medium_padding)
            ).padding(dimensionResource(R.dimen.medium_padding))
        )
    }
}

@Composable
fun TittleText(
    windowSize: WindowWidthSizeClass,
    @StringRes
    name: Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(name),
        fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
        color = MaterialTheme.colorScheme.surface,
        fontSize = if(windowSize == WindowWidthSizeClass.Expanded){
            60.sp
        }else{
            40.sp
        },
        lineHeight = if(windowSize == WindowWidthSizeClass.Expanded){
            65.sp
        }else{
            45.sp
        },
        textAlign = TextAlign.Center,
        modifier = modifier
            .padding(dimensionResource(R.dimen.medium_padding))
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceCarousel(
    onImgClicked: (Int) -> Unit,
    @DrawableRes
    imgs: List<Int>,
    modifier: Modifier = Modifier
) {
    if(imgs.size == 1){
        TextButton(
            onClick = { onImgClicked(imgs[0]) },
            colors = ButtonColors(
                contentColor = colorResource(R.color.transparent),
                containerColor = colorResource(R.color.transparent),
                disabledContentColor = colorResource(R.color.transparent),
                disabledContainerColor = colorResource(R.color.transparent)
            ),
            modifier = Modifier.size(
                height = 180.dp,
                width = 600.dp
            )
        ) {
            Image(
                painter = painterResource(imgs[0]),
                contentDescription = null
            )
        }
    }else{
        BoxWithConstraints(
            modifier = modifier.fillMaxWidth()
        ) {
            val screenWidth = maxWidth
            val imageWidth = painterResource(imgs[0]).intrinsicSize.width.dp

            val horizontalPadding = if (imgs.size == 1 && screenWidth > imageWidth) {
                (screenWidth -painterResource(imgs[0]).intrinsicSize.width.dp / 2) /2
            } else {
                0.dp
            }

            HorizontalMultiBrowseCarousel(
                state = rememberCarouselState { imgs.count() },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(
                        top = dimensionResource(R.dimen.medium_padding),
                        bottom = dimensionResource(R.dimen.medium_padding),
                        start = dimensionResource(R.dimen.big_padding),
                        end = dimensionResource(R.dimen.big_padding)
                    ),
                preferredItemWidth = 350.dp,
                itemSpacing = dimensionResource(R.dimen.small_padding),
                contentPadding = PaddingValues(horizontal = horizontalPadding)
            ) { i ->
                val item = imgs[i]
                TextButton(
                    onClick = { onImgClicked(item) },
                    colors = ButtonColors(
                        contentColor = colorResource(R.color.transparent),
                        containerColor = colorResource(R.color.transparent),
                        disabledContentColor = colorResource(R.color.transparent),
                        disabledContainerColor = colorResource(R.color.transparent)
                    ),
                    modifier = Modifier.size(
                        height = 180.dp,
                        width = 600.dp
                    )
                ) {
                    Image(
                        painter = painterResource(item),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
fun PlaceImage(@DrawableRes img: Int, onClick: () -> Unit, modifier: Modifier = Modifier){
    Surface(
        color = colorResource(R.color.transparentBackground),
        modifier = modifier.fillMaxSize()
    ) {
        TextButton(
            onClick = onClick,
            shape = RectangleShape,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(img),
                contentDescription = stringResource(R.string.imagen_de_punto_de_inter_s),
                modifier = Modifier.fillMaxSize()
            )
        }
        /*Column() {
            Button(
                onClick = onClick,
                Modifier
                    .weight(0.5f)
                    .fillMaxSize()
                    .alpha(0f)
            ) {
            }
            val weight: Float =
                if(painterResource(img).intrinsicSize.width < painterResource(img).intrinsicSize.height){
                    2f
                }else{
                    0.5f
                }
            Image(
                painter = painterResource(img),
                contentDescription = stringResource(R.string.imagen_de_punto_de_inter_s),
                modifier = modifier
                    .size(
                        height = dimensionResource(R.dimen.place_image_full_screen_y),
                        width = dimensionResource(R.dimen.place_image_full_screen_x)
                    )
                    .weight(weight)
            )
            Button(
                onClick = onClick,
                Modifier
                    .weight(0.5f)
                    .fillMaxSize()
                    .alpha(0f)
            ) {
            }
        }*/
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun PlaceDisplayScreenPre(){
    TrochandoParamoTheme() {
        PlaceDisplayScreen(windowSize = WindowWidthSizeClass.Expanded, modifier = Modifier.fillMaxSize())
    }
}
@Preview(showBackground = true, widthDp = 400)
@Composable
fun PlaceDisplayScreenPreCompact(){
    TrochandoParamoTheme() {
        PlaceDisplayScreen(windowSize = WindowWidthSizeClass.Compact)
    }
}