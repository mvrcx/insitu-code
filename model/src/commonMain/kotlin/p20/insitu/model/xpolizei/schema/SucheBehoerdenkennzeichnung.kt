package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBehoerdenkennzeichnung() {
  public var bezeichnung: CIMPSucheString? = null

  public var behoerdenkatalog: CIMPSucheKatalogWert? = null

  public constructor(bezeichnung: CIMPSucheString?, behoerdenkatalog: CIMPSucheKatalogWert?) :
      this() {
    this.bezeichnung = bezeichnung
    this.behoerdenkatalog = behoerdenkatalog
  }
}
