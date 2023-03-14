package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Angaben zum Körperteil.
 */
@Serializable
public open class Koerperteilangabe() {
  /**
   * Angabe des konkreten Körperteils.
   */
  public var koerperteil: KatalogCode244_MitZusatz? = null

  /**
   * Dieses Feld spezifiziert die Lage des Körperteils. Die Lagebeschreibung erfolgt aus Sicht der
   * zu beschreibenden Person.
   */
  public var lagespezifikation: List<KatalogCode376>? = null

  public constructor(koerperteil: KatalogCode244_MitZusatz?,
                     lagespezifikation: List<KatalogCode376>?) : this() {
    this.koerperteil = koerperteil
    this.lagespezifikation = lagespezifikation
  }
}
