package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angaben zum Geltungsbereich des Stadionverbots.
 */
@Serializable
public open class Geltungsbereich() {
  /**
   * Beschreibt den bundesweiten Geltungsbereich eines Stadionverbots für die Sportarten Fußball und
   * Eishockey.
   * Bei Fußball sind die ersten vier Ligen inbegriffen, bei Eishockey die DEL und DEL2.
   */
  public var bundesweit: KatalogCode406? = null

  /**
   * Beschreibt den ligaweiten Geltungsbereich eines Stadionverbots für die Sportarten Fußball und
   * Eishockey.
   * Bei Fußball sind die ersten fünf Ligen inbegriffen, bei Eishockey die DEL oder DEL2.
   */
  public var ligaweit: String? = null

  /**
   * Beschreibt den örtlichen Geltungsbereich eines Stadionverbots für die Sportarten Fußball und
   * Eishockey.
   * Bei Fußball sowie bei Eishockey sind hier ausschließlich einzelne Spielstätten inbegriffen.
   */
  public var oertlich: String? = null

  public constructor(
      bundesweit: KatalogCode406?,
      ligaweit: String?,
      oertlich: String?
  ) : this() {
    this.bundesweit = bundesweit
    this.ligaweit = ligaweit
    this.oertlich = oertlich
  }
}
