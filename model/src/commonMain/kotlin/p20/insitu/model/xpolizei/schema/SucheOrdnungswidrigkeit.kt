package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheOrdnungswidrigkeit() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var versuch: CIMPSucheKatalogWert? = null

  public var kurzdarstellung: CIMPSucheString? = null

  public var beweismittel: List<CIMPSucheString>? = null

  public var lagerelevanz: CIMPSucheKatalogWert? = null

  public var verkehrsordnungswidrigkeit: List<SucheVerkehrsordnungswidrigkeit>? = null

  public var dokument: List<SucheDokument>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var beginn: SucheDatumZeit? = null

  public var ende: SucheDatumZeit? = null

  public var feststellungszeit: SucheDatumZeit? = null

  public var hyDaNeKategorie: CIMPSucheKatalogWert? = null

  public var rechtsgut: List<CIMPSucheKatalogWert>? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      versuch: CIMPSucheKatalogWert?,
      kurzdarstellung: CIMPSucheString?,
      beweismittel: List<CIMPSucheString>?,
      lagerelevanz: CIMPSucheKatalogWert?,
      verkehrsordnungswidrigkeit: List<SucheVerkehrsordnungswidrigkeit>?,
      dokument: List<SucheDokument>?,
      redundanzinformation: SucheRedundanzinformation?,
      beginn: SucheDatumZeit?,
      ende: SucheDatumZeit?,
      feststellungszeit: SucheDatumZeit?,
      hyDaNeKategorie: CIMPSucheKatalogWert?,
      rechtsgut: List<CIMPSucheKatalogWert>?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.versuch = versuch
    this.kurzdarstellung = kurzdarstellung
    this.beweismittel = beweismittel
    this.lagerelevanz = lagerelevanz
    this.verkehrsordnungswidrigkeit = verkehrsordnungswidrigkeit
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.beginn = beginn
    this.ende = ende
    this.feststellungszeit = feststellungszeit
    this.hyDaNeKategorie = hyDaNeKategorie
    this.rechtsgut = rechtsgut
  }
}
