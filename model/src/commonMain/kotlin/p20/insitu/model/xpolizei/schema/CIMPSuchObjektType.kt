package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Container für SuchObjekt
 */
@Serializable
public open class CIMPSuchObjektType() {
  public var sucheAdresse: SucheAdresse? = null

  public var sucheAllgemeinesEreignis: SucheAllgemeinesEreignis? = null

  public var sucheAufzeichnung: SucheAufzeichnung? = null

  public var sucheAusgeuebteTaetigkeit: SucheAusgeuebteTaetigkeit? = null

  public var sucheBargeld: SucheBargeld? = null

  public var sucheBetaeubungsmittel: SucheBetaeubungsmittel? = null

  public var sucheDNA_Blut: SucheDNA_Blut? = null

  public var sucheExplosionsgefaehrlicherStoff: SucheExplosionsgefaehrlicherStoff? = null

  public var sucheFahrrad: SucheFahrrad? = null

  public var sucheFahrzeug: SucheFahrzeug? = null

  public var sucheFalschgeld: SucheFalschgeld? = null

  public var sucheFinanztransaktion: SucheFinanztransaktion? = null

  public var sucheGeld: SucheGeld? = null

  public var sucheHinweis: SucheHinweis? = null

  public var sucheHoheitlicheMassnahme: SucheHoheitlicheMassnahme? = null

  public var sucheInternetressource: SucheInternetressource? = null

  public var sucheKfzKennzeichenschild: SucheKfzKennzeichenschild? = null

  public var sucheKommunikationsanschluss: SucheKommunikationsanschluss? = null

  public var sucheKommunikationsereignis: SucheKommunikationsereignis? = null

  public var sucheKonto: SucheKonto? = null

  public var sucheKraftfahrzeug: SucheKraftfahrzeug? = null

  public var sucheLuftfahrzeug: SucheLuftfahrzeug? = null

  public var sucheMassenvernichtungswaffe: SucheMassenvernichtungswaffe? = null

  public var sucheMunition: SucheMunition? = null

  public var sucheOertlichkeit: SucheOertlichkeit? = null

  public var sucheOrganisation: SucheOrganisation? = null

  public var suchePerson: SuchePerson? = null

  public var suchePersonalie: SuchePersonalie? = null

  public var suchePersonenbeschreibung: SuchePersonenbeschreibung? = null

  public var sucheSchienenfahrzeug: SucheSchienenfahrzeug? = null

  public var sucheSchusswaffe: SucheSchusswaffe? = null

  public var sucheSonstigeSache: SucheSonstigeSache? = null

  public var sucheSonstigesFahrzeug: SucheSonstigesFahrzeug? = null

  public var sucheSprengvorrichtung_Brandvorrichtung: SucheSprengvorrichtung_Brandvorrichtung? =
      null

  public var sucheSpurMateriell: SucheSpurMateriell? = null

  public var sucheStraftat: SucheStraftat? = null

  public var sucheITUEMassnahme: SucheITUEMassnahme? = null

  public var sucheTragbarerGegenstand: SucheTragbarerGegenstand? = null

  public var sucheUrkunde: SucheUrkunde? = null

  public var sucheVorgang: SucheVorgang? = null

  public var sucheWaffe: SucheWaffe? = null

  public var sucheWaffensystem: SucheWaffensystem? = null

  public var sucheWaffenzubehoer_Waffenteil: SucheWaffenzubehoer_Waffenteil? = null

  public var sucheWasserfahrzeug: SucheWasserfahrzeug? = null

  public var sucheZahlungskarte: SucheZahlungskarte? = null

  public var sucheArznei_Betaeubungsmittel_Grundstoff: SucheArznei_Betaeubungsmittel_Grundstoff? =
      null

  public var sucheGrundstoff: SucheGrundstoff? = null

  public var sucheKoerperteil: SucheKoerperteil? = null

  public var sucheLeiche: SucheLeiche? = null

  public var sucheOrdnungswidrigkeit: SucheOrdnungswidrigkeit? = null

