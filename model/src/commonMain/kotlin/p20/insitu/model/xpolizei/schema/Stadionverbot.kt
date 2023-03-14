package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angaben zum Stadionverbot.
 */
@Serializable
public open class Stadionverbot() {
  /**
   * Angabe, welchem Verein bzw. Mannschaft die Person zugeordnet wird.
   */
  public var vereinszuordnung: KatalogCode412_NichtAbgeschlossen? = null

  /**
   * Zeitpunkt, an dem das Stadionverbot begonnen hat.
   */
  public var beginn: String? = null

  /**
   * Zeitpunkt, an dem das Stadionverbot beendet war.
   */
  public var ende: String? = null

  /**
   * Zeitpunkt, an dem das Stadionverbot voraussichtlich endet.
   */
  public var voraussichtlichesEnde: String? = null

  /**
   * Angaben zum Geltungsbereich des Stadionverbots.
   */
  public var geltungsbereich: Geltungsbereich? = null

  public constructor(
      vereinszuordnung: KatalogCode412_NichtAbgeschlossen?,
      beginn: String?,
      ende: String?,
      voraussichtlichesEnde: String?,
      geltungsbereich: Geltungsbereich?
  ) : this() {
    this.vereinszuordnung = vereinszuordnung
    this.beginn = beginn
    this.ende = ende
    this.voraussichtlichesEnde = voraussichtlichesEnde
    this.geltungsbereich = geltungsbereich
  }
}
