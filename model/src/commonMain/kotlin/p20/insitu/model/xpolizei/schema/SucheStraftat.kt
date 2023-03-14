package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheStraftat() : SucheAllgemeineBasisklasse() {
  public var delikt: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var spezifikation: CIMPSucheString? = null

  public var versuch: CIMPSucheKatalogWert? = null

  public var relevanz: List<CIMPSucheKatalogWert>? = null

  public var europaeischeStraftatenkategorie: List<CIMPSucheKatalogWert>? = null

  public var kurzdarstellung: CIMPSucheString? = null

  public var hoechstfreiheitsstrafe: CIMPSucheNumerischerWert? = null

  public var tatbestandsmerkmal: List<CIMPSucheKatalogWert>? = null

  public var ende: SucheDatumZeit? = null

  public var beginn: SucheDatumZeit? = null

  public var dokument: List<SucheDokument>? = null

  public var pMK: SuchePMK? = null

  public var gesamtschaden: SucheGeldbetrag? = null

  public var pKS: SuchePKS? = null

  public var feststellungszeit: SucheDatumZeit? = null

  public var modusOperandi: List<SucheModusOperandi>? = null

  public var redundanzinformation: SucheRedundanzinformation? = null

  public var opfertypus: List<CIMPSucheKatalogWert>? = null

  public var taetertypus: List<CIMPSucheKatalogWert>? = null

  public var eIS: SucheEIS? = null

  public var zukuenftigeStraftat: CIMPSucheKatalogWert? = null

  public var aSTRALSchluessel: CIMPSucheString? = null

  public var rechtsgut: List<CIMPSucheKatalogWert>? = null

  public var hyDaNeKennzeichnung: SucheHyDaNeKennzeichnung? = null

  public constructor(
      delikt: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      spezifikation: CIMPSucheString?,
      versuch: CIMPSucheKatalogWert?,
      relevanz: List<CIMPSucheKatalogWert>?,
      europaeischeStraftatenkategorie: List<CIMPSucheKatalogWert>?,
      kurzdarstellung: CIMPSucheString?,
      hoechstfreiheitsstrafe: CIMPSucheNumerischerWert?,
      tatbestandsmerkmal: List<CIMPSucheKatalogWert>?,
      ende: SucheDatumZeit?,
      beginn: SucheDatumZeit?,
      dokument: List<SucheDokument>?,
      pMK: SuchePMK?,
      gesamtschaden: SucheGeldbetrag?,
      pKS: SuchePKS?,
      feststellungszeit: SucheDatumZeit?,
      modusOperandi: List<SucheModusOperandi>?,
      redundanzinformation: SucheRedundanzinformation?,
      opfertypus: List<CIMPSucheKatalogWert>?,
      taetertypus: List<CIMPSucheKatalogWert>?,
      eIS: SucheEIS?,
      zukuenftigeStraftat: CIMPSucheKatalogWert?,
      aSTRALSchluessel: CIMPSucheString?,
      rechtsgut: List<CIMPSucheKatalogWert>?,
      hyDaNeKennzeichnung: SucheHyDaNeKennzeichnung?
  ) : this() {
    this.delikt = delikt
    this.bezeichnung = bezeichnung
    this.spezifikation = spezifikation
    this.versuch = versuch
    this.relevanz = relevanz
    this.europaeischeStraftatenkategorie = europaeischeStraftatenkategorie
    this.kurzdarstellung = kurzdarstellung
    this.hoechstfreiheitsstrafe = hoechstfreiheitsstrafe
    this.tatbestandsmerkmal = tatbestandsmerkmal
    this.ende = ende
    this.beginn = beginn
    this.dokument = dokument
    this.pMK = pMK
    this.gesamtschaden = gesamtschaden
    this.pKS = pKS
    this.feststellungszeit = feststellungszeit
    this.modusOperandi = modusOperandi
    this.redundanzinformation = redundanzinformation
    this.opfertypus = opfertypus
    this.taetertypus = taetertypus
    this.eIS = eIS
    this.zukuenftigeStraftat = zukuenftigeStraftat
    this.aSTRALSchluessel = aSTRALSchluessel
    this.rechtsgut = rechtsgut
    this.hyDaNeKennzeichnung = hyDaNeKennzeichnung
  }
}
