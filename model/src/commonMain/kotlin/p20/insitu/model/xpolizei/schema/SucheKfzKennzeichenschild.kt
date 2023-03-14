package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheKfzKennzeichenschild() : SucheAllgemeineBasisklasse() {
  public var besondereMerkmale: CIMPSucheString? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var umrandungsfarbe: SucheFarbangabe? = null

  public var hintergrundfarbe: SucheFarbangabe? = null

  public var schriftfarbe: SucheFarbangabe? = null

  public var kfzKennzeicheninformation: SucheKfzKennzeicheninformation? = null

  public var breite: SucheAusmass? = null

  public var laenge: SucheAusmass? = null

  public var ausgestelltVon: SucheBeteiligteStelle? = null

  public var faelschung: SucheFaelschung? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var asservat: SucheAsservat? = null

  public var stueckzahl: CIMPSucheIntegerWert? = null

  public var sachgebundenerHinweis: List<CIMPSucheString>? = null

  public constructor(
      besondereMerkmale: CIMPSucheString?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      umrandungsfarbe: SucheFarbangabe?,
      hintergrundfarbe: SucheFarbangabe?,
      schriftfarbe: SucheFarbangabe?,
      kfzKennzeicheninformation: SucheKfzKennzeicheninformation?,
      breite: SucheAusmass?,
      laenge: SucheAusmass?,
      ausgestelltVon: SucheBeteiligteStelle?,
      faelschung: SucheFaelschung?,
      redundanzinformation: SucheRedundanzinformation?,
      asservat: SucheAsservat?,
      stueckzahl: CIMPSucheIntegerWert?,
      sachgebundenerHinweis: List<CIMPSucheString>?
  ) : this() {
    this.besondereMerkmale = besondereMerkmale
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.umrandungsfarbe = umrandungsfarbe
    this.hintergrundfarbe = hintergrundfarbe
    this.schriftfarbe = schriftfarbe
    this.kfzKennzeicheninformation = kfzKennzeicheninformation
    this.breite = breite
    this.laenge = laenge
    this.ausgestelltVon = ausgestelltVon
    this.faelschung = faelschung
    this.redundanzinformation = redundanzinformation
    this.asservat = asservat
    this.stueckzahl = stueckzahl
    this.sachgebundenerHinweis = sachgebundenerHinweis
  }
}
