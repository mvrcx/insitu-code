package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheVerkehrsweg() {
  public var bezeichnung: CIMPSucheString? = null

  public var netzknotenVon: CIMPSucheString? = null

  public var netzknotenBis: CIMPSucheString? = null

  public var kmAngabe: CIMPSucheNumerischerWert? = null

  public var stationierungssystem: SucheStationierungssystem? = null

  public constructor(
      bezeichnung: CIMPSucheString?,
      netzknotenVon: CIMPSucheString?,
      netzknotenBis: CIMPSucheString?,
      kmAngabe: CIMPSucheNumerischerWert?,
      stationierungssystem: SucheStationierungssystem?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.netzknotenVon = netzknotenVon
    this.netzknotenBis = netzknotenBis
    this.kmAngabe = kmAngabe
    this.stationierungssystem = stationierungssystem
  }
}
