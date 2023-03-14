package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheSchienenfahrzeug() : SucheFahrzeug() {
  public var art: CIMPSucheKatalogWert? = null

  public constructor(art: CIMPSucheKatalogWert?) : this() {
    this.art = art
  }
}
