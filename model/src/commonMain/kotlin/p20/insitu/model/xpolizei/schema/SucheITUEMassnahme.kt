package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheITUEMassnahme() : SucheAllgemeineBasisklasse() {
  public var bezeichnung: CIMPSucheString? = null

  public var leitungsnummer: CIMPSucheString? = null

  public var bemerkung: CIMPSucheString? = null

  public var sachbearbeitung: List<SucheBeteiligteStelleBeteiligungsart>? = null

  public var ende: SucheDatumZeit? = null

  public var beginn: SucheDatumZeit? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var beschlussinformationen: List<SucheBeschlussinformation>? = null

  public var unterbrechung: List<SucheUnterbrechung>? = null

  public var art: CIMPSucheKatalogWert? = null

  public constructor(
      bezeichnung: CIMPSucheString?,
      leitungsnummer: CIMPSucheString?,
      bemerkung: CIMPSucheString?,
      sachbearbeitung: List<SucheBeteiligteStelleBeteiligungsart>?,
      ende: SucheDatumZeit?,
      beginn: SucheDatumZeit?,
      redundanzinformation: SucheRedundanzinformation?,
      beschlussinformationen: List<SucheBeschlussinformation>?,
      unterbrechung: List<SucheUnterbrechung>?,
      art: CIMPSucheKatalogWert?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.leitungsnummer = leitungsnummer
    this.bemerkung = bemerkung
    this.sachbearbeitung = sachbearbeitung
    this.ende = ende
    this.beginn = beginn
    this.redundanzinformation = redundanzinformation
    this.beschlussinformationen = beschlussinformationen
    this.unterbrechung = unterbrechung
    this.art = art
  }
}
