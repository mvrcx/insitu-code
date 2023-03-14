package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheGefahrgut() {
  public var uNNummer: CIMPSucheKatalogWert? = null

  public var gefahrgutAusnahmeverordnung: CIMPSucheKatalogWert? = null

  public var gefahrgutfreisetzung: CIMPSucheKatalogWert? = null

  public constructor(
      uNNummer: CIMPSucheKatalogWert?,
      gefahrgutAusnahmeverordnung: CIMPSucheKatalogWert?,
      gefahrgutfreisetzung: CIMPSucheKatalogWert?
  ) : this() {
    this.uNNummer = uNNummer
    this.gefahrgutAusnahmeverordnung = gefahrgutAusnahmeverordnung
    this.gefahrgutfreisetzung = gefahrgutfreisetzung
  }
}
