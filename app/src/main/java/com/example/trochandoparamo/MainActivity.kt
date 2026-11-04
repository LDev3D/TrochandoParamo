package com.example.trochandoparamo

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.trochandoparamo.ui.theme.TrochandoParamoTheme
import org.osmdroid.config.Configuration.*
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import java.io.File

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val ctx = applicationContext
        val tileCacheDir = File(ctx.cacheDir, "osmdroid/tiles")
        val prefs = PreferenceManager.getDefaultSharedPreferences(ctx)

        getInstance().load(ctx, prefs)
        getInstance().userAgentValue = "Mozilla/5.0 (Android; Mobile; rv:120.0) Gecko/120.0 Firefox/120.0"
        getInstance().osmdroidBasePath = ctx.cacheDir
        getInstance().osmdroidTileCache = tileCacheDir
        getInstance().tileFileSystemCacheMaxBytes = 100L * 1024 * 1024
        getInstance().tileFileSystemCacheTrimBytes = 80L * 1024 * 1024

        setContent {
            TrochandoParamoTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TrochandoAppScreen()
                    //AddNewPlaceScreen(onCatSelected = {}, onZoneSelected = {}, saveNewPlace = {}, onImgClicked = {})
                }
            }
        }
    }
}

@Composable
fun OsmMapView(
    modifier: Modifier = Modifier,
    latitude: Double = 4.6097,
    longitude: Double = -74.0817,
    zoomLevel: Double = 12.0
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            MapView(context).apply {
                setTileSource(TileSourceFactory.OpenTopo)
                setMultiTouchControls(true)
                controller.setZoom(zoomLevel)
                controller.setCenter(GeoPoint(latitude, longitude))
            }
        },
        update = { mapView ->
            mapView.onResume()
        }
    )
}
