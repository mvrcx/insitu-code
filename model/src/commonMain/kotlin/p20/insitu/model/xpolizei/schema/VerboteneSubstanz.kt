package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angabe von verbotenen Substanzen gem. Verbotsliste Welt Anti-Doping Code (Bereiche S0–S5).
 */
@Serializable
public open class VerboteneSubstanz() {
  /**
   * Klassifizierung der Substanz gem. WADA Verbotsliste (S0 bis S5), die zu allen Zeiten (in und
   * außerhalb von Wettkämpfen) verboten ist.
   */
  public var art: KatalogCode326? = null

  /**
   * Angabe der Bezeichnung der verbotenen Substanz.
   */
  public var bezeichnung: String? = null

  public constructor(art: KatalogCode326?, bezeichnung: String?) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
  }
}
