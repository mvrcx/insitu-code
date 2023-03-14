package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Nicht dauerhaft spurgeführte Landfahrzeuge mit eigenem Antrieb oder Anhänger von solchen
 * Fahrzeugen.
 */
@Serializable
public open class Kraftfahrzeug() : Fahrzeug() {
  /**
   * Angabe der Art des Fahrzeugs.
   *  
   * Beispiele: Personenkraftwagen, Lastkraftwagen, Leichtkraftrad, Kleinkraftrad, Motorrad
   */
  public var art: KatalogCode113? = null

  /**
   * Verkaufs- / Handelsmarke, z. B. BMW, Audi, Volkswagen Nutzfahrzeuge.
   *  
   * Hinweis: Teilweise besitzen die Marken eines Konzerns (z. B. Audi und Volkswagen Nutzfahrzeuge
   * als Tochtergesellschaften des Volkswagenkonzerns) eigene WMI-Identifizierungen, die als
   * Herstellerbezeichnung in die FIN einfließen. Siehe auch Attribut Fahrzeugidentifizierungsnummer.
   */
  public var marke: KatalogCode240_NichtAbgeschlossen? = null

  /**
   * International genormte 17-stellige Zeichenfolge zur eindeutigen Identifizierung von
   * Kraftfahrzeugen. Die Fahrzeugidentifizierungsnummer (FIN) beinhaltet eine Herstellerkennung (WMI -
   * World Manufacturer Identifier, z. B. WVW - Volkswagen, VF3 - Peugeot, WBA - BMW) sowie eine
   * fortlaufende Nummer.
   * Die FIN wurde 1981 eingeführt. Zuvor fand in Deutschland die sogenannte Fahrgestellnummer
   * Anwendung.
   *  
   * Da eine FIN auch um weitere eingestanzte Nummern ergänzt (verfälscht) sein kann, ist der
   * semantictype nicht auf 17 Stellen begrenzt.
   *  
   * Beispiele (siehe http://de.wikipedia.org/wiki/Fahrzeug-Identifizierungsnummer):
   * Mercedes-Benz, A-Klasse: WDD1690071J236589
   * Volkswagen, Golf IV: WVWZZZ1JZ3W386752
   */
  public var fahrzeugidentifizierungsnummer: String? = null

  /**
   * Angabe der Aufbauart.
   *
   * Beispiel: Cabriolet, Kasten, Limousine, offen, Planenverdeck
   */
  public var aufbau: KatalogCode239_NichtAbgeschlossen? = null

  /**
   * Die Typschlüsselnummer (TSN) ist ein achtstelliger alphanumerischer Code, der den Fahrzeugtyp
   * eines Herstellers näher bezeichnet. In der Zulassungsbescheinigung Teil I (Fahrzeugschein) und
   * Teil II (Fahrzeugbrief) ist er im Feld 2.2 zusammen mit einer Prüfziffer als neunstelliger Code
   * angegeben. Früher war die Typschlüsselnummer ein sechsstelliger numerischer Code.
   *  
   * Die Typschlüsselnummer berücksichtigt Modell, Karosserieform, Motorisierung und Antriebsart.
   *  
   * Zusammen mit der Herstellerschlüsselnummer (HSN) lässt sich dadurch ein Fahrzeugtyp eindeutig
   * identifizieren.
   */
  public var typschluessel: String? = null

  /**
   * Die Herstellerschlüsselnummer (HSN) ist ein vierstelliger numerischer Code, der den Hersteller
   * eines Kraftfahrzeugs oder Anhängers bezeichnet.
   *  
   * Die HSN ist in der Zulassungsbescheinigung Teil I unter Punkt 2.1 vermerkt. Im alten
   * Fahrzeugschein befand sie sich unter dem Punkt 2.
   *  
   * Die Kombination aus der HSN und des dreistelligen Teiles der alphanumerischen
   * Typschlüsselnummer (TSN) identifiziert eindeutig den Typ des Fahrzeugs. Beispielsweise steht die
   * Schlüsselnummer 0005/ALQ für die ab 2007 gebaute Ausführung des BMW 318d Touring mit 105 kW (143
   * PS) und 1.995 cm³ Hubraum. Dabei ist 0005 die HSN (für BMW) und ALQ die TSN.
   *  
   * Die Zuordnung zwischen Herstellern und HSN ist nicht immer eindeutig: Einigen Herstellern sind
   * mehrere HSN zugeordnet, umgekehrt bezeichnen manche HSN unterschiedliche Hersteller.
   */
  public var herstellerschluessel: String? = null

  /**
   * Datum der Silllegung des Kraftfahrzeugs.
   */
  public var stilllegung: String? = null

  /**
   * Datum der erstmaligen Zulassung des Kraftfahrzeuges zum Straßenverkehr.
   */
  public var erstzulassung: String? = null

  public var zulassungsinformation: List<ZulassungsinformationKfz>? = null

  /**
   * Zulässige Gesamtmasse (zGM) eines Kraftfahrzeugs nach StVZO bzw. StVO (auch als zulässiges
   * Gesamtgewicht - zGG - bezeichnet). Summe aus Leermasse und Zuladung. 
   */
  public var zulaessigesGesamtgewicht: Gewicht? = null

  public constructor(
      art: KatalogCode113?,
      marke: KatalogCode240_NichtAbgeschlossen?,
      fahrzeugidentifizierungsnummer: String?,
      aufbau: KatalogCode239_NichtAbgeschlossen?,
      typschluessel: String?,
      herstellerschluessel: String?,
      stilllegung: String?,
      erstzulassung: String?,
      zulassungsinformation: List<ZulassungsinformationKfz>?,
      zulaessigesGesamtgewicht: Gewicht?
  ) : this() {
    this.art = art
    this.marke = marke
    this.fahrzeugidentifizierungsnummer = fahrzeugidentifizierungsnummer
    this.aufbau = aufbau
    this.typschluessel = typschluessel
    this.herstellerschluessel = herstellerschluessel
    this.stilllegung = stilllegung
    this.erstzulassung = erstzulassung
    this.zulassungsinformation = zulassungsinformation
    this.zulaessigesGesamtgewicht = zulaessigesGesamtgewicht
  }
}
