package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Abstraktes Fachobjekt, welche gemeinsame Merkmale von Betäubungsmitteln und deren Grundstoffen
 * enthält.
 */
@Serializable
abstract class Arznei_Betaeubungsmittel_Grundstoff() :
    Arznei_Betaeubungsmittel_Grundstoff_Leer() {
  /**
   * Dieses Feld enthält ggf. Angaben zur näheren Beschreibung der Art des Betäubungsmittels
   * (Umgangssprache und Sorten) oder des Grundstoffs.
   *
   * Beispiele: schwarzer Afghane, Flauschi
   */
  public var bezeichnung: String? = null

  /**
   * In diesem Feld werden freitextlich ergänzende Informationen zum Betäubungsmittel oder
   * Grundstoff abgebildet.
   */
  public var bemerkung: String? = null

  public var herstellungsinformation: Herstellungsinformation? = null

  /**
   * Bezieht sich auf jeweils eine Einheit (z. B. eine einzelne Tablette oder einzelnes Tütchen,
   * einzelne Ampulle).
   */
  public var volumen: Volumen? = null

  /**
   * Bezieht sich auf jeweils eine Einheit (z. B. eine einzelne Tablette oder einzelnes Tütchen,
   * einzelne Ampulle).
   */
  public var breite: Ausmass? = null

  /**
   * Bezieht sich auf jeweils eine Einheit (z. B. eine einzelne Tablette oder einzelnes Tütchen,
   * einzelne Ampulle).
   */
  public var hoehe: Ausmass? = null

  /**
   * Bezieht sich auf jeweils eine Einheit (z. B. eine einzelne Tablette oder einzelnes Tütchen,
   * einzelne Ampulle).
   */
  public var laenge: Ausmass? = null

  /**
   * Bezieht sich auf jeweils eine Einheit (z. B. eine einzelne Tablette oder einzelnes Tütchen,
   * einzelne Ampulle).
   */
  public var gewicht: Gewicht? = null

  /**
   * Straßenhandelswert für ein Arznei- / Betäubungsmittel oder einen Grundstoff. Die Angabe bezieht
   * sich auf die Gesamtmenge.
   */
  public var strassenhandelswert: Geldbetrag? = null

  /**
   * Bezieht sich auf jeweils eine Einheit (z. B. eine einzelne Tablette oder einzelnes Tütchen,
   * einzelne Ampulle).
   */
  public var durchmesser: Ausmass? = null

  public var dokument: List<Dokument>? = null

  public var redundanzinformation: Redundanzinformation? = null

  public var asservat: Asservat? = null

  /**
   * Angabe von sachgebundenen Hinweisen zu BtM, Arzneimitteln und Grundstoffen.
   */
  public var sachgebundenerHinweis: List<String>? = null

  public constructor(
      bezeichnung: String?,
      bemerkung: String?,
      herstellungsinformation: Herstellungsinformation?,
      volumen: Volumen?,
      breite: Ausmass?,
      hoehe: Ausmass?,
      laenge: Ausmass?,
      gewicht: Gewicht?,
      strassenhandelswert: Geldbetrag?,
      durchmesser: Ausmass?,
      dokument: List<Dokument>?,
      redundanzinformation: Redundanzinformation?,
      asservat: Asservat?,
      sachgebundenerHinweis: List<String>?
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
