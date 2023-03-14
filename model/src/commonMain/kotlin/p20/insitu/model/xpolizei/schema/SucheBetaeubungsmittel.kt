package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheBetaeubungsmittel() : SucheArznei_Betaeubungsmittel_Grundstoff() {
  public var art: CIMPSucheKatalogWert? = null

  public var beschaffenheit: CIMPSucheKatalogWert? = null

  public var verpackungsart: CIMPSucheString? = null

  public var stueckzahl: CIMPSucheIntegerWert? = null

  public var farbangabe: List<SucheFarbangabe>? = null

  public var zusammensetzung: List<SucheInhaltsstoff>? = null

  public var logo: SucheLogo? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      beschaffenheit: CIMPSucheKatalogWert?,
      verpackungsart: CIMPSucheString?,
      stueckzahl: CIMPSucheIntegerWert?,
      farbangabe: List<SucheFarbangabe>?,
      zusammensetzung: List<SucheInhaltsstoff>?,
      logo: SucheLogo?
  ) : this() {
    this.art = art
    this.beschaffenheit = beschaffenheit
    this.verpackungsart = verpackungsart
    this.stueckzahl = stueckzahl
    this.farbangabe = farbangabe
    this.zusammensetzung = zusammensetzung
    this.logo = logo
  }
}
