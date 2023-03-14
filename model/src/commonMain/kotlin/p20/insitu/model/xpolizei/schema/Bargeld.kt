package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Abbildung barer Zahlungsmittel (Banknoten und Münzen) in beliebigen Währungen.
 *  
 * Falschgeld wird als gesonderte Spezialisierung des Gelds abgebildet.
 * Historische Münzen und Banknoten werden als SonstigeSache abgebildet.
 */
@Serializable
public open class Bargeld() : Geld() {
  /**
   * Dieses Feld enthält Angaben zur Anzahl von Bargeld (Münzen, Banknoten).
   */
  public var stueckzahl: Int? = 0

  /**
   * Freitextliche Beschreibung der besonderen Merkmale.
   * Alle Merkmale in einem Eintrag.
   */
  public var besondereMerkmale: String? = null

  /**
   * Klartextbezeichnung des erfassten Gegenstands.
   *
   * Beispiel: 'Banknote 5 britische Pfund', '2 Euro Bundesrepublik Deutschland Hamburger Michel'
   */
  public var bezeichnung: String? = null

  /**
   * Angabe von sachgebundenen Hinweisen zu Zahlungsmitteln.
   */
  public var sachgebundenerHinweis: List<KatalogCode386>? = null

  /**
   * Staat (kein Bundesstaat oder Bundesland) in dem sich die ausgebende Stelle befindet (z. B. bei
   * Euro-Banknoten wird hier der Sitz der EZB in Deutschland abgebildet).
   * Bei Euro-Münzen wird der der nationalen Seite entsprechende Staat abgebildet.
   *  
   * Bei Nicht-Euro Gemeinschaftswährungen (d. h. Währungen, die in mehreren Staaten gesetzliches
   * Zahlungsmittel sind, wie z. B. Ostkaribischer Dollar XCD, CFA-Franc XAF, XOF) gilt dies analog.
   */
  public var ausgabestaat: KatalogCode208_NichtAbgeschlossen? = null

  /**
   * Ausgebende Stelle. Für Banknoten ist dies in der Regel eine Zentral- oder Notenbank.
   *  
   * Beispiele:
   * Für EUR-Banknoten Europäische Zentralbank
   * Für USD-Noten verschiedene Stellen, z. B. Bank of Richmond, Bank of Atlanta
   */
  public var emittent: KatalogCode209_NichtAbgeschlossen? = null

  public constructor(
      stueckzahl: Int?,
      besondereMerkmale: String?,
      bezeichnung: String?,
      sachgebundenerHinweis: List<KatalogCode386>?,
      ausgabestaat: KatalogCode208_NichtAbgeschlossen?,
      emittent: KatalogCode209_NichtAbgeschlossen?
  ) : this() {
    this.stueckzahl = stueckzahl
    this.besondereMerkmale = besondereMerkmale
    this.bezeichnung = bezeichnung
    this.sachgebundenerHinweis = sachgebundenerHinweis
    this.ausgabestaat = ausgabestaat
    this.emittent = emittent
  }
}
