package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Der Begriff 'Konto' stammt aus dem italienischen ('Conto' - Rechnung) und bezeichnet in der
 * Buchhaltung eine zweispaltige Tabelle (Tabellenspalten 'Soll' und 'Haben'). Im Zahlungsverkehr und
 * Bankwesen sowie im Informationsmodell der Polizei steht der Begriff jedoch in einem engeren Sinn für
 * ein Bankkonto. Bankkonten werden von einem Kreditinstitut ('Bank'; Definition siehe § 1
 * Kreditwesengesetz) geführt.
 *  
 * Bei den Bankkonten sind unter anderem die folgenden Arten zu unterscheiden:
 * - Sicht-, Giro- und Kontokorrentkonten: Konten für Zahlungsverkehr
 * - Sparkonten (Sparbücher)
 * - Tagesgeld- und Terminkonten
 * - Kreditkartenkonten
 *  
 * Ein Bankkonto besitzt immer einen oder im Falle eines Gemeinschaftskontos mehrere Inhaber. Dabei
 * kann es sich um natürliche oder juristische Personen handeln mit gegebenfalls einem oder mehreren
 * weiteren Verfügungsberechtigten. Die Zuordnung zu einem Inhaber oder einer verfügungsberechtigten
 * Person erfolgt im Informationsmodell der Polizei über eine Beziehung Personalie_Konto (Rollen: z. B.
 * Inhaber, Verfügungsberechtigter) oder Organisation_Konto.
 */
@Serializable
public open class Konto() : Konto_Leer() {
  /**
   * Hier wird die Art des Kontos abgebildet.
   *  
   * Beispiele:
   * - Girokonto
   * - Kontokorrentkonto
   * - Kreditkartenkonto
   * - Termingeldkonto
   * - Wertpapierdepotkonto
   */
  public var art: KatalogCode112? = null

  /**
   * Hier wird die Währung abgebildet, in der das Konto geführt wird.
   *  
   * Beispiel: EUR (Katalogwert)
   */
  public var waehrung: KatalogCode230_NichtAbgeschlossen? = null

  /**
   * Angabe des Kontotyps.
   *  
   * Der Typ ist von der Art dahingehend zu unterscheiden, dass er durch den Zweck des Kontos und
   * nicht durch die Art (d. h. Sparkonto, Girokonto) bestimmt wird.
   *  
   * Beispiele: Geschäftskonto, Privatkonto, Treuhandkonto
   */
  public var kontotyp: KatalogCode238_NichtAbgeschlossen? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * In diesem Feld werden weitere freitextliche Informationen zum Konto abgebildet.
   *  
   * Beispiel: Kontoeröffnung am 17.03.2009 zum vermutlichen Zwecke der Geldwäsche
   */
  public var bemerkung: String? = null

  /**
   * Angabe des Datums der Kontoeröffnung.
   */
  public var eroeffnungsdatum: String? = null

  /**
   * Angabe des Datums der Kontoauflösung.
   */
  public var schliessungsdatum: String? = null

  public var bankkontoinformation: Bankkontoinformation? = null

  public var redundanzinformation: Redundanzinformation? = null

  public constructor(
      art: KatalogCode112?,
      waehrung: KatalogCode230_NichtAbgeschlossen?,
      kontotyp: KatalogCode238_NichtAbgeschlossen?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      bemerkung: String?,
      eroeffnungsdatum: String?,
      schliessungsdatum: String?,
      bankkontoinformation: Bankkontoinformation?,
      redundanzinformation: Redundanzinformation?
  ) : this() {
    this.art = art
    this.waehrung = waehrung
    this.kontotyp = kontotyp
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.eroeffnungsdatum = eroeffnungsdatum
    this.schliessungsdatum = schliessungsdatum
    this.bankkontoinformation = bankkontoinformation
    this.redundanzinformation = redundanzinformation
  }
}
