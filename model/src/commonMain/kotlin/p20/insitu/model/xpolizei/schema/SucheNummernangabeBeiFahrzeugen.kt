package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheNummernangabeBeiFahrzeugen() {
  public var art: CIMPSucheKatalogWert? = null

  public var nummer: CIMPSucheString? = null

  public constructor(art: CIMPSucheKatalogWert?, nummer: CIMPSucheString?) : this() {
    this.art = art
    this.nummer = nummer
  }
}
