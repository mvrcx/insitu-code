package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheGebiss() {
  public var auffaelligkeit: List<CIMPSucheKatalogWert>? = null

  public var zahn: List<SucheZahn>? = null

  public constructor(auffaelligkeit: List<CIMPSucheKatalogWert>?, zahn: List<SucheZahn>?) : this() {
    this.auffaelligkeit = auffaelligkeit
    this.zahn = zahn
  }
}
