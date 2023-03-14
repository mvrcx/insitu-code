package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheAdresse() : SucheAllgemeineBasisklasse() {
  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var verwaltungspolitischeKodierung: SucheVerwaltungspolitischeKodierung? = null

  public var geokodierung: SucheGeometrie? = null

  public var dokument: List<SucheDokument>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var adresstyp: SucheAdresstyp? = null

  public var region: CIMPSucheString? = null

  public constructor(
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      verwaltungspolitischeKodierung: SucheVerwaltungspolitischeKodierung?,
      geokodierung: SucheGeometrie?,
      dokument: List<SucheDokument>?,
      redundanzinformation: SucheRedundanzinformation?,
      adresstyp: SucheAdresstyp?,
      region: CIMPSucheString?
  ) : this() {
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.verwaltungspolitischeKodierung = verwaltungspolitischeKodierung
    this.geokodierung = geokodierung
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.adresstyp = adresstyp
    this.region = region
  }
}
