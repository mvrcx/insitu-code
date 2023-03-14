package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Das Fachobjekt Verkehrsunfall hat dieselbe Rolle wie ein allgemeines Ereignis oder eine Straftat.
 * Sie dokumentiert das Ereignis, das dem Vorgang zugrunde liegt. Sie dient als Ziel von fachlichen
 * Beziehungen, die die bereits vorhandenen Fachobjekte mit dem Verkehrsunfall verbinden und trägt alle
 * Informationen, die den Verkehrsunfall an sich betreffen.
 * (Quelle: Statistische Bundesamt, Veröffentlichung Verkehr (Verkehrsunfälle) Fachserie 8 Reihe 7)
 */
@Serializable
public open class Verkehrsunfall() : Verkehrsunfall_Leer() {
  /**
   * Die Unfallart beschreibt vom gesamten Unfallablauf die Bewegungsrichtung der beteiligten
   * Fahrzeuge zueinander beim ersten Zusammenstoß auf der Fahrbahn oder, wenn es nicht zum
   * Zusammenstoß gekommen ist, die erste mechanische Einwirkung auf einen Verkehrsteilnehmer.
   */
  public var art: KatalogCode332? = null

  /**
   * Angabe, ob ein Unfallort außerhalb oder innerhalb geschlossener Ortschaften liegt.
   */
  public var ortslage: KatalogCode333? = null

  /**
   * Kategorisierung des Unfalls in Personenschaden- oder Sachschadensunfall. Künftig soll auch der
   * Sonstige Sachschadensunfall (Kleinunfall) enthalten sein. P- oder S-Unfall wird berechnet anhand
   * dem Verletzungsgrad beteiligter Personen.
   */
  public var kategorie: KatalogCode334? = null

  /**
   * Der Unfalltyp beschreibt die Konfliktsituation, die zum Unfall führte, d. h. die Phase des
   * Verkehrsgeschehens, in der ein Fehlverhalten oder eine sonstige Ursache den weiteren Ablauf nicht
   * mehr kontrollierbar machte. Im Gegensatz zur Unfallart geht es also beim Unfalltyp nicht um die
   * Beschreibung der wirklichen Kollision, sondern um die Art der Konfliktauslösung vor diesem
   * eventuellen Zusammenstoß.
   */
  public var typ: KatalogCode335? = null

  /**
   * Angabe allgemeiner (nicht personenbezogener) Unfallursachen. Es wird grundsätzlich
   * unterschieden nach allgemeinen Ursachen (u. a. Straßenverhältnisse, Witterungseinflüsse,
   * Hindernisse), die dem Unfall und nicht einzelnen Beteiligten zugeordnet werden, sowie
   * personenbezogenem Fehlverhalten (wie Vorfahrtsmissachtung, zu schnelles Fahren usw.), das
   * bestimmten Fahrzeugführern oder Fußgängern - d. h. den Beteiligten - zugeschrieben wird.
   *
   * Die personenbezognen Ursachen werden auf der Beziehung Personalie - VU abgebildet
   */
  public var allgemeineUrsachen: KatalogCode336? = null

  /**
   * Katalogisierte Angabe, ob eine Lichtzeichenanlage vorhanden ist und wie der Zustand dieser ist.
   * Gemeint sind Wechsellichtzeichen, Linienbeeinflussungsanlagen, Dauerlichtzeichen, Blinklicht an
   * Bahnübergängen.
   */
  public var lichtzeichenanlage: KatalogCode337? = null

  /**
   * Angaben zu bestehender Geschwindigkeitsbegrenzung.
   *
   * Bei Zonengeschwindigkeit (Z. 274.1) ist Z20 bzw. Z30, bei verkehrsberuhigtem Bereich (Z. 325)
   * oder Fußgängerbereich (Z. 242) ist Z07 anzugeben.
   */
  public var geschwindigkeitsbegrenzung: KatalogCode338? = null

  /**
   * Angabe zu den Lichtverhältnissen zur Unfallzeit - katalogisiert.
   */
  public var lichtverhaeltnisse: KatalogCode339? = null

  /**
   * Angabe zum Straßenzustand.
   */
  public var strassenzustand: List<KatalogCode340>? = null

  /**
   * Aufprall auf ein Hindernis neben der Straße - katalogisiert. Die Information ist nur bei der
   * Unfallart 'Abkommen von der Fahrbahn' zu befüllen.
   */
  public var aufprallAufHindernis: KatalogCode341? = null

  /**
   * Der Anfang des Verkehrsunfallzeitraums.
   */
  public var beginn: DatumZeit? = null

  /**
   * Das Ende des Verkehrsunfallzeitraums.
   */
  public var ende: DatumZeit? = null

  /**
   * Zeitpunkt, an dem der Verkehrsunfall durch eine Amtsperson oder durch einen Zeugen festgestellt
   * wurde.
   */
  public var feststellungszeit: DatumZeit? = null

  /**
   * Der Gesamtschaden berechnet sich aus den Schäden aller Beteiligten (Person / Organisation), den
   * Mitfahrern und sonstigen Geschädigten.
   */
  public var gesamtschaden: Geldbetrag? = null

  /**
   * Freitextliche Kurzdarstellung des Verkehrsunfalls.
   */
  public var kurzdarstellung: String? = null

  /**
   * Angabe, ob der Verkehrsunfall lagerelevant ist.
   */
  public var lagerelevanz: KatalogCode217? = null

  public var dokument: List<Dokument>? = null

  public var redundanzinformation: Redundanzinformation? = null

  public constructor(
      art: KatalogCode332?,
      ortslage: KatalogCode333?,
      kategorie: KatalogCode334?,
      typ: KatalogCode335?,
      allgemeineUrsachen: KatalogCode336?,
      lichtzeichenanlage: KatalogCode337?,
      geschwindigkeitsbegrenzung: KatalogCode338?,
      lichtverhaeltnisse: KatalogCode339?,
      strassenzustand: List<KatalogCode340>?,
      aufprallAufHindernis: KatalogCode341?,
      beginn: DatumZeit?,
      ende: DatumZeit?,
      feststellungszeit: DatumZeit?,
      gesamtschaden: Geldbetrag?,
      kurzdarstellung: String?,
      lagerelevanz: KatalogCode217?,
      dokument: List<Dokument>?,
      redundanzinformation: Redundanzinformation?
  ) : this() {
    this.art = art
    this.ortslage = ortslage
    this.kategorie = kategorie
    this.typ = typ
    this.allgemeineUrsachen = allgemeineUrsachen
    this.lichtzeichenanlage = lichtzeichenanlage
    this.geschwindigkeitsbegrenzung = geschwindigkeitsbegrenzung
    this.lichtverhaeltnisse = lichtverhaeltnisse
    this.strassenzustand = strassenzustand
    this.aufprallAufHindernis = aufprallAufHindernis
    this.beginn = beginn
    this.ende = ende
    this.feststellungszeit = feststellungszeit
    this.gesamtschaden = gesamtschaden
    this.kurzdarstellung = kurzdarstellung
    this.lagerelevanz = lagerelevanz
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
  }
}
