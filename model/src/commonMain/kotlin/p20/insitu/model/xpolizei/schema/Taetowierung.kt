package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Eine Tätowierung (wissenschaftlich auch Tatauierung, umgangssprachlich (engl.) Tattoo) ist ein
 * Motiv, das mit Tinte oder anderen Farbpigmenten in die Haut eingebracht wird.
 */
@Serializable
public open class Taetowierung() {
  /**
   * Katalogisiertes Attribut mit verschiedenen Tätowierungsmotiven.
   */
  public var motiv: KatalogCode274_NichtAbgeschlossen? = null

  /**
   * Angabe des Körperteils, auf dem sich die Tätowierung befindet.
   */
  public var lage: Koerperteilangabe? = null

  /**
   * Dieses Feld enthält freitextliche Angaben zur Tätowierung.
   *
   * Beispiel: ... gilt bei russischen Straftätern als Rangabzeichen...
   */
  public var bemerkung: String? = null

  public constructor(
      motiv: KatalogCode274_NichtAbgeschlossen?,
      lage: Koerperteilangabe?,
      bemerkung: String?
  ) : this() {
    this.motiv = motiv
    this.lage = lage
    this.bemerkung = bemerkung
  }
}
