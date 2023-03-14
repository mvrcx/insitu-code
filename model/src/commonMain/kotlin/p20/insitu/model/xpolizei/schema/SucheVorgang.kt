package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheVorgang() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var auswertemerker: List<CIMPSucheKatalogWert>? = null

  public var nummer: CIMPSucheString? = null

  public var schlagworte: CIMPSucheString? = null

  public var prioritaet: CIMPSucheKatalogWert? = null

  public var prioritaetGrund: List<CIMPSucheKatalogWert>? = null

  public var bearbeitungsstand: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var loeschzeitpunkt: CIMPSucheDatum? = null

  public var beginnzeitpunkt: SucheDatumZeit? = null

  public var wiedervorlagezeitpunkt: CIMPSucheDatum? = null

  public var beteiligung: List<SucheBeteiligteStelleBeteiligungsart>? = null

  public var dokument: List<SucheDokument>? = null

  public var endzeitpunkt: SucheDatumZeit? = null

  public var verwendungsbeschraenkung: SucheVerwendungsbeschraenkung? = null

  public var oK: SucheOK? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var kategorie: CIMPSucheKatalogWert? = null

  public var relevanzkriterium: List<CIMPSucheKatalogWert>? = null

  public var zusaetzlicheInformationen: List<SucheZusaetzlicheInformationen>? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      auswertemerker: List<CIMPSucheKatalogWert>?,
      nummer: CIMPSucheString?,
      schlagworte: CIMPSucheString?,
      prioritaet: CIMPSucheKatalogWert?,
      prioritaetGrund: List<CIMPSucheKatalogWert>?,
      bearbeitungsstand: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      loeschzeitpunkt: CIMPSucheDatum?,
      beginnzeitpunkt: SucheDatumZeit?,
      wiedervorlagezeitpunkt: CIMPSucheDatum?,
      beteiligung: List<SucheBeteiligteStelleBeteiligungsart>?,
      dokument: List<SucheDokument>?,
      endzeitpunkt: SucheDatumZeit?,
      verwendungsbeschraenkung: SucheVerwendungsbeschraenkung?,
      oK: SucheOK?,
      redundanzinformation: SucheRedundanzinformation?,
      kategorie: CIMPSucheKatalogWert?,
      relevanzkriterium: List<CIMPSucheKatalogWert>?,
      zusaetzlicheInformationen: List<SucheZusaetzlicheInformationen>?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.auswertemerker = auswertemerker
    this.nummer = nummer
    this.schlagworte = schlagworte
    this.prioritaet = prioritaet
    this.prioritaetGrund = prioritaetGrund
    this.bearbeitungsstand = bearbeitungsstand
    this.bemerkung = bemerkung
    this.loeschzeitpunkt = loeschzeitpunkt
    this.beginnzeitpunkt = beginnzeitpunkt
    this.wiedervorlagezeitpunkt = wiedervorlagezeitpunkt
    this.beteiligung = beteiligung
    this.dokument = dokument
    this.endzeitpunkt = endzeitpunkt
    this.verwendungsbeschraenkung = verwendungsbeschraenkung
    this.oK = oK
    this.redundanzinformation = redundanzinformation
    this.kategorie = kategorie
    this.relevanzkriterium = relevanzkriterium
    this.zusaetzlicheInformationen = zusaetzlicheInformationen
  }
}
