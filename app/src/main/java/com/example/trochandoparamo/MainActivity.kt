package com.example.trochandoparamo

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getDrawable
import com.example.trochandoparamo.ui.theme.TrochandoParamoTheme
import org.osmdroid.config.Configuration.*
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
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
    latitude: Double = 5.53945,
    longitude: Double = -72.92444,
    zoomLevel: Double = 14.0
) {
    val geoPoint = GeoPoint(latitude, longitude)

    AndroidView(
        modifier = modifier,
        factory = { context ->
            MapView(context).apply {
                setTileSource(TileSourceFactory.OpenTopo)
                setMultiTouchControls(true)
                controller.setZoom(zoomLevel)
                controller.setCenter(geoPoint)

                // Agregar marcador aquí: se ejecuta solo una vez
                val marker = Marker(this) // this es MapView
                marker.position = geoPoint
                marker.icon = ContextCompat.getDrawable(context, R.drawable.baseline_location_on_24_map)
                marker.title = "Test Marker"
                marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER)
                overlays.add(marker)
            }
        },
        update = { mapView ->
            // Si solo actualizas el centro/zoom, hazlo aquí; no agregues marcadores repetidamente
            mapView.controller.setCenter(geoPoint)
            mapView.controller.setZoom(zoomLevel)
        }
    )
}
