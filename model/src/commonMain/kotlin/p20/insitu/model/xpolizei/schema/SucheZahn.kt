package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheZahn() {
  public var zahnnummer: CIMPSucheKatalogWert? = null

  public var zahnfarbe: CIMPSucheString? = null

  public var zahnstatus: CIMPSucheString? = null

  public var zahnzustand: CIMPSucheString? = null

  public var zahnmaterial: CIMPSucheString? = null

  public var zahnBemerkung: CIMPSucheString? = null

  public var zahnBesonderheiten: CIMPSucheString? = null

  public constructor(
      zahnnummer: CIMPSucheKatalogWert?,
      zahnfarbe: CIMPSucheString?,
      zahnstatus: CIMPSucheString?,
      zahnzustand: CIMPSucheString?,
      zahnmaterial: CIMPSucheString?,
      zahnBemerkung: CIMPSucheString?,
      zahnBesonderheiten: CIMPSucheString?
  ) : this() {
    this.zahnnummer = zahnnummer
    this.zahnfarbe = zahnfarbe
    this.zahnstatus = zahnstatus
    this.zahnzustand = zahnzustand
    this.zahnmaterial = zahnmaterial
    this.zahnBemerkung = zahnBemerkung
    this.zahnBesonderheiten = zahnBesonderheiten
  }
}
