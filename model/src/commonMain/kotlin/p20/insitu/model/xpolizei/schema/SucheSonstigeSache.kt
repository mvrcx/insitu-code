package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheSonstigeSache() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var modell: CIMPSucheString? = null

  public var stueckzahl: CIMPSucheIntegerWert? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var besondereMerkmale: CIMPSucheString? = null

  public var bemerkung: CIMPSucheString? = null

  public var material: List<SucheMaterial>? = null

  public var nummernangabe: List<SucheNummernangabe>? = null

  public var herstellungsinformation: SucheHerstellungsinformation? = null

  public var neuwert: SucheGeldbetrag? = null

  public var laenge: SucheAusmass? = null

  public var breite: SucheAusmass? = null

  public var hoehe: SucheAusmass? = null

  public var volumen: SucheVolumen? = null

  public var gewicht: SucheGewicht? = null

  public var farbangabe: List<SucheFarbangabe>? = null

  public var dokument: List<SucheDokument>? = null

  public var zeitwert: SucheGeldbetrag? = null

  public var faelschung: SucheFaelschung? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var asservat: SucheAsservat? = null

  public var durchmesser: SucheAusmass? = null

  public var sachgebundenerHinweis: List<CIMPSucheString>? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      modell: CIMPSucheString?,
      stueckzahl: CIMPSucheIntegerWert?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      besondereMerkmale: CIMPSucheString?,
      bemerkung: CIMPSucheString?,
      material: List<SucheMaterial>?,
      nummernangabe: List<SucheNummernangabe>?,
      herstellungsinformation: SucheHerstellungsinformation?,
      neuwert: SucheGeldbetrag?,
      laenge: SucheAusmass?,
      breite: SucheAusmass?,
      hoehe: SucheAusmass?,
      volumen: SucheVolumen?,
      gewicht: SucheGewicht?,
      farbangabe: List<SucheFarbangabe>?,
      dokument: List<SucheDokument>?,
      zeitwert: SucheGeldbetrag?,
      faelschung: SucheFaelschung?,
      redundanzinformation: SucheRedundanzinformation?,
      asservat: SucheAsservat?,
      durchmesser: SucheAusmass?,
      sachgebundenerHinweis: List<CIMPSucheString>?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.modell = modell
    this.stueckzahl = stueckzahl
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.besondereMerkmale = besondereMerkmale
    this.bemerkung = bemerkung
    this.material = material
    this.nummernangabe = nummernangabe
    this.herstellungsinformation = herstellungsinformation
    this.neuwert = neuwert
    this.laenge = laenge
    this.breite = breite
    this.hoehe = hoehe
    this.volumen = volumen
    this.gewicht = gewicht
    this.farbangabe = farbangabe
    this.dokument = dokument
    this.zeitwert = zeitwert
    this.faelschung = faelschung
    this.redundanzinformation = redundanzinformation
    this.asservat = asservat
    this.durchmesser = durchmesser
    this.sachgebundenerHinweis = sachgebundenerHinweis
  }
}
