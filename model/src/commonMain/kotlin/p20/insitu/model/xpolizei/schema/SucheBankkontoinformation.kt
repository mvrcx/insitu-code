package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBankkontoinformation() {
  public var kontonummer: CIMPSucheString? = null

  public var bankleitzahl: CIMPSucheString? = null

  public var iBAN: CIMPSucheString? = null

  public var bIC: CIMPSucheString? = null

  public var bankname: CIMPSucheString? = null

  public var bankstandort: CIMPSucheString? = null

  public var staat: CIMPSucheKatalogWert? = null

  public constructor(
      kontonummer: CIMPSucheString?,
      bankleitzahl: CIMPSucheString?,
      iBAN: CIMPSucheString?,
      bIC: CIMPSucheString?,
      bankname: CIMPSucheString?,
      bankstandort: CIMPSucheString?,
      staat: CIMPSucheKatalogWert?
  ) : this() {
    this.kontonummer = kontonummer
    this.bankleitzahl = bankleitzahl
    this.iBAN = iBAN
    this.bIC = bIC
    this.bankname = bankname
    this.bankstandort = bankstandort
    this.staat = staat
  }
}
