package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheWaffe() : SucheAllgemeineBasisklasse() {
  public var bezeichnung: CIMPSucheString? = null

  public var modell: CIMPSucheString? = null

  public var nummernangabe: List<SucheNummernangabe>? = null

  public var stueckzahl: CIMPSucheIntegerWert? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var besondereMerkmale: CIMPSucheString? = null

  public var bemerkung: CIMPSucheString? = null

  public var gewicht: SucheGewicht? = null

  public var breite: SucheAusmass? = null

  public var hoehe: SucheAusmass? = null

  public var laenge: SucheAusmass? = null

  public var farbangabe: List<SucheFarbangabe>? = null

  public var dokument: List<SucheDokument>? = null

  public var faelschung: SucheFaelschung? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var asservat: SucheAsservat? = null

  public var sachgebundenerHinweis: List<CIMPSucheString>? = null

  public constructor(
      bezeichnung: CIMPSucheString?,
      modell: CIMPSucheString?,
      nummernangabe: List<SucheNummernangabe>?,
      stueckzahl: CIMPSucheIntegerWert?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      besondereMerkmale: CIMPSucheString?,
      bemerkung: CIMPSucheString?,
      gewicht: SucheGewicht?,
      breite: SucheAusmass?,
      hoehe: SucheAusmass?,
      laenge: SucheAusmass?,
      farbangabe: List<SucheFarbangabe>?,
      dokument: List<SucheDokument>?,
      faelschung: SucheFaelschung?,
      redundanzinformation: SucheRedundanzinformation?,
      asservat: SucheAsservat?,
      sachgebundenerHinweis: List<CIMPSucheString>?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.modell = modell
    this.nummernangabe = nummernangabe
    this.stueckzahl = stueckzahl
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.besondereMerkmale = besondereMerkmale
    this.bemerkung = bemerkung
    this.gewicht = gewicht
    this.breite = breite
    this.hoehe = hoehe
    this.laenge = laenge
    this.farbangabe = farbangabe
    this.dokument = dokument
    this.faelschung = faelschung
    this.redundanzinformation = redundanzinformation
    this.asservat = asservat
    this.sachgebundenerHinweis = sachgebundenerHinweis
  }
}
