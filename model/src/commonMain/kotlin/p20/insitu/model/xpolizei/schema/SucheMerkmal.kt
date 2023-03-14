package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheMerkmal() {
  public var bezeichnung: CIMPSucheKatalogWert? = null

  public var lage: SucheKoerperteilangabe? = null

  public var bemerkung: CIMPSucheString? = null

  public constructor(
      bezeichnung: CIMPSucheKatalogWert?,
      lage: SucheKoerperteilangabe?,
      bemerkung: CIMPSucheString?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.lage = lage
    this.bemerkung = bemerkung
  }
}
