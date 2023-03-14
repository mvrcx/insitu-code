package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheStaatsangehoerigkeit() {
  public var staat: CIMPSucheKatalogWert? = null

  public var bis: CIMPSucheDatum? = null

  public var von: CIMPSucheDatum? = null

  public constructor(
      staat: CIMPSucheKatalogWert?,
      bis: CIMPSucheDatum?,
      von: CIMPSucheDatum?
  ) : this() {
    this.staat = staat
    this.bis = bis
    this.von = von
  }
}
