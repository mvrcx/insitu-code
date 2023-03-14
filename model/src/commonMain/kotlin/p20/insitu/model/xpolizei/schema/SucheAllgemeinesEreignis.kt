package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheAllgemeinesEreignis() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var kurzdarstellung: CIMPSucheString? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var dokument: List<SucheDokument>? = null

  public var beginn: SucheDatumZeit? = null

  public var ende: SucheDatumZeit? = null

  public var feststellungszeit: SucheDatumZeit? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var versuch: CIMPSucheKatalogWert? = null

  public var lagerelevanz: CIMPSucheKatalogWert? = null

  public var rechtsgut: List<CIMPSucheKatalogWert>? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      kurzdarstellung: CIMPSucheString?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      dokument: List<SucheDokument>?,
      beginn: SucheDatumZeit?,
      ende: SucheDatumZeit?,
      feststellungszeit: SucheDatumZeit?,
      redundanzinformation: SucheRedundanzinformation?,
      versuch: CIMPSucheKatalogWert?,
      lagerelevanz: CIMPSucheKatalogWert?,
      rechtsgut: List<CIMPSucheKatalogWert>?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.kurzdarstellung = kurzdarstellung
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.dokument = dokument
    this.beginn = beginn
    this.ende = ende
    this.feststellungszeit = feststellungszeit
    this.redundanzinformation = redundanzinformation
    this.versuch = versuch
    this.lagerelevanz = lagerelevanz
    this.rechtsgut = rechtsgut
  }
}
