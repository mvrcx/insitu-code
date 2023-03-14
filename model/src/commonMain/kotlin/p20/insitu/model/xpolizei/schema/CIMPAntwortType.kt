package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Container für Antwort
 */
@Serializable
public open class CIMPAntwortType() {
  /**
   * Standard Nachrichtenkopf
   */
  public var nachrichtenkopf: CIMPNachrichtenKopf? = null

  /**
   * Container der Quittung
   */
  public var quittung: CIMPQuittungType? = null

  /**
   * Conatiner für die AnwortDaten
   */
  public var antwortDaten: CIMPAntwortDatenType? = null

  public constructor(
      nachrichtenkopf: CIMPNachrichtenKopf?,
      quittung: CIMPQuittungType?,
      antwortDaten: CIMPAntwortDatenType?
  ) : this() {
    this.nachrichtenkopf = nachrichtenkopf
    this.quittung = quittung
    this.antwortDaten = antwortDaten
  }
}
