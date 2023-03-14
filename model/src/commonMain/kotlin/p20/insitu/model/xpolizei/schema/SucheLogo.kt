package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheLogo() {
  public var aufbringungsart: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public constructor(aufbringungsart: CIMPSucheKatalogWert?, bezeichnung: CIMPSucheString?) :
      this() {
    this.aufbringungsart = aufbringungsart
    this.bezeichnung = bezeichnung
  }
}
