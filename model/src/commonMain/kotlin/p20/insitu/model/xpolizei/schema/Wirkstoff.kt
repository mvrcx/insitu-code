package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Stoffe, die in einem Arzneimittel enthalten sind.
 */
@Serializable
public open class Wirkstoff() {
  /**
   * Angabe des Wirkstoffs.
   */
  public var bezeichnung: String? = null

  public var gewicht: Gewicht? = null

  public constructor(bezeichnung: String?, gewicht: Gewicht?) : this() {
    this.bezeichnung = bezeichnung
    this.gewicht = gewicht
  }
}
