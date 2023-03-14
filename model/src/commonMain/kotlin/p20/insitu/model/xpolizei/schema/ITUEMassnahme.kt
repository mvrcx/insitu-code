package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Unter Informationstechnischen Überwachungsmaßnahmen werden
 * Telekommunikationsüberwachungsmaßnahmen und andere informationstechnische Überwachungen (wie z. B.
 * GPS-Tracking) verstanden. Das Fachobjekt ITÜ dient der Abbildung und Klammerung der inhaltlichen
 * Daten (z. B. Kommunikationsereignisse).
 * Weitere fachliche Informationen zu ITÜ-Maßnahmen, wie z. B. Rechtsgrundlage, überwachte Person,
 * etc. werden mittels des Fachobjekts 'HoheitlicheMassnahme' abgebildet.
 */
@Serializable
public open class ITUEMassnahme() : ITUEMassnahme_Leer() {
  /**
   * Bezeichnung der Maßnahme.
   *  
   * Beispiele:
   * - Überwachung Mobiltelefon-Anschluss +49 175 67896789
   * - Überwachung DSL Anschluss
   */
  public var bezeichnung: String? = null

  /**
   * Die Leitungsnummer ist eine technische Information zum Speicherbereich der aufzeichnenden
   * Anlage.
   *
   * Beispiel: 232_ZW_23818
   */
  public var leitungsnummer: String? = null

  /**
   * Bemerkung zur ITÜ-Maßnahme.
   *
   * Beispiel: Häufiger Wechsel der SIM-Karte
   */
  public var bemerkung: String? = null

  /**
   * Angabe der beteiligten Stelle.
   */
  public var sachbearbeitung: List<BeteiligteStelleBeteiligungsart>? = null

  public var ende: DatumZeit? = null

  public var beginn: DatumZeit? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Angabe von Informationen zu Beschlüssen.
   */
  public var beschlussinformationen: List<Beschlussinformation>? = null

  /**
   * Angabe bzgl. einer Unterbrechung der TKÜ-Maßnahme.
   */
  public var unterbrechung: List<Unterbrechung>? = null

  /**
   * Angabe der Art der ITÜ-Maßnahme.
   */
  public var art: KatalogCode361? = null

  public constructor(
      bezeichnung: String?,
      leitungsnummer: String?,
      bemerkung: String?,
      sachbearbeitung: List<BeteiligteStelleBeteiligungsart>?,
      ende: DatumZeit?,
      beginn: DatumZeit?,
      redundanzinformation: Redundanzinformation?,
      beschlussinformationen: List<Beschlussinformation>?,
      unterbrechung: List<Unterbrechung>?,
      art: KatalogCode361?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.leitungsnummer = leitungsnummer
    this.bemerkung = bemerkung
    this.sachbearbeitung = sachbearbeitung
    this.ende = ende
    this.beginn = beginn
    this.redundanzinformation = redundanzinformation
    this.beschlussinformationen = beschlussinformationen
    this.unterbrechung = unterbrechung
    this.art = art
  }
}
