package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheSprachangabe() {
  public var sprache: CIMPSucheKatalogWert? = null

  public var muttersprache: CIMPSucheKatalogWert? = null

  public var sprachniveau: CIMPSucheKatalogWert? = null

  public var akzent: CIMPSucheKatalogWert? = null

  public var mundart: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var feststellungsart: CIMPSucheKatalogWert? = null

  public var erkennungsrate: CIMPSucheNumerischerWert? = null

  public constructor(
      sprache: CIMPSucheKatalogWert?,
      muttersprache: CIMPSucheKatalogWert?,
      sprachniveau: CIMPSucheKatalogWert?,
      akzent: CIMPSucheKatalogWert?,
      mundart: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      feststellungsart: CIMPSucheKatalogWert?,
      erkennungsrate: CIMPSucheNumerischerWert?
  ) : this() {
    this.sprache = sprache
    this.muttersprache = muttersprache
    this.sprachniveau = sprachniveau
    this.akzent = akzent
    this.mundart = mundart
    this.bemerkung = bemerkung
    this.feststellungsart = feststellungsart
    this.erkennungsrate = erkennungsrate
  }
}
