package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Auswahl von Punkt, Strecke, Polygon oder Umkreis.
 */
@Serializable
public open class GeoDaten() {
  /**
   * Angabe des Punktes.
   */
  public var punkt: GeoPoint? = null

  /**
   * Angabe der Strecke.
   */
  public var strecke: GeoLineString? = null

  /**
   * Angabe des Polygons.
   */
  public var polygon: GeoPolygon? = null

  /**
   * Angabe des Umkreises.
   */
  public var umkreis: GeoCircleByCenterPoint? = null

  public constructor(
      punkt: GeoPoint?,
      strecke: GeoLineString?,
      polygon: GeoPolygon?,
      umkreis: GeoCircleByCenterPoint?
  ) : this() {
    this.punkt = punkt
    this.strecke = strecke
    this.polygon = polygon
    this.umkreis = umkreis
  }
}
