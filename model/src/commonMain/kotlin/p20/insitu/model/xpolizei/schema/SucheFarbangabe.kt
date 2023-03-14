package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheFarbangabe() {
  public var farbe: CIMPSucheKatalogWert? = null

  public var farbeffekt: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var bemerkung: CIMPSucheString? = null

  public constructor(
      farbe: CIMPSucheKatalogWert?,
      farbeffekt: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      bemerkung: CIMPSucheString?
  ) : this() {
    this.farbe = farbe
    this.farbeffekt = farbeffekt
    this.bezeichnung = bezeichnung
    this.bemerkung = bemerkung
  }
}
