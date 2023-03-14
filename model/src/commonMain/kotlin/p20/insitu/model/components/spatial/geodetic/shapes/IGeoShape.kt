package p20.insitu.model.components.spatial.geodetic.shapes

import p20.insitu.model.components.spatial.Appearance
import p20.insitu.model.components.spatial.geodetic.GeoPoint
import p20.insitu.model.components.spatial.geodetic.util.GeodeticReferenceSystem
import p20.insitu.model.xpolizei.interfaces.XpGeometrie

interface IGeoShape: XpGeometrie {
    val id: String
    val shapeType: String
    var referenceSystem: GeodeticReferenceSystem
    var worldPosition: GeoPoint?
    var rotationDegrees: Float
    var scaleLat: Float
    var scaleLong: Float
    val appearance: Appearance

    fun getBoundingBox(): GeoPolygon?

}