package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Mögliche Angabe, ob und welche Informationen noch vorhanden, aber nicht Bestandteil des Vorgangs
 * sind. Dieser Hinweis soll Anknüpfungspunkt für weitere Kommunikation sein (Folgeschriftverkehr).
 */
@Serializable
public open class ZusaetzlicheInformationen() {
  /**
   * Bezeichnung der zusätzlichen Informationen.
   * Beispiele: Fingerabdruckblätter, Multimediadateien, DNA etc.
   */
  public var bezeichnung: String? = null

  /**
   * Angabe, ob die genannte zusätzliche Information vorhanden oder nicht vorhanden ist.
   */
  public var vorhanden: KatalogCode217? = null

  public constructor(bezeichnung: String?, vorhanden: KatalogCode217?) : this() {
    this.bezeichnung = bezeichnung
    this.vorhanden = vorhanden
  }
}
