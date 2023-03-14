package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheSchusswaffenzustandsinformation() {
  public var gesichert: CIMPSucheKatalogWert? = null

  public var sicherungVorhanden: CIMPSucheKatalogWert? = null

  public var artDesFeuermodus: CIMPSucheKatalogWert? = null

  public var durchgeladen: CIMPSucheKatalogWert? = null

  public var hahnGespannt: CIMPSucheKatalogWert? = null

  public var zustandLauf: CIMPSucheString? = null

  public var zustandVerschluss: CIMPSucheString? = null

  public constructor(
      gesichert: CIMPSucheKatalogWert?,
      sicherungVorhanden: CIMPSucheKatalogWert?,
      artDesFeuermodus: CIMPSucheKatalogWert?,
      durchgeladen: CIMPSucheKatalogWert?,
      hahnGespannt: CIMPSucheKatalogWert?,
      zustandLauf: CIMPSucheString?,
      zustandVerschluss: CIMPSucheString?
  ) : this() {
    this.gesichert = gesichert
    this.sicherungVorhanden = sicherungVorhanden
    this.artDesFeuermodus = artDesFeuermodus
    this.durchgeladen = durchgeladen
    this.hahnGespannt = hahnGespannt
    this.zustandLauf = zustandLauf
    this.zustandVerschluss = zustandVerschluss
  }
}
