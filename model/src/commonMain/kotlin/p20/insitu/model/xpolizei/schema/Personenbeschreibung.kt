package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Beschreibung einer Person, beispielsweise durch einen Zeugen einer Straftat, Videoauswertung
 * (Überwachung) oder im Rahmen einer ED-Behandlung festgestellt.
 */
@Serializable
public open class Personenbeschreibung() : Personenbeschreibung_Leer() {
  /**
   * Dieses Feld enthält einen Katalog mit Bartarten.
   *  
   * Beispiele: Vollbart, Oberlippenbart, 3-Tage-Bart
   */
  public var bart: KatalogCode259_NichtAbgeschlossen? = null

  /**
   * Dieses Feld enthält Angaben zu auffälligen Verhaltensweisen und Gewohnheiten.
   *
   * Beispiele: nervöses Zwinkern, Linkshänder, Raucher
   */
  public var auffaelligesVerhaltenGewohnheiten: List<KatalogCode384_NichtAbgeschlossen>? = null

  /**
   * Abstammungsbezogene äußere, allgemeine Merkmale einer Person.
   *  
   * Beispiele: afrikanisch, südostasiatisch
   */
  public var geografiebezogenesErscheinungsbild: KatalogCode260? = null

  /**
   * Dieses Feld enthält einen Katalog mit Gesichtsformen.
   */
  public var gesichtsform: KatalogCode261? = null

  /**
   * Dieses Feld enthält einen Katalog mit Angaben zur Gestalt.
   *  
   * Beispiele: dick, schlank
   */
  public var gestalt: KatalogCode262? = null

  /**
   * Angaben zum vermuteten Geschlecht einer Person.
   *  
   * Beispiele: männlich, weiblich
   */
  public var vermutetesGeschlecht: KatalogCode382? = null

  /**
   * Angabe, ob eine Person eine Sehhilfe benötigt.
   */
  public var sehhilfe: KatalogCode217? = null

  /**
   * Dieses Feld enthält einen Katalog mit Angaben zur Stimme.
   *  
   * Beispiele: lispelnd, stotternd, heiser
   */
  public var stimme: List<KatalogCode264>? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Dieses Feld enthält eine freitextliche Bemerkung zur Personenbeschreibung, die nicht über das
   * strukturierte Attribut abgebildet werden können, z. B. Angaben zu Kleidungen.
   */
  public var bemerkung: String? = null

  /**
   * Angabe der Körpergröße.
   */
  public var groesse: Ausmass? = null

  public var merkmal: List<Merkmal>? = null

  public var gewicht: Gewicht? = null

  public var sprachkenntnis: List<Sprachangabe>? = null

  public var taetowierung: List<Taetowierung>? = null

  /**
   * Das in der Regel genannte 'geschätzte Alter' soll aus Gründen der andauernden Aktualität als
   * geschätztes Geburtsdatum eingetragen werden. 
   */
  public var geschaetztesGeburtsjahrVon: String? = null

  /**
   * Das in der Regel genannte 'geschätzte Alter' soll aus Gründen der andauernden Aktualität als
   * geschätztes Geburtsdatum eingetragen werden.
   */
  public var geschaetztesGeburtsjahrBis: String? = null

  public var gebiss: Gebiss? = null

  public var verletzung: List<Verletzung>? = null

  public var dokument: List<Dokument>? = null

  public var schuhgroesse: Schuhgroesse? = null

  /**
   * Angaben zur Augenfarbe.
   *
   * Beispiele: braun, blau
   */
  public var augenfarbe: List<KatalogCode317>? = null

  /**
   * Dieses Feld enthält Angaben zu auffälligen Gerüchen des Täters.
   *
   * Beispiele: Alkohol, Tabak
   */
  public var auffallenderGeruch: List<KatalogCode312_NichtAbgeschlossen>? = null

  /**
   * Dieses Feld enthält Angaben über szenetypische oder auffällige Bekleidung, die eine Person
   * getragen hat.
   */
  public var szenetypischeAuffaelligeBekleidung: List<KatalogCode373>? = null

  /**
   * Angaben zur Beschreibung von Kopfhaaren.
   */
  public var kopfhaar: Kopfhaar? = null

  /**
   * Dieses Feld enthält Angaben über die Hautfarbe einer Person.
   */
  public var hautfarbe: KatalogCode385? = null

  public constructor(
      bart: KatalogCode259_NichtAbgeschlossen?,
      auffaelligesVerhaltenGewohnheiten: List<KatalogCode384_NichtAbgeschlossen>?,
      geografiebezogenesErscheinungsbild: KatalogCode260?,
      gesichtsform: KatalogCode261?,
      gestalt: KatalogCode262?,
      vermutetesGeschlecht: KatalogCode382?,
      sehhilfe: KatalogCode217?,
      stimme: List<KatalogCode264>?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      bemerkung: String?,
      groesse: Ausmass?,
      merkmal: List<Merkmal>?,
      gewicht: Gewicht?,
      sprachkenntnis: List<Sprachangabe>?,
      taetowierung: List<Taetowierung>?,
      geschaetztesGeburtsjahrVon: String?,
      geschaetztesGeburtsjahrBis: String?,
      gebiss: Gebiss?,
      verletzung: List<Verletzung>?,
      dokument: List<Dokument>?,
      schuhgroesse: Schuhgroesse?,
      augenfarbe: List<KatalogCode317>?,
      auffallenderGeruch: List<KatalogCode312_NichtAbgeschlossen>?,
      szenetypischeAuffaelligeBekleidung: List<KatalogCode373>?,
      kopfhaar: Kopfhaar?,
      hautfarbe: KatalogCode385?
  ) : this() {
    this.bart = bart
    this.auffaelligesVerhaltenGewohnheiten = auffaelligesVerhaltenGewohnheiten
    this.geografiebezogenesErscheinungsbild = geografiebezogenesErscheinungsbild
    this.gesichtsform = gesichtsform
    this.gestalt = gestalt
    this.vermutetesGeschlecht = vermutetesGeschlecht
    this.sehhilfe = sehhilfe
    this.stimme = stimme
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.groesse = groesse
    this.merkmal = merkmal
    this.gewicht = gewicht
    this.sprachkenntnis = sprachkenntnis
    this.taetowierung = taetowierung
    this.geschaetztesGeburtsjahrVon = geschaetztesGeburtsjahrVon
    this.geschaetztesGeburtsjahrBis = geschaetztesGeburtsjahrBis
    this.gebiss = gebiss
    this.verletzung = verletzung
    this.dokument = dokument
    this.schuhgroesse = schuhgroesse
    this.augenfarbe = augenfarbe
    this.auffallenderGeruch = auffallenderGeruch
    this.szenetypischeAuffaelligeBekleidung = szenetypischeAuffaelligeBekleidung
    this.kopfhaar = kopfhaar
    this.hautfarbe = hautfarbe
  }
}
