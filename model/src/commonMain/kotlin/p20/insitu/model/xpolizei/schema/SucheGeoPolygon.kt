package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheGeoPolygon() {
  public var polygonpunkt: List<SucheGeoPointWithIndex>? = null

  public constructor(polygonpunkt: List<SucheGeoPointWithIndex>?) : this() {
    this.polygonpunkt = polygonpunkt
  }
}
