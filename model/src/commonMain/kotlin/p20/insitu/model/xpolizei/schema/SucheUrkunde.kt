package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheUrkunde() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var sprache: List<CIMPSucheKatalogWert>? = null

  public var blankodokument: CIMPSucheKatalogWert? = null

  public var eintraege: CIMPSucheString? = null

  public var bemerkung: CIMPSucheString? = null

  public var nationalitaet: CIMPSucheKatalogWert? = null

  public var stueckzahl: CIMPSucheIntegerWert? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var gueltigVon: CIMPSucheDatum? = null

  public var gueltigBis: CIMPSucheDatum? = null

  public var dokument: List<SucheDokument>? = null

  public var identifizierungsnummernserie: SucheSerie? = null

  public var ausgestelltVon: SucheBeteiligteStelle? = null

  public var nennwert: SucheGeldbetrag? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var eUFuehrerscheinklasse: List<CIMPSucheKatalogWert>? = null

  public var asservat: SucheAsservat? = null

  public var faelschung: SucheFaelschungUrkunde? = null

  public var nummernangabe: List<SucheNummernangabe>? = null

  public var elektronisch: CIMPSucheKatalogWert? = null

  public var ausstellungszeitpunkt: SucheDatumZeit? = null

  public var sachgebundenerHinweis: List<CIMPSucheString>? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      sprache: List<CIMPSucheKatalogWert>?,
      blankodokument: CIMPSucheKatalogWert?,
      eintraege: CIMPSucheString?,
      bemerkung: CIMPSucheString?,
      nationalitaet: CIMPSucheKatalogWert?,
      stueckzahl: CIMPSucheIntegerWert?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      gueltigVon: CIMPSucheDatum?,
      gueltigBis: CIMPSucheDatum?,
      dokument: List<SucheDokument>?,
      identifizierungsnummernserie: SucheSerie?,
      ausgestelltVon: SucheBeteiligteStelle?,
      nennwert: SucheGeldbetrag?,
      redundanzinformation: SucheRedundanzinformation?,
      eUFuehrerscheinklasse: List<CIMPSucheKatalogWert>?,
      asservat: SucheAsservat?,
      faelschung: SucheFaelschungUrkunde?,
      nummernangabe: List<SucheNummernangabe>?,
      elektronisch: CIMPSucheKatalogWert?,
      ausstellungszeitpunkt: SucheDatumZeit?,
      sachgebundenerHinweis: List<CIMPSucheString>?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.sprache = sprache
    this.blankodokument = blankodokument
    this.eintraege = eintraege
    this.bemerkung = bemerkung
    this.nationalitaet = nationalitaet
    this.stueckzahl = stueckzahl
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.gueltigVon = gueltigVon
    this.gueltigBis = gueltigBis
    this.dokument = dokument
    this.identifizierungsnummernserie = identifizierungsnummernserie
    this.ausgestelltVon = ausgestelltVon
    this.nennwert = nennwert
    this.redundanzinformation = redundanzinformation
    this.eUFuehrerscheinklasse = eUFuehrerscheinklasse
    this.asservat = asservat
    this.faelschung = faelschung
    this.nummernangabe = nummernangabe
    this.elektronisch = elektronisch
    this.ausstellungszeitpunkt = ausstellungszeitpunkt
    this.sachgebundenerHinweis = sachgebundenerHinweis
  }
}
