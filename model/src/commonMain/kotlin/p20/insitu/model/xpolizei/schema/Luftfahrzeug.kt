package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Definition nach §1 LuftVG, Absatz (2):
 * Luftfahrzeuge sind:
 * Flugzeuge
 * Drehflügler
 * Luftschiffe
 * Segelflugzeuge
 * Motorsegler
 * Frei- und Fesselballone
 * Rettungsfallschirme
 * Flugmodelle
 * Luftsportgeräte
 * sonstige für die Benutzung des Luftraums bestimmte Geräte, sofern sie in Höhen von mehr als
 * dreißig Metern über Grund oder Wasser betrieben werden können.
 * Raumfahrzeuge, Raketen und ähnliche Flugkörper gelten als Luftfahrzeuge, solange sie sich im
 * Luftraum befinden. Ebenfalls als Luftfahrzeuge gelten unbemannte Fluggeräte einschließlich ihrer
 * Kontrollstation, die nicht zu Zwecken des Sports oder der Freizeitgestaltung betrieben werden
 * (unbemannte Luftfahrtsysteme).
 */
@Serializable
public open class Luftfahrzeug() : Fahrzeug() {
  /**
   * Angabe der Art des Luftfahrzeugs nach § 1 LuftVG, Absatz (2):
   * Flugzeuge
   * Drehflügler
   * Luftschiffe
   * Segelflugzeuge
   * Motorsegler
   * Frei- und Fesselballone
   * Rettungsfallschirme
   * Flugmodelle
   * Luftsportgeräte
   * sonstige für die Benutzung des Luftraums bestimmte Geräte, sofern sie in Höhen von mehr als
   * dreißig Metern über Grund oder Wasser betrieben werden können.
   * Raumfahrzeuge, Raketen und ähnliche Flugkörper gelten als Luftfahrzeuge, solange sie sich im
   * Luftraum befinden. Ebenfalls als Luftfahrzeuge gelten unbemannte Fluggeräte einschließlich ihrer
   * Kontrollstation, die nicht zu Zwecken des Sports oder der Freizeitgestaltung betrieben werden
   * (unbemannte Luftfahrtsysteme).
   */
  public var art: KatalogCode114? = null

  /**
   * Die Nationalitäts- und Registrierungskennzeichen von Luftfahrzeugen sind im Annex (Anhang) 7
   * des internationalen Luftfahrtübereinkommens geregelt.
   *  
   * Nationalitätskennzeichen (Beispiele, Quelle:
   * http://www.aufenthaltstitel.de/staaten/schluessel.html):
   * Deutschland: D
   * Oesterreich: OE
   * Schweiz: HB
   * Großbritannien: G
   * USA: N
   * Frankreich: F
   * Dänemark: OY
   *  
   * Die eigentliche Registrierung ist national unterschiedlich geregelt. In Deutschland gilt
   * folgender Aufbau: Nach dem Nationalitätskennzeichen folgt ein Bindestrich und die
   * Kennzeichenklasse (ein Buchstabe; A - Flugzeuge ueber 20t, B - Flugzeuge ueber 14 bis 20 t, H -
   * Drehflügler (Hubschrauber), vollständige Liste:
   * http://www.lba.de/cln_010/nn_57212/DE/Oeffentlichkeitsarbeit/Statistiken/Statistik__Luftfahrzeuge.html__nn=true
   * ) sowie eine dreistellige Buchstabenkombination oder eine vierstellige Nummer (Segelflugzeuge)
   *  
   * Beispiele:
   * D-AVON (in Deutschland registriertes Flugzeug mit Abfluggewicht über 20 t)
   * D-HUBS (in Deutschland registrierter Hubschrauber)
   * D-1234 (in Deutschland registriertes Segelflugzeug)
   */
  public var kennzeichen: String? = null

  /**
   * Land, in welchem das Luftfahrzeug zugelassen/registriert ist.
   * Das Land ist auch in der Kennzeichnung gemaess internationalem Luftverkehrsübereinkommen Annex
   * 7 (ICAO Annex 7) kodiert (siehe Defintion BK Kennzeichen)
   */
  public var nationalitaet: KatalogCode208_NichtAbgeschlossen? = null

  /**
   * Masse des Luftfahrzeugs inkl. ggf. vorhandener Ladung, Anbauten, Treibstoff etc. zum Zeitpunkt
   * des Betriebs.
   */
  public var gewicht: Gewicht? = null

  public constructor(
      art: KatalogCode114?,
      kennzeichen: String?,
      nationalitaet: KatalogCode208_NichtAbgeschlossen?,
      gewicht: Gewicht?
  ) : this() {
    this.art = art
    this.kennzeichen = kennzeichen
    this.nationalitaet = nationalitaet
    this.gewicht = gewicht
  }
}
