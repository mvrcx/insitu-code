package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheFinanztransaktion() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var geschaeftsart: CIMPSucheString? = null

  public var verwendungszweck: CIMPSucheString? = null

  public var restbuchungstext: CIMPSucheString? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var buchungsdatum: SucheDatumZeit? = null

  public var saldoQuellkonto: SucheGeldbetrag? = null

  public var saldoZielkonto: SucheGeldbetrag? = null

  public var transaktionsbetrag: SucheGeldbetrag? = null

  public var valutadatum: SucheDatumZeit? = null

  public var transaktionsdatum: SucheDatumZeit? = null

  public var dokument: List<SucheDokument>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var sEPAPurposeCode: CIMPSucheKatalogWert? = null

  public var transaktionsID: CIMPSucheString? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      geschaeftsart: CIMPSucheString?,
      verwendungszweck: CIMPSucheString?,
      restbuchungstext: CIMPSucheString?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      buchungsdatum: SucheDatumZeit?,
      saldoQuellkonto: SucheGeldbetrag?,
      saldoZielkonto: SucheGeldbetrag?,
      transaktionsbetrag: SucheGeldbetrag?,
      valutadatum: SucheDatumZeit?,
      transaktionsdatum: SucheDatumZeit?,
      dokument: List<SucheDokument>?,
      redundanzinformation: SucheRedundanzinformation?,
      sEPAPurposeCode: CIMPSucheKatalogWert?,
      transaktionsID: CIMPSucheString?
  ) : this() {
    this.art = art
    this.geschaeftsart = geschaeftsart
    this.verwendungszweck = verwendungszweck
    this.restbuchungstext = restbuchungstext
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.buchungsdatum = buchungsdatum
    this.saldoQuellkonto = saldoQuellkonto
    this.saldoZielkonto = saldoZielkonto
    this.transaktionsbetrag = transaktionsbetrag
    this.valutadatum = valutadatum
    this.transaktionsdatum = transaktionsdatum
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.sEPAPurposeCode = sEPAPurposeCode
    this.transaktionsID = transaktionsID
  }
}
