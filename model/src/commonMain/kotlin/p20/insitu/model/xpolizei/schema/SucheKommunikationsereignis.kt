package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheKommunikationsereignis() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var schlagworte: CIMPSucheString? = null

  public var kurzinhalt: CIMPSucheString? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var beginn: SucheDatumZeit? = null

  public var ende: SucheDatumZeit? = null

  public var feststellung: SucheDatumZeit? = null

  public var iTUEDatenquelle: SucheITUEDatenquelle? = null

  public var kommunikationsprotokollierung: List<SucheDokument>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var sachbearbeiter: List<SucheBeteiligteStelle>? = null

  public var bearbeitungsstand: CIMPSucheKatalogWert? = null

  public var kernbereichsloeschung: List<SucheKernbereichsloeschung>? = null

  public var festgestellteSprache: List<SucheSprachangabe>? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      schlagworte: CIMPSucheString?,
      kurzinhalt: CIMPSucheString?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      beginn: SucheDatumZeit?,
      ende: SucheDatumZeit?,
      feststellung: SucheDatumZeit?,
      iTUEDatenquelle: SucheITUEDatenquelle?,
      kommunikationsprotokollierung: List<SucheDokument>?,
      redundanzinformation: SucheRedundanzinformation?,
      sachbearbeiter: List<SucheBeteiligteStelle>?,
      bearbeitungsstand: CIMPSucheKatalogWert?,
      kernbereichsloeschung: List<SucheKernbereichsloeschung>?,
      festgestellteSprache: List<SucheSprachangabe>?
  ) : this() {
    this.art = art
    this.schlagworte = schlagworte
    this.kurzinhalt = kurzinhalt
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.beginn = beginn
    this.ende = ende
    this.feststellung = feststellung
    this.iTUEDatenquelle = iTUEDatenquelle
    this.kommunikationsprotokollierung = kommunikationsprotokollierung
    this.redundanzinformation = redundanzinformation
    this.sachbearbeiter = sachbearbeiter
    this.bearbeitungsstand = bearbeitungsstand
    this.kernbereichsloeschung = kernbereichsloeschung
    this.festgestellteSprache = festgestellteSprache
  }
}
