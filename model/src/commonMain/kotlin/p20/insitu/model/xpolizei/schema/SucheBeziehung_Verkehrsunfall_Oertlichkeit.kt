package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung_Verkehrsunfall_Oertlichkeit() : SucheBeziehung() {
  public var charakteristik: List<CIMPSucheKatalogWert>? = null

  public var besonderheit: List<CIMPSucheKatalogWert>? = null

  public constructor(charakteristik: List<CIMPSucheKatalogWert>?,
                     besonderheit: List<CIMPSucheKatalogWert>?) : this() {
    this.charakteristik = charakteristik
    this.besonderheit = besonderheit
  }
}
