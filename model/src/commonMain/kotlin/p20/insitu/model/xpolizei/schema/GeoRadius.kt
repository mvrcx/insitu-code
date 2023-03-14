package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlinx.serialization.Serializable

/**
 * Diese Klasse enthält Angaben zum Radius.
 */
@Serializable
public open class GeoRadius() {
  /**
   * Wert des Radius.
   */
  public var wert: Double? = 0.0

  /**
   * Maßeinheit des Radius.
   */
  public var masseinheit: KatalogCode207? = null

  public constructor(wert: Double?, masseinheit: KatalogCode207?) : this() {
    this.wert = wert
    this.masseinheit = masseinheit
  }
}
