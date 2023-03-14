package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheWaffenzubehoer_Waffenteil() : SucheWaffe() {
  public var art: CIMPSucheKatalogWert? = null

  public var herstellungsinformation: SucheHerstellungsinformation? = null

  public var erlaubnispflicht: CIMPSucheKatalogWert? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      herstellungsinformation: SucheHerstellungsinformation?,
      erlaubnispflicht: CIMPSucheKatalogWert?
  ) : this() {
    this.art = art
    this.herstellungsinformation = herstellungsinformation
    this.erlaubnispflicht = erlaubnispflicht
  }
}
