package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheGeoLineString() {
  public var streckenpunkt: List<SucheGeoPointWithIndex>? = null

  public constructor(streckenpunkt: List<SucheGeoPointWithIndex>?) : this() {
    this.streckenpunkt = streckenpunkt
  }
}
