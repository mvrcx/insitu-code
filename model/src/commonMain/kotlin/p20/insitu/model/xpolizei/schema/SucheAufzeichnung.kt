package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheAufzeichnung() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var inhaltsbeschreibung: CIMPSucheString? = null

  public var ausgabe: CIMPSucheString? = null

  public var erscheinungsweise: CIMPSucheKatalogWert? = null

  public var seitenzahl: CIMPSucheIntegerWert? = null

  public var schlagworte: CIMPSucheString? = null

  public var bKARegistriernummer: CIMPSucheString? = null

  public var sprache: List<CIMPSucheKatalogWert>? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var einzeltitelKapitelBeschreibung: List<SucheEinzeltitelKapitelBeschreibung>? = null

  public var ersterscheinungsdatum: SucheDatumZeit? = null

  public var letztesErscheinungsdatum: SucheDatumZeit? = null

  public var herstellungsdatum: SucheDatumZeit? = null

  public var erscheinungsdatum: SucheDatumZeit? = null

  public var aufzeichnungKodiert: List<SucheDigitaleDaten>? = null

  public var dokument: List<SucheDokument>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var asservat: SucheAsservat? = null

  public var erscheinungsland: CIMPSucheKatalogWert? = null

  public var sachgebundenerHinweis: List<CIMPSucheString>? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      inhaltsbeschreibung: CIMPSucheString?,
      ausgabe: CIMPSucheString?,
      erscheinungsweise: CIMPSucheKatalogWert?,
      seitenzahl: CIMPSucheIntegerWert?,
      schlagworte: CIMPSucheString?,
      bKARegistriernummer: CIMPSucheString?,
      sprache: List<CIMPSucheKatalogWert>?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      einzeltitelKapitelBeschreibung: List<SucheEinzeltitelKapitelBeschreibung>?,
      ersterscheinungsdatum: SucheDatumZeit?,
      letztesErscheinungsdatum: SucheDatumZeit?,
      herstellungsdatum: SucheDatumZeit?,
      erscheinungsdatum: SucheDatumZeit?,
      aufzeichnungKodiert: List<SucheDigitaleDaten>?,
      dokument: List<SucheDokument>?,
      redundanzinformation: SucheRedundanzinformation?,
      asservat: SucheAsservat?,
      erscheinungsland: CIMPSucheKatalogWert?,
      sachgebundenerHinweis: List<CIMPSucheString>?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.inhaltsbeschreibung = inhaltsbeschreibung
    this.ausgabe = ausgabe
    this.erscheinungsweise = erscheinungsweise
    this.seitenzahl = seitenzahl
    this.schlagworte = schlagworte
    this.bKARegistriernummer = bKARegistriernummer
    this.sprache = sprache
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.einzeltitelKapitelBeschreibung = einzeltitelKapitelBeschreibung
    this.ersterscheinungsdatum = ersterscheinungsdatum
    this.letztesErscheinungsdatum = letztesErscheinungsdatum
    this.herstellungsdatum = herstellungsdatum
    this.erscheinungsdatum = erscheinungsdatum
    this.aufzeichnungKodiert = aufzeichnungKodiert
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.asservat = asservat
    this.erscheinungsland = erscheinungsland
    this.sachgebundenerHinweis = sachgebundenerHinweis
  }
}
