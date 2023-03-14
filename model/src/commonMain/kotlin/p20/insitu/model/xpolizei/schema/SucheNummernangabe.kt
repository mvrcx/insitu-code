package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheNummernangabe() {
  public var nummer: CIMPSucheString? = null

  public var bezeichnung: CIMPSucheString? = null

  public var individualnummer: CIMPSucheKatalogWert? = null

  public constructor(
      nummer: CIMPSucheString?,
      bezeichnung: CIMPSucheString?,
      individualnummer: CIMPSucheKatalogWert?
  ) : this() {
    this.nummer = nummer
    this.bezeichnung = bezeichnung
    this.individualnummer = individualnummer
  }
}
