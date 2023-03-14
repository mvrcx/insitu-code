package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Angabe zum Ermittlungsunterstützenden Hinweis gem. EHW-Leitfaden.
 */
@Serializable
public open class ErmittlungsunterstuetzenderHinweis() {
  /**
   * Ermittlungsunterstützende Hinweise (EHW) sind Hinweise auf Besonderheiten einer natürlichen
   * Person, die primär dazu geeignet sind, einen polizeilichen Kontext zu verdeutlichen, polizeiliches
   * Handeln zielgerichteter zu steuern bzw. zu unterstützen, oder die dem Schutz Dritter dienen. Sie
   * sind darüber hinaus auch geeignet, Datenbestände für Ermittlungen zu kennzeichnen bzw. zu
   * selektieren.
   *
   * Sekundär kann ein EHW auch dem Schutz der Betroffenen und der eingesetzten Polizeibediensteten
   * dienen.
   * (Quelle: EHW-Leitfaden, Stand 09.02.2016)
   */
  public var eHW: KatalogCode354? = null

  /**
   * Angaben zur Qualifizierung eines Ermittlungsunterstützenden Hinweises.
   */
  public var eHWAuspraegung: List<KatalogCode355>? = null

  public constructor(eHW: KatalogCode354?, eHWAuspraegung: List<KatalogCode355>?) : this() {
    this.eHW = eHW
    this.eHWAuspraegung = eHWAuspraegung
  }
}
