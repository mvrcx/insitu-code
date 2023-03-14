package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung_Hinweis_Spur() : SucheBeziehung() {
  public var spurennummer: CIMPSucheString? = null

  public constructor(spurennummer: CIMPSucheString?) : this() {
    this.spurennummer = spurennummer
  }
}
