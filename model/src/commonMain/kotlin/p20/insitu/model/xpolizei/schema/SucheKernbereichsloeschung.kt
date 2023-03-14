package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheKernbereichsloeschung() {
  public var status: CIMPSucheKatalogWert? = null

  public var zeitpunkt: SucheDatumZeit? = null

  public constructor(status: CIMPSucheKatalogWert?, zeitpunkt: SucheDatumZeit?) : this() {
    this.status = status
    this.zeitpunkt = zeitpunkt
  }
}
