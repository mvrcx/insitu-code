package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheAusgeuebteTaetigkeit() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var branche: CIMPSucheKatalogWert? = null

  public var einrichtung: CIMPSucheKatalogWert? = null

  public var funktion: CIMPSucheString? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var taetigkeitsBeginn: CIMPSucheDatum? = null

  public var taetigkeitsEnde: CIMPSucheDatum? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var ueberregionalTaetig: CIMPSucheKatalogWert? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      branche: CIMPSucheKatalogWert?,
      einrichtung: CIMPSucheKatalogWert?,
      funktion: CIMPSucheString?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      taetigkeitsBeginn: CIMPSucheDatum?,
      taetigkeitsEnde: CIMPSucheDatum?,
      redundanzinformation: SucheRedundanzinformation?,
      ueberregionalTaetig: CIMPSucheKatalogWert?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.branche = branche
    this.einrichtung = einrichtung
    this.funktion = funktion
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.taetigkeitsBeginn = taetigkeitsBeginn
    this.taetigkeitsEnde = taetigkeitsEnde
    this.redundanzinformation = redundanzinformation
    this.ueberregionalTaetig = ueberregionalTaetig
  }
}
