package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angabe von Informationen zu Beschlüssen.
 */
@Serializable
public open class Beschlussinformation() {
  /**
   * Der Beschluss der anordnenden Stelle, auf deren Grundlage die Maßnahme durchgeführt wird.
   */
  public var beschluss: Dokument? = null

  /**
   * Gem. Beschluss festgelegter Beginn der Maßnahme.
   */
  public var beginn: String? = null

  /**
   * Gem. Beschluss festgelegtes Ende der Maßnahme.
   */
  public var ende: String? = null

  public constructor(
      beschluss: Dokument?,
      beginn: String?,
      ende: String?
  ) : this() {
    this.beschluss = beschluss
    this.beginn = beginn
    this.ende = ende
  }
}
