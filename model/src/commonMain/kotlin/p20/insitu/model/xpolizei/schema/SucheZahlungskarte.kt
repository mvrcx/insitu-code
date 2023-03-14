package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheZahlungskarte() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var faelschungsart: CIMPSucheKatalogWert? = null

  public var emittent: CIMPSucheString? = null

  public var dachmarkengesellschaft: CIMPSucheKatalogWert? = null

  public var nummer: CIMPSucheString? = null

  public var nummerCodiert: CIMPSucheString? = null

  public var name: CIMPSucheString? = null

  public var nameCodiert: CIMPSucheString? = null

  public var merkmalMikroschrift: CIMPSucheKatalogWert? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var gueltigBis: CIMPSucheDatum? = null

  public var gueltigVon: CIMPSucheDatum? = null

  public var konto: SucheBankkontoinformation? = null

  public var dokument: List<SucheDokument>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var bezeichnung: CIMPSucheString? = null

  public var asservat: SucheAsservat? = null

  public var stueckzahl: CIMPSucheIntegerWert? = null

  public var guthaben: SucheGeldbetrag? = null

  public var sachgebundenerHinweis: List<CIMPSucheString>? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      faelschungsart: CIMPSucheKatalogWert?,
      emittent: CIMPSucheString?,
      dachmarkengesellschaft: CIMPSucheKatalogWert?,
      nummer: CIMPSucheString?,
      nummerCodiert: CIMPSucheString?,
      name: CIMPSucheString?,
      nameCodiert: CIMPSucheString?,
      merkmalMikroschrift: CIMPSucheKatalogWert?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      gueltigBis: CIMPSucheDatum?,
      gueltigVon: CIMPSucheDatum?,
      konto: SucheBankkontoinformation?,
      dokument: List<SucheDokument>?,
      redundanzinformation: SucheRedundanzinformation?,
      bezeichnung: CIMPSucheString?,
      asservat: SucheAsservat?,
      stueckzahl: CIMPSucheIntegerWert?,
      guthaben: SucheGeldbetrag?,
      sachgebundenerHinweis: List<CIMPSucheString>?
  ) : this() {
    this.art = art
    this.faelschungsart = faelschungsart
    this.emittent = emittent
    this.dachmarkengesellschaft = dachmarkengesellschaft
    this.nummer = nummer
    this.nummerCodiert = nummerCodiert
    this.name = name
    this.nameCodiert = nameCodiert
    this.merkmalMikroschrift = merkmalMikroschrift
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.gueltigBis = gueltigBis
    this.gueltigVon = gueltigVon
    this.konto = konto
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.bezeichnung = bezeichnung
    this.asservat = asservat
    this.stueckzahl = stueckzahl
    this.guthaben = guthaben
    this.sachgebundenerHinweis = sachgebundenerHinweis
  }
}
