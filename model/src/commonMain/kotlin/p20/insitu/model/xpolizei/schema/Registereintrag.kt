package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Informationen zur autorisierenden Registrierung einer Organisation in einem fachlichen Register.
 * (Quelle: XÖV)
 */
@Serializable
public open class Registereintrag() {
  /**
   * Angabe der Nummer des Registereintrags der Organisation.
   */
  public var nummer: String? = null

  /**
   * Angabe des Datums des Eintrags der Organisation in ein behördliches Register.
   */
  public var eintragsdatum: String? = null

  /**
   * Angabe des Datums der Löschung der Organisation aus einem behördlichen Register.
   */
  public var austragsdatum: String? = null

  /**
   * Höhe des eingetragenen Stamm- oder Grundkapitals der Organisation.
   */
  public var stammkapital_Grundkapital: Geldbetrag? = null

  /**
   * Angabe der Stelle, die den Registereintrag vergeben hat.
   */
  public var behoerde: BeteiligteStelle? = null

  public constructor(
      nummer: String?,
      eintragsdatum: String?,
      austragsdatum: String?,
      stammkapital_Grundkapital: Geldbetrag?,
      behoerde: BeteiligteStelle?
  ) : this() {
    this.nummer = nummer
    this.eintragsdatum = eintragsdatum
    this.austragsdatum = austragsdatum
    this.stammkapital_Grundkapital = stammkapital_Grundkapital
    this.behoerde = behoerde
  }
}
