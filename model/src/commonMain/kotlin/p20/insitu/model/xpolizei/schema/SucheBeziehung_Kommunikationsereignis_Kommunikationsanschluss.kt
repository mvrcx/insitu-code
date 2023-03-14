package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung_Kommunikationsereignis_Kommunikationsanschluss() : SucheBeziehung()
    {
  public var dTMFDaten: List<CIMPSucheString>? = null

  public var iTUEGeodaten: List<SucheITUEOrtungsdaten>? = null

  public var statusNachrichtenuebertragung: CIMPSucheKatalogWert? = null

  public constructor(
      dTMFDaten: List<CIMPSucheString>?,
      iTUEGeodaten: List<SucheITUEOrtungsdaten>?,
      statusNachrichtenuebertragung: CIMPSucheKatalogWert?
  ) : this() {
    this.dTMFDaten = dTMFDaten
    this.iTUEGeodaten = iTUEGeodaten
    this.statusNachrichtenuebertragung = statusNachrichtenuebertragung
  }
}
