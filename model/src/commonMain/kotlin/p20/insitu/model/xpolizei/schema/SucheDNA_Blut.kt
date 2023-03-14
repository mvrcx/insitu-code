package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheDNA_Blut() : SucheAllgemeineBasisklasse() {
  public var blutgruppe: CIMPSucheKatalogWert? = null

  public var rhesusfaktor: CIMPSucheKatalogWert? = null

  public var anonymisierungsformel: CIMPSucheString? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var allel: List<SucheAllel>? = null

  public constructor(
      blutgruppe: CIMPSucheKatalogWert?,
      rhesusfaktor: CIMPSucheKatalogWert?,
      anonymisierungsformel: CIMPSucheString?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      allel: List<SucheAllel>?
  ) : this() {
    this.blutgruppe = blutgruppe
    this.rhesusfaktor = rhesusfaktor
    this.anonymisierungsformel = anonymisierungsformel
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.allel = allel
  }
}
