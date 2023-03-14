package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheFahrzeug() : SucheAllgemeineBasisklasse() {
  public var bezeichnung: CIMPSucheString? = null

  public var sachgebundenerHinweis: List<CIMPSucheKatalogWert>? = null

  public var besondereMerkmale: CIMPSucheString? = null

  public var bemerkung: CIMPSucheString? = null

  public var verwendungsart: CIMPSucheKatalogWert? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var zeitwert: SucheGeldbetrag? = null

  public var neuwert: SucheGeldbetrag? = null

  public var nummernangabeBeiFahrzeugen: List<SucheNummernangabeBeiFahrzeugen>? = null

  public var breite: SucheAusmass? = null

  public var hoehe: SucheAusmass? = null

  public var laenge: SucheAusmass? = null

  public var dokument: List<SucheDokument>? = null

  public var fahrzeugfarbe: List<SucheFahrzeugfarbe>? = null

  public var faelschung: SucheFaelschung? = null

  public var herstellungsinformation: SucheHerstellungsinformation? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var asservat: SucheAsservat? = null

  public constructor(
      bezeichnung: CIMPSucheString?,
      sachgebundenerHinweis: List<CIMPSucheKatalogWert>?,
      besondereMerkmale: CIMPSucheString?,
      bemerkung: CIMPSucheString?,
      verwendungsart: CIMPSucheKatalogWert?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      zeitwert: SucheGeldbetrag?,
      neuwert: SucheGeldbetrag?,
      nummernangabeBeiFahrzeugen: List<SucheNummernangabeBeiFahrzeugen>?,
      breite: SucheAusmass?,
      hoehe: SucheAusmass?,
      laenge: SucheAusmass?,
      dokument: List<SucheDokument>?,
      fahrzeugfarbe: List<SucheFahrzeugfarbe>?,
      faelschung: SucheFaelschung?,
      herstellungsinformation: SucheHerstellungsinformation?,
      redundanzinformation: SucheRedundanzinformation?,
      asservat: SucheAsservat?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.sachgebundenerHinweis = sachgebundenerHinweis
    this.besondereMerkmale = besondereMerkmale
    this.bemerkung = bemerkung
    this.verwendungsart = verwendungsart
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.zeitwert = zeitwert
    this.neuwert = neuwert
    this.nummernangabeBeiFahrzeugen = nummernangabeBeiFahrzeugen
    this.breite = breite
    this.hoehe = hoehe
    this.laenge = laenge
    this.dokument = dokument
    this.fahrzeugfarbe = fahrzeugfarbe
    this.faelschung = faelschung
    this.herstellungsinformation = herstellungsinformation
    this.redundanzinformation = redundanzinformation
    this.asservat = asservat
  }
}
