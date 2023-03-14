package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Alle Maßnahmen der Polizei gem. StPO, Polizeirecht und weiteren Rechtsgrundlagen, aber auch alle
 * Maßnahmen, die Behörden mit hoheitlichen Befugnissen im Rahmen ihrer Zusammenarbeit mit der Polizei
 * durchführen bzw. anordnen können. Maßnahmen, die von privaten Instituten im hoheitlichen Auftrag
 * durchgeführt werden, wie KT-Untersuchungen, sind auch hoheitliche Maßnahmen.
 */
@Serializable
public open class HoheitlicheMassnahme() : HoheitlicheMassnahme_Leer() {
  /**
   * Angabe der Art der Maßnahme.
   *
   * - in den Polizeigesetzen der Länder und der Strafprozessordnung und Nebengesetzen definierten
   * polizeilichen Maßnahmen
   * - Maßnahmen von Behörden mit hoheitlichen Befugnissen im Rahmen ihrer Zusammenarbeit mit der
   * Polizei
   * - von privaten Instituten im hoheitlichen Auftrag
   *
   *  
   * Beispiele:
   * - Abschiebung
   * - Aufenthaltsermittlung
   * - Erkennungsdienstliche Maßnahme
   * - Gefährdetenansprache
   * - Identitätsfeststellung
   * - Ingewahrsamnahme
   * - Kontrolle
   * - Rechtshilfe
   * - Rückkehrverbot
   * - Sicherstellung
   * - Zurückweisung
   */
  public var art: KatalogCode108? = null

  /**
   * Bezeichnung der Maßnahme.
   *  
   * Beispiel: Beschuldigtenvernehmung
   */
  public var bezeichnung: String? = null

  /**
   * Nähere Erläuterung zur durchgeführten Maßnahme.
   *  
   * Beispiel: Vernehmung nach der Reid-Methode
   */
  public var spezifikation: String? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob eine Maßnahme verdeckt oder nicht verdeckt (offen)
   * durchgeführt wurde.
   */
  public var verdeckteMassnahme: KatalogCode217? = null

  /**
   * Freitextliche Bemerkung zur Maßnahme.
   */
  public var bemerkung: String? = null

  /**
   * Zeitpunkt, zu dem die Durchführung der Maßnahme begonnen hat.
   */
  public var beginn: DatumZeit? = null

  /**
   * Zeitpunkt, zu dem die Durchführung der Maßnahme beendet war. Keine Angabe bedeutet: Die
   * Maßnahme dauert noch an. 
   */
  public var ende: DatumZeit? = null

  /**
   * Ein zu einer hoheitlichenMaßnahme gehörendes Dokument einer öffentlichen Stelle
   *
   * Beispiele:
   * - Anordnung zur Durchsuchung
   * - Haftbefehl
   * - Protokoll 
   */
  public var dokument: List<Dokument>? = null

  /**
   * Angabe der beteiligten Stelle.
   */
  public var beteiligung: List<BeteiligteStelleBeteiligungsart>? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Priorität der Hoheitlichen Maßnahme.
   */
  public var prioritaet: KatalogCode235? = null

  /**
   * Angabe, ob ein Widerspruch gegen die hoheitliche Maßnahme eingelegt wurde.
   */
  public var widerspruch: KatalogCode217? = null

  /**
   * Katalogisierte nähere Erläuterung zur durchgeführten Maßnahme.
   *
   * Beispiel: Schutzmaßnahme 1
   */
  public var spezifikationKatalogisiert: KatalogCode404? = null

  public var rechtsgrundlage: Rechtsgrundlage? = null

  /**
   * Kategorisierung von Erhebungsmaßnahmen anhand ihrer Eingriffsintensität, mit dem Ziel der
   * späteren Vergleichbarkeit im Rahmen der hyDaNe.
   */
  public var hyDaNeKategorie: KatalogCode408? = null

  public constructor(
      art: KatalogCode108?,
      bezeichnung: String?,
      spezifikation: String?,
      verdeckteMassnahme: KatalogCode217?,
      bemerkung: String?,
      beginn: DatumZeit?,
      ende: DatumZeit?,
      dokument: List<Dokument>?,
      beteiligung: List<BeteiligteStelleBeteiligungsart>?,
      redundanzinformation: Redundanzinformation?,
      prioritaet: KatalogCode235?,
      widerspruch: KatalogCode217?,
      spezifikationKatalogisiert: KatalogCode404?,
      rechtsgrundlage: Rechtsgrundlage?,
      hyDaNeKategorie: KatalogCode408?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.spezifikation = spezifikation
    this.verdeckteMassnahme = verdeckteMassnahme
    this.bemerkung = bemerkung
    this.beginn = beginn
    this.ende = ende
    this.dokument = dokument
    this.beteiligung = beteiligung
    this.redundanzinformation = redundanzinformation
    this.prioritaet = prioritaet
    this.widerspruch = widerspruch
    this.spezifikationKatalogisiert = spezifikationKatalogisiert
    this.rechtsgrundlage = rechtsgrundlage
    this.hyDaNeKategorie = hyDaNeKategorie
  }
}
