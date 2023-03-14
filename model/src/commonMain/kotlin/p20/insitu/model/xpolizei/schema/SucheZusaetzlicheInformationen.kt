package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheZusaetzlicheInformationen() {
  public var bezeichnung: CIMPSucheString? = null

  public var vorhanden: CIMPSucheKatalogWert? = null

  public constructor(bezeichnung: CIMPSucheString?, vorhanden: CIMPSucheKatalogWert?) : this() {
    this.bezeichnung = bezeichnung
    this.vorhanden = vorhanden
  }
}
