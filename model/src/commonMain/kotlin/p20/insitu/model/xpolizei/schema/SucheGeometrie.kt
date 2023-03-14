package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheGeometrie() {
  public var referenzsystem: CIMPSucheKatalogWert? = null

  public var geoDaten: SucheGeoDaten? = null

  public constructor(referenzsystem: CIMPSucheKatalogWert?, geoDaten: SucheGeoDaten?) : this() {
    this.referenzsystem = referenzsystem
    this.geoDaten = geoDaten
  }
}
