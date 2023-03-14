package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheVerwaltungspolitischeKodierung() {
  public var gemeindeschluessel: CIMPSucheKatalogWert? = null

  public var kreis: CIMPSucheString? = null

  public var bezirk: CIMPSucheString? = null

  public var regionalschluessel: CIMPSucheString? = null

  public var bundesland: CIMPSucheKatalogWert? = null

  public constructor(
      gemeindeschluessel: CIMPSucheKatalogWert?,
      kreis: CIMPSucheString?,
      bezirk: CIMPSucheString?,
      regionalschluessel: CIMPSucheString?,
      bundesland: CIMPSucheKatalogWert?
  ) : this() {
    this.gemeindeschluessel = gemeindeschluessel
    this.kreis = kreis
    this.bezirk = bezirk
    this.regionalschluessel = regionalschluessel
    this.bundesland = bundesland
  }
}
