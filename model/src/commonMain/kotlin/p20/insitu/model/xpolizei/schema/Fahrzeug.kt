package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Abstraktes Fachobjekt für alle Fahrzeuge.
 *
 * Enthält gemeinsame Merkmale aller Fahrzeuge.
 */
@Serializable
abstract class Fahrzeug() : Fahrzeug_Leer() {
  /**
   * Allgemeine, freitextliche Bezeichnung des Fahrzeugs. Es kann sich um eine allgemeine
   * Bezeichnung oder eine Bezeichnung des individuellen Fahrzeugs handeln.
   *  
   * Bei Kraftfahrzeugen ist hier die Modellbezeichnung, unter der das Fahrzeug verkauft wird,
   * abbildbar.
   *  
   * In der Praxis werden im Lauf der Jahre technisch verschiedene Fahrzeuge unter derselben
   * Modellbezeichnung verkauft. Ein Volkswagen Golf des Baujahres 1974 ist technisch von dem Modell
   * der gleichen Handelsbezeichnung 'Golf' mit dem Baujahr 2009 verschieden.
   *  
   * Beispiel: BMW 316i, VW Golf, Mercedes A 170, VW Polo, Opel Zafira, Airbus A320-212
   */
  public var bezeichnung: String? = null

  /**
   * Sachgebundene Hinweise zum Fahrzeug.
   *
   * Beispiele: Explosionsgefahr, chemische Gefahr, gefährliche Stoffe, Strahlungsgefahr
   */
  public var sachgebundenerHinweis: List<KatalogCode223_NichtAbgeschlossen>? = null

  /**
   * Spezielle Eigenschaften dieser konkreten Sache (z. B. Beule hinten links, Beplankung defekt),
   * die über einen längeren Zeitraum bestehen und somit der Sache selbst zugeordnet werden können.
   *  
   * Alle Merkmale werden in einem Eintrag abgebildet.
   *  
   * Eine Eigenschaft wie '137 Insassen' ist nicht dem Fahrzeug selbst, sondern der Verbindung des
   * Fahrzeugs mit einem Ereignis oder einer Straftat (z. B. 'gefährlicher Eingriff in den
   * Bahnverkehr') zuzuordnen (siehe auch Erläuterung zum Objekt Bemerkung).
   */
  public var besondereMerkmale: String? = null

  /**
   * Freitextliche Bemerkung zum Fahrzeug.
   *  
   * Die Bemerkung sollte sich auf eine nicht nur vorübergehende Eigenschaft des Fahrzeugs beziehen.
   *  
   * Andere Bemerkungen, die sich auf das Fahrzeug in Verbindung mit einer Straftat (z. B. gemäß §
   * 315 StGB Gefährliche Eingriffe in den Bahn-, Schiffs- und Luftverkehr) beziehen, werden nicht beim
   * Fahrzeug, sondern in der Beziehung zwischen Straftat und Fahrzeug übertragen.
   */
  public var bemerkung: String? = null

  /**
   * Das Attribut beschreibt die Verwendungsart bzw. die Besonderheit, die durch den Nutzer oder die
   * Art der Nutzung eines Fahrzeuges besteht. Über die Kombination des jeweiligen Attributs Art
   * (Kraftfahrzeug.Art, Wasserfahrzeug.Art, etc.) und diesem Attribut ist es z. B. möglich, sowohl die
   * Information 'Pkw' als auch die Information 'Polizeifahrzeug' für ein konkretes Fahrzeug
   * abzubilden.
   */
  public var verwendungsart: KatalogCode224_NichtAbgeschlossen? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Zeitwert eines Fahrzeugs.
   */
  public var zeitwert: Geldbetrag? = null

  /**
   * Neuwert eines Fahrzeugs.
   *
   * Beispiel:
   * Ein Kraftfahrzeug hat einen Neuwert von 22.376 EUR (UVP des Herstellers).
   */
  public var neuwert: Geldbetrag? = null

  public var nummernangabeBeiFahrzeugen: List<NummernangabeBeiFahrzeugen>? = null

  /**
   * Breite des Fahrzeugs.
   */
  public var breite: Ausmass? = null

  /**
   * Höhe des Fahrzeugs.
   */
  public var hoehe: Ausmass? = null

  /**
   * Gesamte Länge des Fahrzeugs.
   */
  public var laenge: Ausmass? = null

  public var dokument: List<Dokument>? = null

  public var fahrzeugfarbe: List<Fahrzeugfarbe>? = null

  public var faelschung: Faelschung? = null

  public var herstellungsinformation: Herstellungsinformation? = null

  public var redundanzinformation: Redundanzinformation? = null

  public var asservat: Asservat? = null

  public constructor(
      bezeichnung: String?,
      sachgebundenerHinweis: List<KatalogCode223_NichtAbgeschlossen>?,
      besondereMerkmale: String?,
      bemerkung: String?,
      verwendungsart: KatalogCode224_NichtAbgeschlossen?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      zeitwert: Geldbetrag?,
      neuwert: Geldbetrag?,
      nummernangabeBeiFahrzeugen: List<NummernangabeBeiFahrzeugen>?,
      breite: Ausmass?,
      hoehe: Ausmass?,
      laenge: Ausmass?,
      dokument: List<Dokument>?,
      fahrzeugfarbe: List<Fahrzeugfarbe>?,
      faelschung: Faelschung?,
      herstellungsinformation: Herstellungsinformation?,
      redundanzinformation: Redundanzinformation?,
      asservat: Asservat?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.sachgebundenerHinweis = sachgebundenerHinweis
    this.besondereMerkmale = besondereMerkmale
    this.bemerkung = bemerkung
    this.verwendungsart = verwendungsart
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.zeitwert = zeitwert
    this.neuwert = neuwert
    this.nummernangabeBeiFahrzeugen = nummernangabeBeiFahrzeugen
    this.breite = breite
    this.hoehe = hoehe
    this.laenge = laenge
    this.dokument = dokument
    this.fahrzeugfarbe = fahrzeugfarbe
    this.faelschung = faelschung
    this.herstellungsinformation = herstellungsinformation
    this.redundanzinformation = redundanzinformation
    this.asservat = asservat
  }
}
