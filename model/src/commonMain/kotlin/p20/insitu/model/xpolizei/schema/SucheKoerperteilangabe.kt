package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheKoerperteilangabe() {
  public var koerperteil: CIMPSucheKatalogWert? = null

  public var lagespezifikation: List<CIMPSucheKatalogWert>? = null

  public constructor(koerperteil: CIMPSucheKatalogWert?,
                     lagespezifikation: List<CIMPSucheKatalogWert>?) : this() {
    this.koerperteil = koerperteil
    this.lagespezifikation = lagespezifikation
  }
}
