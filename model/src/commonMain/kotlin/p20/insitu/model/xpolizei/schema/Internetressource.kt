package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Hier wird der 'Ort' einer Internetressource beschrieben, also die Erreichbarkeit von Ressourcen
 * im Internet wie Webseiten, Foren, Chatrooms, Videodateien, Musikdateien, Softwaredateien etc.
 *
 * Die Abbildung von E-Mail-Adressen und internetbasierten Telekommunikationsdiensten (z. B. Skype)
 * erfolgt dagegen als Kommunikationsanschluss.
 */
@Serializable
public open class Internetressource() : Internetressource_Leer() {
  /**
   * Die Bezeichnung gibt an, was mit der URI erreicht wird. Deren Inhalt kann als Aufzeichnung
   * abgebildet werden.
   *  
   * Beispiele: 'Loginseite des Chatroom xyz', 'MP3-Datei des XY-Liedes'
   */
  public var bezeichnung: String? = null

  /**
   * Ein Uniform Resource Identifier (URI) (engl. Bezeichner für Ressourcen) ist ein Identifikator
   * und besteht aus einer Zeichenfolge, die zur Identifizierung einer abstrakten oder physischen
   * Ressource dient. URIs werden zur Bezeichnung von Ressourcen (wie Webseiten, sonstigen Dateien,
   * Aufruf von Webservices aber auch z. B. E-Mail-Empfängern) eingesetzt.
   *
   * Der Standard ist durch die IETF in der RFC 3986 definiert.
   *
   * Häufig werden URLs synonym zu URIs verwendet, dabei stellen URLs aber nur eine Teilmenge der
   * URIs da.
   *
   * Beispiele:
   * http://de.wikipedia.org/wiki/Uniform_Resource_Identifier
   * http://192.168.0.214:8080
   * http://[2001:0db8:85a3:08d3:1319:8a2e:0370:7344]:8080/
   * mailto:John.Doe@example.com
   * telnet://192.0.2.16:20/
   * news:comp.infosystems.www.servers.unix
   * ftp://ftp.is.co.za/rfc/rfc1808.txt
   */
  public var uRI: String? = null

  /**
   * Freitextliche Ergänzungen zur Internetressource.
   */
  public var bemerkung: String? = null

  /**
   * Abbildung eines Host- oder Access-Providers einer Internet-Ressource, sofern dieser nicht
   * Gegenstand von polizeilichen Ermittlungen ist.
   *  
   * Das Attribut enthält die Bezeichnung eines Host- und / oder Access-Providers (Beispiele '1und1'
   * als Hosting-Provider, 'HanseNet' als Access-Provider).
   *  
   * Content-Provider (z. B. Personen oder Organisationen als Domain-Inhaber) sowie Host- und
   * Accessprovider, die Gegenstand von polizeilichen Ermittlungen sind, werden als Personalie oder
   * Organisation abgebildet und mit der Internetressource in Beziehung gesetzt.
   */
  public var provider: List<String>? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  public var dokument: List<Dokument>? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Angabe zur Art der Internetressource.
   */
  public var art: KatalogCode315? = null

  /**
   * IP-Adressen nach dem Internet Protocol Version 4 bestehen aus vier numerischen Werten zwischen
   * 0 und 255, die durch Punkte getrennt werden.
   *
   * Beispiel: 52.212.83.163
   */
  public var iPv4: String? = null

  /**
   * IP-Adressen nach dem Internet Protocol Version 6 bestehen aus acht Gruppen mit je vier Werten
   * in Hexadezimalschreibweise, die durch Doppelpunkte getrennt werden.
   *
   * Beispiel: 2001:0db8:85a3:0000:0000:8a2e:0370:7334
   */
  public var iPv6: String? = null

  public constructor(
      bezeichnung: String?,
      uRI: String?,
      bemerkung: String?,
      provider: List<String>?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      dokument: List<Dokument>?,
      redundanzinformation: Redundanzinformation?,
      art: KatalogCode315?,
      iPv4: String?,
      iPv6: String?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.uRI = uRI
    this.bemerkung = bemerkung
    this.provider = provider
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.art = art
    this.iPv4 = iPv4
    this.iPv6 = iPv6
  }
}
