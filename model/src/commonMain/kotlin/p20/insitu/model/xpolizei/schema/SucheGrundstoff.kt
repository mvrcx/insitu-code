package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheGrundstoff() : SucheArznei_Betaeubungsmittel_Grundstoff() {
  public var art: CIMPSucheKatalogWert? = null

  public constructor(art: CIMPSucheKatalogWert?) : this() {
    this.art = art
  }
}
