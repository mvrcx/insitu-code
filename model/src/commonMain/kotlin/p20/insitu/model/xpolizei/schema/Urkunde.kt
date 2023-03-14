package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Urkunden sind verkörperte, für den Rechtsverkehr bestimmte Erklärungen. Dies sind alle
 * Gegenstände, die bestimmt und geeignet sind, durch ihren gedanklichen Inhalt eine rechtlich
 * erhebliche Tatsache zu beweisen.
 */
@Serializable
public open class Urkunde() : Urkunde_Leer() {
  /**
   * Art der Urkunde.
   *  
   * Beispiele: Ausweis, Sterbeurkunde, Wertpapier (auch Bundesschuldverschreibung), Zahlungsmittel,
   * Vertrag, Totenschein
   */
  public var art: KatalogCode122_NichtAbgeschlossen? = null

  /**
   * Bezeichnung der Urkunde.
   */
  public var bezeichnung: String? = null

  /**
   * Die Sprachen, in denen die Urkunde abgefasst ist.
   *  
   * Beispiele: deutsch, polnisch
   */
  public var sprache: List<KatalogCode203_NichtAbgeschlossen>? = null

  /**
   * Angabe, ob es sich um ein oder mehrere Blankodokumente handelt.
   */
  public var blankodokument: KatalogCode214? = null

  /**
   * Einträge in einer öffentlichen Urkunde. Im Wesentlichen relevant bei Reisedokumenten, welche
   * Visa-Einträge oder Ein- und Ausreisestempel enthalten.
   *  
   * Alle Einträge werden in einem Freitextfeld beschrieben.
   *  
   * Beispiel: Einreisestempel USA, Department of the interior, SFO, 2000-03-20
   */
  public var eintraege: String? = null

  /**
   * Bemerkung zur individuellen Urkunde.
   *  
   * Beispiel: 'Deckblatt vergilbt'
   */
  public var bemerkung: String? = null

  /**
   * Angabe zur nationalen oder organisatorischen Zugehörigkeit einer Urkunde (Staat, Gebiet oder
   * Organisation).
   */
  public var nationalitaet: KatalogCode398_NichtAbgeschlossen? = null

  /**
   * Dieses Feld enthält Angaben zur Anzahl von Urkunden.
   */
  public var stueckzahl: Int? = 0

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Beginn der Gueltigkeit der Urkunde. Fehlender Eintrag bedeutet entweder, dass die Urkunde ab
   * Ausstellungsdatum gilt, oder dass die Art der Urkunde nicht der Angabe eines Gueltigkeitsbeginns
   * bedarf.
   */
  public var gueltigVon: String? = null

  /**
   * Ende der Gültigkeit.
   *
   * Fehlender Eintrag bedeutet entweder unbegrenzte Gültigkeit oder unbekanntes Gültigkeitsende.
   */
  public var gueltigBis: String? = null

  /**
   * Dokument zu einer Urkunde. Z. B. eingescannter Reisepass 
   */
  public var dokument: List<Dokument>? = null

  /**
   * Serie, die aus Identifizierungsnummern gebildet wird. Ausgehend von
   * Urkunde.Nummernangabe.Nummer wird (Serie.Anzahl-1) mal der Wert Serie.Inkrement addiert, um die
   * Elemente der Serie zu bilden. Voraussetzung: Identifizierungsnummer hat einen Aufbau, der
   * numerisches Erhöhen zulässt (d. h. endet mit so vielen Dezimalstellen, dass sinnvolles
   * inkrementieren möglich ist).
   *  
   * Beispiel:
   * - Identifizierungsnummer X3405052
   * - Serie.Anzahl 3
   * - Serie.Inkrement 2
   *  
   * Elemente der Serie X3405052, X3405054, X3405056.
   */
  public var identifizierungsnummernserie: Serie? = null

  /**
   * Öffentliche Stelle, welche eine öffentliche Urkunde ausgestellt hat
   *
   * Beispiel: Führerschein ausgestellt vom Landrat des XY-Kreises 
   */
  public var ausgestelltVon: BeteiligteStelle? = null

  /**
   * Nennwert einer Urkunde (zum Beispiel Wertpapier)
   *
   * Beispiel: 'Vorzugsaktie der XY AG ueber 50 DM' 
   */
  public var nennwert: Geldbetrag? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Angabe zur Art der Führerscheinklasse.
   */
  public var eUFuehrerscheinklasse: List<KatalogCode353>? = null

  public var asservat: Asservat? = null

  /**
   * Fälschungseigenschaften von Urkunden.
   */
  public var faelschung: FaelschungUrkunde? = null

  public var nummernangabe: List<Nummernangabe>? = null

  /**
   * Angabe, dass eine Urkunde elektronische Komponenten beinhaltet.
   */
  public var elektronisch: KatalogCode217? = null

  /**
   * Aus der Urkunde ersichtlicher Ausstellungszeitpunkt.
   */
  public var ausstellungszeitpunkt: DatumZeit? = null

  /**
   * Angabe von sachgebundenen Hinweisen zu Urkunden.
   */
  public var sachgebundenerHinweis: List<String>? = null

  public constructor(
      art: KatalogCode122_NichtAbgeschlossen?,
      bezeichnung: String?,
      sprache: List<KatalogCode203_NichtAbgeschlossen>?,
      blankodokument: KatalogCode214?,
      eintraege: String?,
      bemerkung: String?,
      nationalitaet: KatalogCode398_NichtAbgeschlossen?,
      stueckzahl: Int?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      gueltigVon: String?,
      gueltigBis: String?,
      dokument: List<Dokument>?,
      identifizierungsnummernserie: Serie?,
      ausgestelltVon: BeteiligteStelle?,
      nennwert: Geldbetrag?,
      redundanzinformation: Redundanzinformation?,
      eUFuehrerscheinklasse: List<KatalogCode353>?,
      asservat: Asservat?,
      faelschung: FaelschungUrkunde?,
      nummernangabe: List<Nummernangabe>?,
      elektronisch: KatalogCode217?,
      ausstellungszeitpunkt: DatumZeit?,
      sachgebundenerHinweis: List<String>?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.sprache = sprache
    this.blankodokument = blankodokument
    this.eintraege = eintraege
    this.bemerkung = bemerkung
    this.nationalitaet = nationalitaet
    this.stueckzahl = stueckzahl
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.gueltigVon = gueltigVon
    this.gueltigBis = gueltigBis
    this.dokument = dokument
    this.identifizierungsnummernserie = identifizierungsnummernserie
    this.ausgestelltVon = ausgestelltVon
    this.nennwert = nennwert
    this.redundanzinformation = redundanzinformation
    this.eUFuehrerscheinklasse = eUFuehrerscheinklasse
    this.asservat = asservat
    this.faelschung = faelschung
    this.nummernangabe = nummernangabe
    this.elektronisch = elektronisch
    this.ausstellungszeitpunkt = ausstellungszeitpunkt
    this.sachgebundenerHinweis = sachgebundenerHinweis
  }
}
