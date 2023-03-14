package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Container für SucheObjekte
 */
@Serializable
public open class CIMPSuchObjekteType() {
  public var sucheAdresse: List<SucheAdresse>? = null

  public var sucheAllgemeinesEreignis: List<SucheAllgemeinesEreignis>? = null

  public var sucheAufzeichnung: List<SucheAufzeichnung>? = null

  public var sucheAusgeuebteTaetigkeit: List<SucheAusgeuebteTaetigkeit>? = null

  public var sucheBargeld: List<SucheBargeld>? = null

  public var sucheBetaeubungsmittel: List<SucheBetaeubungsmittel>? = null

  public var sucheDNA_Blut: List<SucheDNA_Blut>? = null

  public var sucheExplosionsgefaehrlicherStoff: List<SucheExplosionsgefaehrlicherStoff>? = null

  public var sucheFahrrad: List<SucheFahrrad>? = null

  public var sucheFahrzeug: List<SucheFahrzeug>? = null

  public var sucheFalschgeld: List<SucheFalschgeld>? = null

  public var sucheFinanztransaktion: List<SucheFinanztransaktion>? = null

  public var sucheGeld: List<SucheGeld>? = null

  public var sucheHinweis: List<SucheHinweis>? = null

  public var sucheHoheitlicheMassnahme: List<SucheHoheitlicheMassnahme>? = null

  public var sucheInternetressource: List<SucheInternetressource>? = null

  public var sucheKfzKennzeichenschild: List<SucheKfzKennzeichenschild>? = null

  public var sucheKommunikationsanschluss: List<SucheKommunikationsanschluss>? = null

  public var sucheKommunikationsereignis: List<SucheKommunikationsereignis>? = null

  public var sucheKonto: List<SucheKonto>? = null

  public var sucheKraftfahrzeug: List<SucheKraftfahrzeug>? = null

  public var sucheLuftfahrzeug: List<SucheLuftfahrzeug>? = null

  public var sucheMassenvernichtungswaffe: List<SucheMassenvernichtungswaffe>? = null

  public var sucheMunition: List<SucheMunition>? = null

  public var sucheOertlichkeit: List<SucheOertlichkeit>? = null

  public var sucheOrganisation: List<SucheOrganisation>? = null

  public var suchePerson: List<SuchePerson>? = null

  public var suchePersonalie: List<SuchePersonalie>? = null

  public var suchePersonenbeschreibung: List<SuchePersonenbeschreibung>? = null

  public var sucheSchienenfahrzeug: List<SucheSchienenfahrzeug>? = null

  public var sucheSchusswaffe: List<SucheSchusswaffe>? = null

  public var sucheSonstigeSache: List<SucheSonstigeSache>? = null

  public var sucheSonstigesFahrzeug: List<SucheSonstigesFahrzeug>? = null

  public var sucheSprengvorrichtung_Brandvorrichtung: List<SucheSprengvorrichtung_Brandvorrichtung>?
      = null

  public var sucheSpurMateriell: List<SucheSpurMateriell>? = null

  public var sucheStraftat: List<SucheStraftat>? = null

  public var sucheITUEMassnahme: List<SucheITUEMassnahme>? = null

  public var sucheTragbarerGegenstand: List<SucheTragbarerGegenstand>? = null

  public var sucheUrkunde: List<SucheUrkunde>? = null

  public var sucheVorgang: List<SucheVorgang>? = null

  public var sucheWaffe: List<SucheWaffe>? = null

  public var sucheWaffensystem: List<SucheWaffensystem>? = null

  public var sucheWaffenzubehoer_Waffenteil: List<SucheWaffenzubehoer_Waffenteil>? = null

  public var sucheWasserfahrzeug: List<SucheWasserfahrzeug>? = null

  public var sucheZahlungskarte: List<SucheZahlungskarte>? = null

  public var sucheArznei_Betaeubungsmittel_Grundstoff:
      List<SucheArznei_Betaeubungsmittel_Grundstoff>? = null

  public var sucheGrundstoff: List<SucheGrundstoff>? = null

  public var sucheKoerperteil: List<SucheKoerperteil>? = null

  public var sucheLeiche: List<SucheLeiche>? = null

