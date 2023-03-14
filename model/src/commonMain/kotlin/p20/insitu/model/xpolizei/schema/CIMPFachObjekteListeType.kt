package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Container für FachObjekteListe
 */
@Serializable
public open class CIMPFachObjekteListeType() {
  public var adresse: List<Adresse_Leer>? = null

  public var allgemeinesEreignis: List<AllgemeinesEreignis_Leer>? = null

  public var aufzeichnung: List<Aufzeichnung_Leer>? = null

  public var ausgeuebteTaetigkeit: List<AusgeuebteTaetigkeit_Leer>? = null

  public var bargeld: List<Bargeld_Leer>? = null

  public var betaeubungsmittel: List<Betaeubungsmittel_Leer>? = null

  public var dNA_Blut: List<DNA_Blut_Leer>? = null

  public var explosionsgefaehrlicherStoff: List<ExplosionsgefaehrlicherStoff_Leer>? = null

  public var fahrrad: List<Fahrrad_Leer>? = null

  public var fahrzeug: List<Fahrzeug_Leer>? = null

  public var falschgeld: List<Falschgeld_Leer>? = null

  public var finanztransaktion: List<Finanztransaktion_Leer>? = null

  public var geld: List<Geld_Leer>? = null

  public var hinweis: List<Hinweis_Leer>? = null

  public var hoheitlicheMassnahme: List<HoheitlicheMassnahme_Leer>? = null

  public var internetressource: List<Internetressource_Leer>? = null

  public var kfzKennzeichenschild: List<KfzKennzeichenschild_Leer>? = null

  public var kommunikationsanschluss: List<Kommunikationsanschluss_Leer>? = null

  public var kommunikationsereignis: List<Kommunikationsereignis_Leer>? = null

  public var konto: List<Konto_Leer>? = null

  public var kraftfahrzeug: List<Kraftfahrzeug_Leer>? = null

  public var luftfahrzeug: List<Luftfahrzeug_Leer>? = null

  public var massenvernichtungswaffe: List<Massenvernichtungswaffe_Leer>? = null

  public var munition: List<Munition_Leer>? = null

  public var oertlichkeit: List<Oertlichkeit_Leer>? = null

  public var organisation: List<Organisation_Leer>? = null

  public var person: List<Person_Leer>? = null

  public var personalie: List<Personalie_Leer>? = null

  public var personenbeschreibung: List<Personenbeschreibung_Leer>? = null

  public var schienenfahrzeug: List<Schienenfahrzeug_Leer>? = null

  public var schusswaffe: List<Schusswaffe_Leer>? = null

  public var sonstigeSache: List<SonstigeSache_Leer>? = null

  public var sonstigesFahrzeug: List<SonstigesFahrzeug_Leer>? = null

  public var sprengvorrichtung_Brandvorrichtung: List<Sprengvorrichtung_Brandvorrichtung_Leer>? =
      null

  public var spurMateriell: List<SpurMateriell_Leer>? = null

  public var straftat: List<Straftat_Leer>? = null

  public var iTUEMassnahme: List<ITUEMassnahme_Leer>? = null

  public var tragbarerGegenstand: List<TragbarerGegenstand_Leer>? = null

  public var urkunde: List<Urkunde_Leer>? = null

  public var vorgang: List<Vorgang_Leer>? = null

  public var waffe: List<Waffe_Leer>? = null

  public var waffensystem: List<Waffensystem_Leer>? = null

  public var waffenzubehoer_Waffenteil: List<Waffenzubehoer_Waffenteil_Leer>? = null

  public var wasserfahrzeug: List<Wasserfahrzeug_Leer>? = null

  public var zahlungskarte: List<Zahlungskarte_Leer>? = null

  public var arznei_Betaeubungsmittel_Grundstoff: List<Arznei_Betaeubungsmittel_Grundstoff_Leer>? =
      null

  public var grundstoff: List<Grundstoff_Leer>? = null

  public var koerperteil: List<Koerperteil_Leer>? = null

  public var leiche: List<Leiche_Leer>? = null

