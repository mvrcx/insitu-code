package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Ein Kommunikationsanschluss zeichnet sich dadurch aus, dass eine juristische oder natürliche
 * Person als Anschlussinhaber auftritt (Beziehung_Personalie_Kommunikationsanschluss und
 * Beziehung_Organisation_Kommunikationsanschluss) und dass er als Endpunkt für ausgehende oder
 * eingehende (also direkte) schriftliche, bildliche und / oder audiovisuelle
 * Kommunikationsverbindungen geeignet ist oder diese ermöglicht.
 * Der Begriff 'Anschluss' legt nahe, dass das Fachobjekt Kommunikationsanschluss nur physisch
 * vorhandene Anschlüsse wie den klassischen Teilnehmeranschluss zum analogen Telefonnetz abbildet.
 * Dies ist jedoch nicht der Fall. Die Kernkomponente bildet darüberhinaus auch 'virtuelle Anschlüsse'
 * (z. B. E-Mail-Postfächer) sowie nicht ortsgebundene Telekommunikationsanschlüsse (z. B. Mobilfunk)
 * ab.
 *
 * Beispiele:
 * - Die meisten E-Mail-Postfächer erfüllen die Kriterien ebenfalls, da sie (bei Einrichtung) einer
 * Person zugeordnet werden und ein- sowie ausgehende schriftliche Kommunikation ermöglichen.
 * - Ein DSL-Anschluss stellt hier eine Besonderheit dar. Er erlaubt ohne passendes Endgerät noch
 * keine Kommunikation. Im Gegensatz zur SIM-Karte, an die eine Rufnummer gebunden ist, ist dies beim
 * DSL-Anschluss nicht der Fall. Dennoch wird der DSL- Anschluss hier subsumiert, da er Ziel einer
 * Telekommunikationsüberwachung sein kann.
 */
@Serializable
public open class Kommunikationsanschluss() : Kommunikationsanschluss_Leer() {
  /**
   * Art des Kommunikationsanschlusses.
   *
   * Beispiele:
   * - E-Mail-Postfach
   * - Telefon
   * - Mobilfunk
   *
   * Chatrooms werden über die Internetressource abgebildet, da dort keine
   * 'Punkt-zu-Punkt-Verbindung' stattfindet, sondern i. d. R. ein offener virtueller Raum, auf den ein
   * größerer Kreis Zugriff hat.
   */
  public var art: KatalogCode110? = null

  /**
   * Nähere Bezeichnung des jeweiligen Anschlusses.
   *
   * Beispiel:
   * - Bei Art 'E-Mail-Postfach': E-Mail-Postfach mit Hauptadresse weihnachtsmann@web.de
   * - Bei Art 'Telefon': Telefonanschluss in Wohnung, Birkenweg 17, 1. OG links, Rufnummer 0611
   * 12345
   */
  public var bezeichnung: String? = null

  /**
   * Zeichenfolge der jeweiligen Kennung passend zur Art.
   * Diese Kennung muss ausgefüllt sein, wenn zusätzlich eine strukturierte Rufnummer erfasst werden
   * soll. Darüber hinaus dürfen die erfassten Daten nicht voneinander abweichen.
   *
   * Beispiele:
   * - bei Art 'Telefon': Telefonnummer 0611 1234567
   * - bei Art 'E-Mail-Postfach': E-Mail-Adresse weihnachtsmann@web.de
   * - bei Art 'internetbasierter TK-Dienst': Skype-Benutzername unicorn4567
   * - bei Art 'DSL': Anschlusskennung 260690191191652487
   */
  public var kennung: String? = null

  /**
   * Name des Netzbetreibers.
   *  
   * Beispiele:
   * - Deutsche Telekom AG (T-Home)
   * - Vodafone (Arcor)
   * - Deutsche Telekom (T-Mobile)
   * - E-Plus
   * - O2
   */
  public var netzbetreiber: String? = null

  /**
   * Dieses Feld enthält Angaben zur technischen Kennung des Anschlusses.
   *
   * Beispiel: BSA (Bitstreamaccess)-Nummer der Telekom
   */
  public var technischeKennung: List<String>? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Dieses Feld enthält Freitextinformationen zum Anschluss.
   *  
   * Beispiel: SIM-Karte wird hauptsächlich für UMTS-Datenübertragung genutzt
   */
  public var bemerkung: String? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Anbieter zur Erbringung von Telekommunikationsdienstleistungen ohne eigenes Kommunikationsnetz.
   *
   * Beispiele: ALDI Talk, Tchibo Mobil, Simyo
   */
  public var serviceprovider: String? = null

  /**
   * Angabe, ob es sich bei dem Kommunikationsanschluss um einen Serviceanschluss handelt.
   *
   * Beispiele: Servicerufnummer oder Service-IP-Adresse
   */
  public var serviceanschluss: KatalogCode214? = null

  /**
   * Strukturierte Angaben zur Rufnummer.
   */
  public var rufnummer: Rufnummer? = null

  public constructor(
      art: KatalogCode110?,
      bezeichnung: String?,
      kennung: String?,
      netzbetreiber: String?,
      technischeKennung: List<String>?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      bemerkung: String?,
      redundanzinformation: Redundanzinformation?,
      serviceprovider: String?,
      serviceanschluss: KatalogCode214?,
      rufnummer: Rufnummer?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.kennung = kennung
    this.netzbetreiber = netzbetreiber
    this.technischeKennung = technischeKennung
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.redundanzinformation = redundanzinformation
    this.serviceprovider = serviceprovider
    this.serviceanschluss = serviceanschluss
    this.rufnummer = rufnummer
  }
}
