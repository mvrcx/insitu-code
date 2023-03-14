package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung_ITUEMassnahme_Kommunikationsereignis() : SucheBeziehung() {
  public var gespraechsklassifizierung: CIMPSucheKatalogWert? = null

  public constructor(gespraechsklassifizierung: CIMPSucheKatalogWert?) : this() {
    this.gespraechsklassifizierung = gespraechsklassifizierung
  }
}