  public var ordnungswidrigkeit: List<Ordnungswidrigkeit_Leer>? = null

  public var software: List<Software_Leer>? = null

  public var verkehrsunfall: List<Verkehrsunfall_Leer>? = null

  public var arzneimittel: List<Arzneimittel_Leer>? = null

  public var benutzerkonto: List<Benutzerkonto_Leer>? = null

  public constructor(
      adresse: List<Adresse_Leer>?,
      allgemeinesEreignis: List<AllgemeinesEreignis_Leer>?,
      aufzeichnung: List<Aufzeichnung_Leer>?,
      ausgeuebteTaetigkeit: List<AusgeuebteTaetigkeit_Leer>?,
      bargeld: List<Bargeld_Leer>?,
      betaeubungsmittel: List<Betaeubungsmittel_Leer>?,
      dNA_Blut: List<DNA_Blut_Leer>?,
      explosionsgefaehrlicherStoff: List<ExplosionsgefaehrlicherStoff_Leer>?,
      fahrrad: List<Fahrrad_Leer>?,
      fahrzeug: List<Fahrzeug_Leer>?,
      falschgeld: List<Falschgeld_Leer>?,
      finanztransaktion: List<Finanztransaktion_Leer>?,
      geld: List<Geld_Leer>?,
      hinweis: List<Hinweis_Leer>?,
      hoheitlicheMassnahme: List<HoheitlicheMassnahme_Leer>?,
      internetressource: List<Internetressource_Leer>?,
      kfzKennzeichenschild: List<KfzKennzeichenschild_Leer>?,
      kommunikationsanschluss: List<Kommunikationsanschluss_Leer>?,
      kommunikationsereignis: List<Kommunikationsereignis_Leer>?,
      konto: List<Konto_Leer>?,
      kraftfahrzeug: List<Kraftfahrzeug_Leer>?,
      luftfahrzeug: List<Luftfahrzeug_Leer>?,
      massenvernichtungswaffe: List<Massenvernichtungswaffe_Leer>?,
      munition: List<Munition_Leer>?,
      oertlichkeit: List<Oertlichkeit_Leer>?,
      organisation: List<Organisation_Leer>?,
      person: List<Person_Leer>?,
      personalie: List<Personalie_Leer>?,
      personenbeschreibung: List<Personenbeschreibung_Leer>?,
      schienenfahrzeug: List<Schienenfahrzeug_Leer>?,
      schusswaffe: List<Schusswaffe_Leer>?,
      sonstigeSache: List<SonstigeSache_Leer>?,
      sonstigesFahrzeug: List<SonstigesFahrzeug_Leer>?,
      sprengvorrichtung_Brandvorrichtung: List<Sprengvorrichtung_Brandvorrichtung_Leer>?,
      spurMateriell: List<SpurMateriell_Leer>?,
      straftat: List<Straftat_Leer>?,
      iTUEMassnahme: List<ITUEMassnahme_Leer>?,
      tragbarerGegenstand: List<TragbarerGegenstand_Leer>?,
      urkunde: List<Urkunde_Leer>?,
      vorgang: List<Vorgang_Leer>?,
      waffe: List<Waffe_Leer>?,
      waffensystem: List<Waffensystem_Leer>?,
      waffenzubehoer_Waffenteil: List<Waffenzubehoer_Waffenteil_Leer>?,
      wasserfahrzeug: List<Wasserfahrzeug_Leer>?,
      zahlungskarte: List<Zahlungskarte_Leer>?,
      arznei_Betaeubungsmittel_Grundstoff: List<Arznei_Betaeubungsmittel_Grundstoff_Leer>?,
      grundstoff: List<Grundstoff_Leer>?,
      koerperteil: List<Koerperteil_Leer>?,
      leiche: List<Leiche_Leer>?,
      ordnungswidrigkeit: List<Ordnungswidrigkeit_Leer>?,
      software: List<Software_Leer>?,
      verkehrsunfall: List<Verkehrsunfall_Leer>?,
      arzneimittel: List<Arzneimittel_Leer>?,
      benutzerkonto: List<Benutzerkonto_Leer>?
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
