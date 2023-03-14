package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Ein Allel bezeichnet eine mögliche Ausprägung eines Gens, das sich an einem bestimmten Ort auf
 * einem Chromosom befindet.
 */
@Serializable
public open class Allel() {
  /**
   * Dieses Feld enthält Angaben zur genauen Ausprägung eines Allels.
   */
  public var auspraegung: KatalogCode201? = null

  /**
   * Dieses Feld enthält Angaben zur Untergrenze des Allels.
   */
  public var untergrenze: String? = null

  /**
   * Dieses Feld enthält Angaben zur Obergrenze des Allels.
   */
  public var obergrenze: String? = null

  public constructor(
      auspraegung: KatalogCode201?,
      untergrenze: String?,
      obergrenze: String?
  ) : this() {
    this.auspraegung = auspraegung
    this.untergrenze = untergrenze
    this.obergrenze = obergrenze
  }
}
