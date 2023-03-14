package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Inhaltsstoffe eines Betäubungsmittels bezogen auf dieselbe Maßeinheit, d. h. dass sich z. B. alle
 * Angaben auf das Volumen beziehen müssen.
 */
@Serializable
public open class Inhaltsstoff() {
  /**
   * Hier werden die Inhaltsstoffe eines Betäubungsmittels abgebildet.
   *
   * Beispiel: THC, DMBA.
   */
  public var inhaltsstoff: String? = null

  /**
   * Hier wird der prozentuale Anteil des jeweiligen Inhaltsstoffes des Betäubungsmittels
   * abgebildet.
   */
  public var anteilInProzent: Double? = 0.0

  public var volumen: Volumen? = null

  public var gewicht: Gewicht? = null

  public constructor(
      inhaltsstoff: String?,
      anteilInProzent: Double?,
      volumen: Volumen?,
      gewicht: Gewicht?
  ) : this() {
    this.inhaltsstoff = inhaltsstoff
    this.anteilInProzent = anteilInProzent
    this.volumen = volumen
    this.gewicht = gewicht
  }
}
