package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SuchePersonenbeschreibung() : SucheAllgemeineBasisklasse() {
  public var bart: CIMPSucheKatalogWert? = null

  public var auffaelligesVerhaltenGewohnheiten: List<CIMPSucheKatalogWert>? = null

  public var geografiebezogenesErscheinungsbild: CIMPSucheKatalogWert? = null

  public var gesichtsform: CIMPSucheKatalogWert? = null

  public var gestalt: CIMPSucheKatalogWert? = null

  public var vermutetesGeschlecht: CIMPSucheKatalogWert? = null

  public var sehhilfe: CIMPSucheKatalogWert? = null

  public var stimme: List<CIMPSucheKatalogWert>? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var groesse: SucheAusmass? = null

  public var merkmal: List<SucheMerkmal>? = null

  public var gewicht: SucheGewicht? = null

  public var sprachkenntnis: List<SucheSprachangabe>? = null

  public var taetowierung: List<SucheTaetowierung>? = null

  public var geschaetztesGeburtsjahrVon: CIMPSucheDatum? = null

  public var geschaetztesGeburtsjahrBis: CIMPSucheDatum? = null

  public var gebiss: SucheGebiss? = null

  public var verletzung: List<SucheVerletzung>? = null

  public var dokument: List<SucheDokument>? = null

  public var schuhgroesse: SucheSchuhgroesse? = null

  public var augenfarbe: List<CIMPSucheKatalogWert>? = null

  public var auffallenderGeruch: List<CIMPSucheKatalogWert>? = null

  public var szenetypischeAuffaelligeBekleidung: List<CIMPSucheKatalogWert>? = null

  public var kopfhaar: SucheKopfhaar? = null

  public var hautfarbe: CIMPSucheKatalogWert? = null

  public constructor(
      bart: CIMPSucheKatalogWert?,
      auffaelligesVerhaltenGewohnheiten: List<CIMPSucheKatalogWert>?,
      geografiebezogenesErscheinungsbild: CIMPSucheKatalogWert?,
      gesichtsform: CIMPSucheKatalogWert?,
      gestalt: CIMPSucheKatalogWert?,
      vermutetesGeschlecht: CIMPSucheKatalogWert?,
      sehhilfe: CIMPSucheKatalogWert?,
      stimme: List<CIMPSucheKatalogWert>?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      groesse: SucheAusmass?,
      merkmal: List<SucheMerkmal>?,
      gewicht: SucheGewicht?,
      sprachkenntnis: List<SucheSprachangabe>?,
      taetowierung: List<SucheTaetowierung>?,
      geschaetztesGeburtsjahrVon: CIMPSucheDatum?,
      geschaetztesGeburtsjahrBis: CIMPSucheDatum?,
      gebiss: SucheGebiss?,
      verletzung: List<SucheVerletzung>?,
      dokument: List<SucheDokument>?,
      schuhgroesse: SucheSchuhgroesse?,
      augenfarbe: List<CIMPSucheKatalogWert>?,
      auffallenderGeruch: List<CIMPSucheKatalogWert>?,
      szenetypischeAuffaelligeBekleidung: List<CIMPSucheKatalogWert>?,
      kopfhaar: SucheKopfhaar?,
      hautfarbe: CIMPSucheKatalogWert?
  ) : this() {
    this.bart = bart
    this.auffaelligesVerhaltenGewohnheiten = auffaelligesVerhaltenGewohnheiten
    this.geografiebezogenesErscheinungsbild = geografiebezogenesErscheinungsbild
    this.gesichtsform = gesichtsform
    this.gestalt = gestalt
    this.vermutetesGeschlecht = vermutetesGeschlecht
    this.sehhilfe = sehhilfe
    this.stimme = stimme
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.groesse = groesse
    this.merkmal = merkmal
    this.gewicht = gewicht
    this.sprachkenntnis = sprachkenntnis
    this.taetowierung = taetowierung
    this.geschaetztesGeburtsjahrVon = geschaetztesGeburtsjahrVon
    this.geschaetztesGeburtsjahrBis = geschaetztesGeburtsjahrBis
    this.gebiss = gebiss
    this.verletzung = verletzung
    this.dokument = dokument
    this.schuhgroesse = schuhgroesse
    this.augenfarbe = augenfarbe
    this.auffallenderGeruch = auffallenderGeruch
    this.szenetypischeAuffaelligeBekleidung = szenetypischeAuffaelligeBekleidung
    this.kopfhaar = kopfhaar
    this.hautfarbe = hautfarbe
  }
}
