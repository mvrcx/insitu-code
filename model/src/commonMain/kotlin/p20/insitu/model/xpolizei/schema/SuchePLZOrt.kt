package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SuchePLZOrt() {
  public var ortsname: CIMPSucheString? = null

  public var pLZ: CIMPSucheString? = null

  public var staat: CIMPSucheKatalogWert? = null

  public constructor(
      ortsname: CIMPSucheString?,
      pLZ: CIMPSucheString?,
      staat: CIMPSucheKatalogWert?
  ) : this() {
    this.ortsname = ortsname
    this.pLZ = pLZ
    this.staat = staat
  }
}
