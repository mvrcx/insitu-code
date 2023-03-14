package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Container für DateQuittungBasis
 */
@Serializable
public open class CIMPDatenQuittungBasisType() : CIMPQuittungBasisType() {
  /**
   * Enthält die im Bereich nachrichtenbezogene Quittungen beschriebenen Elemente als
   * redundanteZielID
   */
  public var redundanteZielID: String? = null

  /**
   * Enthält die im Bereich nachrichtenbezogene Quittungen beschriebenen Elemente als
   * redundanteQuellID
   */
  public var redundanteQuellID: String? = null

  /**
   * Datenbesitzer des Objekts.
   */
  public var datenbesitzer: String? = null

  public constructor(
    redundanteZielID: String?,
    redundanteQuellID: String?,
    datenbesitzer: String?
  ) : this() {
    this.redundanteZielID = redundanteZielID
    this.redundanteQuellID = redundanteQuellID
    this.datenbesitzer = datenbesitzer
  }
}
