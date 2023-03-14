package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung_Vorgang_Straftat() : SucheBeziehung() {
  public var fuehrungsdelikt: CIMPSucheKatalogWert? = null

  public constructor(fuehrungsdelikt: CIMPSucheKatalogWert?) : this() {
    this.fuehrungsdelikt = fuehrungsdelikt
  }
}
