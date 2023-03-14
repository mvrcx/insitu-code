package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SuchePMK() {
  public var deliktsqualitaet: CIMPSucheKatalogWert? = null

  public var phaenomenbereich: CIMPSucheKatalogWert? = null

  public var extremismus: CIMPSucheKatalogWert? = null

  public var thema: List<CIMPSucheKatalogWert>? = null

  public var politischerKalender: CIMPSucheKatalogWert? = null

  public var schlagwort: List<CIMPSucheKatalogWert>? = null

  public var zusammenhangMitDemonstrativemEreignis: CIMPSucheKatalogWert? = null

  public var zusammenhangMitAuslandsereignis: CIMPSucheKatalogWert? = null

  public var internationaleBezuege: CIMPSucheKatalogWert? = null

  public constructor(
      deliktsqualitaet: CIMPSucheKatalogWert?,
      phaenomenbereich: CIMPSucheKatalogWert?,
      extremismus: CIMPSucheKatalogWert?,
      thema: List<CIMPSucheKatalogWert>?,
      politischerKalender: CIMPSucheKatalogWert?,
      schlagwort: List<CIMPSucheKatalogWert>?,
      zusammenhangMitDemonstrativemEreignis: CIMPSucheKatalogWert?,
      zusammenhangMitAuslandsereignis: CIMPSucheKatalogWert?,
      internationaleBezuege: CIMPSucheKatalogWert?
  ) : this() {
    this.deliktsqualitaet = deliktsqualitaet
    this.phaenomenbereich = phaenomenbereich
    this.extremismus = extremismus
    this.thema = thema
    this.politischerKalender = politischerKalender
    this.schlagwort = schlagwort
    this.zusammenhangMitDemonstrativemEreignis = zusammenhangMitDemonstrativemEreignis
    this.zusammenhangMitAuslandsereignis = zusammenhangMitAuslandsereignis
    this.internationaleBezuege = internationaleBezuege
  }
}
