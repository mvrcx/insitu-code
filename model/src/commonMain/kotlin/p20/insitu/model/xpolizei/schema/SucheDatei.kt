package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheDatei() {
  public var daten: CIMPSucheDigitaleDaten? = null

  public var download: CIMPSucheString? = null

  public constructor(daten: CIMPSucheDigitaleDaten?, download: CIMPSucheString?) : this() {
    this.daten = daten
    this.download = download
  }
}
