package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheKommunikationsanschluss() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var kennung: CIMPSucheString? = null

  public var netzbetreiber: CIMPSucheString? = null

  public var technischeKennung: List<CIMPSucheString>? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var serviceprovider: CIMPSucheString? = null

  public var serviceanschluss: CIMPSucheKatalogWert? = null

  public var rufnummer: SucheRufnummer? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      kennung: CIMPSucheString?,
      netzbetreiber: CIMPSucheString?,
      technischeKennung: List<CIMPSucheString>?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      redundanzinformation: SucheRedundanzinformation?,
      serviceprovider: CIMPSucheString?,
      serviceanschluss: CIMPSucheKatalogWert?,
      rufnummer: SucheRufnummer?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.kennung = kennung
    this.netzbetreiber = netzbetreiber
    this.technischeKennung = technischeKennung
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.redundanzinformation = redundanzinformation
    this.serviceprovider = serviceprovider
    this.serviceanschluss = serviceanschluss
    this.rufnummer = rufnummer
  }
}
