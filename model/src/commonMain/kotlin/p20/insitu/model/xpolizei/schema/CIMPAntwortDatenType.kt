package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Container für AntwortDaten
 */
@Serializable
public open class CIMPAntwortDatenType() {
  /**
   * Angabe der Fachdaten
   */
  public var fachdaten: CIMPFachdatenType? = null

  public var allgemeinesErgebnis: String? = null

  public constructor(fachdaten: CIMPFachdatenType?, allgemeinesErgebnis: String?) : this() {
    this.fachdaten = fachdaten
    this.allgemeinesErgebnis = allgemeinesErgebnis
  }
}
