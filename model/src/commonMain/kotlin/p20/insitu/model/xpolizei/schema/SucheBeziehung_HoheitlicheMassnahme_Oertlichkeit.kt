package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung_HoheitlicheMassnahme_Oertlichkeit() : SucheBeziehung() {
  public var gefaehrdungsstufe: CIMPSucheKatalogWert? = null

  public constructor(gefaehrdungsstufe: CIMPSucheKatalogWert?) : this() {
    this.gefaehrdungsstufe = gefaehrdungsstufe
  }
}
