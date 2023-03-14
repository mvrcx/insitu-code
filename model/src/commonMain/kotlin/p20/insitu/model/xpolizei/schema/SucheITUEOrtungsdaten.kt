package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheITUEOrtungsdaten() {
  public var azimutWert: CIMPSucheNumerischerWert? = null

  public var gCID: CIMPSucheString? = null

  public var zeitpunkt: SucheDatumZeit? = null

  public var geokodierung: SucheGeometrie? = null

  public var geschwindigkeit: CIMPSucheNumerischerWert? = null

  public var standzeit: CIMPSucheDuration? = null

  public var satellitenanzahl: CIMPSucheIntegerWert? = null

  public var abweichung: CIMPSucheNumerischerWert? = null

  public var bewegungsrichtung: CIMPSucheKatalogWert? = null

  public var statusGPSPack: CIMPSucheKatalogWert? = null

  public var anschrift: SucheAnschrift? = null

  public constructor(
      azimutWert: CIMPSucheNumerischerWert?,
      gCID: CIMPSucheString?,
      zeitpunkt: SucheDatumZeit?,
      geokodierung: SucheGeometrie?,
      geschwindigkeit: CIMPSucheNumerischerWert?,
      standzeit: CIMPSucheDuration?,
      satellitenanzahl: CIMPSucheIntegerWert?,
      abweichung: CIMPSucheNumerischerWert?,
      bewegungsrichtung: CIMPSucheKatalogWert?,
      statusGPSPack: CIMPSucheKatalogWert?,
      anschrift: SucheAnschrift?
  ) : this() {
    this.azimutWert = azimutWert
    this.gCID = gCID
    this.zeitpunkt = zeitpunkt
    this.geokodierung = geokodierung
    this.geschwindigkeit = geschwindigkeit
    this.standzeit = standzeit
    this.satellitenanzahl = satellitenanzahl
    this.abweichung = abweichung
    this.bewegungsrichtung = bewegungsrichtung
    this.statusGPSPack = statusGPSPack
    this.anschrift = anschrift
  }
}
