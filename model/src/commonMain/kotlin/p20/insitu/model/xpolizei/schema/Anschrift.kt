package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Die Anschrift bezeichnet das Ziel in Adressform (postalische Anschrift), an das beispielsweise
 * eine Postsendung zugestellt werden soll. Hierbei handelt es sich dann um eine physische Adresse mit
 * einem Briefkasten. Postfächer werden separat abgebildet.
 *  
 * Weiterhin können Anschriften auch i. V. m. Örtlichkeiten abgebildet werden, wenn man darstellen
 * will, dass sich die Örtlichkeit 'Wohnung erste Etage links' an der Adresse mit der Anschrift
 * Brunnenweg 4 in Berlin, Deutschland befindet.
 */
@Serializable
public open class Anschrift() {
  /**
   * Hier wird der Straßenname (auch Planquadrate für Mannheim, wie z. B. O 7,23) abgebildet.
   *
   * Beispiel: 'Schiersteiner Straße'
   */
  public var strasse: String? = null

  /**
   * Hier wird die Hausnummer einer Anschrift abgebildet. Enthalten sind auch evtl.
   * Hausnummerzusätze und von-bis-Nummernangaben.
   *
   * Beispiele:
   * - '99'
   * - '99b'
   * - '1-99'
   */
  public var hausnummer: String? = null

  /**
   * Hier wird der Ortsteil eines Ortes abgebildet, z. B. Dortmund Mitte.
   */
  public var ortsteil: String? = null

  /**
   * Hier wird die i. d. R. 5 stellige Schlüsselnummer einer Straße abgebildet.
   */
  public var strassenschluessel: String? = null

  /**
   * Übermittlung der freitextlichen Adresse als Alternative zur Übermittlung in den einzelnen
   * Attributen.
   *  
   * Dieses Feld enthält Angaben zu Kontaktinformationen zur mittelbaren Erreichbarkeit
   * (Hausanschrift, Postanschrift), z. B. Musterstraße 5, 10555 Berlin.
   *  
   * Alle Informationen werden in einem Feld abgebildet.
   */
  public var alternativeAdressangabe: String? = null

  public var pLZOrt: PLZOrt? = null

  public constructor(
    strasse: String?,
    hausnummer: String?,
    ortsteil: String?,
    strassenschluessel: String?,
    alternativeAdressangabe: String?,
    pLZOrt: PLZOrt?
  ) : this() {
    this.strasse = strasse
    this.hausnummer = hausnummer
    this.ortsteil = ortsteil
    this.strassenschluessel = strassenschluessel
    this.alternativeAdressangabe = alternativeAdressangabe
    this.pLZOrt = pLZOrt
  }
}
