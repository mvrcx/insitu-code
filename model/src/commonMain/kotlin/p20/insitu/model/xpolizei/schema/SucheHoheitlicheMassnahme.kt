package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheHoheitlicheMassnahme() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var spezifikation: CIMPSucheString? = null

  public var verdeckteMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var beginn: SucheDatumZeit? = null

  public var ende: SucheDatumZeit? = null

  public var dokument: List<SucheDokument>? = null

  public var beteiligung: List<SucheBeteiligteStelleBeteiligungsart>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var prioritaet: CIMPSucheKatalogWert? = null

  public var widerspruch: CIMPSucheKatalogWert? = null

  public var spezifikationKatalogisiert: CIMPSucheKatalogWert? = null

  public var rechtsgrundlage: SucheRechtsgrundlage? = null

  public var hyDaNeKategorie: CIMPSucheKatalogWert? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      spezifikation: CIMPSucheString?,
      verdeckteMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      beginn: SucheDatumZeit?,
      ende: SucheDatumZeit?,
      dokument: List<SucheDokument>?,
      beteiligung: List<SucheBeteiligteStelleBeteiligungsart>?,
      redundanzinformation: SucheRedundanzinformation?,
      prioritaet: CIMPSucheKatalogWert?,
      widerspruch: CIMPSucheKatalogWert?,
      spezifikationKatalogisiert: CIMPSucheKatalogWert?,
      rechtsgrundlage: SucheRechtsgrundlage?,
      hyDaNeKategorie: CIMPSucheKatalogWert?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.spezifikation = spezifikation
    this.verdeckteMassnahme = verdeckteMassnahme
    this.bemerkung = bemerkung
    this.beginn = beginn
    this.ende = ende
    this.dokument = dokument
    this.beteiligung = beteiligung
    this.redundanzinformation = redundanzinformation
    this.prioritaet = prioritaet
    this.widerspruch = widerspruch
    this.spezifikationKatalogisiert = spezifikationKatalogisiert
    this.rechtsgrundlage = rechtsgrundlage
    this.hyDaNeKategorie = hyDaNeKategorie
  }
}
