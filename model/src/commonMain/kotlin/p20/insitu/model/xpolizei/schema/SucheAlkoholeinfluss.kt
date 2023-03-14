package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlinx.serialization.Serializable

@Serializable
public open class SucheAlkoholeinfluss() {
  public var ja: SucheAlkoholeinflussJa? = null

  public var nein: Boolean? = true

  public constructor(ja: SucheAlkoholeinflussJa?, nein: Boolean?) : this() {
    this.ja = ja
    this.nein = nein
  }
}
