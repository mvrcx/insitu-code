package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Angabe zu Geometrie-Daten.
 */
@Serializable
public open class GeoPolygon() {
  /**
   * Einzelner Punkt des Geo-Polygons.
   */
  public var polygonpunkt: List<GeoPointWithIndex>? = null

  public constructor(polygonpunkt: List<GeoPointWithIndex>?) : this() {
    this.polygonpunkt = polygonpunkt
  }
}
