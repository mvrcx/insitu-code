package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Angabe bzgl. einer Unterbrechung der ITÜ-Maßnahme.
 */
@Serializable
public open class Unterbrechung() {
  /**
   * Beginn der Unterbrechung der TKÜ-Maßnahme.
   */
  public var beginn: DatumZeit? = null

  /**
   * Ende der Unterbrechung der TKÜ-Maßnahme.
   */
  public var ende: DatumZeit? = null

  public constructor(beginn: DatumZeit?, ende: DatumZeit?) : this() {
    this.beginn = beginn
    this.ende = ende
  }
}
