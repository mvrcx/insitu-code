package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Ein Kfz-Kennzeichenschild wird als eigenständige Sache abgebildet, da eine Ausschreibung in
 * Sachfahndung möglich ist.
 *
 * Die Beschriftung des Kennzeichens (zum Beispiel WI-OO 123) wird im Attribut Kennzeichen des
 * Fachobjekts KfzKennzeicheninformation abgebildet.
 */
@Serializable
public open class KfzKennzeichenschild() : KfzKennzeichenschild_Leer() {
  /**
   * Beschreibung besonderer Merkmale des KfzKennzeichenschildes (z. B. Beschädigungen,
   * Markierungen)
   *  
   * Alle Merkmale in einem Eintrag.
   *  
   * Beispiele: 'Aufkleber BVB 09', 'Aufkleber Sylt'
   */
  public var besondereMerkmale: String? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Freitextliche Bemerkungen zum KfzKennzeichenschild, die sich nicht strukturiert beschreiben
   * lassen.
   */
  public var bemerkung: String? = null

  /**
   * Farbe der Umrandung des Kennzeichenschildes.
   */
  public var umrandungsfarbe: Farbangabe? = null

  /**
   * Farbe des Hintergrunds des Kennzeichenschildes.
   */
  public var hintergrundfarbe: Farbangabe? = null

  /**
   * Farbe der Schrift des Kennzeichenschildes.
   */
  public var schriftfarbe: Farbangabe? = null

  public var kfzKennzeicheninformation: KfzKennzeicheninformation? = null

  /**
   * Breite des Kennzeichenschildes.
   */
  public var breite: Ausmass? = null

  /**
   * Länge des Kennzeichenschildes.
   */
  public var laenge: Ausmass? = null

  /**
   * Angabe der Stelle, die das Kennzeichenschild ausgestellt hat.
   */
  public var ausgestelltVon: BeteiligteStelle? = null

  public var faelschung: Faelschung? = null

  public var redundanzinformation: Redundanzinformation? = null

  public var asservat: Asservat? = null

  /**
   * Angabe zur Anzahl von Kfz-Kennzeichenschildern.
   */
  public var stueckzahl: Int? = 0

  /**
   * Angabe von sachgebundenen Hinweisen zu KfzKennzeichenschildern.
   */
  public var sachgebundenerHinweis: List<String>? = null

  public constructor(
      besondereMerkmale: String?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      bemerkung: String?,
      umrandungsfarbe: Farbangabe?,
      hintergrundfarbe: Farbangabe?,
      schriftfarbe: Farbangabe?,
      kfzKennzeicheninformation: KfzKennzeicheninformation?,
      breite: Ausmass?,
      laenge: Ausmass?,
      ausgestelltVon: BeteiligteStelle?,
      faelschung: Faelschung?,
      redundanzinformation: Redundanzinformation?,
      asservat: Asservat?,
      stueckzahl: Int?,
      sachgebundenerHinweis: List<String>?
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
