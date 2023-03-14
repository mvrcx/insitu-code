package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Spezielle Merkmale von Fahrrädern.
 */
@Serializable
public open class Fahrrad() : Fahrzeug() {
  /**
   * 'Alle am deutschen Markt erhältlichen Fahrräder, die der DIN 79100 für Fahrräder entsprechen,
   * tragen eine eingeschlagene oder anderweitg fest mit dem Rahmen verbundene Rahmennummer. Diese
   * (befindet sich) in der Nähe des Tretlagers, des Sattels, oder des Steuerkopfes.'
   *
   * (Quelle: http://einbruchschutz.polizei-beratung.de/fahrzeuge/fahrrad/rahmennummer.htm)
   */
  public var rahmennummer: String? = null

  /**
   * Codierung von Fahrrädern durch Polizeidienststellen nach dem EIN-
   * (Eigentümer-Identifizierungs-Nachweis) oder FEIN- (Friedberger Eigentümer-Identifikations-Nummer)
   * Verfahren. Das Verfahren wird in allen deutschen Bundesländern mit Ausnahme Berlins verwendet.
   *  
   * (Quelle: http://de.wikipedia.org/wiki/Fahrradcodierung)
   */
  public var codenummer: String? = null

  /**
   * Obwohl Zoll (25,4 mm) keine gesetzliche Maßeinheit ist, werden Fahrräder vielfach im
   * Alltagsgebrauch noch anhand des ungefähren Radaußendurchmessers in Zoll klassifiziert (z. B.
   * 24-Zoll-, 26-Zoll- oder 28-Zoll-Rad).
   */
  public var radgroesseInZoll: Double? = 0.0

  /**
   * Modellbezeichung eines Fahrrads.
   *
   * Beispiel: Carver 300
   */
  public var modell: String? = null

  /**
   * Angabe der Art des Fahrrads.
   */
  public var art: KatalogCode328_NichtAbgeschlossen? = null

  /**
   * Angabe, ob das Fahrrad einen Hilfsmotor besitzt und es sich deshalb um ein Pedelec handelt.
   */
  public var pedelec: KatalogCode217? = null

  public constructor(
      rahmennummer: String?,
      codenummer: String?,
      radgroesseInZoll: Double?,
      modell: String?,
      art: KatalogCode328_NichtAbgeschlossen?,
      pedelec: KatalogCode217?
  ) : this() {
    this.rahmennummer = rahmennummer
    this.codenummer = codenummer
    this.radgroesseInZoll = radgroesseInZoll
    this.modell = modell
    this.art = art
    this.pedelec = pedelec
  }
}
