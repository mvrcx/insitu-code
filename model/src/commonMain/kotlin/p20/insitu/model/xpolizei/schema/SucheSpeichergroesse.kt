package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheSpeichergroesse() {
  public var wert: CIMPSucheNumerischerWert? = null

  public var masseinheit: CIMPSucheKatalogWert? = null

  public constructor(wert: CIMPSucheNumerischerWert?, masseinheit: CIMPSucheKatalogWert?) : this() {
    this.wert = wert
    this.masseinheit = masseinheit
  }
}
