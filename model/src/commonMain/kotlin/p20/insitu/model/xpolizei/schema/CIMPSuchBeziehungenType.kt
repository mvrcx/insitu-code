package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Container für SuchBeziehungen
 */
@Serializable
public open class CIMPSuchBeziehungenType() {
  public var sucheBeziehung: List<SucheBeziehung>? = null

  public var sucheBeziehung_allgemein: List<SucheBeziehung_allgemein>? = null

  public var sucheBeziehung_Hinweis_Spur: List<SucheBeziehung_Hinweis_Spur>? = null

  public var sucheBeziehung_HoheitlicheMassnahme_Person:
      List<SucheBeziehung_HoheitlicheMassnahme_Person>? = null

  public var sucheBeziehung_Person_Straftat: List<SucheBeziehung_Person_Straftat>? = null

  public var sucheBeziehung_PersonalieOrganisation_OrganisationOertlichkeit:
      List<SucheBeziehung_PersonalieOrganisation_OrganisationOertlichkeit>? = null

  public var sucheBeziehung_Vorgang_Straftat: List<SucheBeziehung_Vorgang_Straftat>? = null

  public var sucheBeziehung_Ordnungswidrigkeit_Person:
      List<SucheBeziehung_Ordnungswidrigkeit_Person>? = null

  public var sucheBeziehung_Verkehrsunfall_Fahrzeug: List<SucheBeziehung_Verkehrsunfall_Fahrzeug>? =
      null

  public var sucheBeziehung_Verkehrsunfall_Oertlichkeit:
      List<SucheBeziehung_Verkehrsunfall_Oertlichkeit>? = null

  public var sucheBeziehung_Verkehrsunfall_Organisation:
      List<SucheBeziehung_Verkehrsunfall_Organisation>? = null

  public var sucheBeziehung_Verkehrsunfall_Person: List<SucheBeziehung_Verkehrsunfall_Person>? =
      null

  public var sucheBeziehung_Vorgang_Ordnungswidrigkeit:
      List<SucheBeziehung_Vorgang_Ordnungswidrigkeit>? = null

  public var sucheBeziehung_Kommunikationsereignis_Kommunikationsanschluss:
      List<SucheBeziehung_Kommunikationsereignis_Kommunikationsanschluss>? = null

  public var sucheBeziehung_ITUEMassnahme_Kommunikationsereignis:
      List<SucheBeziehung_ITUEMassnahme_Kommunikationsereignis>? = null

  public var sucheBeziehung_AllgemeinesEreignis_Person:
      List<SucheBeziehung_AllgemeinesEreignis_Person>? = null

  public var sucheBeziehung_HoheitlicheMassnahme_Oertlichkeit:
      List<SucheBeziehung_HoheitlicheMassnahme_Oertlichkeit>? = null

  public constructor(
      sucheBeziehung: List<SucheBeziehung>?,
      sucheBeziehung_allgemein: List<SucheBeziehung_allgemein>?,
      sucheBeziehung_Hinweis_Spur: List<SucheBeziehung_Hinweis_Spur>?,
      sucheBeziehung_HoheitlicheMassnahme_Person: List<SucheBeziehung_HoheitlicheMassnahme_Person>?,
      sucheBeziehung_Person_Straftat: List<SucheBeziehung_Person_Straftat>?,
      sucheBeziehung_PersonalieOrganisation_OrganisationOertlichkeit: List<SucheBeziehung_PersonalieOrganisation_OrganisationOertlichkeit>?,
      sucheBeziehung_Vorgang_Straftat: List<SucheBeziehung_Vorgang_Straftat>?,
      sucheBeziehung_Ordnungswidrigkeit_Person: List<SucheBeziehung_Ordnungswidrigkeit_Person>?,
      sucheBeziehung_Verkehrsunfall_Fahrzeug: List<SucheBeziehung_Verkehrsunfall_Fahrzeug>?,
      sucheBeziehung_Verkehrsunfall_Oertlichkeit: List<SucheBeziehung_Verkehrsunfall_Oertlichkeit>?,
      sucheBeziehung_Verkehrsunfall_Organisation: List<SucheBeziehung_Verkehrsunfall_Organisation>?,
      sucheBeziehung_Verkehrsunfall_Person: List<SucheBeziehung_Verkehrsunfall_Person>?,
      sucheBeziehung_Vorgang_Ordnungswidrigkeit: List<SucheBeziehung_Vorgang_Ordnungswidrigkeit>?,
      sucheBeziehung_Kommunikationsereignis_Kommunikationsanschluss: List<SucheBeziehung_Kommunikationsereignis_Kommunikationsanschluss>?,
      sucheBeziehung_ITUEMassnahme_Kommunikationsereignis: List<SucheBeziehung_ITUEMassnahme_Kommunikationsereignis>?,
      sucheBeziehung_AllgemeinesEreignis_Person: List<SucheBeziehung_AllgemeinesEreignis_Person>?,
      sucheBeziehung_HoheitlicheMassnahme_Oertlichkeit: List<SucheBeziehung_HoheitlicheMassnahme_Oertlichkeit>?
  ) : this() {
    this.sucheBeziehung = sucheBeziehung
    this.sucheBeziehung_allgemein = sucheBeziehung_allgemein
    this.sucheBeziehung_Hinweis_Spur = sucheBeziehung_Hinweis_Spur
    this.sucheBeziehung_HoheitlicheMassnahme_Person = sucheBeziehung_HoheitlicheMassnahme_Person
    this.sucheBeziehung_Person_Straftat = sucheBeziehung_Person_Straftat
    this.sucheBeziehung_PersonalieOrganisation_OrganisationOertlichkeit =
        sucheBeziehung_PersonalieOrganisation_OrganisationOertlichkeit
    this.sucheBeziehung_Vorgang_Straftat = sucheBeziehung_Vorgang_Straftat
    this.sucheBeziehung_Ordnungswidrigkeit_Person = sucheBeziehung_Ordnungswidrigkeit_Person
    this.sucheBeziehung_Verkehrsunfall_Fahrzeug = sucheBeziehung_Verkehrsunfall_Fahrzeug
    this.sucheBeziehung_Verkehrsunfall_Oertlichkeit = sucheBeziehung_Verkehrsunfall_Oertlichkeit
    this.sucheBeziehung_Verkehrsunfall_Organisation = sucheBeziehung_Verkehrsunfall_Organisation
    this.sucheBeziehung_Verkehrsunfall_Person = sucheBeziehung_Verkehrsunfall_Person
    this.sucheBeziehung_Vorgang_Ordnungswidrigkeit = sucheBeziehung_Vorgang_Ordnungswidrigkeit
    this.sucheBeziehung_Kommunikationsereignis_Kommunikationsanschluss =
        sucheBeziehung_Kommunikationsereignis_Kommunikationsanschluss
    this.sucheBeziehung_ITUEMassnahme_Kommunikationsereignis =
        sucheBeziehung_ITUEMassnahme_Kommunikationsereignis
    this.sucheBeziehung_AllgemeinesEreignis_Person = sucheBeziehung_AllgemeinesEreignis_Person
    this.sucheBeziehung_HoheitlicheMassnahme_Oertlichkeit =
        sucheBeziehung_HoheitlicheMassnahme_Oertlichkeit
  }
}
