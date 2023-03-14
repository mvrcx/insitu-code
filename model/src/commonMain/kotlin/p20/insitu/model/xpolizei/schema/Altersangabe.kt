package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlinx.serialization.Serializable

/**
 * Angaben zum exakten oder geschätzten (Unter- und Obergrenze) Alter einer Person.
 */
@Serializable
public open class Altersangabe() {
  /**
   * Dieses Feld enthält Angaben über das exakte Alter einer Person (in ganzen Jahren).
   */
  public var exakt: Int? = null

  /**
   * Dieses Feld enthält Angaben über die Unter- und Obergrenze für das Alter einer Person (in
   * ganzen Jahren).
   */
  public var alterVonBis: AlterVonBis? = null

  public constructor(exakt: Int?, alterVonBis: AlterVonBis?) : this() {
    this.exakt = exakt
    this.alterVonBis = alterVonBis
  }
}
