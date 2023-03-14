package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Das Klassendiagramm Straftat beschreibt den Verstoß gegen eine gesetzliche Vorschrift. Als
 * Grundlage für die Abbildung als Straftat gelten neben dem StGB auch die strafrechtlichen
 * Nebengesetze wie BtMG oder AufenthG sowie das Völkerrecht.
 */
@Serializable
public open class Straftat() : Straftat_Leer() {
  /**
   * Bezeichnung der gesetzlichen Vorschrift, gegen die verstoßen wurde, bzw. des Ereignisses, das
   * den Fall darstellt oder die Erläuterung des Anlasses einer Maßnahme.
   *  
   * Beispiel: Besonders schwerer Fall des Diebstahls § 243 StGB
   */
  public var delikt: KatalogCode121? = null

  /**
   * Freitextliche Bezeichnung der Straftat wie Handtaschenraub, Bankraub, Kellerdiebstahl,
   * Einbruch.
   */
  public var bezeichnung: String? = null

  /**
   * Stichworte zu einer Straftat (Beispiele sind Völkermord, Beschaffungskriminalität, Amok,
   * Milieu).
   *  
   * Alle Stichworte in einem Eintrag.
   */
  public var spezifikation: String? = null

  /**
   * Die Angabe, ob ein versuchter Gesetzesverstoß vorliegt.
   */
  public var versuch: KatalogCode217? = null

  /**
   * Relevanz des Ereignisses für bestimmte nationale und internationale Systeme.
   *
   * Beispiele: FIU-Net, Interpol, Europol, Lage
   */
  public var relevanz: List<KatalogCode273>? = null

  /**
   * Angabe der Europäischen Straftatenkategorie gem. Rahmenbeschluss 2006/960/ JI DES RATES vom
   * 18.12.2006.
   *
   * Die Abbildung einer 'sonstigen Straftat' mit der Verpflichtung der freitextlichen Beschreibung
   * wird dadurch ermöglicht, dass der Katalog als nicht abgeschlossene Codeliste eingebunden wird.
   */
  public var europaeischeStraftatenkategorie: List<KatalogCode272_NichtAbgeschlossen>? = null

  /**
   * Freitextliche Kurzdarstellung der Straftat.
   */
  public var kurzdarstellung: String? = null

  /**
   * Im Attribut Hoechstfreiheitsstrafe wird die laut Gesetz maximale Strafandrohung in 'Jahren
   * Freiheitsstrafe' als numerischer Wert abgebildet.
   *  
   * Beispiel: § 226 StGB (Schwere Körperverletzung): '... von einem Jahr bis zu zehn Jahren'
   * In diesem Fall wäre der Wert für das Attribut 10.
   */
  public var hoechstfreiheitsstrafe: Double? = 0.0

  /**
   * Tatbestandsmerkmale sind Voraussetzungen in einer Rechtsnorm, welche erfüllt sein müssen, um
   * eine bestimmte Rechtsfolge auszulösen.
   */
  public var tatbestandsmerkmal: List<KatalogCode304_NichtAbgeschlossen>? = null

  /**
   * Zeitpunkt, zu dem die Straftat beendet war.
   */
  public var ende: DatumZeit? = null

  /**
   * Zeitpunkt, zu dem die Straftat begonnen hat.
   */
  public var beginn: DatumZeit? = null

  public var dokument: List<Dokument>? = null

  public var pMK: PMK? = null

  /**
   * Der aus der Straftat resultierende Gesamtschaden. Beispiel: Brandstiftung beinhaltet neben dem
   * Sachschaden an dem betroffenen Gebäude auch die Kosten des Feuerwehreinsatzes und Hotelkosten der
   * Geschädigten usw. 
   */
  public var gesamtschaden: Geldbetrag? = null

  /**
   * PKS-relevante Informationen zu einer Straftat.
   */
  public var pKS: PKS? = null

  /**
   * Zeitpunkt, an dem die Straftat durch eine Amtsperson oder durch einen Zeugen festgestellt
   * wurde.
   * Beispiel: Zeitpunkt der Feststellung eines Einbruchdiebstahls. 
   */
  public var feststellungszeit: DatumZeit? = null

