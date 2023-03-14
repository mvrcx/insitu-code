package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheModusOperandi() {
  public var art: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var tatphase: CIMPSucheKatalogWert? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      tatphase: CIMPSucheKatalogWert?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.tatphase = tatphase
  }
}
