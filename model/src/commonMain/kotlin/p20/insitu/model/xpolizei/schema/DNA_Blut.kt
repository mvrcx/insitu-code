package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Abbildung von DNA- und oder Informationen zum Blut einer ggf. noch unbekannten Person.
 *  
 * Die Desoxyribonukleinsäure (kurz DNA oder DNS) ist ein in allen Lebewesen und DNA-Viren
 * vorkommendes Biomolekül und die Trägerin der Erbinformation.
 *  
 * Das Blut ist eine Körperflüssigkeit, die mit Unterstützung des Herz-Kreislauf-Systems die
 * Funktionalität der verschiedenen Körpergewebe über vielfältige Transport- und Verknüpfungsfunktionen
 * sicherstellt.
 */
@Serializable
public open class DNA_Blut() : DNA_Blut_Leer() {
  /**
   * Dieses Feld enthält Angaben über die Blutgruppe.
   *
   * Eine Blutgruppe ist die Beschreibung der individuellen Zusammensetzung der Glykolipide oder
   * Proteine (Eiweiße) auf der Oberfläche der roten Blutkörperchen von höheren Lebewesen, speziell des
   * Menschen.
   */
  public var blutgruppe: KatalogCode218? = null

  /**
   * Dieses Feld enthält Angaben zum Rhesusfaktor.
   *
   * Der Rhesusfaktor ist ein Protein auf der Zellmembran der roten Blutkörperchen im menschlichen
   * Blut.
   *
   * Beispiele: (A)+, (0)-
   */
  public var rhesusfaktor: KatalogCode219? = null

  /**
   * Dieses Feld enthält Angaben zur Anonymisierungsformel, die aus der jeweiligen Personalie
   * berechnet wird.
   */
  public var anonymisierungsformel: String? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Freitextliche Angaben über die strukturierten Felder hinaus.
   */
  public var bemerkung: String? = null

  public var allel: List<Allel>? = null

  public constructor(
      blutgruppe: KatalogCode218?,
      rhesusfaktor: KatalogCode219?,
      anonymisierungsformel: String?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      bemerkung: String?,
      allel: List<Allel>?
  ) : this() {
    this.blutgruppe = blutgruppe
    this.rhesusfaktor = rhesusfaktor
    this.anonymisierungsformel = anonymisierungsformel
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.allel = allel
  }
}
