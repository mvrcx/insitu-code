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
import p20.insitu.model.xpolizei.schema.Geometrie

@Serializable
data class ComposedGeoShape(
    override val shapeType: String = ShapeType.COMPOSED_GEO_SHAPE.toString(),
    override var referenceSystem: GeodeticReferenceSystem,
    override var worldPosition: GeoPoint?,
    override var rotationDegrees: Float = 0.0f,
    override var scaleLat: Float = 1.0f,
    override var scaleLong: Float = 1.0f,
    override val appearance: Appearance = Appearance(),
    var parts: MutableList<GeoShape> = mutableListOf()
)  : GeoShape() {

    override fun getGeometrie(): List<Geometrie> {
        return parts.flatMap { it.getGeometrie() }
    }

}