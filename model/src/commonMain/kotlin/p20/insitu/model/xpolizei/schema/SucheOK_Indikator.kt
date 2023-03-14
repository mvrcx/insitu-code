package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheOK_Indikator() {
  public var art: CIMPSucheKatalogWert? = null

  public var bewertung: CIMPSucheKatalogWert? = null

  public constructor(art: CIMPSucheKatalogWert?, bewertung: CIMPSucheKatalogWert?) : this() {
    this.art = art
    this.bewertung = bewertung
  }
}
