package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheFaelschungUrkunde() {
  public var art: CIMPSucheKatalogWert? = null

  public var merkmal: List<CIMPSucheKatalogWert>? = null

  public constructor(art: CIMPSucheKatalogWert?, merkmal: List<CIMPSucheKatalogWert>?) : this() {
    this.art = art
    this.merkmal = merkmal
  }
}
