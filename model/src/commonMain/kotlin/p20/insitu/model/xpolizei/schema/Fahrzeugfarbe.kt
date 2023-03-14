package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Angabe der Fahrzeugfarbe.
 */
@Serializable
public open class Fahrzeugfarbe() {
  /**
   * Farbe bzw. Farbkombinationen eines Fahrzeugs.
   */
  public var farbangabe: List<Farbangabe>? = null

  /**
   * Angabe, bis wann diese Farbe(n) des Fahrzeuges bestand. 
   */
  public var bis: String? = null

  /**
   * Angabe, ab wann diese Farbe(n) des Fahrzeuges bestand. 
   */
  public var von: String? = null

  public constructor(
      farbangabe: List<Farbangabe>?,
      bis: String?,
      von: String?
  ) : this() {
    this.farbangabe = farbangabe
    this.bis = bis
    this.von = von
  }
}
