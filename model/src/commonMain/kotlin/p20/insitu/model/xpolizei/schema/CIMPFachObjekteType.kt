package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Container für Fachobjekte
 */
@Serializable
public open class CIMPFachObjekteType() {
  public var adresse: List<Adresse>? = null

  public var allgemeinesEreignis: List<AllgemeinesEreignis>? = null

  public var aufzeichnung: List<Aufzeichnung>? = null

  public var ausgeuebteTaetigkeit: List<AusgeuebteTaetigkeit>? = null

  public var bargeld: List<Bargeld>? = null

  public var betaeubungsmittel: List<Betaeubungsmittel>? = null

  public var dNA_Blut: List<DNA_Blut>? = null

  public var explosionsgefaehrlicherStoff: List<ExplosionsgefaehrlicherStoff>? = null

  public var fahrrad: List<Fahrrad>? = null

  public var fahrzeug: List<Fahrzeug>? = null

  public var falschgeld: List<Falschgeld>? = null

  public var finanztransaktion: List<Finanztransaktion>? = null

  public var geld: List<Geld>? = null

  public var hinweis: List<Hinweis>? = null

  public var hoheitlicheMassnahme: List<HoheitlicheMassnahme>? = null

  public var internetressource: List<Internetressource>? = null

  public var kfzKennzeichenschild: List<KfzKennzeichenschild>? = null

  public var kommunikationsanschluss: List<Kommunikationsanschluss>? = null

  public var kommunikationsereignis: List<Kommunikationsereignis>? = null

  public var konto: List<Konto>? = null

  public var kraftfahrzeug: List<Kraftfahrzeug>? = null

  public var luftfahrzeug: List<Luftfahrzeug>? = null

  public var massenvernichtungswaffe: List<Massenvernichtungswaffe>? = null

  public var munition: List<Munition>? = null

  public var oertlichkeit: List<Oertlichkeit>? = null

  public var organisation: List<Organisation>? = null

  public var person: List<Person>? = null

  public var personalie: List<Personalie>? = null

  public var personenbeschreibung: List<Personenbeschreibung>? = null

  public var schienenfahrzeug: List<Schienenfahrzeug>? = null

  public var schusswaffe: List<Schusswaffe>? = null

  public var sonstigeSache: List<SonstigeSache>? = null

  public var sonstigesFahrzeug: List<SonstigesFahrzeug>? = null

  public var sprengvorrichtung_Brandvorrichtung: List<Sprengvorrichtung_Brandvorrichtung>? = null

  public var spurMateriell: List<SpurMateriell>? = null

  public var straftat: List<Straftat>? = null

  public var iTUEMassnahme: List<ITUEMassnahme>? = null

  public var tragbarerGegenstand: List<TragbarerGegenstand>? = null

  public var urkunde: List<Urkunde>? = null

  public var vorgang: List<Vorgang>? = null

  public var waffe: List<Waffe>? = null

  public var waffensystem: List<Waffensystem>? = null

  public var waffenzubehoer_Waffenteil: List<Waffenzubehoer_Waffenteil>? = null

  public var wasserfahrzeug: List<Wasserfahrzeug>? = null

  public var zahlungskarte: List<Zahlungskarte>? = null

  public var arznei_Betaeubungsmittel_Grundstoff: List<Arznei_Betaeubungsmittel_Grundstoff>? = null

  public var grundstoff: List<Grundstoff>? = null

  public var koerperteil: List<Koerperteil>? = null

  public var leiche: List<Leiche>? = null

  public var ordnungswidrigkeit: List<Ordnungswidrigkeit>? = null

  public var software: List<Software>? = null

  public var verkehrsunfall: List<Verkehrsunfall>? = null

  public var arzneimittel: List<Arzneimittel>? = null

  public var benutzerkonto: List<Benutzerkonto>? = null

