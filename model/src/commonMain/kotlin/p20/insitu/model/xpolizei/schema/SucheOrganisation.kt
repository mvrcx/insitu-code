package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheOrganisation() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var zweck: CIMPSucheString? = null

  public var betaetigungsfeld: List<CIMPSucheKatalogWert>? = null

  public var volkszugehoerigkeit: CIMPSucheKatalogWert? = null

  public var nationaleZugehoerigkeit: CIMPSucheKatalogWert? = null

  public var gruendungsstaat: CIMPSucheKatalogWert? = null

  public var nationaleRechtsform: CIMPSucheKatalogWert? = null

  public var internationaleRechtsform: CIMPSucheString? = null

  public var branche: List<CIMPSucheKatalogWert>? = null

  public var aufloesungsgrund: CIMPSucheKatalogWert? = null

  public var ideologie: CIMPSucheKatalogWert? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var gruendungsdatum: CIMPSucheDatum? = null

  public var aufloesungsdatum: CIMPSucheDatum? = null

  public var vermoegen: SucheGeldbetrag? = null

  public var registereintrag: List<SucheRegistereintrag>? = null

  public var dokument: List<SucheDokument>? = null

  public var name: List<SucheNamensangabe>? = null

  public var abkuerzungName: List<SucheNamensangabe>? = null

  public var fruehererName: List<SucheNamensangabe>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var nummerDerOrganisation: List<SucheNummerDerOrganisation>? = null

  public var bezeichnung: CIMPSucheString? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      zweck: CIMPSucheString?,
      betaetigungsfeld: List<CIMPSucheKatalogWert>?,
      volkszugehoerigkeit: CIMPSucheKatalogWert?,
      nationaleZugehoerigkeit: CIMPSucheKatalogWert?,
      gruendungsstaat: CIMPSucheKatalogWert?,
      nationaleRechtsform: CIMPSucheKatalogWert?,
      internationaleRechtsform: CIMPSucheString?,
      branche: List<CIMPSucheKatalogWert>?,
      aufloesungsgrund: CIMPSucheKatalogWert?,
      ideologie: CIMPSucheKatalogWert?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      gruendungsdatum: CIMPSucheDatum?,
      aufloesungsdatum: CIMPSucheDatum?,
      vermoegen: SucheGeldbetrag?,
      registereintrag: List<SucheRegistereintrag>?,
      dokument: List<SucheDokument>?,
      name: List<SucheNamensangabe>?,
      abkuerzungName: List<SucheNamensangabe>?,
      fruehererName: List<SucheNamensangabe>?,
      redundanzinformation: SucheRedundanzinformation?,
      nummerDerOrganisation: List<SucheNummerDerOrganisation>?,
      bezeichnung: CIMPSucheString?
  ) : this() {
    this.art = art
    this.zweck = zweck
    this.betaetigungsfeld = betaetigungsfeld
    this.volkszugehoerigkeit = volkszugehoerigkeit
    this.nationaleZugehoerigkeit = nationaleZugehoerigkeit
    this.gruendungsstaat = gruendungsstaat
    this.nationaleRechtsform = nationaleRechtsform
    this.internationaleRechtsform = internationaleRechtsform
    this.branche = branche
    this.aufloesungsgrund = aufloesungsgrund
    this.ideologie = ideologie
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.gruendungsdatum = gruendungsdatum
    this.aufloesungsdatum = aufloesungsdatum
    this.vermoegen = vermoegen
    this.registereintrag = registereintrag
    this.dokument = dokument
    this.name = name
    this.abkuerzungName = abkuerzungName
    this.fruehererName = fruehererName
    this.redundanzinformation = redundanzinformation
    this.nummerDerOrganisation = nummerDerOrganisation
    this.bezeichnung = bezeichnung
  }
}
