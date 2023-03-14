package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Container für Fachbeziehungen
 */
@Serializable
public open class CIMPFachBeziehungenType() {
  public var beziehung: List<Beziehung>? = null

  public var beziehung_allgemein: List<Beziehung_allgemein>? = null

  public var beziehung_Hinweis_Spur: List<Beziehung_Hinweis_Spur>? = null

  public var beziehung_HoheitlicheMassnahme_Person: List<Beziehung_HoheitlicheMassnahme_Person>? =
      null

  public var beziehung_Person_Straftat: List<Beziehung_Person_Straftat>? = null

  public var beziehung_PersonalieOrganisation_OrganisationOertlichkeit:
      List<Beziehung_PersonalieOrganisation_OrganisationOertlichkeit>? = null

  public var beziehung_Vorgang_Straftat: List<Beziehung_Vorgang_Straftat>? = null

  public var beziehung_Ordnungswidrigkeit_Person: List<Beziehung_Ordnungswidrigkeit_Person>? = null

  public var beziehung_Verkehrsunfall_Fahrzeug: List<Beziehung_Verkehrsunfall_Fahrzeug>? = null

  public var beziehung_Verkehrsunfall_Oertlichkeit: List<Beziehung_Verkehrsunfall_Oertlichkeit>? =
      null

  public var beziehung_Verkehrsunfall_Organisation: List<Beziehung_Verkehrsunfall_Organisation>? =
      null

  public var beziehung_Verkehrsunfall_Person: List<Beziehung_Verkehrsunfall_Person>? = null

  public var beziehung_Vorgang_Ordnungswidrigkeit: List<Beziehung_Vorgang_Ordnungswidrigkeit>? =
      null

  public var beziehung_Kommunikationsereignis_Kommunikationsanschluss:
      List<Beziehung_Kommunikationsereignis_Kommunikationsanschluss>? = null

  public var beziehung_ITUEMassnahme_Kommunikationsereignis:
      List<Beziehung_ITUEMassnahme_Kommunikationsereignis>? = null

  public var beziehung_AllgemeinesEreignis_Person: List<Beziehung_AllgemeinesEreignis_Person>? =
      null

  public var beziehung_HoheitlicheMassnahme_Oertlichkeit:
      List<Beziehung_HoheitlicheMassnahme_Oertlichkeit>? = null

  public constructor(
      beziehung: List<Beziehung>?,
      beziehung_allgemein: List<Beziehung_allgemein>?,
      beziehung_Hinweis_Spur: List<Beziehung_Hinweis_Spur>?,
      beziehung_HoheitlicheMassnahme_Person: List<Beziehung_HoheitlicheMassnahme_Person>?,
      beziehung_Person_Straftat: List<Beziehung_Person_Straftat>?,
      beziehung_PersonalieOrganisation_OrganisationOertlichkeit: List<Beziehung_PersonalieOrganisation_OrganisationOertlichkeit>?,
      beziehung_Vorgang_Straftat: List<Beziehung_Vorgang_Straftat>?,
      beziehung_Ordnungswidrigkeit_Person: List<Beziehung_Ordnungswidrigkeit_Person>?,
      beziehung_Verkehrsunfall_Fahrzeug: List<Beziehung_Verkehrsunfall_Fahrzeug>?,
      beziehung_Verkehrsunfall_Oertlichkeit: List<Beziehung_Verkehrsunfall_Oertlichkeit>?,
      beziehung_Verkehrsunfall_Organisation: List<Beziehung_Verkehrsunfall_Organisation>?,
      beziehung_Verkehrsunfall_Person: List<Beziehung_Verkehrsunfall_Person>?,
      beziehung_Vorgang_Ordnungswidrigkeit: List<Beziehung_Vorgang_Ordnungswidrigkeit>?,
      beziehung_Kommunikationsereignis_Kommunikationsanschluss: List<Beziehung_Kommunikationsereignis_Kommunikationsanschluss>?,
      beziehung_ITUEMassnahme_Kommunikationsereignis: List<Beziehung_ITUEMassnahme_Kommunikationsereignis>?,
      beziehung_AllgemeinesEreignis_Person: List<Beziehung_AllgemeinesEreignis_Person>?,
      beziehung_HoheitlicheMassnahme_Oertlichkeit: List<Beziehung_HoheitlicheMassnahme_Oertlichkeit>?
  ) : this() {
    this.beziehung = beziehung
    this.beziehung_allgemein = beziehung_allgemein
    this.beziehung_Hinweis_Spur = beziehung_Hinweis_Spur
    this.beziehung_HoheitlicheMassnahme_Person = beziehung_HoheitlicheMassnahme_Person
    this.beziehung_Person_Straftat = beziehung_Person_Straftat
    this.beziehung_PersonalieOrganisation_OrganisationOertlichkeit =
        beziehung_PersonalieOrganisation_OrganisationOertlichkeit
    this.beziehung_Vorgang_Straftat = beziehung_Vorgang_Straftat
    this.beziehung_Ordnungswidrigkeit_Person = beziehung_Ordnungswidrigkeit_Person
    this.beziehung_Verkehrsunfall_Fahrzeug = beziehung_Verkehrsunfall_Fahrzeug
    this.beziehung_Verkehrsunfall_Oertlichkeit = beziehung_Verkehrsunfall_Oertlichkeit
    this.beziehung_Verkehrsunfall_Organisation = beziehung_Verkehrsunfall_Organisation
    this.beziehung_Verkehrsunfall_Person = beziehung_Verkehrsunfall_Person
    this.beziehung_Vorgang_Ordnungswidrigkeit = beziehung_Vorgang_Ordnungswidrigkeit
    this.beziehung_Kommunikationsereignis_Kommunikationsanschluss =
        beziehung_Kommunikationsereignis_Kommunikationsanschluss
    this.beziehung_ITUEMassnahme_Kommunikationsereignis =
        beziehung_ITUEMassnahme_Kommunikationsereignis
    this.beziehung_AllgemeinesEreignis_Person = beziehung_AllgemeinesEreignis_Person
    this.beziehung_HoheitlicheMassnahme_Oertlichkeit = beziehung_HoheitlicheMassnahme_Oertlichkeit
  }
}
