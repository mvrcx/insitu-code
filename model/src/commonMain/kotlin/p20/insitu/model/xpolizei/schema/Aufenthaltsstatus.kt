package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Der Aufenthaltsstatus beschreibt den rechtlichen Status eines Ausländers in Bezug auf dessen
 * Aufenthalt. Dies schließt sowohl den rechtmäßigen als auch den unrechtmäßigen Aufenthalt ein.
 */
@Serializable
public open class Aufenthaltsstatus() {
  /**
   * Die Art des Aufenthaltsstatus beschreibt den rechtlichen Status eines Ausländers in Bezug auf
   * dessen Aufenthalt. Dies schließt sowohl den rechtmäßigen als auch den unrechtmäßigen Aufenthalt
   * ein.
   */
  public var art: KatalogCode366? = null

  /**
   * Angabe des Beginns des Aufenthaltsstatus.
   */
  public var beginn: String? = null

  /**
   * Angabe der Beendigung des Aufenthaltsstatus.
   */
  public var ende: String? = null

  /**
   * Beschreibt den Grund für die Stellung eines Aufenthaltsantrags.
   */
  public var aufenthaltszweck: String? = null

  public constructor(
      art: KatalogCode366?,
      beginn: String?,
      ende: String?,
      aufenthaltszweck: String?
  ) : this() {
    this.art = art
    this.beginn = beginn
    this.ende = ende
    this.aufenthaltszweck = aufenthaltszweck
  }
}
