package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheWertVonBis() {
  public var wertVon: CIMPSucheNumerischerWert? = null

  public var wertBis: CIMPSucheNumerischerWert? = null

  public constructor(wertVon: CIMPSucheNumerischerWert?, wertBis: CIMPSucheNumerischerWert?) :
      this() {
    this.wertVon = wertVon
    this.wertBis = wertBis
  }
}
