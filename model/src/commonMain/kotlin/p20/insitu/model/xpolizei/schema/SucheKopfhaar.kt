package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheKopfhaar() {
  public var frisur: List<CIMPSucheKatalogWert>? = null

  public var farbe: List<CIMPSucheKatalogWert>? = null

  public var laenge: CIMPSucheKatalogWert? = null

  public var haarwuchs: List<CIMPSucheKatalogWert>? = null

  public var form: CIMPSucheKatalogWert? = null

  public constructor(
      frisur: List<CIMPSucheKatalogWert>?,
      farbe: List<CIMPSucheKatalogWert>?,
      laenge: CIMPSucheKatalogWert?,
      haarwuchs: List<CIMPSucheKatalogWert>?,
      form: CIMPSucheKatalogWert?
  ) : this() {
    this.frisur = frisur
    this.farbe = farbe
    this.laenge = laenge
    this.haarwuchs = haarwuchs
    this.form = form
  }
}
