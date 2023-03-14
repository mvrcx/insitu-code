package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheStadionverbot() {
  public var vereinszuordnung: CIMPSucheKatalogWert? = null

  public var beginn: CIMPSucheDatum? = null

  public var ende: CIMPSucheDatum? = null

  public var voraussichtlichesEnde: CIMPSucheDatum? = null

  public var geltungsbereich: SucheGeltungsbereich? = null

  public constructor(
      vereinszuordnung: CIMPSucheKatalogWert?,
      beginn: CIMPSucheDatum?,
      ende: CIMPSucheDatum?,
      voraussichtlichesEnde: CIMPSucheDatum?,
      geltungsbereich: SucheGeltungsbereich?
  ) : this() {
    this.vereinszuordnung = vereinszuordnung
    this.beginn = beginn
    this.ende = ende
    this.voraussichtlichesEnde = voraussichtlichesEnde
    this.geltungsbereich = geltungsbereich
  }
}
