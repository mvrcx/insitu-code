package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheReligionszugehoerigkeit() {
  public var religion: CIMPSucheKatalogWert? = null

  public var konvertiert: CIMPSucheKatalogWert? = null

  public var bis: CIMPSucheDatum? = null

  public var von: CIMPSucheDatum? = null

  public constructor(
      religion: CIMPSucheKatalogWert?,
      konvertiert: CIMPSucheKatalogWert?,
      bis: CIMPSucheDatum?,
      von: CIMPSucheDatum?
  ) : this() {
    this.religion = religion
    this.konvertiert = konvertiert
    this.bis = bis
    this.von = von
  }
}
