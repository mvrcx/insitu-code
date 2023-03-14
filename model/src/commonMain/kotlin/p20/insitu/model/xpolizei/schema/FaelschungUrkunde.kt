package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Fälschungseigenschaften von Urkunden.
 */
@Serializable
public open class FaelschungUrkunde() {
  /**
   * Angabe zur Fälschungsart einer Urkunde.
   *
   * Katalogwerte:
   * -Totalfälschung
   * -Verfälschung
   * -unbekannt
   *
   * Anmerkung: Fälschungsart 'unbekannt' wird verwendet, wenn eine Fälschung vermutet wird, aber
   * nicht bekannt ist, welche Fälschungsart vorliegt.
   * Blankodokumente / -urkunden werden über ein separates Attribut des Fachobjekts Urkunde
   * abgebildet.
   */
  public var art: KatalogCode222? = null

  /**
   * Angabe von Fälschungsmerkmalen.
   */
  public var merkmal: List<KatalogCode357>? = null

  public constructor(art: KatalogCode222?, merkmal: List<KatalogCode357>?) : this() {
    this.art = art
    this.merkmal = merkmal
  }
}
