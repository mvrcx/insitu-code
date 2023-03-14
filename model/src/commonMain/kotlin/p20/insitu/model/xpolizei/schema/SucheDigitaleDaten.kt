package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheDigitaleDaten() {
  public var mimeType: CIMPSucheString? = null

  public var dateiID: CIMPSucheString? = null

  public var absenderID: CIMPSucheString? = null

  public var pruefsumme: CIMPSucheString? = null

  public var datei: SucheDatei? = null

  public constructor(
      mimeType: CIMPSucheString?,
      dateiID: CIMPSucheString?,
      absenderID: CIMPSucheString?,
      pruefsumme: CIMPSucheString?,
      datei: SucheDatei?
  ) : this() {
    this.mimeType = mimeType
    this.dateiID = dateiID
    this.absenderID = absenderID
    this.pruefsumme = pruefsumme
    this.datei = datei
  }
}