  public var modusOperandi: List<ModusOperandi>? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Faktoren bzw. Lebensumstände des Opfers, die die Tat beeinflusst oder begünstigt haben.
   *
   * Beispiele: Prostituierte, Homosexuelles Milieu, Drogenmilieu
   */
  public var opfertypus: List<KatalogCode318_MitZusatz>? = null

  /**
   * Den Täter klassifizierende Faktoren, Lebensumstände bzw. seine Stellung, die die Tat
   * beeinflusst, begünstigt oder ermöglicht haben.
   *
   * Beispiele: Amtsträger, Wach- und Sicherheitspersonal, Drogenmilieu
   */
  public var taetertypus: List<KatalogCode318_MitZusatz>? = null

  public var eIS: EIS? = null

  /**
   * Angabe, ob eine zukünftige Straftat vorliegt.
   *
   * Diese Angabe ist erforderlich, um Opfer einer zukünftigen Straftat, Gefährder und relevante
   * Personen datenschutzrechtlich korrekt abbilden zu können.
   *
   * Weiterhin wird diese Angabe benötigt, um Straftaten abbilden zu können, die durch
   * Logistikstraftaten begünstigt oder ermöglicht wurden. Diese Straftaten müssen zum
   * Erfassungszeitpunkt in der Zukunft liegen.
   */
  public var zukuenftigeStraftat: KatalogCode217? = null

  /**
   * Abbildung des ASTRAL-Schlüssels.
   */
  public var aSTRALSchluessel: String? = null

  /**
   * Angabe der Rechtsgüter, deren Schutz die Erhebung dient.
   */
  public var rechtsgut: List<KatalogCode370>? = null

  /**
   * Kategorisierung von Straftaten anhand ihrer Schwere, mit dem Ziel der späteren Vergleichbarkeit
   * im Rahmen der hyDaNe. Die Begründung der Abweichung von den Vorgaben kann hier erfolgen.
   */
  public var hyDaNeKennzeichnung: HyDaNeKennzeichnung? = null

  public constructor(
      delikt: KatalogCode121?,
      bezeichnung: String?,
      spezifikation: String?,
      versuch: KatalogCode217?,
      relevanz: List<KatalogCode273>?,
      europaeischeStraftatenkategorie: List<KatalogCode272_NichtAbgeschlossen>?,
      kurzdarstellung: String?,
      hoechstfreiheitsstrafe: Double?,
      tatbestandsmerkmal: List<KatalogCode304_NichtAbgeschlossen>?,
      ende: DatumZeit?,
      beginn: DatumZeit?,
      dokument: List<Dokument>?,
      pMK: PMK?,
      gesamtschaden: Geldbetrag?,
      pKS: PKS?,
      feststellungszeit: DatumZeit?,
      modusOperandi: List<ModusOperandi>?,
      redundanzinformation: Redundanzinformation?,
      opfertypus: List<KatalogCode318_MitZusatz>?,
      taetertypus: List<KatalogCode318_MitZusatz>?,
      eIS: EIS?,
      zukuenftigeStraftat: KatalogCode217?,
      aSTRALSchluessel: String?,
      rechtsgut: List<KatalogCode370>?,
      hyDaNeKennzeichnung: HyDaNeKennzeichnung?
  ) : this() {
    this.delikt = delikt
    this.bezeichnung = bezeichnung
    this.spezifikation = spezifikation
    this.versuch = versuch
    this.relevanz = relevanz
    this.europaeischeStraftatenkategorie = europaeischeStraftatenkategorie
    this.kurzdarstellung = kurzdarstellung
    this.hoechstfreiheitsstrafe = hoechstfreiheitsstrafe
    this.tatbestandsmerkmal = tatbestandsmerkmal
    this.ende = ende
    this.beginn = beginn
    this.dokument = dokument
    this.pMK = pMK
    this.gesamtschaden = gesamtschaden
    this.pKS = pKS
    this.feststellungszeit = feststellungszeit
    this.modusOperandi = modusOperandi
    this.redundanzinformation = redundanzinformation
    this.opfertypus = opfertypus
    this.taetertypus = taetertypus
    this.eIS = eIS
    this.zukuenftigeStraftat = zukuenftigeStraftat
    this.aSTRALSchluessel = aSTRALSchluessel
    this.rechtsgut = rechtsgut
    this.hyDaNeKennzeichnung = hyDaNeKennzeichnung
  }
}
