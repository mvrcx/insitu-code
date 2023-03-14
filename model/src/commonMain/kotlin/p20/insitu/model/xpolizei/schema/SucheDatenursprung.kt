package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheDatenursprung() {
  public var quelle: CIMPSucheKatalogWert? = null

  public var besonderheit: List<CIMPSucheKatalogWert>? = null

  public var quelleID: List<String>? = null

  public constructor(
      quelle: CIMPSucheKatalogWert?,
      besonderheit: List<CIMPSucheKatalogWert>?,
      quelleID: List<String>?
  ) : this() {
    this.quelle = quelle
    this.besonderheit = besonderheit
    this.quelleID = quelleID
  }
}
