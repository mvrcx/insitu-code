package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheGeld() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var seriennummer: CIMPSucheString? = null

  public var ausgabejahr: CIMPSucheIntegerWert? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var nennwert: SucheGeldbetrag? = null

  public var seriennummernserie: SucheSerie? = null

  public var dokument: List<SucheDokument>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var asservat: SucheAsservat? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      seriennummer: CIMPSucheString?,
      ausgabejahr: CIMPSucheIntegerWert?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      nennwert: SucheGeldbetrag?,
      seriennummernserie: SucheSerie?,
      dokument: List<SucheDokument>?,
      redundanzinformation: SucheRedundanzinformation?,
      asservat: SucheAsservat?
  ) : this() {
    this.art = art
    this.seriennummer = seriennummer
    this.ausgabejahr = ausgabejahr
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.nennwert = nennwert
    this.seriennummernserie = seriennummernserie
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.asservat = asservat
  }
}
