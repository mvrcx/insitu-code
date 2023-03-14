package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Angabe zu Geometrie-Daten.
 */
@Serializable
public open class GeoCircleByCenterPoint() {
  /**
   * Angabe des Mittelpunktes des Umkreises.
   */
  public var mittelpunkt: GeoPoint? = null

  public var radius: GeoRadius? = null

  public constructor(mittelpunkt: GeoPoint?, radius: GeoRadius?) : this() {
    this.mittelpunkt = mittelpunkt
    this.radius = radius
  }
}
