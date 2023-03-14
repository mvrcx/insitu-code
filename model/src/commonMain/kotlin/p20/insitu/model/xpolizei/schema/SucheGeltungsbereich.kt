package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheGeltungsbereich() {
  public var bundesweit: CIMPSucheKatalogWert? = null

  public var ligaweit: CIMPSucheString? = null

  public var oertlich: CIMPSucheString? = null

  public constructor(
      bundesweit: CIMPSucheKatalogWert?,
      ligaweit: CIMPSucheString?,
      oertlich: CIMPSucheString?
  ) : this() {
    this.bundesweit = bundesweit
    this.ligaweit = ligaweit
    this.oertlich = oertlich
  }
}
