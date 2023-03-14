package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheOertlichkeit() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var lage: CIMPSucheString? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var besondereMerkmale: CIMPSucheString? = null

  public var bemerkung: CIMPSucheString? = null

  public var grundbucheintrag: List<SucheGrundbucheintrag>? = null

  public var dokument: List<SucheDokument>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      lage: CIMPSucheString?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      besondereMerkmale: CIMPSucheString?,
      bemerkung: CIMPSucheString?,
      grundbucheintrag: List<SucheGrundbucheintrag>?,
      dokument: List<SucheDokument>?,
      redundanzinformation: SucheRedundanzinformation?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.lage = lage
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.besondereMerkmale = besondereMerkmale
    this.bemerkung = bemerkung
    this.grundbucheintrag = grundbucheintrag
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
  }
}
