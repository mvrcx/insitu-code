package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Einige Wasserfahrzeuge unterliegen einer Kennzeichenpflicht (z. B. Sportboote gemäß 'Verordnung
 * über die Kennzeichnung von auf Binnenschiffahrtsstraßen verkehrenden Kleinfahrzeugen' oder
 * Fischereifahrzeuge).
 *  
 * Beispiele:
 * Sportboot: HMÜ - X 222
 * Fischereifahrzeug (Seefischerschiff): LIST 22
 */
@Serializable
public open class ZulassungsinformationWasserfahrzeug() {
  /**
   * Das Kennzeichen in alphanumerischer Form.
   *  
   * Beispiele:
   *
   * - HMÜ - X 333 (Kleinfahrzeug auf Binnenschiffahrtsstrassen)
   * - LIST 22 (Fischereikennzeichen)
   */
  public var kennzeichen: String? = null

  /**
   * Art des Kennzeichens.
   *  
   * Beispiele:
   *
   * - Kennzeichen für Fischereifahrzeuge
   * - Kennzeichen für deutsche Kleinfahrzeuge in Deutschland (amtlich oder amtlich anerkannt)
   */
  public var kennzeichenArt: KatalogCode284_NichtAbgeschlossen? = null

  /**
   * Das Unterscheidungssignal ist ein eindeutiges Identifikationsmerkmal, das Seeschiffen bei
   * Eintragung in das Schiffsregister zugeteilt wird. Es ist gleichzeitig auch Rufzeichen im
   * Seefunkdienst.
   */
  public var unterscheidungssignal: String? = null

  /**
   * Gültigkeitsbeginn der Zulassungsinformation.
   */
  public var gueltigVon: String? = null

  /**
   * Gültigkeitssende der Zulassungsinformation.
   */
  public var gueltigBis: String? = null

  /**
   * Angabe der Zulassungsstelle des Wasserfahrzeugs.
   */
  public var zulassungsstelle: BeteiligteStelle? = null

  /**
   * Angabe über die Art der Zulassung eines Wasserfahrzeugs.
   */
  public var art: KatalogCode402? = null

  public constructor(
      kennzeichen: String?,
      kennzeichenArt: KatalogCode284_NichtAbgeschlossen?,
      unterscheidungssignal: String?,
      gueltigVon: String?,
      gueltigBis: String?,
      zulassungsstelle: BeteiligteStelle?,
      art: KatalogCode402?
  ) : this() {
    this.kennzeichen = kennzeichen
    this.kennzeichenArt = kennzeichenArt
    this.unterscheidungssignal = unterscheidungssignal
    this.gueltigVon = gueltigVon
    this.gueltigBis = gueltigBis
    this.zulassungsstelle = zulassungsstelle
    this.art = art
  }
}
