package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlinx.serialization.Serializable

/**
 * Abbildung eines Geldbetrags (bar oder unbar). Ein Geldbetrag besitzt die Attribute Währung und
 * Betrag (inkl. Nachkommastellen).
 */
@Serializable
public open class Geldbetrag() {
  /**
   * Währung nach Katalog, z. B. Euro.
   *
   * Der Katalog orientiert sich an den Währungscodes nach ISO 4217.
   */
  public var waehrung: KatalogCode230_NichtAbgeschlossen? = null

  /**
   * Der Betrag wird in der Basiseinheit der Währung mit Nachkommastellen angegeben (als
   * Dezimalbruch).
   *  
   * Beispiel: Die Währung Euro besitzt die Untereinheit Eurocent, wobei ein Euro 100 Eurocent
   * entspricht. Ein Betrag von 56 Euro und 11 Eurocent lässt sich deshalb als 56,11 Euro darstellen.
   *  
   * Hinweis: Bei Währungen, bei denen das Verhältnis der Untereinheit zur Basiseinheit nicht ohne
   * Rest durch 10 teilbar ist, muss zuvor eine Umrechnung in einen Dezimalbruch erfolgen. Ein
   * historisches Beispiel für eine solche Währung ist das Britische Pfund, welches bis 1971 in 20
   * Shilling zu je 12 Pence unterteilt war (aktuell 1 Pfund = 100 Pence).
   */
  public var betrag: Double? = 0.0

  public constructor(waehrung: KatalogCode230_NichtAbgeschlossen?, betrag: Double?) : this() {
    this.waehrung = waehrung
    this.betrag = betrag
  }
}
