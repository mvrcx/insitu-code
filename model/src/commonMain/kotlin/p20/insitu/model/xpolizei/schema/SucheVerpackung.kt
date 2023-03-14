package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheVerpackung() {
  public var primaerverpackung: CIMPSucheString? = null

  public var sekundaerverpackung: CIMPSucheString? = null

  public var beipackzettel: CIMPSucheKatalogWert? = null

  public constructor(
      primaerverpackung: CIMPSucheString?,
      sekundaerverpackung: CIMPSucheString?,
      beipackzettel: CIMPSucheKatalogWert?
  ) : this() {
    this.primaerverpackung = primaerverpackung
    this.sekundaerverpackung = sekundaerverpackung
    this.beipackzettel = beipackzettel
  }
}
