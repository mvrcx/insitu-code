package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheSprengvorrichtung_Brandvorrichtung() : SucheWaffe() {
  public var kategorie: CIMPSucheKatalogWert? = null

  public var art: CIMPSucheKatalogWert? = null

  public var attrappe: CIMPSucheKatalogWert? = null

  public var laborierung: CIMPSucheKatalogWert? = null

  public var herstellungsinformation: SucheHerstellungsinformation? = null

  public var erlaubnispflicht: CIMPSucheKatalogWert? = null

  public constructor(
      kategorie: CIMPSucheKatalogWert?,
      art: CIMPSucheKatalogWert?,
      attrappe: CIMPSucheKatalogWert?,
      laborierung: CIMPSucheKatalogWert?,
      herstellungsinformation: SucheHerstellungsinformation?,
      erlaubnispflicht: CIMPSucheKatalogWert?
  ) : this() {
    this.kategorie = kategorie
    this.art = art
    this.attrappe = attrappe
    this.laborierung = laborierung
    this.herstellungsinformation = herstellungsinformation
    this.erlaubnispflicht = erlaubnispflicht
  }
}
