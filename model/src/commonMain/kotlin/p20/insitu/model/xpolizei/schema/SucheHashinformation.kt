package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheHashinformation() {
  public var hashfunktion: CIMPSucheKatalogWert? = null

  public var hashwert: CIMPSucheString? = null

  public constructor(hashfunktion: CIMPSucheKatalogWert?, hashwert: CIMPSucheString?) : this() {
    this.hashfunktion = hashfunktion
    this.hashwert = hashwert
  }
}
