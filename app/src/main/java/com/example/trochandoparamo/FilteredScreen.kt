package com.example.trochandoparamo

import android.text.Layout
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.foundation.text.TextAutoSizeDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trochandoparamo.data.DataSetParamo
import com.example.trochandoparamo.data.PuntoInteres
import com.example.trochandoparamo.ui.theme.TrochandoParamoTheme
import org.intellij.lang.annotations.JdkConstants

class FilteredScreen {
}

@Composable
fun FilteredList(
    windowSize: WindowWidthSizeClass,
    points: List<PuntoInteres>,
    onPointClick: (PuntoInteres) -> Unit,
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            state = rememberLazyListState(),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.secondary)
        ) {
            items(points){ point ->
                ListElement(interestPoint = point, onClick = onPointClick)
            }
        }
    }
}

@Composable
fun ListElement(
    interestPoint: PuntoInteres,
    onClick:(PuntoInteres) -> Unit,
    modifier: Modifier = Modifier){
    TextButton(
        onClick = {onClick(interestPoint)} ,
        shape = RectangleShape,
        border = null,
        modifier = modifier.fillMaxWidth().size(
            height = 250.dp,
            width = 600.dp)

    ) {
        Card(
            modifier = modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.background(MaterialTheme.colorScheme.tertiary)
            ) {
                ListItemImg(img = interestPoint.imgs[0], modifier = modifier.weight(0.6f))
                Column(
                    modifier = modifier.weight(1f)
                ) {
                    ListItemTittle(name = interestPoint.name)
                    Spacer(modifier = Modifier.padding(start = dimensionResource(R.dimen.list_item_width), end = dimensionResource(R.dimen.list_item_width), bottom = dimensionResource(R.dimen.small_padding)))
                    Box() {
                        ListItemDesc(interestPoint.description)
                        StartRate(
                            interestPoint.ratingStars,
                            modifier
                                .align(alignment = Alignment.BottomEnd)
                                .padding(
                                    bottom = dimensionResource(R.dimen.small_padding),
                                    end = dimensionResource(R.dimen.medium_padding)
                                )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StartRate(
    rate: Int,
    modifier: Modifier = Modifier
){
    Row(modifier = modifier) {
        repeat(5) { index ->
            val isFilled = rate > index
            Image(
                painter = if (isFilled) painterResource(R.drawable.baseline_star_24) else painterResource(R.drawable.baseline_star_border_24),
                contentDescription = "Rating ${index + 1}"
            )
        }
    }
}

@Composable
fun ListItemDesc(
    @StringRes
    desc: Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(desc),
        fontFamily = MaterialTheme.typography.labelMedium.fontFamily,
        textAlign = TextAlign.Justify,
        color = MaterialTheme.colorScheme.surface,
        overflow = TextOverflow.Ellipsis,
        lineHeight = 15.sp,
        modifier = modifier
            .size(width = 500.dp, height = 200.dp)
            .padding(
                start = dimensionResource(R.dimen.medium_padding),
                end = dimensionResource(R.dimen.medium_padding),
                bottom = dimensionResource(R.dimen.big_padding)
            )
    )
}

@Composable
fun ListItemTittle(
    @StringRes
    name: Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(name),
        fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
        color = MaterialTheme.colorScheme.surface,
        fontSize = 30.sp,
        lineHeight = 28.sp,
        modifier = modifier.padding(
            start = dimensionResource(R.dimen.medium_padding),
            top = dimensionResource(R.dimen.small_padding),
            end = dimensionResource(R.dimen.medium_padding)
        )
    )
}

@Composable
fun ListItemImg(
    @DrawableRes
    img: Int,
    modifier: Modifier = Modifier
){
    Image(
        painter = painterResource(img),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxHeight()
            .width(dimensionResource(R.dimen.list_item_image))
            .clip(MaterialTheme.shapes.medium)
    )
}

/*@Preview(showBackground = true)
@Composable
fun ListElementPre(){
    TrochandoParamoTheme() {
        ListElement(interestPoint = DataSetParamo().puntos[5], onClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun FilteredListPre(){
    TrochandoParamoTheme() {
        FilteredList(windowSize = WindowWidthSizeClass.Compact,DataSetParamo().puntos, {})
    }
}*/
@Preview(showBackground = true, widthDp = 1000)
@Composable
fun FilteredListPre(){
    TrochandoParamoTheme() {
        FilteredList(windowSize = WindowWidthSizeClass.Compact,DataSetParamo().puntos, {})
    }
}