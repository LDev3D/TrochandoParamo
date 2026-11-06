package com.example.trochandoparamo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trochandoparamo.data.DataSetParamo
import com.example.trochandoparamo.data.PuntoInteres
import com.example.trochandoparamo.ui.theme.TrochandoParamoTheme

class PlaceScreen {
}

@Composable
fun PlaceDisplayScreen(placeToDisplay: PuntoInteres = DataSetParamo().puntos[31], modifier: Modifier = Modifier){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TittleText(placeToDisplay.name)
            PlaceCarousel(placeToDisplay.imgs)
        }
    }
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
        preferredItemWidth = 200.dp,
        itemSpacing = dimensionResource(R.dimen.small_padding),
        contentPadding = PaddingValues(
            horizontal = dimensionResource(R.dimen.medium_padding)
        )
    ) { i ->
        val item = imgs[i]
        Image(
            painter = painterResource(id = item),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlaceDisplayScreenPre(){
    TrochandoParamoTheme() {
        PlaceDisplayScreen()
    }
}