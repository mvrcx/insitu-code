package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBenutzerkonto() : SucheAllgemeineBasisklasse() {
  public var bezeichnung: CIMPSucheString? = null

  public var fakeAccount: CIMPSucheKatalogWert? = null

  public var kennung: CIMPSucheString? = null

  public var passwort: CIMPSucheString? = null

  public var bemerkung: CIMPSucheString? = null

  public var benutzerID: CIMPSucheString? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public constructor(
      bezeichnung: CIMPSucheString?,
      fakeAccount: CIMPSucheKatalogWert?,
      kennung: CIMPSucheString?,
      passwort: CIMPSucheString?,
      bemerkung: CIMPSucheString?,
      benutzerID: CIMPSucheString?,
      redundanzinformation: SucheRedundanzinformation?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.fakeAccount = fakeAccount
    this.kennung = kennung
    this.passwort = passwort
    this.bemerkung = bemerkung
    this.benutzerID = benutzerID
    this.redundanzinformation = redundanzinformation
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
  }
}
