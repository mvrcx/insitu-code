package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Das Spurenobjekt bildet Informationen über Spuren ab, die kriminaltechnisch untersucht werden und
 * als Ermittlungsansätze dienen können, da sie Rückschlüsse auf Taten und oder Täter erlauben.
 *
 * Die Spurensicherung als Aktivität des sichernden Beamten wird als hoheitliche Massnahme
 * abgebildet. Die gesicherten Spuren werden damit in Beziehung gesetzt. Von welchem Spurenträger
 * (Sache) die jeweilige Spur stammt, wird über eine Beziehung (Zusammenhang) zu diesem abgebildet.
 *
 * Der Spurenträger als solcher wird als Sache mit der Spur in Beziehung gesetzt.
 *
 * Das Untersuchungsergebnis ist als Dokument Bestandteil der jeweiligen Spur. Mittels des
 * Fachobjekts Spur können als Bestandteil auch die 'Spurendokumente' (z. B.Fingerabdrücke) abgebildet
 * und übertragen werden.
 *
 * Ermittlungsansätze in Form von Gedanken eines ermittelnden Beamten, sind davon nicht umfasst.
 */
@Serializable
public open class SpurMateriell() : SpurMateriell_Leer() {
  /**
   * Arten von Spuren wie Blutspur, Gegenstandsspur.
   */
  public var art: KatalogCode120? = null

  /**
   * Dieses Feld enthält ggf. freitextliche Angaben zur näheren Beschreibung der Spur, die über die
   * Katalogwerte des Attributs Art hinausgehen (z. B. Aufhebelspur).
   */
  public var bezeichnung: String? = null

  /**
   * Sichergestellte Spuren, die im Rahmen einer KT-Untersuchung festgestellt wurden, werden über
   * eine eigene Spurennummer registriert. Bei einigen INPOL-Teilnehmern geschieht dies über Barcode.
   */
  public var nummer: String? = null

  /**
   * Anzahl der Spuren, die durch das Spurenobjekt repräsentiert werden.
   *
   * Beispiel: 10 Spurenkarten mit Fingerabdrücken
   */
  public var stueckzahl: Int? = 0

  /**
   * Im Feld Lage wird beschrieben, wo genau die Spur sich befand.
   *
   * Beispiel: Obere Hälfte der Fensterinnenseite.
   */
  public var lage: String? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Freitextliche Beschreibung der Spur.
   */
  public var bemerkung: String? = null

  public var dokument: List<Dokument>? = null

  public var gewicht: Gewicht? = null

  public var farbangabe: List<Farbangabe>? = null

  public var volumen: Volumen? = null

  public var material: List<Material>? = null

  /**
   * Länge der materiellen Spur. 
   */
  public var laenge: Ausmass? = null

  /**
   * Breite der materiellen Spur. 
   */
  public var breite: Ausmass? = null

  /**
   * Höhe der materiellen Spur. 
   */
  public var hoehe: Ausmass? = null

  /**
   * Durchmesser der materiellen Spur. 
   */
  public var durchmesser: Ausmass? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Angabe, ob die vorhandene Spur verwertbar, bedingt / teilweise verwertbar oder nicht verwertbar
   * ist.
   */
  public var verwertbarkeit: KatalogCode327? = null

  public var asservat: Asservat? = null

  public constructor(
      art: KatalogCode120?,
      bezeichnung: String?,
      nummer: String?,
      stueckzahl: Int?,
      lage: String?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      bemerkung: String?,
      dokument: List<Dokument>?,
      gewicht: Gewicht?,
      farbangabe: List<Farbangabe>?,
      volumen: Volumen?,
      material: List<Material>?,
      laenge: Ausmass?,
      breite: Ausmass?,
      hoehe: Ausmass?,
      durchmesser: Ausmass?,
      redundanzinformation: Redundanzinformation?,
      verwertbarkeit: KatalogCode327?,
      asservat: Asservat?
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
