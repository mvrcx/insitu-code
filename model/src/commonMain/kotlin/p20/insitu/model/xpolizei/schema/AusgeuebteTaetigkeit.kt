package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Die ausgeübte Tätigkeit wird definiert als Tätigkeit, die eine Person regelmäßig für finanzielle
 * oder herkömmliche Gegenleistungen oder im Dienste Dritter erbringt, bzw. für die sie ausgebildet,
 * erzogen oder berufen ist. Darüber hinaus sind auch Schul- und Ausbildungszeiten abbildbar.
 *  
 * Der erlernte Beruf wird in dem Fachobjekt Personalie abgebildet.
 */
@Serializable
public open class AusgeuebteTaetigkeit() : AusgeuebteTaetigkeit_Leer() {
  /**
   * Dieses Feld enthält Angaben über die Art der ausgeübten Tätigkeit.
   *  
   * Anmerkungen:
   * Unter Berufstätigkeit werden alle Formen der selbständigen und nicht selbständigen
   * Erwerbstätigkeit erfasst.
   *  
   * Nicht erwerbstätig sind z. B. Rentner, Hausfrauen / Hausmänner, Pensionäre usw.
   */
  public var art: KatalogCode103? = null

  /**
   * Dieses Feld enthält die Bezeichnung der ausgeübten Tätigkeit.
   *  
   * Beispiele:
   * - Gärtner
   * - Rechtsanwalt
   * - Richter
   * - Polizeivollzugsbeamter
   * - Türsteher
   */
  public var bezeichnung: String? = null

  /**
   * Dieses Feld enthält einen Katalog mit Angaben über die Branche, der die ausgeübte Tätigkeit
   * zuzuordnen ist.
   *  
   * Beispiele: Baugewerbe / Bau, Energieversorgung
   */
  public var branche: KatalogCode204? = null

  /**
   * Dieses Feld enthält Angaben darüber, in welcher sicherheitsrelevanten Einrichtung die Person
   * tätig ist.
   *  
   * Beispiele: Verkehrs- / Versorgungseinrichtung
   */
  public var einrichtung: KatalogCode205? = null

  /**
   * Dieses Feld enthält Angaben über die Funktion, die eine Person innerhalb ihrer Tätigkeit
   * ausfüllt.
   *
   * Beispiele: Kassenwart, Projektgruppenleiter
   */
  public var funktion: String? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Freitextliche Bemerkung zur ausgeübten Tätigkeit.
   */
  public var bemerkung: String? = null

  /**
   * Beginn der ausgeübten Tätigkeit.
   */
  public var taetigkeitsBeginn: String? = null

  /**
   * Ende der ausgeübten Tätigkeit.
   */
  public var taetigkeitsEnde: String? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Angabe, ob die Person insbesondere aufgrund ihrer ausgeübten beruflichen Tätigkeit (z. B.
   * LKW-Fahrer, Handelsvertreter etc.) überregional tätig ist.
   */
  public var ueberregionalTaetig: KatalogCode217? = null

  public constructor(
      art: KatalogCode103?,
      bezeichnung: String?,
      branche: KatalogCode204?,
      einrichtung: KatalogCode205?,
      funktion: String?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      bemerkung: String?,
      taetigkeitsBeginn: String?,
      taetigkeitsEnde: String?,
      redundanzinformation: Redundanzinformation?,
      ueberregionalTaetig: KatalogCode217?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.branche = branche
    this.einrichtung = einrichtung
    this.funktion = funktion
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.taetigkeitsBeginn = taetigkeitsBeginn
    this.taetigkeitsEnde = taetigkeitsEnde
    this.redundanzinformation = redundanzinformation
    this.ueberregionalTaetig = ueberregionalTaetig
  }
}
