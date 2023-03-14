package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

/**
 * Der Vorgang bildet die Klammer um fachliche Objekte und dient beispielsweise zum Nachweis der
 * bearbeitenden Dienststelle, der individuellen Vorgangsnummer und von Schlagworten, die der
 * Wiederfindung des Vorgangs dienen.
 */
@Serializable
public open class Vorgang() : Vorgang_Leer() {
  /**
   * Dieses Feld enthält Angaben zur Art des Vorgangs.
   *  
   * Beispiele: Sammelvorgang, Vorgang zur Strafverfolgung
   */
  public var art: KatalogCode123? = null

  /**
   * Dieses Feld enthält freitextliche Angaben zur Vorgangsbezeichnung.
   *  
   * Beispiele: Ermittlungsverfahren, Ersuchen um...
   */
  public var bezeichnung: String? = null

  /**
   * Auswertemerker kennzeichnen kriminalpolizeiliche Vorgänge, eines überregionalen
   * Phänomenbereiches, die eine besondere Bedeutung für die Kriminalitätsbekämpfung haben.
   */
  public var auswertemerker: List<KatalogCode303>? = null

  /**
   * Dieses Feld enthält Angaben zur Vorgangsnummer. Diese Nummer identifiziert in Kombination mit
   * dem Aktenzeichen der vorgangserstellenden Stelle den Vorgang eindeutig.
   *
   * Beispiele: 253/34/2009, 00003456232009
   */
  public var nummer: String? = null

  /**
   * Dieses Feld enthält Angaben zu Schlagworten, nach denen der Vorgangskontext eingeordnet werden
   * kann.
   *  
   * Alle Schlagworte in einem Eintrag.
   *  
   * Beispiele: Rechtshilfe, Jugendkriminalität, Ausländerhass
   */
  public var schlagworte: String? = null

  /**
   * Priorität der Bearbeitung des Vorgangs.
   *  
   * Beispiele: 'hoch', 'mittel', 'niedrig'
   */
  public var prioritaet: KatalogCode235? = null

  /**
   * Angabe der Gründe für die Priorisierung der Bearbeitung.
   * Die Abbildung eines 'sonstigen Grundes' wird dadurch ermöglicht, dass der Katalog als nicht
   * abgeschlossene Codeliste eingebunden wird.
   */
  public var prioritaetGrund: List<KatalogCode280_NichtAbgeschlossen>? = null

  /**
   * Der Zustand, in dem sich die Bearbeitung des Vorgangs befindet.
   *  
   * Beispiele: 'eingegangen', 'in Bearbeitung', 'abgeschlossen'
   */
  public var bearbeitungsstand: KatalogCode221? = null

  /**
   * Dieses Feld enthält freitextliche Angaben zur Bemerkung zum Vorgang.
   */
  public var bemerkung: String? = null

  /**
   * Gibt den Zeitpunkt an, an dem der Vorgang zu löschen ist.
   */
  public var loeschzeitpunkt: LocalDate? = null

  /**
   * Gibt den Zeitpunkt an, an dem der Vorgang angelegt wurde.
   */
  public var beginnzeitpunkt: DatumZeit? = null

  /**
   * Gibt den Zeitpunkt an, an dem der Vorgang dem Sachbearbeiter erneut vorgelegt werden soll, um
   * bestimmte Fristen einhalten zu können. 
   */
  public var wiedervorlagezeitpunkt: LocalDate? = null

  /**
   * Angabe der beteiligten Stelle.
   */
  public var beteiligung: List<BeteiligteStelleBeteiligungsart>? = null

  /**
   * Vorgangsanhänge bzw. vorgangsbezogene Dokumente wie EPOST-Nachricht, Rechtshilfeersuchen,
   * Vermerk.
   */
  public var dokument: List<Dokument>? = null

  /**
   * Gibt den Zeitpunkt an, an dem der Vorgang abgeschlossen wurde.
   */
  public var endzeitpunkt: DatumZeit? = null

  public var verwendungsbeschraenkung: Verwendungsbeschraenkung? = null

  public var oK: OK? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Angabe der Vorgangskategorie.
   */
  public var kategorie: KatalogCode330? = null

  /**
   * Dieses Feld enthält Angaben über die Relevanzkriterien eines Vorgangs.
   */
  public var relevanzkriterium: List<KatalogCode394>? = null

  public var zusaetzlicheInformationen: List<ZusaetzlicheInformationen>? = null

  public constructor(
    art: KatalogCode123?,
    bezeichnung: String?,
    auswertemerker: List<KatalogCode303>?,
    nummer: String?,
    schlagworte: String?,
    prioritaet: KatalogCode235?,
    prioritaetGrund: List<KatalogCode280_NichtAbgeschlossen>?,
    bearbeitungsstand: KatalogCode221?,
    bemerkung: String?,
    loeschzeitpunkt: LocalDate?,
    beginnzeitpunkt: DatumZeit?,
    wiedervorlagezeitpunkt: LocalDate?,
    beteiligung: List<BeteiligteStelleBeteiligungsart>?,
    dokument: List<Dokument>?,
    endzeitpunkt: DatumZeit?,
    verwendungsbeschraenkung: Verwendungsbeschraenkung?,
    oK: OK?,
    redundanzinformation: Redundanzinformation?,
    kategorie: KatalogCode330?,
    relevanzkriterium: List<KatalogCode394>?,
    zusaetzlicheInformationen: List<ZusaetzlicheInformationen>?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.auswertemerker = auswertemerker
    this.nummer = nummer
    this.schlagworte = schlagworte
    this.prioritaet = prioritaet
    this.prioritaetGrund = prioritaetGrund
    this.bearbeitungsstand = bearbeitungsstand
    this.bemerkung = bemerkung
    this.loeschzeitpunkt = loeschzeitpunkt
    this.beginnzeitpunkt = beginnzeitpunkt
    this.wiedervorlagezeitpunkt = wiedervorlagezeitpunkt
    this.beteiligung = beteiligung
    this.dokument = dokument
    this.endzeitpunkt = endzeitpunkt
    this.verwendungsbeschraenkung = verwendungsbeschraenkung
    this.oK = oK
    this.redundanzinformation = redundanzinformation
    this.kategorie = kategorie
    this.relevanzkriterium = relevanzkriterium
    this.zusaetzlicheInformationen = zusaetzlicheInformationen
  }
}
