package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlinx.serialization.Serializable

/**
 * Abbildung von Speichergrößen.
 */
@Serializable
public open class Speichergroesse() {
  /**
   * Exakte Angabe eines Wertes.
   */
  public var wert: Double? = 0.0

  /**
   * Maßeinheit, in der die Größe angegeben ist.
   */
  public var masseinheit: KatalogCode401? = null

  public constructor(wert: Double?, masseinheit: KatalogCode401?) : this() {
    this.wert = wert
    this.masseinheit = masseinheit
  }
}
