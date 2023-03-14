package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheGeoPoint() {
  public var geografischeLaenge: CIMPSucheNumerischerWert? = null

  public var geografischeBreite: CIMPSucheNumerischerWert? = null

  public constructor(geografischeLaenge: CIMPSucheNumerischerWert?,
                     geografischeBreite: CIMPSucheNumerischerWert?) : this() {
    this.geografischeLaenge = geografischeLaenge
    this.geografischeBreite = geografischeBreite
  }
}
