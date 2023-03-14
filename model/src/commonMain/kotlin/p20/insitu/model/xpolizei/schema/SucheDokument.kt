package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheDokument() {
  public var bezeichnung: CIMPSucheString? = null

  public var version: CIMPSucheString? = null

  public var betreff: CIMPSucheString? = null

  public var bearbeitungsstand: CIMPSucheKatalogWert? = null

  public var sprache: List<CIMPSucheKatalogWert>? = null

  public var eISRelevanz: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var erstelldatum: CIMPSucheDatum? = null

  public var digitaleDaten: List<SucheDigitaleDaten>? = null

  public var ersteller: SucheBeteiligteStelle? = null

  public var uebersetzungsart: CIMPSucheKatalogWert? = null

  public var art: CIMPSucheKatalogWert? = null

  public var originaldokument: CIMPSucheKatalogWert? = null

  public var verdeckterEinsatzInAusWohnung: CIMPSucheKatalogWert? = null

  public constructor(
      bezeichnung: CIMPSucheString?,
      version: CIMPSucheString?,
      betreff: CIMPSucheString?,
      bearbeitungsstand: CIMPSucheKatalogWert?,
      sprache: List<CIMPSucheKatalogWert>?,
      eISRelevanz: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      erstelldatum: CIMPSucheDatum?,
      digitaleDaten: List<SucheDigitaleDaten>?,
      ersteller: SucheBeteiligteStelle?,
      uebersetzungsart: CIMPSucheKatalogWert?,
      art: CIMPSucheKatalogWert?,
      originaldokument: CIMPSucheKatalogWert?,
      verdeckterEinsatzInAusWohnung: CIMPSucheKatalogWert?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.version = version
    this.betreff = betreff
    this.bearbeitungsstand = bearbeitungsstand
    this.sprache = sprache
    this.eISRelevanz = eISRelevanz
    this.bemerkung = bemerkung
    this.erstelldatum = erstelldatum
    this.digitaleDaten = digitaleDaten
    this.ersteller = ersteller
    this.uebersetzungsart = uebersetzungsart
    this.art = art
    this.originaldokument = originaldokument
    this.verdeckterEinsatzInAusWohnung = verdeckterEinsatzInAusWohnung
  }
}
