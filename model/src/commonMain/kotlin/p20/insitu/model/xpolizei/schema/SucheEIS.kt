package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheEIS() {
  public var europolMandatsbereich: CIMPSucheKatalogWert? = null

  public var aussonderungspruefdatum: CIMPSucheDatum? = null

  public constructor(europolMandatsbereich: CIMPSucheKatalogWert?,
                     aussonderungspruefdatum: CIMPSucheDatum?) : this() {
    this.europolMandatsbereich = europolMandatsbereich
    this.aussonderungspruefdatum = aussonderungspruefdatum
  }
}
