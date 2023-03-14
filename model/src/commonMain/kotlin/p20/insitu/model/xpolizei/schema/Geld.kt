package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Abstraktes Fachobjekt für Geld.
 *
 * Enthält gemeinsame Merkmale von Bargeld und Falschgeld.
 */
@Serializable
abstract class Geld() : Geld_Leer() {
  /**
   * Hier wird die Art des Geldes abgebildet.
   *  
   * HINWEIS: Einige Systeme besitzen eigene Katalogwerte für Falschgeld, Devisen sowie 'verrufene
   * Banknoten' und 'verrufene Münzen'.
   *
   * Im vorliegenden Modell wird Falschgeld in einem eigenen Fachobjekt Falschgeld abgebildet.
   * Devisen brauchen nicht gesondert erfasst zu werden, da für jede Instanz die Währung erfasst wird.
   *  
   * 'Verrufene' (d. h. ungültige) Münzen und Banknoten müssen gekennzeichnet werden können, da z.
   * B. für ungültig erklärte chinesische Banknoten in Deutschland nicht immer bekannt sind.
   *  
   * Historische Münzen und Banknoten werden hingegen im Fachobjekt SonstigeSache abgebildet.
   */
  public var art: KatalogCode104? = null

  /**
   * Seriennummer einer einzelnen Banknote.
   * Der Aufbau der Seriennummer kann je nach Währung unterschiedlich sein. Sollen Serien von
   * Banknoten abgebildet werden (mittels Seriennummernserie und Fachobjekt Serie), ist in diesem
   * Attribut die Seriennummer des ersten Serienelements gespeichert.
   *  
   * Beispiele:
   * Beispiel für Währung USD: E82104464 F
   * Beispiel für Währung EUR: X23085180704
   *  
   * Anmerkung: Zwischen dem Buchstaben und der Ziffernfolge ist kein Leerzeichen enthalten.
   *  
   * Abbildungen von EUR- und USD-Noten, auf denen die Seriennummer gekennzeichnet ist.
   */
  public var seriennummer: String? = null

  /**
   * Jahr der Ausgabe, wie auf dem baren Zahlungsmittel angegeben.
   *
   * Beispiele:
   * Die US-Dollar-Note (Nennwert 1 USD) mit der Seriennummer F 52763006 E, ausgegeben von der Bank
   * of Atlanta, trägt die Aufschrift 'Series 2006', d. h. Ausgabejahr 2006.
   * Münzen tragen i. d. R. eine Jahreszahl.
   * Bei deutschen Euro-Münzen ist das Ausgabejahr auf der nationalen Rückseite zu finden.
   */
  public var ausgabejahr: Int? = 0

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Bemerkungen zur erfassten Sache (z. B. auffälliger Zustand).
   *  
   * Beispiel: Banknote eingerissen
   */
  public var bemerkung: String? = null

  /**
   * Nennwert einer Münze oder Banknote.
   *
   * Beispiele:
   * 0,02 EUR für 2-Cent-Stück, 1 EUR für 1-EUR-Münze, 20 EUR für Banknote 20 EUR
   *
   * Bei Währungen, bei denen Haupt- und Untereinheiten in einem nicht-dezimalen Bezug stehen
   * (Beispiel britisches Pfund bis 1970), muss eine Umwandlung in einen Dezimalbruch erfolgen.
   *
   * Beispiel:
   * Britisches Pfund vor 1970: 1 Pfund = 20 Shilling, 1 Shilling = 12 Pence; d. h. 0,05 Pfund = 1
   * Shilling (Münze zu 1 Shilling), 1/240 Pfund ca. 0,00417 Pfund = 1 Penny 
   */
  public var nennwert: Geldbetrag? = null

  /**
   * Serie, die aus Seriennummern gebildet wird.
   *
   * Ausgehend von Bargeld.Seriennummer wird (Serie.Anzahl-1) mal der Wert Serie.Inkrement addiert,
   * um die Elemente der Serie zu bilden.
   * Voraussetzung: Seriennummer hat einen Aufbau, der numerisches Erhöhen zulässt (d. h. endet mit
   * so vielen Dezimalstellen, dass sinnvolles Inkrementieren möglich ist).
   *
   * Beispiele:
   * - Seriennummer X3405052
   * - Serie.Anzahl 3
   * - Serie.Inkrement 2
   *
   * Elemente der Serie X3405052, X3405054, X3405056
   */
  public var seriennummernserie: Serie? = null

  public var dokument: List<Dokument>? = null

  public var redundanzinformation: Redundanzinformation? = null

  public var asservat: Asservat? = null

  public constructor(
      art: KatalogCode104?,
      seriennummer: String?,
      ausgabejahr: Int?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      bemerkung: String?,
      nennwert: Geldbetrag?,
      seriennummernserie: Serie?,
      dokument: List<Dokument>?,
      redundanzinformation: Redundanzinformation?,
      asservat: Asservat?
  ) : this() {
    this.art = art
    this.seriennummer = seriennummer
    this.ausgabejahr = ausgabejahr
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.nennwert = nennwert
    this.seriennummernserie = seriennummernserie
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.asservat = asservat
  }
}
