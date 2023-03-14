package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeteiligteStelle() {
  public var art: CIMPSucheKatalogWert? = null

  public var aktenzeichen: List<CIMPSucheString>? = null

  public var bemerkung: CIMPSucheString? = null

  public var nationaleZugehoerigkeit: CIMPSucheKatalogWert? = null

  public var laenderschluessel: CIMPSucheKatalogWert? = null

  public var anschrift: SucheAnschrift? = null

  public var postfach: SuchePostfach? = null

  public var sachbearbeiter: List<SucheKontakt>? = null

  public var dienststelle: SucheKontakt? = null

  public var organisationseinheit: SucheKontakt? = null

  public var behoerdenkennzeichnung: SucheBehoerdenkennzeichnung? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      aktenzeichen: List<CIMPSucheString>?,
      bemerkung: CIMPSucheString?,
      nationaleZugehoerigkeit: CIMPSucheKatalogWert?,
      laenderschluessel: CIMPSucheKatalogWert?,
      anschrift: SucheAnschrift?,
      postfach: SuchePostfach?,
      sachbearbeiter: List<SucheKontakt>?,
      dienststelle: SucheKontakt?,
      organisationseinheit: SucheKontakt?,
      behoerdenkennzeichnung: SucheBehoerdenkennzeichnung?
  ) : this() {
    this.art = art
    this.aktenzeichen = aktenzeichen
    this.bemerkung = bemerkung
    this.nationaleZugehoerigkeit = nationaleZugehoerigkeit
    this.laenderschluessel = laenderschluessel
    this.anschrift = anschrift
    this.postfach = postfach
    this.sachbearbeiter = sachbearbeiter
    this.dienststelle = dienststelle
    this.organisationseinheit = organisationseinheit
    this.behoerdenkennzeichnung = behoerdenkennzeichnung
  }
}
