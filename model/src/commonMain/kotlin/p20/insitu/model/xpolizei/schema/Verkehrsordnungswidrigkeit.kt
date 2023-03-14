package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angabe weiterer Informationen zur Verkehrsordnungswidrigkeit.
 */
@Serializable
public open class Verkehrsordnungswidrigkeit() {
  /**
   * Angabe der Verkehrsordnungswidrigkeit nach dem Bußgeldkatalog des KBA.
   *
   * Beispiel: 101000 'Sie kamen von der Fahrbahn ab und verursachten Sachschaden. § 1 Abs. 2, § 49
   * StVO; § 24 StVG'
   */
  public var tatbestandsnummer: KatalogCode352? = null

  /**
   * Konkretisierung der Tatbestandsnummer.
   */
  public var tatbestandsnummerKonkretisierung: String? = null

  public constructor(tatbestandsnummer: KatalogCode352?, tatbestandsnummerKonkretisierung: String?)
      : this() {
    this.tatbestandsnummer = tatbestandsnummer
    this.tatbestandsnummerKonkretisierung = tatbestandsnummerKonkretisierung
  }
}
