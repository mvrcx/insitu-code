package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheLeiche() : SucheAllgemeineBasisklasse() {
  public var vollstaendigkeit: CIMPSucheKatalogWert? = null

  public var fehlendesKoerperteil: List<SucheKoerperteilangabe>? = null

  public var bergungsnummer: CIMPSucheString? = null

  public var identifizierungsnummer: CIMPSucheString? = null

  public var kind: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var asservat: SucheAsservat? = null

  public var dokument: List<SucheDokument>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public constructor(
      vollstaendigkeit: CIMPSucheKatalogWert?,
      fehlendesKoerperteil: List<SucheKoerperteilangabe>?,
      bergungsnummer: CIMPSucheString?,
      identifizierungsnummer: CIMPSucheString?,
      kind: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      asservat: SucheAsservat?,
      dokument: List<SucheDokument>?,
      redundanzinformation: SucheRedundanzinformation?
  ) : this() {
    this.vollstaendigkeit = vollstaendigkeit
    this.fehlendesKoerperteil = fehlendesKoerperteil
    this.bergungsnummer = bergungsnummer
    this.identifizierungsnummer = identifizierungsnummer
    this.kind = kind
    this.bemerkung = bemerkung
    this.asservat = asservat
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
  }
}
