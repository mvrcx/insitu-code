package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Container für Anfrage
 */
@Serializable
public open class CIMPAnfrageType() {
  /**
   * Standard Nachrichtenkopf
   */
  public var nachrichtenkopf: CIMPNachrichtenKopf? = null

  /**
   * Angabe der Fachdaten
   */
  public var fachdaten: CIMPFachdatenType? = null

  public constructor(nachrichtenkopf: CIMPNachrichtenKopf?, fachdaten: CIMPFachdatenType?) :
      this() {
    this.nachrichtenkopf = nachrichtenkopf
    this.fachdaten = fachdaten
  }
}
