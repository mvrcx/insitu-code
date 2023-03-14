package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheInternetressource() : SucheAllgemeineBasisklasse() {
  public var bezeichnung: CIMPSucheString? = null

  public var uRI: CIMPSucheString? = null

  public var bemerkung: CIMPSucheString? = null

  public var provider: List<CIMPSucheString>? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var dokument: List<SucheDokument>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var art: CIMPSucheKatalogWert? = null

  public var iPv4: CIMPSucheString? = null

  public var iPv6: CIMPSucheString? = null

  public constructor(
      bezeichnung: CIMPSucheString?,
      uRI: CIMPSucheString?,
      bemerkung: CIMPSucheString?,
      provider: List<CIMPSucheString>?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      dokument: List<SucheDokument>?,
      redundanzinformation: SucheRedundanzinformation?,
      art: CIMPSucheKatalogWert?,
      iPv4: CIMPSucheString?,
      iPv6: CIMPSucheString?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.uRI = uRI
    this.bemerkung = bemerkung
    this.provider = provider
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.art = art
    this.iPv4 = iPv4
    this.iPv6 = iPv6
  }
}
