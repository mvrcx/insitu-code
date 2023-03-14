package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung_Verkehrsunfall_Organisation() : SucheBeziehung() {
  public var ordnungsnummer: CIMPSucheString? = null

  public var schaden: SucheGeldbetrag? = null

  public var verkehrsbeteiligungFahrzeugbezogen: CIMPSucheKatalogWert? = null

  public var gefahrgutangabe: SucheGefahrgut? = null

  public constructor(
      ordnungsnummer: CIMPSucheString?,
      schaden: SucheGeldbetrag?,
      verkehrsbeteiligungFahrzeugbezogen: CIMPSucheKatalogWert?,
      gefahrgutangabe: SucheGefahrgut?
  ) : this() {
    this.ordnungsnummer = ordnungsnummer
    this.schaden = schaden
    this.verkehrsbeteiligungFahrzeugbezogen = verkehrsbeteiligungFahrzeugbezogen
    this.gefahrgutangabe = gefahrgutangabe
  }
}
