package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Hinweise sind Kundgaben über Sachverhalte / Ereignisse, die aus Sicht des Kundgebenden
 * (Hinweisgeber) einer hoheitlichen Stelle (Polizei, StA) bekannt gemacht werden sollten. Es handelt
 * sich demnach um subjektive und noch nicht verifizierte Wahrnehmungen des Hinweisgebers. Wenn das
 * 'Objekt', auf welches hingewiesen wird, polizeilich relevant ist, wird es über den Rollenwert
 * 'Hinweiszuordnung' der Beziehungsklasse Hinweis_Spur mit dem Hinweis verbunden, z. B. die Person hat
 * 'Hinweiszuordnung' zu Hinweis vom 01.06.09.
 *
 * Beispiele für Hinweise sind:
 * - In Folge eines Anschlags Hinweis auf merkwürdiges Verhalten einer Person im Vorfeld des
 * Anschlags wie Ausspähung.
 * - Auffälliges, da unbeaufsichtigtes Gepäckstück befindet sich am Bahnhof, Gleis 3.
 * - Fahrzeug steht seit längerer Zeit an einem bestimmten Ort und aus dem Kofferraum kriechen
 * Maden.
 * - Schilderung der Wahrnehmung eines Zeugen eines Zugunglückes kurz vor dem Unfall (merkwürdige
 * Geräusche, die der Zug im Vorbeifahren machte).
 *
 * Aus dem Hinweis können später (materielle) Spuren wie Fingerabdrücke, die von dem Spurenträger
 * (herrenloses) Gepäckstück stammen, entstehen, die im Rahmen einer KT-Untersuchung festgestellt
 * wurden. Von welchem Spurenträger (Sache) die jeweilige Spur im Einzelnen stammt, wird über eine
 * Beziehung (Zusammenhang) zu diesem abgebildet. Die KT-Untersuchung als solche ist eine hoheitliche
 * Maßnahme und der zu untersuchende Spurenträger wird über 'Gegenstand der Maßnahme' damit verknüpft.
 */
@Serializable
public open class Hinweis() : Hinweis_Leer() {
  /**
   * Angabe der Art, wie der Hinweis die hoheitliche Stelle erreicht hat.
   *
   * Beispiele: Telefonisch, per E-Mail, Brief, Fax
   */
  public var mitteilungsart: KatalogCode234? = null

  /**
   * Kurze Bezeichnung des Hinweises.
   *  
   * Beispiele:
   * - Hinweis auf verdächtiges Gepäckstück
   * - Hinweis nach Flugzeugabsturz
   * - Hinweis auf Ausspähung der Botschaft XYZ
   */
  public var bezeichnung: String? = null

  /**
   * Freitextliche Kurzdarstellung des Hinweises.
   */
  public var kurzdarstellung: String? = null

  /**
   * Eine Nummer, die den Hinweis eindeutig identifiziert. In älteren Systemen zur
   * Hinweisbearbeitung im Rahmen eines Lagefalls wird nicht zwischen Hinweis- und Spurennummer
   * unterschieden. Dort sind alles 'Spurennummern'.
   *
   * Die Spurnummer ist bis zum Schrägstrich siebenstellig numerisch.
   * Die ersten beiden Stellen der insgesamt siebenstelligen Spurnummer werden für den numerischen
   * Länderschlüssel benutzt (Quelle: SPUDOK Handbuch).
   *
   * Beispiele:
   * - SPU:2100123/-- (Länderschlüssel 21 BKA Meckenheim)
   * - SPU:0200456/-- (Länderschlüssel 02 LKA Hamburg)
   * - SPU:9900789/-- (Sonderkommission bzw. Einsatzort)
   *
   * Hinter dem Schrägstrich werden die zum Spurengrunddatensatz dazugehörenden Folgedatensätze
   * laufend nummeriert, z. B. 2100123/01.
   *
   * Verzeichnis der numerischen Länderschlüssel gemäß INPOL:
   *
   * 01 = Schleswig-Holstein
   * 02 = Hamburg
   * 03 = Niedersachsen
   * 04 = Bremen
   * 05 = Nordrhein-Westfalen
   * 06 = Hessen
   * 07 = Rheinland-Pfalz
   * 08 = Baden-Württemberg
   * 09 = Bayern
   * 10 = Saarland
   * 11 = Berlin
   * 12 = Brandenburg
   * 13 = Mecklenburg-Vorpommern
   * 14 = Sachsen
   * 15 = Sachsen-Anhalt
   * 16 = Thüringen
   * 20 =
   * 21 = BKA Abteilung ST
   * 23 = BKA Berlin SG
   * 25 =
   * 27 =
   * 30 = Bundespolizeidirektion Koblenz
   * 31 = ZF – Zollkriminalamt
   * 99 = SOKO – Sonderkommission
   *
   *
   * FTS: Hinweis / Hinweisnummer
   */
  public var hinweisnummer: String? = null

