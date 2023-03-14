package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheVerboteneSubstanz() {
  public var art: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public constructor(art: CIMPSucheKatalogWert?, bezeichnung: CIMPSucheString?) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
  }
}
