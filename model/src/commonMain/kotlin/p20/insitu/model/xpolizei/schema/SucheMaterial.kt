package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheMaterial() {
  public var art: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var anteilInProzent: CIMPSucheNumerischerWert? = null

  public var bemerkung: CIMPSucheString? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      anteilInProzent: CIMPSucheNumerischerWert?,
      bemerkung: CIMPSucheString?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.anteilInProzent = anteilInProzent
    this.bemerkung = bemerkung
  }
}
