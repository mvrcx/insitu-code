package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheWertangabe() {
  public var wert: CIMPSucheNumerischerWert? = null

  public var wertVonBis: SucheWertVonBis? = null

  public constructor(wert: CIMPSucheNumerischerWert?, wertVonBis: SucheWertVonBis?) : this() {
    this.wert = wert
    this.wertVonBis = wertVonBis
  }
}
