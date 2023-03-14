package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheBtMeinflussJa() {
  public var ja: Boolean? = true

  public var art: List<CIMPSucheKatalogWert>? = null

  public constructor(ja: Boolean?, art: List<CIMPSucheKatalogWert>?) : this() {
    this.ja = ja
    this.art = art
  }
}
