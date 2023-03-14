package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheGeldbetrag() {
  public var waehrung: CIMPSucheKatalogWert? = null

  public var betrag: CIMPSucheNumerischerWert? = null

  public constructor(waehrung: CIMPSucheKatalogWert?, betrag: CIMPSucheNumerischerWert?) : this() {
    this.waehrung = waehrung
    this.betrag = betrag
  }
}
