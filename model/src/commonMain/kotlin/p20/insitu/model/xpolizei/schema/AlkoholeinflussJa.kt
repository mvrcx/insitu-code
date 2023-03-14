package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlin.Double
import kotlinx.serialization.Serializable

/**
 * Angabe, dass und welcher Atem- bzw. Blutalkoholwert vorlag.
 */
@Serializable
public open class AlkoholeinflussJa() {
  /**
   * Angabe, dass die Person unter Alkoholeinfluss stand.
   */
  public var ja: Boolean? = true

  /**
   * Angabe der gemessenen Atemalkoholkonzentration in mg/l.
   */
  public var atemAlkoholwert: Double? = 0.0

  /**
   * Angabe der gemessenen Blutalkoholkonzentration in Promille.
   */
  public var blutAlkoholwert: Double? = 0.0

  public constructor(
    ja: Boolean?,
    atemAlkoholwert: Double?,
    blutAlkoholwert: Double?
  ) : this() {
    this.ja = ja
    this.atemAlkoholwert = atemAlkoholwert
    this.blutAlkoholwert = blutAlkoholwert
  }
}
