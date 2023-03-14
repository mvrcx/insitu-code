package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Es werden die 3 Alternativen der speziellen OK-Merkmale gemäß OK-Raster (Punkt 1.12) abgebildet.
 */
@Serializable
public open class OK_Merkmal() {
  /**
   * Verwendung gewerblicher Strukturen.
   */
  public var a1: String? = null

  /**
   * Verwendung geschäftsähnlicher Strukturen.
   */
  public var a2: String? = null

  /**
   * Anwendung von Gewalt.
   */
  public var b1: String? = null

  /**
   * Anwendung anderer zur Einschüchterung geeigneter Mittel.
   */
  public var b2: String? = null

  /**
   * Einflussnahme auf Politik, Medien, öffentliche Verwaltung, Justiz oder Wirtschaft.
   */
  public var c: String? = null

  public constructor(
    a1: String?,
    a2: String?,
    b1: String?,
    b2: String?,
    c: String?
  ) : this() {
    this.a1 = a1
    this.a2 = a2
    this.b1 = b1
    this.b2 = b2
    this.c = c
  }
}
