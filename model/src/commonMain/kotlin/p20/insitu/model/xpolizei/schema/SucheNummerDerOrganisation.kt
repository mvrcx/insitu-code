package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheNummerDerOrganisation() {
  public var art: CIMPSucheKatalogWert? = null

  public var nummer: SucheNummer? = null

  public constructor(art: CIMPSucheKatalogWert?, nummer: SucheNummer?) : this() {
    this.art = art
    this.nummer = nummer
  }
}
