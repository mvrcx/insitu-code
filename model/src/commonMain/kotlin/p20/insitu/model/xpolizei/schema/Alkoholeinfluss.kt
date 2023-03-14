package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlinx.serialization.Serializable

/**
 * Angabe, ob die Person unter Einfluss von Alkohol stand. Erfolgt keine Angabe, ist nicht bekannt,
 * ob Alkoholeinfluss vorlag.
 */
@Serializable
public open class Alkoholeinfluss() {
  public var ja: AlkoholeinflussJa? = null

  /**
   * Angabe, dass die Person nicht unter Alkoholeinfluss stand.
   */
  public var nein: Boolean? = true

  public constructor(ja: AlkoholeinflussJa?, nein: Boolean?) : this() {
    this.ja = ja
    this.nein = nein
  }
}
