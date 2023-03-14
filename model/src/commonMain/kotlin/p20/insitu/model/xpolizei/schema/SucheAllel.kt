package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheAllel() {
  public var auspraegung: CIMPSucheKatalogWert? = null

  public var untergrenze: CIMPSucheString? = null

  public var obergrenze: CIMPSucheString? = null

  public constructor(
      auspraegung: CIMPSucheKatalogWert?,
      untergrenze: CIMPSucheString?,
      obergrenze: CIMPSucheString?
  ) : this() {
    this.auspraegung = auspraegung
    this.untergrenze = untergrenze
    this.obergrenze = obergrenze
  }
}
