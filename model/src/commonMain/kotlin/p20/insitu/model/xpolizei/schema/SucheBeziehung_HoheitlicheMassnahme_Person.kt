package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung_HoheitlicheMassnahme_Person() : SucheBeziehung() {
  public var aussonderungspruefdatum: CIMPSucheDatum? = null

  public var dSStatus: SucheDatenschutzrechtlicherStatus? = null

  public var gefaehrdungsstufe: CIMPSucheKatalogWert? = null

  public constructor(
      aussonderungspruefdatum: CIMPSucheDatum?,
      dSStatus: SucheDatenschutzrechtlicherStatus?,
      gefaehrdungsstufe: CIMPSucheKatalogWert?
  ) : this() {
    this.aussonderungspruefdatum = aussonderungspruefdatum
    this.dSStatus = dSStatus
    this.gefaehrdungsstufe = gefaehrdungsstufe
  }
}
