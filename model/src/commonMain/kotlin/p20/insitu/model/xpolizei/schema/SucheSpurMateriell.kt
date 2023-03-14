package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheSpurMateriell() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var nummer: CIMPSucheString? = null

  public var stueckzahl: CIMPSucheIntegerWert? = null

  public var lage: CIMPSucheString? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var dokument: List<SucheDokument>? = null

  public var gewicht: SucheGewicht? = null

  public var farbangabe: List<SucheFarbangabe>? = null

  public var volumen: SucheVolumen? = null

  public var material: List<SucheMaterial>? = null

  public var laenge: SucheAusmass? = null

  public var breite: SucheAusmass? = null

  public var hoehe: SucheAusmass? = null

  public var durchmesser: SucheAusmass? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var verwertbarkeit: CIMPSucheKatalogWert? = null

  public var asservat: SucheAsservat? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      nummer: CIMPSucheString?,
      stueckzahl: CIMPSucheIntegerWert?,
      lage: CIMPSucheString?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      dokument: List<SucheDokument>?,
      gewicht: SucheGewicht?,
      farbangabe: List<SucheFarbangabe>?,
      volumen: SucheVolumen?,
      material: List<SucheMaterial>?,
      laenge: SucheAusmass?,
      breite: SucheAusmass?,
      hoehe: SucheAusmass?,
      durchmesser: SucheAusmass?,
      redundanzinformation: SucheRedundanzinformation?,
      verwertbarkeit: CIMPSucheKatalogWert?,
      asservat: SucheAsservat?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.nummer = nummer
    this.stueckzahl = stueckzahl
    this.lage = lage
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.dokument = dokument
    this.gewicht = gewicht
    this.farbangabe = farbangabe
    this.volumen = volumen
    this.material = material
    this.laenge = laenge
    this.breite = breite
    this.hoehe = hoehe
    this.durchmesser = durchmesser
    this.redundanzinformation = redundanzinformation
    this.verwertbarkeit = verwertbarkeit
    this.asservat = asservat
  }
}
