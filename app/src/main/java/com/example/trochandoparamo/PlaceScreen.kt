package com.example.trochandoparamo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
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
    placeToDisplay: PuntoInteres = DataSetParamo().puntos[24],
    viewModel: PlaceDisplayViewModel = viewModel() ,
    modifier: Modifier = Modifier){
    val uiState by viewModel.UiStatePlace.collectAsState()
    val scrollState = rememberScrollState()
    Box() {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .verticalScroll(scrollState)
                    .background(color = MaterialTheme.colorScheme.background)
            ) {
                TittleText(placeToDisplay.name)
                PlaceCarousel(onImgClicked = {
                    viewModel.setCurrentImage(it)
                    viewModel.setFullScreen(true)
                },
                    imgs = placeToDisplay.imgs)
                PlaceDescDisplay(placeToDisplay.description)
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

@Composable
fun PlaceDescDisplay(
    @StringRes
    desc: Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(desc),
        fontFamily = MaterialTheme.typography.labelMedium.fontFamily,
        textAlign = TextAlign.Justify,
        modifier = modifier.padding(
            start = dimensionResource(R.dimen.medium_padding),
            end = dimensionResource(R.dimen.medium_padding)
        )
    )
}

@Composable
fun TittleText(
    @StringRes
    name: Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(name),
        fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
        fontSize = 40.sp,
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
){
    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState { imgs.count() },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                top = dimensionResource(R.dimen.medium_padding),
                bottom = dimensionResource(R.dimen.medium_padding)
            ),
        preferredItemWidth = 350.dp,
        itemSpacing = dimensionResource(R.dimen.small_padding)
    ) { i ->
        val item = imgs[i]
        TextButton(
            onClick = {onImgClicked(item)},
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
                contentDescription = null,
                modifier = modifier.size(
                    height = 400.dp,
                    width = 380.dp
                )
            )
        }
    }
}

@Composable
fun PlaceImage(@DrawableRes img: Int, onClick: () -> Unit, modifier: Modifier = Modifier){
    Surface(
        color = colorResource(R.color.transparentBackground),
        modifier = modifier.fillMaxSize()
    ) {
        Column() {
            Button(
                onClick = onClick,
                Modifier.weight(0.5f)
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
                contentDescription = "Imagen de prirepipipi",
                modifier = modifier.size(
                    height = dimensionResource(R.dimen.place_image_full_screen_y),
                    width = dimensionResource(R.dimen.place_image_full_screen_x)
                )
                    .weight(weight)
            )
            Button(
                onClick = onClick,
                Modifier.weight(0.5f)
                    .fillMaxSize()
                    .alpha(0f)
            ) {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlaceDisplayScreenPre(){
    TrochandoParamoTheme() {
        PlaceDisplayScreen()
    }
}