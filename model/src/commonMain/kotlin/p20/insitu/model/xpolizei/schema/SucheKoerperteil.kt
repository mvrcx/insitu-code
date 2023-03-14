package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheKoerperteil() : SucheAllgemeineBasisklasse() {
  public var art: SucheKoerperteilangabe? = null

  public var bergungsnummer: CIMPSucheString? = null

  public var identifizierungsnummer: CIMPSucheString? = null

  public var kind: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var verletzung: List<SucheVerletzung>? = null

  public var merkmal: List<SucheMerkmal>? = null

  public var taetowierung: List<SucheTaetowierung>? = null

  public var gebiss: SucheGebiss? = null

  public var asservat: SucheAsservat? = null

  public var dokument: List<SucheDokument>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public constructor(
      art: SucheKoerperteilangabe?,
      bergungsnummer: CIMPSucheString?,
      identifizierungsnummer: CIMPSucheString?,
      kind: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      verletzung: List<SucheVerletzung>?,
      merkmal: List<SucheMerkmal>?,
      taetowierung: List<SucheTaetowierung>?,
      gebiss: SucheGebiss?,
      asservat: SucheAsservat?,
      dokument: List<SucheDokument>?,
      redundanzinformation: SucheRedundanzinformation?
  ) : this() {
    this.art = art
    this.bergungsnummer = bergungsnummer
    this.identifizierungsnummer = identifizierungsnummer
    this.kind = kind
    this.bemerkung = bemerkung
    this.verletzung = verletzung
    this.merkmal = merkmal
    this.taetowierung = taetowierung
    this.gebiss = gebiss
    this.asservat = asservat
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
  }
}