  public var sucheSoftware: SucheSoftware? = null

  public var sucheVerkehrsunfall: SucheVerkehrsunfall? = null

  public var sucheArzneimittel: SucheArzneimittel? = null

  public var sucheBenutzerkonto: SucheBenutzerkonto? = null

  public var sucheSachnummer: SucheSachnummer? = null

  public constructor(
      sucheAdresse: SucheAdresse?,
      sucheAllgemeinesEreignis: SucheAllgemeinesEreignis?,
      sucheAufzeichnung: SucheAufzeichnung?,
      sucheAusgeuebteTaetigkeit: SucheAusgeuebteTaetigkeit?,
      sucheBargeld: SucheBargeld?,
      sucheBetaeubungsmittel: SucheBetaeubungsmittel?,
      sucheDNA_Blut: SucheDNA_Blut?,
      sucheExplosionsgefaehrlicherStoff: SucheExplosionsgefaehrlicherStoff?,
      sucheFahrrad: SucheFahrrad?,
      sucheFahrzeug: SucheFahrzeug?,
      sucheFalschgeld: SucheFalschgeld?,
      sucheFinanztransaktion: SucheFinanztransaktion?,
      sucheGeld: SucheGeld?,
      sucheHinweis: SucheHinweis?,
      sucheHoheitlicheMassnahme: SucheHoheitlicheMassnahme?,
      sucheInternetressource: SucheInternetressource?,
      sucheKfzKennzeichenschild: SucheKfzKennzeichenschild?,
      sucheKommunikationsanschluss: SucheKommunikationsanschluss?,
      sucheKommunikationsereignis: SucheKommunikationsereignis?,
      sucheKonto: SucheKonto?,
      sucheKraftfahrzeug: SucheKraftfahrzeug?,
      sucheLuftfahrzeug: SucheLuftfahrzeug?,
      sucheMassenvernichtungswaffe: SucheMassenvernichtungswaffe?,
      sucheMunition: SucheMunition?,
      sucheOertlichkeit: SucheOertlichkeit?,
      sucheOrganisation: SucheOrganisation?,
      suchePerson: SuchePerson?,
      suchePersonalie: SuchePersonalie?,
      suchePersonenbeschreibung: SuchePersonenbeschreibung?,
      sucheSchienenfahrzeug: SucheSchienenfahrzeug?,
      sucheSchusswaffe: SucheSchusswaffe?,
      sucheSonstigeSache: SucheSonstigeSache?,
      sucheSonstigesFahrzeug: SucheSonstigesFahrzeug?,
      sucheSprengvorrichtung_Brandvorrichtung: SucheSprengvorrichtung_Brandvorrichtung?,
      sucheSpurMateriell: SucheSpurMateriell?,
      sucheStraftat: SucheStraftat?,
      sucheITUEMassnahme: SucheITUEMassnahme?,
      sucheTragbarerGegenstand: SucheTragbarerGegenstand?,
      sucheUrkunde: SucheUrkunde?,
      sucheVorgang: SucheVorgang?,
      sucheWaffe: SucheWaffe?,
      sucheWaffensystem: SucheWaffensystem?,
      sucheWaffenzubehoer_Waffenteil: SucheWaffenzubehoer_Waffenteil?,
      sucheWasserfahrzeug: SucheWasserfahrzeug?,
      sucheZahlungskarte: SucheZahlungskarte?,
      sucheArznei_Betaeubungsmittel_Grundstoff: SucheArznei_Betaeubungsmittel_Grundstoff?,
      sucheGrundstoff: SucheGrundstoff?,
      sucheKoerperteil: SucheKoerperteil?,
      sucheLeiche: SucheLeiche?,
      sucheOrdnungswidrigkeit: SucheOrdnungswidrigkeit?,
      sucheSoftware: SucheSoftware?,
      sucheVerkehrsunfall: SucheVerkehrsunfall?,
      sucheArzneimittel: SucheArzneimittel?,
      sucheBenutzerkonto: SucheBenutzerkonto?,
      sucheSachnummer: SucheSachnummer?
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
