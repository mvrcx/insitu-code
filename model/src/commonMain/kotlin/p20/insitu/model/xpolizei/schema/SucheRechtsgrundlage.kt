package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheRechtsgrundlage() {
  public var strafprozessordnung: CIMPSucheKatalogWert? = null

  public var polizeigesetz: CIMPSucheKatalogWert? = null

  public var sonstigesGesetz: CIMPSucheKatalogWert? = null

  public constructor(
      strafprozessordnung: CIMPSucheKatalogWert?,
      polizeigesetz: CIMPSucheKatalogWert?,
      sonstigesGesetz: CIMPSucheKatalogWert?
  ) : this() {
    this.strafprozessordnung = strafprozessordnung
    this.polizeigesetz = polizeigesetz
    this.sonstigesGesetz = sonstigesGesetz
  }
}
