package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheHyDaNeKennzeichnung() {
  public var hyDaNeKategorie: CIMPSucheKatalogWert? = null

  public var begruendungBeiAbweichung: CIMPSucheString? = null

  public constructor(hyDaNeKategorie: CIMPSucheKatalogWert?,
                     begruendungBeiAbweichung: CIMPSucheString?) : this() {
    this.hyDaNeKategorie = hyDaNeKategorie
    this.begruendungBeiAbweichung = begruendungBeiAbweichung
  }
}
