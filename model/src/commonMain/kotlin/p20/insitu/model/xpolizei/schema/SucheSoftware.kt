package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheSoftware() : SucheAllgemeineBasisklasse() {
  public var schadsoftware: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var programmiersprache: CIMPSucheString? = null

  public var version: CIMPSucheString? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var hashinformation: List<SucheHashinformation>? = null

  public constructor(
      schadsoftware: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      programmiersprache: CIMPSucheString?,
      version: CIMPSucheString?,
      redundanzinformation: SucheRedundanzinformation?,
      hashinformation: List<SucheHashinformation>?
  ) : this() {
    this.schadsoftware = schadsoftware
    this.bezeichnung = bezeichnung
    this.programmiersprache = programmiersprache
    this.version = version
    this.redundanzinformation = redundanzinformation
    this.hashinformation = hashinformation
  }
}
