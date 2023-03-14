package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Bildet das 'was' - ohne das 'wo' - einer Örtlichkeit ab, z. B. Wohngebäude. (um WAS für eine
 * Örtlichkeit handelt es sich?)
 *  
 * Detaillierung der Örtlichkeit hängt vom polizeilichen Interesse ab. Wenn die Wohnung interessant
 * ist, wird sie abgebildet (z. B. bei Durchsuchungen), wenn 'nur' das Gebäude als gefährdetes Objekt
 * eine Rolle spielt, dann das Gebäude.
 */
@Serializable
public open class Oertlichkeit() : Oertlichkeit_Leer() {
  /**
   * Hier wird die Art der Örtlichkeit abgebildet.
   */
  public var art: KatalogCode115_NichtAbgeschlossen? = null

  /**
   * Hier wird die nähere Bezeichnung der Örtlichkeit abgebildet.
   *  
   * Beispiele:
   * - Bei Hotelzimmer: die Nummer des Hotelzimmers
   * - Bei Haus: das Einfamilienhaus oder Mehrfamilienhaus
   * - Bei Schließfach: die Nummer des Faches
   * - Bei Hotel: der Name des Hotels
   * - Bei Praxis: der Name der Praxis (Arztpraxis Dr. Pfusch oder Rechtsanwaltsparaxis Dr.
   * Winkeladvokat)
   * - Bei Geschäftsgebäude: der Name der Firma, z. B. BMW Niederlassung Frankfurt
   */
  public var bezeichnung: String? = null

  /**
   * Lage dieser Örtlichkeit relativ gesehen zur nächstgrößeren Örtlichkeit. Anschriften werden über
   * das Fachobjekt Adresse i. V. m. Anschrift abgebildet.
   *  
   * Beispiele:
   * - Lage des Badezimmers innerhalb der Wohnung
   * - Lage der Wohnung im Haus
   * - Lage der Holzhütte auf Grundstück
   * - Raststätte bei Kilometer 164 auf der A9 Richtung München-Nürnberg
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
   * Hier werden besondere Merkmale einer Örtlichkeit abgebildet, z. B. Messiewohnung, gelbe
   * Fassade, Präsidentensuite, Fichtenwald, Wasserschutzgebiet.
   *  
   * Alle Merkmale in einem Eintrag.
   */
  public var besondereMerkmale: String? = null

  /**
   * In diesem Feld werden freitextliche Informationen zur Örtlichkeit abgebildet.
   */
  public var bemerkung: String? = null

  public var grundbucheintrag: List<Grundbucheintrag>? = null

  public var dokument: List<Dokument>? = null

  public var redundanzinformation: Redundanzinformation? = null

  public constructor(
      art: KatalogCode115_NichtAbgeschlossen?,
      bezeichnung: String?,
      lage: String?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      besondereMerkmale: String?,
      bemerkung: String?,
      grundbucheintrag: List<Grundbucheintrag>?,
      dokument: List<Dokument>?,
      redundanzinformation: Redundanzinformation?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.lage = lage
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.besondereMerkmale = besondereMerkmale
    this.bemerkung = bemerkung
    this.grundbucheintrag = grundbucheintrag
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
  }
}