  /**
   * Abbildung der Tatsache, ob der Hinweis durch eine bekannte Personalie oder anonym erfolgte. Bei
   * Hinweis durch bekannte Personalie wird eine Beziehung Personalie_Hinweis angelegt.
   */
  public var anonym: KatalogCode217? = null

  /**
   * Dieses Feld bildet ab, wie die Priorität des Hinweises eingeschätzt wird.
   */
  public var prioritaet: KatalogCode235? = null

  /**
   * Hier wird der Stand der Bearbeitung des Hinweises abgebildet.
   */
  public var bearbeitungsstand: KatalogCode221? = null

  /**
   * Anmerkungen zu den Umständen der Hinweisaufnahme und / oder zum Hinweisgeber und zum Inhalt.
   *  
   * Beispiele:
   * - Hinweisgeber wirkte nervös / alkoholisiert / hat gestottert
   * - Hintergrundgeräusche
   * - kein Ermittlungsansatz
   *  
   * Zur detaillierten Beschreibung des Hinweisgebers sollte die Beziehung
   * Hinweis_Personenbeschreibung/Personalie (bei bekannten Hinweisgebern) genutzt werden.
   */
  public var bemerkung: String? = null

  /**
   * Zeitpunkt, wann der Sachverhalt / das Ereignis beendet war.
   *
   * Beispiel.: 'verdächtiges Fahrzeug stand bis 22:45 Uhr an diesem Ort'
   */
  public var ende: DatumZeit? = null

  /**
   * Zeitpunkt der Aufnahme / Entgegennahme des Hinweises durch die beteiligte Stelle.
   */
  public var aufnahme: DatumZeit? = null

  /**
   * Zeitpunkt, ab wann der Sachverhalt / das Ereignis bestand.
   *
   * Beispiel: 'verdächtiges Fahrzeug steht seit 01.04.2009 an diesem Ort'
   */
  public var beginn: DatumZeit? = null

  /**
   * Angabe der beteiligten Stelle.
   */
  public var beteiligung: List<BeteiligteStelleBeteiligungsart>? = null

  /**
   * Binärdaten zum Originalhinweis: Aufzeichnung eines Telefonates, eingescannte Schriftstücke,
   * E-Mail des Hinweisgebers inkl. Anhänge.
   */
  public var anlageZumHinweis: List<DigitaleDaten>? = null

  public var dokument: List<Dokument>? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Angaben zur Art des Hinweises.
   */
  public var art: KatalogCode393? = null

  public constructor(
      mitteilungsart: KatalogCode234?,
      bezeichnung: String?,
      kurzdarstellung: String?,
      hinweisnummer: String?,
      anonym: KatalogCode217?,
      prioritaet: KatalogCode235?,
      bearbeitungsstand: KatalogCode221?,
      bemerkung: String?,
      ende: DatumZeit?,
      aufnahme: DatumZeit?,
      beginn: DatumZeit?,
      beteiligung: List<BeteiligteStelleBeteiligungsart>?,
      anlageZumHinweis: List<DigitaleDaten>?,
      dokument: List<Dokument>?,
      redundanzinformation: Redundanzinformation?,
      art: KatalogCode393?
  ) : this() {
    this.mitteilungsart = mitteilungsart
    this.bezeichnung = bezeichnung
    this.kurzdarstellung = kurzdarstellung
    this.hinweisnummer = hinweisnummer
    this.anonym = anonym
    this.prioritaet = prioritaet
    this.bearbeitungsstand = bearbeitungsstand
    this.bemerkung = bemerkung
    this.ende = ende
    this.aufnahme = aufnahme
    this.beginn = beginn
    this.beteiligung = beteiligung
    this.anlageZumHinweis = anlageZumHinweis
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.art = art
  }
}
