package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Dieses Fachobjekt ermöglicht die Abbildung von Informationsinhalten (was ist zu sehen oder zu
 * hören?), jedoch nicht die Abbildung des physischen Gegenstands, auf dem die Informationen
 * gespeichert sind.
 * Als Aufzeichnungen gelten diese Informationen dann, wenn sie von einem polizeilichen Gegenüber,
 * Zeugen oder Hinweisgeber stammen und polizeilich relevant sind. Von öffentlichen Stellen (z. B.
 * Polizei oder Justiz) erstellte Dokumente sind somit hier nicht abzubilden.
 *
 * Beispiele für Aufzeichnungen:
 * - Inhalt eines Erpresserbriefs (Text)
 * - kinderpornographische Bilder auf einem USB-Stick (Bild)
 * - Mitschnitt eines Drohanrufs (Ton) durch den Geschädigten
 * - Überwachungsvideo einer Tankstelle (Video)
 *
 * Sollte der physische Datenträger, auf dem die Aufzeichnung gespeichert ist, polizeilich relevant
 * sein (z. B. der USB-Stick mit kinderpornographischen Bildern oder das Papier eines Erpresserbriefs),
 * kann dieser Gegenstand als sonstige Sache erfasst und mit der Aufzeichnung in Beziehung gesetzt
 * werden.
 */
@Serializable
public open class Aufzeichnung() : Aufzeichnung_Leer() {
  /**
   * Art der Aufzeichnung.
   *
   * Hier wird unterschieden, ob es sich um eine Text-, Ton-, Bild- oder Filmaufzeichnung handelt.
   */
  public var art: KatalogCode102? = null

  /**
   * Bezeichnung der Aufzeichnung.
   *
   * Bei betitelten Aufzeichnungen bietet sich der Titel der Aufzeichnung an. Bei nicht betitelten
   * Aufzeichnungen sollte eine kurze, prägnante Bezeichnung gewählt werden.
   *  
   * Beispiel (nicht betitelte Aufzeichnung): 'Mit Jahreszahl 2006 beschriftete VHS-Kassette'
   * Beispiel (betitelte Aufzeichnung): 'Mein Kampf (Buch)'
   *  
   * Bei einer elektronischen Nachricht z. B. der Betreff der E-Mail oder Internetforum.
   */
  public var bezeichnung: String? = null

  /**
   * Kurze Beschreibung des Inhalts. Ein eventuell im Rahmen einer polizeilichen Maßnahme
   * (Auswertung) erstellter Bericht, der den Inhalt genauer beschreibt, wird in dem Fachobjekt
   * Dokument abgebildet.
   *  
   * Beispiel: 'In dem vorliegenden Videofilm sind Kennzeichen verfassungswidriger Organisationen (§
   * 86a StGB) zu sehen; am Ende des Films wird eine Verbrennung der Bundesflagge (§ 90a StGB)
   * gezeigt'.
   */
  public var inhaltsbeschreibung: String? = null

  /**
   * Bei Periodika: Bezeichnung der Ausgabe, welche die inkriminierten Inhalte enthält.
   *  
   * Beispiel: 'Ausgabe 27/2009 vom 02.07.2009'
   */
  public var ausgabe: String? = null

  /**
   * Bei Periodika: Frequenz der Erscheinung.
   *  
   * Beispiele: täglich, werktäglich, wöchentlich, 14-tägig, monatlich, jährlich
   */
  public var erscheinungsweise: KatalogCode202_NichtAbgeschlossen? = null

  /**
   * Bei schriftlichen Aufzeichnungen (Bücher, Magazine, Zeitungen, Zeitschriften, Manuskripte):
   * Anzahl der Seiten.
   *  
   * Beispiel: 42
   */
  public var seitenzahl: Int? = 0

  /**
   * Stichworte zum Inhalt.
   *  
   * Alle Schlagworte in einem Eintrag.
   *  
   * Beispiele: Tierpornographie, Volksverhetzung, Kennzeichen verfassungswidriger Organisationen
   */
  public var schlagworte: String? = null

  /**
   * Nummer, unter der die Aufzeichnung beim BKA deutschlandweit eindeutig registriert ist.
   */
  public var bKARegistriernummer: String? = null

