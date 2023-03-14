package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheErmittlungsunterstuetzenderHinweis() {
  public var eHW: CIMPSucheKatalogWert? = null

  public var eHWAuspraegung: List<CIMPSucheKatalogWert>? = null

  public constructor(eHW: CIMPSucheKatalogWert?, eHWAuspraegung: List<CIMPSucheKatalogWert>?) :
      this() {
    this.eHW = eHW
    this.eHWAuspraegung = eHWAuspraegung
  }
}
