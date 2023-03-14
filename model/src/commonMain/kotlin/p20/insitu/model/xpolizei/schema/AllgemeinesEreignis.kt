package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Allgemeine Ereignisse sind alle Sachverhalte, die keine Straftaten oder hoheitliche Maßnahmen
 * sind.
 *  
 * Beispiele: Demonstrationen, Treffen, Mahnwachen, Geschlechtsumwandlung, Namensänderung etc.
 *  
 * Geldübergaben sind Finanztransaktionen zwischen verschiedenen Akteuren.
 */
@Serializable
public open class AllgemeinesEreignis() : AllgemeinesEreignis_Leer() {
  /**
   * Dieses Feld enthält die Art des allgemeinen Ereignisses.
   *  
   * Beispiele: Infostand, Treffen, Veranstaltung, Namensänderung etc.
   *  
   * Die Katalogwerte sollten allgemein gehalten werden, eine nähere Spezifizierung findet in der
   * Bezeichnung statt.
   */
  public var art: KatalogCode101_NichtAbgeschlossen? = null

  /**
   * Freitextliche Bezeichnung des allgemeinen Ereignisses.
   *  
   * Beispiele: Demonstration gegen 'Killerspiele', öffentliche Kundgebung zur Unterstützung der
   * Tsunami-Opfer
   */
  public var bezeichnung: String? = null

  /**
   * Freitextliche Kurzdarstellung des allgemeinen Ereignisses.
   *
   * Beispiele: 400 Teilnehmer, die Route verlief durch die Innenstadt, es kam zu keinen Störungen
   */
  public var kurzdarstellung: String? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  public var dokument: List<Dokument>? = null

  /**
   * Beginn des Ereignisses.
   */
  public var beginn: DatumZeit? = null

  /**
   * Ende des Ereignisses.
   */
  public var ende: DatumZeit? = null

  /**
   * Zeitpunkt, an dem das Ereignis durch eine Amtsperson oder durch einen Zeugen festgestellt
   * wurde.
   *
   * Beispiel: Zeitpunkt des Auffindens einer Leiche
   */
  public var feststellungszeit: DatumZeit? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Nicht vollendetes Handeln ohne strafrechtlichen Hintergrund, wie z. B. ein gescheiterter
   * Suizid.
   */
  public var versuch: KatalogCode217? = null

  /**
   * Angabe, ob das allgemeine Ereignis lagerelevant ist.
   */
  public var lagerelevanz: KatalogCode217? = null

  /**
   * Angabe der Rechtsgüter, deren Schutz die Erhebung dient.
   */
  public var rechtsgut: List<KatalogCode370>? = null

  public constructor(
      art: KatalogCode101_NichtAbgeschlossen?,
      bezeichnung: String?,
      kurzdarstellung: String?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      dokument: List<Dokument>?,
      beginn: DatumZeit?,
      ende: DatumZeit?,
      feststellungszeit: DatumZeit?,
      redundanzinformation: Redundanzinformation?,
      versuch: KatalogCode217?,
      lagerelevanz: KatalogCode217?,
      rechtsgut: List<KatalogCode370>?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.kurzdarstellung = kurzdarstellung
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.dokument = dokument
    this.beginn = beginn
    this.ende = ende
    this.feststellungszeit = feststellungszeit
    this.redundanzinformation = redundanzinformation
    this.versuch = versuch
    this.lagerelevanz = lagerelevanz
    this.rechtsgut = rechtsgut
  }
}
