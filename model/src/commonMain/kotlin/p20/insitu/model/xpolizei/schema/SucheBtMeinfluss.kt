package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlinx.serialization.Serializable

@Serializable
public open class SucheBtMeinfluss() {
  public var ja: SucheBtMeinflussJa? = null

  public var nein: Boolean? = true

  public constructor(ja: SucheBtMeinflussJa?, nein: Boolean?) : this() {
    this.ja = ja
    this.nein = nein
  }
}
