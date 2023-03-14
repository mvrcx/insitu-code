package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheLuftfahrzeug() : SucheFahrzeug() {
  public var art: CIMPSucheKatalogWert? = null

  public var kennzeichen: CIMPSucheString? = null

  public var nationalitaet: CIMPSucheKatalogWert? = null

  public var gewicht: SucheGewicht? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      kennzeichen: CIMPSucheString?,
      nationalitaet: CIMPSucheKatalogWert?,
      gewicht: SucheGewicht?
  ) : this() {
    this.art = art
    this.kennzeichen = kennzeichen
    this.nationalitaet = nationalitaet
    this.gewicht = gewicht
  }
}
