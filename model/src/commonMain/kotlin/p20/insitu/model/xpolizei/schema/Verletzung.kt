package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Hier werden physische Verletzungen abgebildet.
 */
@Serializable
public open class Verletzung() {
  /**
   * Dieses Feld enthält freitextliche Angaben zur Art der Verletzung.
   *  
   * Beispiele:
   * - Fleischwunde
   * - Kieferbruch
   * - Verätzung der Haut
   */
  public var bezeichnung: String? = null

  /**
   * Angabe des Körperteils, auf dem sich die Verletzung befindet.
   */
  public var lage: Koerperteilangabe? = null

  /**
   * Dieses Feld enthält Angaben zum Grad der Verletzungen.
   *  
   * Beispiel: leicht verletzt, schwer verletzt
   */
  public var grad: KatalogCode277? = null

  /**
   * Dieses Feld enthält freitextliche Angaben zur Verletzung.
   *
   * Beispiel: Verätzung der Haut mittels Salzsäure
   */
  public var bemerkung: String? = null

  public constructor(
      bezeichnung: String?,
      lage: Koerperteilangabe?,
      grad: KatalogCode277?,
      bemerkung: String?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.lage = lage
    this.grad = grad
    this.bemerkung = bemerkung
  }
}
