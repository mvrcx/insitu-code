package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSucheDatumBereich() {
  public var von: String? = null

  public var bis: String? = null

  public constructor(von: String?, bis: String?) : this() {
    this.von = von
    this.bis = bis
  }
}
