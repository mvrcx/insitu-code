package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlinx.serialization.Serializable

@Serializable
public open class SucheGeoRadius() {
  public var wert: Double? = 0.0

  public var masseinheit: CIMPSucheKatalogWert? = null

  public constructor(wert: Double?, masseinheit: CIMPSucheKatalogWert?) : this() {
    this.wert = wert
    this.masseinheit = masseinheit
  }
}
