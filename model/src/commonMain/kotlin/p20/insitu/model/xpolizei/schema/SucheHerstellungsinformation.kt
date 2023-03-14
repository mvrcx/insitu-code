package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheHerstellungsinformation() {
  public var herstellerbezeichnung: CIMPSucheString? = null

  public var herstellungsstaat: CIMPSucheKatalogWert? = null

  public var herstellungsdatum: CIMPSucheDatum? = null

  public constructor(
      herstellerbezeichnung: CIMPSucheString?,
      herstellungsstaat: CIMPSucheKatalogWert?,
      herstellungsdatum: CIMPSucheDatum?
  ) : this() {
    this.herstellerbezeichnung = herstellerbezeichnung
    this.herstellungsstaat = herstellungsstaat
    this.herstellungsdatum = herstellungsdatum
  }
}
