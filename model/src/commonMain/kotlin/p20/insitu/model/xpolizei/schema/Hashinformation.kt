package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Abbildung von Informationen der genutzten Hashfunktion und des damit errechneten Hashwertes.
 */
@Serializable
public open class Hashinformation() {
  /**
   * Hashfunktion, mit der der Hashwert errechnet wurde.
   */
  public var hashfunktion: KatalogCode397_NichtAbgeschlossen? = null

  /**
   * Ein Hashwert ist eine mathematische Prüfsumme, die durch Anwendung einer Hashfunktion aus einer
   * elektronischen Nachricht erzeugt wird. Dieser bildet eine nahezu eindeutige Kennzeichnung einer
   * größeren Datenmenge, so wie ein Fingerabdruck einen Menschen nahezu eindeutig identifiziert.
   *
   * Beispiel: c54c6b24607fbe14080d90ef1b0c12c2
   */
  public var hashwert: String? = null

  public constructor(hashfunktion: KatalogCode397_NichtAbgeschlossen?, hashwert: String?) : this() {
    this.hashfunktion = hashfunktion
    this.hashwert = hashwert
  }
}
