package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Container für SeitenAbruf
 */
@Serializable
public open class CIMPSeitenAbrufType() {
  /**
   * Standard Nachrichtenkopf
   */
  public var nachrichtenkopf: CIMPNachrichtenKopf? = null

  /**
   * ID der Ergebnismenge
   */
  public var ergebnismengenID: String? = null

  /**
   * Angefragte Seite
   */
  public var seite: Int? = 0

  public constructor(
      nachrichtenkopf: CIMPNachrichtenKopf?,
      ergebnismengenID: String?,
      seite: Int?
  ) : this() {
    this.nachrichtenkopf = nachrichtenkopf
    this.ergebnismengenID = ergebnismengenID
    this.seite = seite
  }
}
