package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlinx.serialization.Serializable

/**
 * Angaben zur Unter- und Obergrenze des Alters einer Person.
 */
@Serializable
public open class AlterVonBis() {
  /**
   * Untergrenze des Alters.
   */
  public var alterVon: Int? = null

  /**
   * Obergrenze des Alters.
   */
  public var alterBis: Int? = null

  public constructor(alterVon: Int?, alterBis: Int?) : this() {
    this.alterVon = alterVon
    this.alterBis = alterBis
  }
}
