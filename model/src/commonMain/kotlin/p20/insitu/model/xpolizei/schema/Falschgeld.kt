package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Falschgeld (d. h. nachgemachte oder verfälschte Münzen oder Banknoten) wird als Spezialisierung
 * des Geldes abgebildet.
 */
@Serializable
public open class Falschgeld() : Geld() {
  /**
   * Angabe der Art der Fälschung.
   *  
   * Katalogwerte enthalten sowohl die Herstellungsart einer Fälschung (z. B. Druckfälschung,
   * Farbkopierer-Fälschung) als auch die grundsätzliche Fälschungsart, z. B. Verfälschung.
   *  
   * In der Praxis häufen sich die Fälle von 'Kombinationsfälschungen', d. h. ein Geldschein wird
   * beispielsweise erst kopiert und danach die Seriennummer manipuliert. Daher wurde hier die
   * Multiplizität * gewählt.
   */
  public var faelschungsart: List<KatalogCode226_NichtAbgeschlossen>? = null

  /**
   * Beschreibung der nationalen Rückseite (bei Euro-Münzen).
   *  
   * Beispiele:
   * - Bundesrepublik Deutschland, 2-Euro-Münze, Bundesländer-Serie, Motiv
   * Schleswig-Holstein/Holstentor
   * - Bundesrepublik Deutschland, 2-Euro-Münze, Motiv 50 Jahre römische Verträge
   * - Bundesrepublik Deutschland, 10-Cent-Stück, Motiv Brandenburger Tor
   * - Griechenland, 1-Euro-Münze, Motiv Eule
   * - Italien, 5-Cent-Münze, Motiv Kolosseum
   * - Bundesrepublik Deutschland, 1-Euro-Münze, Motiv Bundesadler
   */
  public var nationaleSeite: String? = null

  /**
   * Freitextliche Beschreibung der besonderen Merkmale (insbesondere Fälschungsmerkmale).
   *
   * Beispiel (für Banknote): Sicherheitsmerkmal Hologramm fehlt
   *  
   * Alle Merkmale in einem Eintrag.
   */
  public var besondereMerkmale: String? = null

  /**
   * Die Plattennummer ist während der Herstellung der Banknoten ein internes Prüfkriterium und
   * befindet sich bei allen geläufigen Währungen, wie z. B. EUR-Geldscheinen, auf der Vorderseite der
   * Banknote. Die Plattennummer soll ohne Punkt, Komma oder Leerzeichen erfasst werden, z. B. F003F1.
   */
  public var plattennummer: String? = null

  /**
   * Kennzeichen bzw. Kennbuchstabe der Prägestätte.
   *
   * Bei deutschen Euro-Münzen auf der nationalen Seite zu finden.
   */
  public var muenzzeichen: String? = null

  /**
   * Angabe, an welcher Stelle das Falschgeld als solches erkannt bzw. erstmals in Erscheinung
   * getreten ist.
   *  
   * Beispiele: 
   * DBBk (Zentrale / Filialen)
   * Geschäft/Öffentlichkeit
   * Sicherstellung durch Polizei
   */
  public var festgestelltBei: KatalogCode227? = null

  /**
   * Sowohl bei Münzen als auch bei Scheinen (inkl. Seriennummer) müssen alle Herstellungsmerkmale
   * identisch sein. Bei Abweichungen auch nur eines Herstellungsmerkmals muss ein neues Falschgeld
   * erfasst werden. Die Angabe einer Seriennummernserie und die Angabe der Anzahl mit gleichen
   * Herstellungsmerkmalen schließen sich gegenseitig aus.
   */
  public var anzahlMitGleichenHerstellungsmerkmalen: Int? = 0

  /**
   * Banknoten werden in verschiedenen Serien herausgegeben, bei Euro-Banknoten ist die erste Serie
   * dieser Währung z. B.: ES1. Sollte eine Banknote mit verändertem Design / Sicherheitsmerkmalen
   * entwickelt und herausgegeben werden, wird die Serie entsprechend fortgeschrieben z. B.: ES2.
   */
  public var serienbezeichnung: String? = null

  /**
   * Indikative zu Euro-Falsifikaten, die von der EZB vergeben werden, z. B. EUA50P5 (EU für EZB; A
   * für Ausgabe A des Euros; 2010-2012 kommt Ausgabe B; 50 für den Nennwert; P für Druckfälschung; C
   * wäre Kopiefälschung und 5 für die 5); verschiedene Druckfälschungsart eines 50-Euro-Scheines.
   */
  public var indikativEZB: String? = null

  public constructor(
      faelschungsart: List<KatalogCode226_NichtAbgeschlossen>?,
      nationaleSeite: String?,
      besondereMerkmale: String?,
      plattennummer: String?,
      muenzzeichen: String?,
      festgestelltBei: KatalogCode227?,
      anzahlMitGleichenHerstellungsmerkmalen: Int?,
      serienbezeichnung: String?,
      indikativEZB: String?
  ) : this() {
    this.faelschungsart = faelschungsart
    this.nationaleSeite = nationaleSeite
    this.besondereMerkmale = besondereMerkmale
    this.plattennummer = plattennummer
    this.muenzzeichen = muenzzeichen
    this.festgestelltBei = festgestelltBei
    this.anzahlMitGleichenHerstellungsmerkmalen = anzahlMitGleichenHerstellungsmerkmalen
    this.serienbezeichnung = serienbezeichnung
    this.indikativEZB = indikativEZB
  }
}
