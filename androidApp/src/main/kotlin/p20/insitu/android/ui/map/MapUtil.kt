package p20.insitu.android.ui.map

import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

fun initMapView(mapView: MapView, initialZoom: Double) {
    mapView.setTileSource(TileSourceFactory.MAPNIK)
    mapView.setMultiTouchControls(true)
    //mapView.zoomController.activate()
    //mapView.setUseDataConnection(true)
    mapView.controller.setZoom(initialZoom)
}

/**
 * Zooms and centers map view to the given location
 *
 * @param mapView The map view.
 * @param location The location to zoom to.
 * @param zoomLevel The zoom level to use.
 */
fun zoomToLocation(mapView: MapView, location: GeoPoint, zoomLevel: Double) {
    mapView.controller.setZoom(zoomLevel)
    mapView.controller.setCenter(location)
    //mapView.controller.animateTo(location)
}