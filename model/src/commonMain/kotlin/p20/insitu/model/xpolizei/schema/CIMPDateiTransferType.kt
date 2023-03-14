package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlinx.serialization.Serializable

/**
 * Container für den DateiTransfer
 */
@Serializable
public open class CIMPDateiTransferType() {
  /**
   * Standard Nachrichtenkopf
   */
  public var nachrichtenkopf: CIMPNachrichtenKopf? = null

  /**
   * Entspricht der KK DigitaleDaten des IMP, ergänzt durch die technischen Attribute mimeType,
   * dateiID und absenderID
   */
  public var daten: DigitaleDaten? = null

  /**
   * Soll ein Download ausgelöst werden, ist hierfür der Wert true anzugeben, false löst einen
   * Upload aus
   */
  public var download: Boolean? = true

  public constructor(
      nachrichtenkopf: CIMPNachrichtenKopf?,
      daten: DigitaleDaten?,
      download: Boolean?
  ) : this() {
    this.nachrichtenkopf = nachrichtenkopf
    this.daten = daten
    this.download = download
  }
}
