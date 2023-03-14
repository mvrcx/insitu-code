package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheGeoDaten() {
  public var punkt: SucheGeoPoint? = null

  public var strecke: SucheGeoLineString? = null

  public var polygon: SucheGeoPolygon? = null

  public var umkreis: SucheGeoCircleByCenterPoint? = null

  public constructor(
      punkt: SucheGeoPoint?,
      strecke: SucheGeoLineString?,
      polygon: SucheGeoPolygon?,
      umkreis: SucheGeoCircleByCenterPoint?
  ) : this() {
    this.punkt = punkt
    this.strecke = strecke
    this.polygon = polygon
    this.umkreis = umkreis
  }
}
