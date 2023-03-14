package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Unterlage einer öffentlichen Behörde wie z. B. Polizei, Gericht, Staatsanwaltschaft,
 * Ausländeramt, Pass- und Meldeamt oder eines verpflichteten Dritten, die aufgrund eines polizeilichen
 * Sachverhaltes erstellt wurden, z. B. auch Lichtbilder, Fahndungsplakate, die wörtliche Übersetzung
 * eines überwachten Kommunikationsereignisses, das Wortprotokoll eines überwachten Gespräches,
 * Haftbefehl. Hierunter fallen auch Ton- oder Videodateien, die z. B. von einem MEK oder einem
 * verdeckten Ermittler angefertigt wurden.
 *  
 * Verwendung als AKK beispielsweise zu Vorgang, Aufzeichnung, Kommunikationsereignis und Maßnahme.
 *  
 * Hoheitliche Unterlagen wie Urkunden als Reisepässe, die ausgeschrieben werden sollen, oder Bilder
 * als Aufzeichnungen, die einer KT-Untersuchung bedürfen, fallen nicht unter diese AKK.
 */
@Serializable
public open class Dokument() {
  /**
   * Dieses Feld enthält Angaben über die Bezeichnung des Dokuments.
   *
   * Beispiel: Ausschreibung zur Festnahme des N.N. wegen des Verdachts auf Herbeiführung einer
   * Sprengstoffexplosion
   */
  public var bezeichnung: String? = null

  /**
   * Dieses Feld enthält Angaben zur technischen Version des Dokuments.
   *
   * Beispiele: Ver. 1.00, ver. 2.11, v3
   */
  public var version: String? = null

  /**
   * Dieses Feld enthält Angaben zum Betreff des Dokuments. Der Betreff ergibt sich aus dem
   * Dokument.
   *
   * Beispiel: Ausschreibung wegen...
   */
  public var betreff: String? = null

  /**
   * Dieses Feld enthält Angaben zum Bearbeitungsstand des Dokuments.
   *
   * Beispiel: in Bearbeitung, abgeschlossen
   */
  public var bearbeitungsstand: KatalogCode221? = null

  /**
   * Sprachen, in denen das Dokument abgefasst ist (bzw. bei Film- oder Tonaufnahmen: Sprachen, die
   * in dem Dokument gesprochen werden).
   *  
   * Beispiele:
   * - ein in französischer Sprache verfasster Lagebericht
   * - eine Filmdokumentation zu Schulungszwecken, die sowohl in deutscher Sprache als auch in
   * Englisch zur Verfügung gestellt wird
   */
  public var sprache: List<KatalogCode203_NichtAbgeschlossen>? = null

  /**
   * Angabe, ob das Dokument EIS-relevant ist.
   */
  public var eISRelevanz: KatalogCode217? = null

  /**
   * Dieses Feld enthält freitextliche Angaben zum Dokument.
   *  
   * Beispiel: Ausschreibung zur Festnahme des N.N. wegen des Verdachts auf Herbeiführung einer
   * Sprengstoffexplosion nach §§ 307-309 StGB
   */
  public var bemerkung: String? = null

  /**
   * Erstelldatum des Dokuments.
   */
  public var erstelldatum: String? = null

  public var digitaleDaten: List<DigitaleDaten>? = null

  /**
   * Ersteller des Dokuments.
   */
  public var ersteller: BeteiligteStelle? = null

  /**
   * Angabe, ob die Übersetzung durch Dolmetscher oder durch eine Software erfolgt ist.
   */
  public var uebersetzungsart: KatalogCode364? = null

  /**
   * Dieses Feld enthält Angaben über die Art des Dokuments.
   */
  public var art: KatalogCode388_NichtAbgeschlossen? = null

  /**
   * Angabe, ob es sich um ein gerichtsfestes, unbearbeitetes Dokument handelt.
   */
  public var originaldokument: KatalogCode217? = null

  /**
   * Angabe, ob das Lichtbild oder die Bildaufzeichnung mittels einer verdeckten Maßnahme in oder
   * aus einer Wohnung hergestellt wurde und personenbezogene Daten enthält.
   */
  public var verdeckterEinsatzInAusWohnung: KatalogCode406? = null

  public constructor(
      bezeichnung: String?,
      version: String?,
      betreff: String?,
      bearbeitungsstand: KatalogCode221?,
      sprache: List<KatalogCode203_NichtAbgeschlossen>?,
      eISRelevanz: KatalogCode217?,
      bemerkung: String?,
      erstelldatum: String?,
      digitaleDaten: List<DigitaleDaten>?,
      ersteller: BeteiligteStelle?,
      uebersetzungsart: KatalogCode364?,
      art: KatalogCode388_NichtAbgeschlossen?,
      originaldokument: KatalogCode217?,
      verdeckterEinsatzInAusWohnung: KatalogCode406?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.version = version
    this.betreff = betreff
    this.bearbeitungsstand = bearbeitungsstand
    this.sprache = sprache
    this.eISRelevanz = eISRelevanz
    this.bemerkung = bemerkung
    this.erstelldatum = erstelldatum
    this.digitaleDaten = digitaleDaten
    this.ersteller = ersteller
    this.uebersetzungsart = uebersetzungsart
    this.art = art
    this.originaldokument = originaldokument
    this.verdeckterEinsatzInAusWohnung = verdeckterEinsatzInAusWohnung
  }
}
