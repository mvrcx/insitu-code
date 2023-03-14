package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSucheGekreuzteNamen() {
  public var vorname: SucheNamensangabe? = null

  public var familienname: SucheNamensangabe? = null

  public constructor(vorname: SucheNamensangabe?, familienname: SucheNamensangabe?) : this() {
    this.vorname = vorname
    this.familienname = familienname
  }
}
