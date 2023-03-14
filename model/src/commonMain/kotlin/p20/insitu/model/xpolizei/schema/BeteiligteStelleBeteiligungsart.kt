package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Das Fachobjekt BeteiligteStelleBeteiligungsart ist eine Spezialisierung des Fachobjekts
 * BeteiligteStelle, weil hier gegenüber der beteiligten Stelle zusätzlich Vorgangs-, Hinweis-,
 * Maßnahmen- bzw. ITÜ-spezifische Beteiligungsarten (z. B. anordnende, ersuchende, sachbearbeitende,
 * aufnehmende oder durchführende Dienststelle) benötigt werden und außerdem der Zeitraum der
 * Beteiligung (zu Protokollzwecken) festzuhalten ist.
 */
@Serializable
public open class BeteiligteStelleBeteiligungsart() : BeteiligteStelle() {
  /**
   * Hier wird die Art der Beteiligung einer Stelle im Vorgang, Hinweis, hoheitlichen Maßnahme oder
   * der TKÜ-Maßnahme abgebildet, z. B. 'anordnende Stelle', 'sachbearbeitende Stelle'.
   */
  public var artDerBeteiligung: KatalogCode213? = null

  /**
   * Angabe des Datums, ab dem die Stelle beteiligt war.
   */
  public var von: DatumZeit? = null

  /**
   * Angabe des Datums, bis zu dem die Stelle beteiligt war.
   */
  public var bis: DatumZeit? = null

  public constructor(
      artDerBeteiligung: KatalogCode213?,
      von: DatumZeit?,
      bis: DatumZeit?
  ) : this() {
    this.artDerBeteiligung = artDerBeteiligung
    this.von = von
    this.bis = bis
  }
}
