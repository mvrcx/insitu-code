package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Container für DatenQuittung
 */
@Serializable
public open class CIMPDatenQuittungType() {
  /**
   * ID des Datenobjekts, auf das sich die Rückmeldung bezieht, die dieses in der ursprünglichen
   * Nachricht hatte
   */
  public var objektID: String? = null

  public var quellID: String? = null

  public var zielID: String? = null

  public var teilnehmerankerID: String? = null

  /**
   * ID des Verbundankers mit dem der Teilnehmeranker fachlich zusammengehörig (FZ) ist
   */
  public var fZID: String? = null

  /**
   * ID des Verbundankers mit dem der Teilnehmeranker automatisiert zusammengehörig (AZ) ist.
   */
  public var aZID: List<String>? = null

  /**
   * ID des Verbundankers mit dem der Teilnehmeranker fachlich möglicherweise zusammengehörig (FMZ)
   * ist
   */
  public var fMZID: List<String>? = null

  /**
   * ID des Verbundankers mit dem der Teilnehmeranker automatisiert möglicherweise zusammengehörig
   * (AMZ) ist.
   */
  public var aMZID: List<String>? = null

  /**
   * ID des Verbundankers mit dem der Teilnehmeranker fachlich nicht zusammengehörig (FNZ) ist
   */
  public var fNZID: List<String>? = null

  public var quittungen: List<CIMPDatenQuittungBasisType>? = null

  public var betroffenesObjekt: List<CIMPDatenQuittungObjekteType>? = null

  public constructor(
      objektID: String?,
      quellID: String?,
      zielID: String?,
      teilnehmerankerID: String?,
      fZID: String?,
      aZID: List<String>?,
      fMZID: List<String>?,
      aMZID: List<String>?,
      fNZID: List<String>?,
      quittungen: List<CIMPDatenQuittungBasisType>?,
      betroffenesObjekt: List<CIMPDatenQuittungObjekteType>?
  ) : this() {
    this.objektID = objektID
    this.quellID = quellID
    this.zielID = zielID
    this.teilnehmerankerID = teilnehmerankerID
    this.fZID = fZID
    this.aZID = aZID
    this.fMZID = fMZID
    this.aMZID = aMZID
    this.fNZID = fNZID
    this.quittungen = quittungen
    this.betroffenesObjekt = betroffenesObjekt
  }
}
