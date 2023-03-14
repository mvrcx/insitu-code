package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Hier werden Angaben zur Verpackung des Arzneimittels gemacht.
 */
@Serializable
public open class Verpackung() {
  /**
   * Angaben zur Verpackung, welche direkt das Arzneimittel umschließt.
   *
   * Beispiele: Blister, Kapselhülle
   */
  public var primaerverpackung: String? = null

  /**
   * Angaben zur äußeren Verpackung des Arzneimittels.
   *
   * Beispiel: Faltschachtel
   */
  public var sekundaerverpackung: String? = null

  /**
   * Angabe, ob ein Beipackzettel vorhanden ist.
   */
  public var beipackzettel: KatalogCode217? = null

  public constructor(
    primaerverpackung: String?,
    sekundaerverpackung: String?,
    beipackzettel: KatalogCode217?
  ) : this() {
    this.primaerverpackung = primaerverpackung
    this.sekundaerverpackung = sekundaerverpackung
    this.beipackzettel = beipackzettel
  }
}
