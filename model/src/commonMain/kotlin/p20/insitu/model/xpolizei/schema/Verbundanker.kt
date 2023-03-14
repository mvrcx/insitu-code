package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Die KK Verbundanker enthält alle Referenzen zu Verbundankern in den jeweiligen fachlichen
 * Differenzierungen (FZ, AZ usw.).
 */
@Serializable
public open class Verbundanker() {
  /**
   * ID des Verbundankers, mit dem der Teilnehmeranker 'fachlich zusammengehörig (FZ)' ist.
   */
  public var fZID: String? = null

  /**
   * ID des Verbundankers, mit dem der Teilnehmeranker 'automatisiert zusammengehörig (AZ)' ist.
   */
  public var aZID: List<String>? = null

  /**
   * ID des Verbundankers, mit dem der Teilnehmeranker 'fachlich möglicherweise zusammengehörig
   * (FMZ)' ist.
   */
  public var fMZID: List<String>? = null

  /**
   * ID des Verbundankers, mit dem der Teilnehmeranker 'automatisiert möglicherweise zusammengehörig
   * (AMZ)' ist.
   */
  public var aMZID: List<String>? = null

  /**
   * ID des Verbundankers, mit dem der Teilnehmeranker 'fachlich nicht zusammengehörig (FNZ)' ist.
   */
  public var fNZID: List<String>? = null

  public constructor(
    fZID: String?,
    aZID: List<String>?,
    fMZID: List<String>?,
    aMZID: List<String>?,
    fNZID: List<String>?
  ) : this() {
    this.fZID = fZID
    this.aZID = aZID
    this.fMZID = fMZID
    this.aMZID = aMZID
    this.fNZID = fNZID
  }
}
