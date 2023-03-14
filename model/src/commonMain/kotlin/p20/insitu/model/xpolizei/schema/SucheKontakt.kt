package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheKontakt() {
  public var name: CIMPSucheString? = null

  public var eMail: CIMPSucheString? = null

  public var telefonnummer: CIMPSucheString? = null

  public var faxnummer: CIMPSucheString? = null

  public var uID: CIMPSucheString? = null

  public constructor(
      name: CIMPSucheString?,
      eMail: CIMPSucheString?,
      telefonnummer: CIMPSucheString?,
      faxnummer: CIMPSucheString?,
      uID: CIMPSucheString?
  ) : this() {
    this.name = name
    this.eMail = eMail
    this.telefonnummer = telefonnummer
    this.faxnummer = faxnummer
    this.uID = uID
  }
}
