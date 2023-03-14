package p20.insitu.model.components.spatial.geodetic.shapes

import kotlinx.serialization.Serializable
import p20.insitu.model.components.spatial.Appearance
import p20.insitu.model.components.spatial.ShapeType
import p20.insitu.model.components.spatial.geodetic.GeoPoint
import p20.insitu.model.components.spatial.geodetic.util.GeodeticReferenceSystem
import p20.insitu.model.components.spatial.util.PATH_DEFAULT_COLOR
import p20.insitu.model.components.spatial.util.PATH_FILL_ALPHA
import p20.insitu.model.components.spatial.util.PATH_STROKE_ALPHA
import p20.insitu.model.components.spatial.util.PATH_STROKE_WIDTH
import p20.insitu.model.xpolizei.schema.GeoDaten
import p20.insitu.model.xpolizei.schema.Geometrie

@Serializable
data class GeoLineString(
    override val shapeType: String = ShapeType.GEO_LINE_STRING.toString(),
    override var referenceSystem: GeodeticReferenceSystem,
    override var worldPosition: GeoPoint? = null,
    override var rotationDegrees: Float = 0.0f,
    override var scaleLat: Float = 1.0f,
    override var scaleLong: Float = 1.0f,
    override val appearance: Appearance = Appearance(),
    var points: MutableList<GeoPoint> = mutableListOf()
) : GeoShape() {

    override fun getGeometrie(): List<Geometrie> {
        return listOf(
            Geometrie(
                referenzsystem = this.referenceSystem.toKatalogCode231(),
                geoDaten = GeoDaten().also {
                    it.strecke = p20.insitu.model.xpolizei.schema.GeoLineString(
                        streckenpunkt = points.mapIndexed { index, geoPoint ->
                            geoPoint.getGeoPointWithIndex(index)
                        }
                    )
                }
            )
        )
    }

}