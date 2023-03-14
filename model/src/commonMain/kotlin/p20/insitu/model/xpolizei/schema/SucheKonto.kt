package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheKonto() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var waehrung: CIMPSucheKatalogWert? = null

  public var kontotyp: CIMPSucheKatalogWert? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var eroeffnungsdatum: CIMPSucheDatum? = null

  public var schliessungsdatum: CIMPSucheDatum? = null

  public var bankkontoinformation: SucheBankkontoinformation? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      waehrung: CIMPSucheKatalogWert?,
      kontotyp: CIMPSucheKatalogWert?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      eroeffnungsdatum: CIMPSucheDatum?,
      schliessungsdatum: CIMPSucheDatum?,
      bankkontoinformation: SucheBankkontoinformation?,
      redundanzinformation: SucheRedundanzinformation?
  ) : this() {
    this.art = art
    this.waehrung = waehrung
    this.kontotyp = kontotyp
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.eroeffnungsdatum = eroeffnungsdatum
    this.schliessungsdatum = schliessungsdatum
    this.bankkontoinformation = bankkontoinformation
    this.redundanzinformation = redundanzinformation
  }
}
