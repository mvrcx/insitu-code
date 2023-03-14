package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angabe der PLZ und des Ortes.
 */
@Serializable
public open class PLZOrt() {
  /**
   * Hier wird der Ortsname der Adresse abgebildet, z. B. Köln.
   */
  public var ortsname: String? = null

  /**
   * Hier wird die Postleitzahl einer Adresse abgebildet, z. B. 81375.
   */
  public var pLZ: String? = null

  /**
   * Hier wird der Name des Landes / Gebiets abgebildet, in dem sich die Adresse befindet.
   */
  public var staat: KatalogCode285_NichtAbgeschlossen? = null

  public constructor(
    ortsname: String?,
    pLZ: String?,
    staat: KatalogCode285_NichtAbgeschlossen?
  ) : this() {
    this.ortsname = ortsname
    this.pLZ = pLZ
    this.staat = staat
  }
}
