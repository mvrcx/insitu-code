package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SuchePersonenidentifikationsnummer() {
  public var nummer: SucheNummer? = null

  public var art: CIMPSucheKatalogWert? = null

  public constructor(nummer: SucheNummer?, art: CIMPSucheKatalogWert?) : this() {
    this.nummer = nummer
    this.art = art
  }
}