  /**
   * In der Aufzeichnung verwendete Sprachen.
   *  
   * Beispiele: deutsch, russisch
   */
  public var sprache: List<KatalogCode203_NichtAbgeschlossen>? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Bemerkung zur individuell beschriebenen Aufzeichnung.
   *  
   * Beispiele: 'Widmung des Autors auf Innenseite des Buchdeckels', 'Seiten 5-9 fehlen'
   */
  public var bemerkung: String? = null

  public var einzeltitelKapitelBeschreibung: List<EinzeltitelKapitelBeschreibung>? = null

  /**
   * Bei Periodika: Erscheinungsdatum der Erstausgabe.
   */
  public var ersterscheinungsdatum: DatumZeit? = null

  /**
   * Datum, an dem die Publikation zuletzt erschienen ist. Nur bei eingestellten Periodika.
   */
  public var letztesErscheinungsdatum: DatumZeit? = null

  /**
   * Herstellungsdatum der individuellen Aufzeichnung, soweit feststellbar. Bei
   * Internetpublikationen (z. B. Forumsbeiträgen) Datum des Eintrags.
   */
  public var herstellungsdatum: DatumZeit? = null

  /**
   * Datum, an dem die inkriminierte Aufzeichnung veröffentlicht wurde.
   */
  public var erscheinungsdatum: DatumZeit? = null

  /**
   * Anhang zu einer Aufzeichnung als Binärdaten.
   *
   * Beispiel: Schulhof-CD als mp3
   */
  public var aufzeichnungKodiert: List<DigitaleDaten>? = null

  /**
   * Zu einer Aufzeichnung erstelltes Dokument einer öffentlichen Stelle (z. B. Protokoll einer
   * Auswertung).
   */
  public var dokument: List<Dokument>? = null

  public var redundanzinformation: Redundanzinformation? = null

  public var asservat: Asservat? = null

  /**
   * Angabe des Landes, in dem die Aufzeichnung erschienen ist.
   */
  public var erscheinungsland: KatalogCode285_NichtAbgeschlossen? = null

  /**
   * Angabe von sachgebundenen Hinweisen zu Aufzeichnungen.
   */
  public var sachgebundenerHinweis: List<String>? = null

  public constructor(
      art: KatalogCode102?,
      bezeichnung: String?,
      inhaltsbeschreibung: String?,
      ausgabe: String?,
      erscheinungsweise: KatalogCode202_NichtAbgeschlossen?,
      seitenzahl: Int?,
      schlagworte: String?,
      bKARegistriernummer: String?,
      sprache: List<KatalogCode203_NichtAbgeschlossen>?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      bemerkung: String?,
      einzeltitelKapitelBeschreibung: List<EinzeltitelKapitelBeschreibung>?,
      ersterscheinungsdatum: DatumZeit?,
      letztesErscheinungsdatum: DatumZeit?,
      herstellungsdatum: DatumZeit?,
      erscheinungsdatum: DatumZeit?,
      aufzeichnungKodiert: List<DigitaleDaten>?,
      dokument: List<Dokument>?,
      redundanzinformation: Redundanzinformation?,
      asservat: Asservat?,
      erscheinungsland: KatalogCode285_NichtAbgeschlossen?,
      sachgebundenerHinweis: List<String>?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.inhaltsbeschreibung = inhaltsbeschreibung
    this.ausgabe = ausgabe
    this.erscheinungsweise = erscheinungsweise
    this.seitenzahl = seitenzahl
    this.schlagworte = schlagworte
    this.bKARegistriernummer = bKARegistriernummer
    this.sprache = sprache
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.einzeltitelKapitelBeschreibung = einzeltitelKapitelBeschreibung
    this.ersterscheinungsdatum = ersterscheinungsdatum
    this.letztesErscheinungsdatum = letztesErscheinungsdatum
    this.herstellungsdatum = herstellungsdatum
    this.erscheinungsdatum = erscheinungsdatum
    this.aufzeichnungKodiert = aufzeichnungKodiert
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.asservat = asservat
    this.erscheinungsland = erscheinungsland
    this.sachgebundenerHinweis = sachgebundenerHinweis
  }
}
