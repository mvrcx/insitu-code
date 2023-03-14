package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.ui.map.MapView
import p20.insitu.android.ui.map.initMapView
import p20.insitu.android.ui.map.zoomToLocation
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.CrimeSceneViewModel

@Composable
fun CrimeSceneMap(
    uiStateHandler: UiStateHandler,
    viewModel: CrimeSceneViewModel
) {
    // UiStateHandler states
    val language = uiStateHandler.language.collectAsState()

    // Context
    val context = LocalContext.current

    // Geolocation of the address
    val geolocation = viewModel.geolocation.collectAsState()

    // Map configuration & state
    Configuration.getInstance()
        .load(context, androidx.preference.PreferenceManager.getDefaultSharedPreferences(context))
    val locationOverlay = remember { mutableStateOf<MyLocationNewOverlay?>(null) }
    val zoomLevel = remember { mutableStateOf(15.0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(all = Padding.screen),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = MessageStrings.featureNotImplementedYet(language.value))

        MapView(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .heightIn(min = 550.dp)
        ) { mapView ->
            initMapView(mapView, zoomLevel.value)
            if (locationOverlay.value == null) {
                locationOverlay.value =
                    MyLocationNewOverlay(GpsMyLocationProvider(context), mapView)
                locationOverlay.value?.enableMyLocation()
                mapView.overlays.add(locationOverlay.value)
            }
            // Zoom to address location idf exists
            geolocation.value?.worldPosition?.let { addressLocation ->
                zoomToLocation(
                    mapView = mapView,
                    location = GeoPoint(
                        addressLocation.latitude.toDouble(),
                        addressLocation.longitude.toDouble()
                    ),
                    zoomLevel = zoomLevel.value
                )
            } ?: run {
                // Zoom to current location if no address location exists
                locationOverlay.value?.myLocation?.let { currentLocation ->
                    zoomToLocation(
                        mapView = mapView,
                        location = currentLocation,
                        zoomLevel.value
                    )
                }
            }
        }
    }
}