package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlinx.serialization.Serializable

/**
 * Angabe, ob die Person zur Tatzeit unter Einfluss von Betäubungsmitteln stand. Erfolgt keine
 * Angabe, ist nicht bekannt, ob BtM-Einfluss vorlag.
 */
@Serializable
public open class BtMeinfluss() {
  public var ja: BtMeinflussJa? = null

  /**
   * Angabe, dass die Person zur Tatzeit nicht unter BtM-Einfluss stand.
   */
  public var nein: Boolean? = true

  public constructor(ja: BtMeinflussJa?, nein: Boolean?) : this() {
    this.ja = ja
    this.nein = nein
  }
}
