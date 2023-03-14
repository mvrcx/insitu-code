package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheGewicht() {
  public var masseinheit: CIMPSucheKatalogWert? = null

  public var wertangabe: SucheWertangabe? = null

  public var feststellungsart: CIMPSucheKatalogWert? = null

  public constructor(
      masseinheit: CIMPSucheKatalogWert?,
      wertangabe: SucheWertangabe?,
      feststellungsart: CIMPSucheKatalogWert?
  ) : this() {
    this.masseinheit = masseinheit
    this.wertangabe = wertangabe
    this.feststellungsart = feststellungsart
  }
}
