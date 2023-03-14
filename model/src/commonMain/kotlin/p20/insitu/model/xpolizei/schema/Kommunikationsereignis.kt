package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Ein Kommunikationsereignis ist der versuchte oder vollendete Aufbau einer Verbindung zwischen
 * mindestens zwei Kommunikationsanschlüssen und / oder Benutzerkonten. Bei einem vollendeten Aufbau
 * einer Verbindung werden Informationen (z. B. als Gespräch, Bildinformation oder Text) übertragen.
 *
 * Ein direktes Gespräch zwischen zwei oder mehreren Personen (face to face bzw. vis a vis) wird
 * über ein allgemeines Ereignis abgebildet.
 *
 * Beispiele:
 * - Gespräche (Sprachübertragung)
 * - FAX (Bildübertragung)
 * - E-Mail (Textübertragung)
 * - Telefonkonferenz (Telefonat mit mehr als zwei Teilnehmern)
 *
 * Bei der Erarbeitung des Fachobjekts Kommunikationsereignis standen die Anforderungen aus dem
 * Bereich TKÜ im Vordergrund.
 */
@Serializable
public open class Kommunikationsereignis() : Kommunikationsereignis_Leer() {
  /**
   * Art des Kommunikationsereignisses hinsichtlich technischer Aspekte, d. h. 'wie' aus Sicht des
   * Kommunikationsinitiators übertragen wurde. Der Inhalt, also das 'was' übertragen wurde, wird über
   * die Vertextung, die Schlagworte, Kurzinhalt etc. abgebildet.
   * Da es auch Kommunikation über TeamSpeak oder Skype etc. gibt, ist der Begriff 'Telefonat'
   * irreführend, daher wird er durch 'Gespräch' ersetzt.
   *  
   * Beispiele:
   * - Gespräch (Audio)
   * - Gespräch (Video)
   * - Textnachrichtenaustausch (SMS)
   * - Multimedianachrichtenaustausch (MMS)
   * - E-Mail
   * - FAX
   */
  public var art: KatalogCode111? = null

  /**
   * Freitextfeld mit Schlagworten zu den übertragenen Inhalten.
   *  
   * Alle Schlagworte in einem Eintrag.
   *  
   * Beispiel: Verabredung zur Durchführung einer Straftat
   */
  public var schlagworte: String? = null

  /**
   * Das Feld Kurzinhalt wird durch den Sachbearbeiter für die Zusammenfassung von
   * Kommunikationsinhalten genutzt.
   */
  public var kurzinhalt: String? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Freitextliche Erläuterung zum Kommunikationsereignis.
   *  
   * Beispiel: Hinweis auf parallel zum Gespräch übertragene E-Mail
   *  
   * Die komplette Dokumentation von Gesprächsinhalten erfolgt im Fachobjekt Dokument.
   */
  public var bemerkung: String? = null

  /**
   * Der Zeitpunkt, an dem das Kommunikationsereignis begonnen hat.
   */
  public var beginn: DatumZeit? = null

  /**
   * Das Ende der Kommunikationsbeziehung.
   *
   * Beispiele: Gesprächsende, Ende der Datenübertragung
   */
  public var ende: DatumZeit? = null

  /**
   * Der Zeitpunkt, an dem das Kommunikationsereignis festgestellt wurde
   *
   * Beispiel: Bei der forensischen Auswertung eines sichergestellten Computers wird eine E-Mail
   * gefunden, die bereits eine Woche vor dem Zeitpunkt der Untersuchung eingegangen ist. Der Zeitpunkt
   * der Untersuchung ist der Zeitpunkt der Feststellung.
   */
  public var feststellung: DatumZeit? = null

  public var iTUEDatenquelle: ITUEDatenquelle? = null

  /**
   * Die Audiodatei (z. B. mp3) des Kommunikationsereignisses oder die Wortprotokollierung. 
   */
  public var kommunikationsprotokollierung: List<Dokument>? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Angaben zum Sachbearbeiter.
   */
  public var sachbearbeiter: List<BeteiligteStelle>? = null

  /**
   * Angabe zum Bearbeitungsstand.
   */
  public var bearbeitungsstand: KatalogCode221? = null

  /**
   * Angaben zur Kernbereichslöschung.
   */
  public var kernbereichsloeschung: List<Kernbereichsloeschung>? = null

  public var festgestellteSprache: List<Sprachangabe>? = null

  public constructor(
      art: KatalogCode111?,
      schlagworte: String?,
      kurzinhalt: String?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      bemerkung: String?,
      beginn: DatumZeit?,
      ende: DatumZeit?,
      feststellung: DatumZeit?,
      iTUEDatenquelle: ITUEDatenquelle?,
      kommunikationsprotokollierung: List<Dokument>?,
      redundanzinformation: Redundanzinformation?,
      sachbearbeiter: List<BeteiligteStelle>?,
      bearbeitungsstand: KatalogCode221?,
      kernbereichsloeschung: List<Kernbereichsloeschung>?,
      festgestellteSprache: List<Sprachangabe>?
  ) : this() {
    this.art = art
    this.schlagworte = schlagworte
    this.kurzinhalt = kurzinhalt
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.beginn = beginn
    this.ende = ende
    this.feststellung = feststellung
    this.iTUEDatenquelle = iTUEDatenquelle
    this.kommunikationsprotokollierung = kommunikationsprotokollierung
    this.redundanzinformation = redundanzinformation
    this.sachbearbeiter = sachbearbeiter
    this.bearbeitungsstand = bearbeitungsstand
    this.kernbereichsloeschung = kernbereichsloeschung
    this.festgestellteSprache = festgestellteSprache
  }
}
