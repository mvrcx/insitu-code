package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheSerie() {
  public var anzahl: CIMPSucheIntegerWert? = null

  public var inkrement: CIMPSucheIntegerWert? = null

  public constructor(anzahl: CIMPSucheIntegerWert?, inkrement: CIMPSucheIntegerWert?) : this() {
    this.anzahl = anzahl
    this.inkrement = inkrement
  }
}
