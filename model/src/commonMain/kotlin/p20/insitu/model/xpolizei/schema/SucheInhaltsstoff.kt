package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheInhaltsstoff() {
  public var inhaltsstoff: CIMPSucheString? = null

  public var anteilInProzent: CIMPSucheNumerischerWert? = null

  public var volumen: SucheVolumen? = null

  public var gewicht: SucheGewicht? = null

  public constructor(
      inhaltsstoff: CIMPSucheString?,
      anteilInProzent: CIMPSucheNumerischerWert?,
      volumen: SucheVolumen?,
      gewicht: SucheGewicht?
  ) : this() {
    this.inhaltsstoff = inhaltsstoff
    this.anteilInProzent = anteilInProzent
    this.volumen = volumen
    this.gewicht = gewicht
  }
}
