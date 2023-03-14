package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheExplosionsgefaehrlicherStoff() : SucheWaffe() {
  public var art: CIMPSucheKatalogWert? = null

  public var bAMZulassungszeichen: CIMPSucheString? = null

  public var laborierung: CIMPSucheKatalogWert? = null

  public var herstellungsinformation: SucheHerstellungsinformation? = null

  public var volumen: SucheVolumen? = null

  public var erlaubnispflicht: CIMPSucheKatalogWert? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      bAMZulassungszeichen: CIMPSucheString?,
      laborierung: CIMPSucheKatalogWert?,
      herstellungsinformation: SucheHerstellungsinformation?,
      volumen: SucheVolumen?,
      erlaubnispflicht: CIMPSucheKatalogWert?
  ) : this() {
    this.art = art
    this.bAMZulassungszeichen = bAMZulassungszeichen
    this.laborierung = laborierung
    this.herstellungsinformation = herstellungsinformation
    this.volumen = volumen
    this.erlaubnispflicht = erlaubnispflicht
  }
}
