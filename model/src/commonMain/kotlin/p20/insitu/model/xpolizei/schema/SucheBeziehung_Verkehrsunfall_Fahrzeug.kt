package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung_Verkehrsunfall_Fahrzeug() : SucheBeziehung() {
  public var anzahlBenutzer: CIMPSucheIntegerWert? = null

  public var nichtFahrbereit: CIMPSucheKatalogWert? = null

  public constructor(anzahlBenutzer: CIMPSucheIntegerWert?, nichtFahrbereit: CIMPSucheKatalogWert?)
      : this() {
    this.anzahlBenutzer = anzahlBenutzer
    this.nichtFahrbereit = nichtFahrbereit
  }
}