  public var sucheOrdnungswidrigkeit: List<SucheOrdnungswidrigkeit>? = null

  public var sucheSoftware: List<SucheSoftware>? = null

  public var sucheVerkehrsunfall: List<SucheVerkehrsunfall>? = null

  public var sucheArzneimittel: List<SucheArzneimittel>? = null

  public var sucheBenutzerkonto: List<SucheBenutzerkonto>? = null

  public var sucheSachnummer: List<SucheSachnummer>? = null

  public constructor(
      sucheAdresse: List<SucheAdresse>?,
      sucheAllgemeinesEreignis: List<SucheAllgemeinesEreignis>?,
      sucheAufzeichnung: List<SucheAufzeichnung>?,
      sucheAusgeuebteTaetigkeit: List<SucheAusgeuebteTaetigkeit>?,
      sucheBargeld: List<SucheBargeld>?,
      sucheBetaeubungsmittel: List<SucheBetaeubungsmittel>?,
      sucheDNA_Blut: List<SucheDNA_Blut>?,
      sucheExplosionsgefaehrlicherStoff: List<SucheExplosionsgefaehrlicherStoff>?,
      sucheFahrrad: List<SucheFahrrad>?,
      sucheFahrzeug: List<SucheFahrzeug>?,
      sucheFalschgeld: List<SucheFalschgeld>?,
      sucheFinanztransaktion: List<SucheFinanztransaktion>?,
      sucheGeld: List<SucheGeld>?,
      sucheHinweis: List<SucheHinweis>?,
      sucheHoheitlicheMassnahme: List<SucheHoheitlicheMassnahme>?,
      sucheInternetressource: List<SucheInternetressource>?,
      sucheKfzKennzeichenschild: List<SucheKfzKennzeichenschild>?,
      sucheKommunikationsanschluss: List<SucheKommunikationsanschluss>?,
      sucheKommunikationsereignis: List<SucheKommunikationsereignis>?,
      sucheKonto: List<SucheKonto>?,
      sucheKraftfahrzeug: List<SucheKraftfahrzeug>?,
      sucheLuftfahrzeug: List<SucheLuftfahrzeug>?,
      sucheMassenvernichtungswaffe: List<SucheMassenvernichtungswaffe>?,
      sucheMunition: List<SucheMunition>?,
      sucheOertlichkeit: List<SucheOertlichkeit>?,
      sucheOrganisation: List<SucheOrganisation>?,
      suchePerson: List<SuchePerson>?,
      suchePersonalie: List<SuchePersonalie>?,
      suchePersonenbeschreibung: List<SuchePersonenbeschreibung>?,
      sucheSchienenfahrzeug: List<SucheSchienenfahrzeug>?,
      sucheSchusswaffe: List<SucheSchusswaffe>?,
      sucheSonstigeSache: List<SucheSonstigeSache>?,
      sucheSonstigesFahrzeug: List<SucheSonstigesFahrzeug>?,
      sucheSprengvorrichtung_Brandvorrichtung: List<SucheSprengvorrichtung_Brandvorrichtung>?,
      sucheSpurMateriell: List<SucheSpurMateriell>?,
      sucheStraftat: List<SucheStraftat>?,
      sucheITUEMassnahme: List<SucheITUEMassnahme>?,
      sucheTragbarerGegenstand: List<SucheTragbarerGegenstand>?,
      sucheUrkunde: List<SucheUrkunde>?,
      sucheVorgang: List<SucheVorgang>?,
      sucheWaffe: List<SucheWaffe>?,
      sucheWaffensystem: List<SucheWaffensystem>?,
      sucheWaffenzubehoer_Waffenteil: List<SucheWaffenzubehoer_Waffenteil>?,
      sucheWasserfahrzeug: List<SucheWasserfahrzeug>?,
      sucheZahlungskarte: List<SucheZahlungskarte>?,
      sucheArznei_Betaeubungsmittel_Grundstoff: List<SucheArznei_Betaeubungsmittel_Grundstoff>?,
      sucheGrundstoff: List<SucheGrundstoff>?,
      sucheKoerperteil: List<SucheKoerperteil>?,
      sucheLeiche: List<SucheLeiche>?,
      sucheOrdnungswidrigkeit: List<SucheOrdnungswidrigkeit>?,
      sucheSoftware: List<SucheSoftware>?,
      sucheVerkehrsunfall: List<SucheVerkehrsunfall>?,
      sucheArzneimittel: List<SucheArzneimittel>?,
      sucheBenutzerkonto: List<SucheBenutzerkonto>?,
      sucheSachnummer: List<SucheSachnummer>?
  ) : this() {
    this.sucheAdresse = sucheAdresse
    this.sucheAllgemeinesEreignis = sucheAllgemeinesEreignis
    this.sucheAufzeichnung = sucheAufzeichnung
    this.sucheAusgeuebteTaetigkeit = sucheAusgeuebteTaetigkeit
    this.sucheBargeld = sucheBargeld
    this.sucheBetaeubungsmittel = sucheBetaeubungsmittel
    this.sucheDNA_Blut = sucheDNA_Blut
    this.sucheExplosionsgefaehrlicherStoff = sucheExplosionsgefaehrlicherStoff
    this.sucheFahrrad = sucheFahrrad
    this.sucheFahrzeug = sucheFahrzeug
    this.sucheFalschgeld = sucheFalschgeld
    this.sucheFinanztransaktion = sucheFinanztransaktion
    this.sucheGeld = sucheGeld
    this.sucheHinweis = sucheHinweis
    this.sucheHoheitlicheMassnahme = sucheHoheitlicheMassnahme
    this.sucheInternetressource = sucheInternetressource
    this.sucheKfzKennzeichenschild = sucheKfzKennzeichenschild
    this.sucheKommunikationsanschluss = sucheKommunikationsanschluss
    this.sucheKommunikationsereignis = sucheKommunikationsereignis
    this.sucheKonto = sucheKonto
    this.sucheKraftfahrzeug = sucheKraftfahrzeug
    this.sucheLuftfahrzeug = sucheLuftfahrzeug
    this.sucheMassenvernichtungswaffe = sucheMassenvernichtungswaffe
    this.sucheMunition = sucheMunition
    this.sucheOertlichkeit = sucheOertlichkeit
    this.sucheOrganisation = sucheOrganisation
    this.suchePerson = suchePerson
    this.suchePersonalie = suchePersonalie
    this.suchePersonenbeschreibung = suchePersonenbeschreibung
    this.sucheSchienenfahrzeug = sucheSchienenfahrzeug
    this.sucheSchusswaffe = sucheSchusswaffe
    this.sucheSonstigeSache = sucheSonstigeSache
    this.sucheSonstigesFahrzeug = sucheSonstigesFahrzeug
    this.sucheSprengvorrichtung_Brandvorrichtung = sucheSprengvorrichtung_Brandvorrichtung
    this.sucheSpurMateriell = sucheSpurMateriell
    this.sucheStraftat = sucheStraftat
    this.sucheITUEMassnahme = sucheITUEMassnahme
    this.sucheTragbarerGegenstand = sucheTragbarerGegenstand
    this.sucheUrkunde = sucheUrkunde
    this.sucheVorgang = sucheVorgang
    this.sucheWaffe = sucheWaffe
    this.sucheWaffensystem = sucheWaffensystem
    this.sucheWaffenzubehoer_Waffenteil = sucheWaffenzubehoer_Waffenteil
    this.sucheWasserfahrzeug = sucheWasserfahrzeug
    this.sucheZahlungskarte = sucheZahlungskarte
    this.sucheArznei_Betaeubungsmittel_Grundstoff = sucheArznei_Betaeubungsmittel_Grundstoff
    this.sucheGrundstoff = sucheGrundstoff
    this.sucheKoerperteil = sucheKoerperteil
    this.sucheLeiche = sucheLeiche
    this.sucheOrdnungswidrigkeit = sucheOrdnungswidrigkeit
    this.sucheSoftware = sucheSoftware
    this.sucheVerkehrsunfall = sucheVerkehrsunfall
    this.sucheArzneimittel = sucheArzneimittel
    this.sucheBenutzerkonto = sucheBenutzerkonto
    this.sucheSachnummer = sucheSachnummer
  }
}
