package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheSchusswaffenherstellungsinformation() {
  public var hersteller: CIMPSucheKatalogWert? = null

  public var herstellungsstaat: CIMPSucheKatalogWert? = null

  public var herstellungsdatum: CIMPSucheDatum? = null

  public constructor(
      hersteller: CIMPSucheKatalogWert?,
      herstellungsstaat: CIMPSucheKatalogWert?,
      herstellungsdatum: CIMPSucheDatum?
  ) : this() {
    this.hersteller = hersteller
    this.herstellungsstaat = herstellungsstaat
    this.herstellungsdatum = herstellungsdatum
  }
}
