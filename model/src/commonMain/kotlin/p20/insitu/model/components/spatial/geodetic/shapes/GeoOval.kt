package p20.insitu.model.components.spatial.geodetic.shapes

import kotlinx.serialization.Serializable
import p20.insitu.model.components.spatial.Appearance
import p20.insitu.model.components.spatial.ShapeType
import p20.insitu.model.components.spatial.geodetic.GeoPoint
import p20.insitu.model.components.spatial.geodetic.util.GeodeticReferenceSystem
import p20.insitu.model.components.spatial.util.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class GeoOval(
    override val shapeType: String = ShapeType.GEO_OVAL.toString(),
    override var referenceSystem: GeodeticReferenceSystem,
    override var worldPosition: GeoPoint?,
    override var rotationDegrees: Float = 0.0f,
    override var scaleLat: Float = 1.0f,
    override var scaleLong: Float = 1.0f,
    override val appearance: Appearance = Appearance(),
    var radiusLat: Float = DEFAULT_RADIUS_LAT,
    var radiusLong: Float = DEFAULT_RADIUS_LONG
) : GeoShape() {

    override fun getGeometrie(): List<Geometrie> {
        return listOf(
            Geometrie(
                referenzsystem = this.referenceSystem.toKatalogCode231(),
                geoDaten = GeoDaten().also {
                    if (radiusLat.compareTo(radiusLong) == 0) {
                        it.umkreis = GeoCircleByCenterPoint(
                            mittelpunkt = worldPosition?.getXpGeoPoint(),
                            radius = GeoRadius(
                                radiusLat.toDouble(),
                                KatalogCode207().also {
                                    it.code = "207_2"
                                    it.name = "Meter"
                                }
                            )
                        )
                    }
                }
            )
        )
    }

}