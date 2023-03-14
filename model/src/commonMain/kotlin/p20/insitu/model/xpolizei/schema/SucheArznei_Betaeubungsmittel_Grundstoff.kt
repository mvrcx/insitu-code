package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheArznei_Betaeubungsmittel_Grundstoff() : SucheAllgemeineBasisklasse() {
  public var bezeichnung: CIMPSucheString? = null

  public var bemerkung: CIMPSucheString? = null

  public var herstellungsinformation: SucheHerstellungsinformation? = null

  public var volumen: SucheVolumen? = null

  public var breite: SucheAusmass? = null

  public var hoehe: SucheAusmass? = null

  public var laenge: SucheAusmass? = null

  public var gewicht: SucheGewicht? = null

  public var strassenhandelswert: SucheGeldbetrag? = null

  public var durchmesser: SucheAusmass? = null

  public var dokument: List<SucheDokument>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var asservat: SucheAsservat? = null

  public var sachgebundenerHinweis: List<CIMPSucheString>? = null

  public constructor(
      bezeichnung: CIMPSucheString?,
      bemerkung: CIMPSucheString?,
      herstellungsinformation: SucheHerstellungsinformation?,
      volumen: SucheVolumen?,
      breite: SucheAusmass?,
      hoehe: SucheAusmass?,
      laenge: SucheAusmass?,
      gewicht: SucheGewicht?,
      strassenhandelswert: SucheGeldbetrag?,
      durchmesser: SucheAusmass?,
      dokument: List<SucheDokument>?,
      redundanzinformation: SucheRedundanzinformation?,
      asservat: SucheAsservat?,
      sachgebundenerHinweis: List<CIMPSucheString>?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.bemerkung = bemerkung
    this.herstellungsinformation = herstellungsinformation
    this.volumen = volumen
    this.breite = breite
    this.hoehe = hoehe
    this.laenge = laenge
    this.gewicht = gewicht
    this.strassenhandelswert = strassenhandelswert
    this.durchmesser = durchmesser
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.asservat = asservat
    this.sachgebundenerHinweis = sachgebundenerHinweis
  }
}
