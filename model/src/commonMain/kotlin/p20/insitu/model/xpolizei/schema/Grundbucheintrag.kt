package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Das Grundbuch ist ein amtliches öffentliches Verzeichnis von Grundstücken, in dem die
 * Eigentumsverhältnisse sowie etwaige mit dem Grundstück verbundene Rechte und auf ihm liegende Lasten
 * erfasst werden.
 */
@Serializable
public open class Grundbucheintrag() {
  /**
   * Hier erfolgt die Angabe der Grundbuchnummer der Immobilie (Angabe von Band und Blatt).
   */
  public var grundbuchnummer: String? = null

  /**
   * Angabe des Grundbuchamtes.
   */
  public var grundbuchamt: BeteiligteStelle? = null

  public constructor(grundbuchnummer: String?, grundbuchamt: BeteiligteStelle?) : this() {
    this.grundbuchnummer = grundbuchnummer
    this.grundbuchamt = grundbuchamt
  }
}
