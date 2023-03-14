package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheMunition() : SucheWaffe() {
  public var art: CIMPSucheKatalogWert? = null

  public var kaliberXWaffe: CIMPSucheKatalogWert? = null

  public var bodenstempel: CIMPSucheString? = null

  public var eUKategorie: CIMPSucheKatalogWert? = null

  public var herstellungsinformation: SucheHerstellungsinformation? = null

  public var kaliber: CIMPSucheKatalogWert? = null

  public var erlaubnispflicht: CIMPSucheKatalogWert? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      kaliberXWaffe: CIMPSucheKatalogWert?,
      bodenstempel: CIMPSucheString?,
      eUKategorie: CIMPSucheKatalogWert?,
      herstellungsinformation: SucheHerstellungsinformation?,
      kaliber: CIMPSucheKatalogWert?,
      erlaubnispflicht: CIMPSucheKatalogWert?
  ) : this() {
    this.art = art
    this.kaliberXWaffe = kaliberXWaffe
    this.bodenstempel = bodenstempel
    this.eUKategorie = eUKategorie
    this.herstellungsinformation = herstellungsinformation
    this.kaliber = kaliber
    this.erlaubnispflicht = erlaubnispflicht
  }
}
