package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheHinweis() : SucheAllgemeineBasisklasse() {
  public var mitteilungsart: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var kurzdarstellung: CIMPSucheString? = null

  public var hinweisnummer: CIMPSucheString? = null

  public var anonym: CIMPSucheKatalogWert? = null

  public var prioritaet: CIMPSucheKatalogWert? = null

  public var bearbeitungsstand: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var ende: SucheDatumZeit? = null

  public var aufnahme: SucheDatumZeit? = null

  public var beginn: SucheDatumZeit? = null

  public var beteiligung: List<SucheBeteiligteStelleBeteiligungsart>? = null

  public var anlageZumHinweis: List<SucheDigitaleDaten>? = null

  public var dokument: List<SucheDokument>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var art: CIMPSucheKatalogWert? = null

  public constructor(
      mitteilungsart: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      kurzdarstellung: CIMPSucheString?,
      hinweisnummer: CIMPSucheString?,
      anonym: CIMPSucheKatalogWert?,
      prioritaet: CIMPSucheKatalogWert?,
      bearbeitungsstand: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      ende: SucheDatumZeit?,
      aufnahme: SucheDatumZeit?,
      beginn: SucheDatumZeit?,
      beteiligung: List<SucheBeteiligteStelleBeteiligungsart>?,
      anlageZumHinweis: List<SucheDigitaleDaten>?,
      dokument: List<SucheDokument>?,
      redundanzinformation: SucheRedundanzinformation?,
      art: CIMPSucheKatalogWert?
  ) : this() {
    this.mitteilungsart = mitteilungsart
    this.bezeichnung = bezeichnung
    this.kurzdarstellung = kurzdarstellung
    this.hinweisnummer = hinweisnummer
    this.anonym = anonym
    this.prioritaet = prioritaet
    this.bearbeitungsstand = bearbeitungsstand
    this.bemerkung = bemerkung
    this.ende = ende
    this.aufnahme = aufnahme
    this.beginn = beginn
    this.beteiligung = beteiligung
    this.anlageZumHinweis = anlageZumHinweis
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.art = art
  }
}
