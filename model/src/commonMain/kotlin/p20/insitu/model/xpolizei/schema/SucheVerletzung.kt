package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheVerletzung() {
  public var bezeichnung: CIMPSucheString? = null

  public var lage: SucheKoerperteilangabe? = null

  public var grad: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public constructor(
      bezeichnung: CIMPSucheString?,
      lage: SucheKoerperteilangabe?,
      grad: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.lage = lage
    this.grad = grad
    this.bemerkung = bemerkung
  }
}
