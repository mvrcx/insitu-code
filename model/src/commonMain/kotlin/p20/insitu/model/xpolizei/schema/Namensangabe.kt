package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Namen von Personen oder Organisationen sowie abweichende Schreibweisen dieser Namen.
 */
@Serializable
public open class Namensangabe() {
  /**
   * Angaben zum Namen.
   */
  public var bezeichnung: String? = null

  /**
   * Angabe von abweichenden Namensschreibweisen.
   */
  public var abweichendeSchreibweise: List<String>? = null

  public constructor(bezeichnung: String?, abweichendeSchreibweise: List<String>?) : this() {
    this.bezeichnung = bezeichnung
    this.abweichendeSchreibweise = abweichendeSchreibweise
  }
}
