package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheTeilnehmeranker() {
  public var art: CIMPSucheKatalogWert? = null

  public var iD: CIMPSucheString? = null

  public constructor(art: CIMPSucheKatalogWert?, iD: CIMPSucheString?) : this() {
    this.art = art
    this.iD = iD
  }
}