  public constructor(
      adresse: List<Adresse>?,
      allgemeinesEreignis: List<AllgemeinesEreignis>?,
      aufzeichnung: List<Aufzeichnung>?,
      ausgeuebteTaetigkeit: List<AusgeuebteTaetigkeit>?,
      bargeld: List<Bargeld>?,
      betaeubungsmittel: List<Betaeubungsmittel>?,
      dNA_Blut: List<DNA_Blut>?,
      explosionsgefaehrlicherStoff: List<ExplosionsgefaehrlicherStoff>?,
      fahrrad: List<Fahrrad>?,
      fahrzeug: List<Fahrzeug>?,
      falschgeld: List<Falschgeld>?,
      finanztransaktion: List<Finanztransaktion>?,
      geld: List<Geld>?,
      hinweis: List<Hinweis>?,
      hoheitlicheMassnahme: List<HoheitlicheMassnahme>?,
      internetressource: List<Internetressource>?,
      kfzKennzeichenschild: List<KfzKennzeichenschild>?,
      kommunikationsanschluss: List<Kommunikationsanschluss>?,
      kommunikationsereignis: List<Kommunikationsereignis>?,
      konto: List<Konto>?,
      kraftfahrzeug: List<Kraftfahrzeug>?,
      luftfahrzeug: List<Luftfahrzeug>?,
      massenvernichtungswaffe: List<Massenvernichtungswaffe>?,
      munition: List<Munition>?,
      oertlichkeit: List<Oertlichkeit>?,
      organisation: List<Organisation>?,
      person: List<Person>?,
      personalie: List<Personalie>?,
      personenbeschreibung: List<Personenbeschreibung>?,
      schienenfahrzeug: List<Schienenfahrzeug>?,
      schusswaffe: List<Schusswaffe>?,
      sonstigeSache: List<SonstigeSache>?,
      sonstigesFahrzeug: List<SonstigesFahrzeug>?,
      sprengvorrichtung_Brandvorrichtung: List<Sprengvorrichtung_Brandvorrichtung>?,
      spurMateriell: List<SpurMateriell>?,
      straftat: List<Straftat>?,
      iTUEMassnahme: List<ITUEMassnahme>?,
      tragbarerGegenstand: List<TragbarerGegenstand>?,
      urkunde: List<Urkunde>?,
      vorgang: List<Vorgang>?,
      waffe: List<Waffe>?,
      waffensystem: List<Waffensystem>?,
      waffenzubehoer_Waffenteil: List<Waffenzubehoer_Waffenteil>?,
      wasserfahrzeug: List<Wasserfahrzeug>?,
      zahlungskarte: List<Zahlungskarte>?,
      arznei_Betaeubungsmittel_Grundstoff: List<Arznei_Betaeubungsmittel_Grundstoff>?,
      grundstoff: List<Grundstoff>?,
      koerperteil: List<Koerperteil>?,
      leiche: List<Leiche>?,
      ordnungswidrigkeit: List<Ordnungswidrigkeit>?,
      software: List<Software>?,
      verkehrsunfall: List<Verkehrsunfall>?,
      arzneimittel: List<Arzneimittel>?,
      benutzerkonto: List<Benutzerkonto>?
  ) : this() {
    this.adresse = adresse
    this.allgemeinesEreignis = allgemeinesEreignis
    this.aufzeichnung = aufzeichnung
    this.ausgeuebteTaetigkeit = ausgeuebteTaetigkeit
    this.bargeld = bargeld
    this.betaeubungsmittel = betaeubungsmittel
    this.dNA_Blut = dNA_Blut
    this.explosionsgefaehrlicherStoff = explosionsgefaehrlicherStoff
    this.fahrrad = fahrrad
    this.fahrzeug = fahrzeug
    this.falschgeld = falschgeld
    this.finanztransaktion = finanztransaktion
    this.geld = geld
    this.hinweis = hinweis
    this.hoheitlicheMassnahme = hoheitlicheMassnahme
    this.internetressource = internetressource
    this.kfzKennzeichenschild = kfzKennzeichenschild
    this.kommunikationsanschluss = kommunikationsanschluss
    this.kommunikationsereignis = kommunikationsereignis
    this.konto = konto
    this.kraftfahrzeug = kraftfahrzeug
    this.luftfahrzeug = luftfahrzeug
    this.massenvernichtungswaffe = massenvernichtungswaffe
    this.munition = munition
    this.oertlichkeit = oertlichkeit
    this.organisation = organisation
    this.person = person
    this.personalie = personalie
    this.personenbeschreibung = personenbeschreibung
    this.schienenfahrzeug = schienenfahrzeug
    this.schusswaffe = schusswaffe
    this.sonstigeSache = sonstigeSache
    this.sonstigesFahrzeug = sonstigesFahrzeug
    this.sprengvorrichtung_Brandvorrichtung = sprengvorrichtung_Brandvorrichtung
    this.spurMateriell = spurMateriell
    this.straftat = straftat
    this.iTUEMassnahme = iTUEMassnahme
    this.tragbarerGegenstand = tragbarerGegenstand
    this.urkunde = urkunde
    this.vorgang = vorgang
    this.waffe = waffe
    this.waffensystem = waffensystem
    this.waffenzubehoer_Waffenteil = waffenzubehoer_Waffenteil
    this.wasserfahrzeug = wasserfahrzeug
    this.zahlungskarte = zahlungskarte
    this.arznei_Betaeubungsmittel_Grundstoff = arznei_Betaeubungsmittel_Grundstoff
    this.grundstoff = grundstoff
    this.koerperteil = koerperteil
    this.leiche = leiche
    this.ordnungswidrigkeit = ordnungswidrigkeit
    this.software = software
    this.verkehrsunfall = verkehrsunfall
    this.arzneimittel = arzneimittel
    this.benutzerkonto = benutzerkonto
  }
}
