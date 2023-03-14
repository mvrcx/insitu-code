package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheStationierungssystem() {
  public var abschnitt: CIMPSucheIntegerWert? = null

  public var station: CIMPSucheNumerischerWert? = null

  public var anschlussstelle: CIMPSucheString? = null

  public var astbezeichnung: CIMPSucheString? = null

  public var astkilometer: CIMPSucheNumerischerWert? = null

  public constructor(
      abschnitt: CIMPSucheIntegerWert?,
      station: CIMPSucheNumerischerWert?,
      anschlussstelle: CIMPSucheString?,
      astbezeichnung: CIMPSucheString?,
      astkilometer: CIMPSucheNumerischerWert?
  ) : this() {
    this.abschnitt = abschnitt
    this.station = station
    this.anschlussstelle = anschlussstelle
    this.astbezeichnung = astbezeichnung
    this.astkilometer = astkilometer
  }
}
