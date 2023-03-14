package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheVerkehrsunfall() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var ortslage: CIMPSucheKatalogWert? = null

  public var kategorie: CIMPSucheKatalogWert? = null

  public var typ: CIMPSucheKatalogWert? = null

  public var allgemeineUrsachen: CIMPSucheKatalogWert? = null

  public var lichtzeichenanlage: CIMPSucheKatalogWert? = null

  public var geschwindigkeitsbegrenzung: CIMPSucheKatalogWert? = null

  public var lichtverhaeltnisse: CIMPSucheKatalogWert? = null

  public var strassenzustand: List<CIMPSucheKatalogWert>? = null

  public var aufprallAufHindernis: CIMPSucheKatalogWert? = null

  public var beginn: SucheDatumZeit? = null

  public var ende: SucheDatumZeit? = null

  public var feststellungszeit: SucheDatumZeit? = null

  public var gesamtschaden: SucheGeldbetrag? = null

  public var kurzdarstellung: CIMPSucheString? = null

  public var lagerelevanz: CIMPSucheKatalogWert? = null

  public var dokument: List<SucheDokument>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      ortslage: CIMPSucheKatalogWert?,
      kategorie: CIMPSucheKatalogWert?,
      typ: CIMPSucheKatalogWert?,
      allgemeineUrsachen: CIMPSucheKatalogWert?,
      lichtzeichenanlage: CIMPSucheKatalogWert?,
      geschwindigkeitsbegrenzung: CIMPSucheKatalogWert?,
      lichtverhaeltnisse: CIMPSucheKatalogWert?,
      strassenzustand: List<CIMPSucheKatalogWert>?,
      aufprallAufHindernis: CIMPSucheKatalogWert?,
      beginn: SucheDatumZeit?,
      ende: SucheDatumZeit?,
      feststellungszeit: SucheDatumZeit?,
      gesamtschaden: SucheGeldbetrag?,
      kurzdarstellung: CIMPSucheString?,
      lagerelevanz: CIMPSucheKatalogWert?,
      dokument: List<SucheDokument>?,
      redundanzinformation: SucheRedundanzinformation?
  ) : this() {
    this.art = art
    this.ortslage = ortslage
    this.kategorie = kategorie
    this.typ = typ
    this.allgemeineUrsachen = allgemeineUrsachen
    this.lichtzeichenanlage = lichtzeichenanlage
    this.geschwindigkeitsbegrenzung = geschwindigkeitsbegrenzung
    this.lichtverhaeltnisse = lichtverhaeltnisse
    this.strassenzustand = strassenzustand
    this.aufprallAufHindernis = aufprallAufHindernis
    this.beginn = beginn
    this.ende = ende
    this.feststellungszeit = feststellungszeit
    this.gesamtschaden = gesamtschaden
    this.kurzdarstellung = kurzdarstellung
    this.lagerelevanz = lagerelevanz
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
  }
}
