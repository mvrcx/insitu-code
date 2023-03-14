package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheTaetowierung() {
  public var motiv: CIMPSucheKatalogWert? = null

  public var lage: SucheKoerperteilangabe? = null

  public var bemerkung: CIMPSucheString? = null

  public constructor(
      motiv: CIMPSucheKatalogWert?,
      lage: SucheKoerperteilangabe?,
      bemerkung: CIMPSucheString?
  ) : this() {
    this.motiv = motiv
    this.lage = lage
    this.bemerkung = bemerkung
  }
}
