package p20.insitu.android.ui.map

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import org.osmdroid.views.MapView

/**
 * A composable Map.
 *
 * @param modifier Modifiers to apply to the map.
 * @param onLoad This will get called once the map has been loaded.
 */
@Composable
fun MapView(
    modifier: Modifier = Modifier,
    onLoad: ((map: MapView) -> Unit)? = null
) {
    val mapViewState = rememberMapViewWithLifecycle()

    AndroidView(
        { mapViewState },
        modifier
    ) { mapView -> onLoad?.invoke(mapView) }
}
