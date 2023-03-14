package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlinx.serialization.Serializable

/**
 * Angabe einer Unter- oder Obergrenze für einen Wert oder Angabe eines Wertebereichs.
 */
@Serializable
public open class WertVonBis() {
  /**
   * Untergrenze für einen Wert.
   *
   * Kann nur zusammen mit Attribut WertBis und ohne Attribut Wert verwendet werden.
   * Sinnvolle Verwendung insbesondere bei Feststellungsart 'geschätzt'.
   */
  public var wertVon: Double? = 0.0

  /**
   * Obergrenze für einen Wert.
   *
   * Kann nur zusammen mit Attribut WertVon und ohne Attribut Wert verwendet werden.
   * Sinnvolle Verwendung insbesondere bei Feststellungsart 'geschätzt'.
   */
  public var wertBis: Double? = 0.0

  public constructor(wertVon: Double?, wertBis: Double?) : this() {
    this.wertVon = wertVon
    this.wertBis = wertBis
  }
}
