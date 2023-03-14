package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Angabe, dass und unter Einfluss welchen Betäubungsmittels die Person zur Tatzeit stand.
 */
@Serializable
public open class BtMeinflussJa() {
  /**
   * Angabe, dass die Person zur Tatzeit unter BtM-Einfluss stand.
   */
  public var ja: Boolean? = true

  /**
   * Angabe, unter Einfluss welchen Betäubungsmittels die Person zur Tatzeit stand.
   */
  public var art: List<KatalogCode105>? = null

  public constructor(ja: Boolean?, art: List<KatalogCode105>?) : this() {
    this.ja = ja
    this.art = art
  }
}
