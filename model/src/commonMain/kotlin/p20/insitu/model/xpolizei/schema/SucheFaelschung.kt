package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheFaelschung() {
  public var art: CIMPSucheKatalogWert? = null

  public var merkmale: CIMPSucheString? = null

  public constructor(art: CIMPSucheKatalogWert?, merkmale: CIMPSucheString?) : this() {
    this.art = art
    this.merkmale = merkmale
  }
}
