package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Angabe des Datenursprungs und in diesem Zusammenhang stehende Besonderheiten des Fachobjekts.
 */
@Serializable
public open class Datenursprung() {
  /**
   * Angabe der Quelle, aus der das Fachobjekt stammt.
   */
  public var quelle: KatalogCode319_NichtAbgeschlossen? = null

  /**
   * Angabe von Besonderheiten des Fachobjekts, die im Zusammenhang mit der Quelle stehen.
   */
  public var besonderheit: List<KatalogCode320>? = null

  /**
   * Angabe der ID des Datenursprungs.
   */
  public var quelleID: List<String>? = null

  public constructor(
      quelle: KatalogCode319_NichtAbgeschlossen?,
      besonderheit: List<KatalogCode320>?,
      quelleID: List<String>?
  ) : this() {
    this.quelle = quelle
    this.besonderheit = besonderheit
    this.quelleID = quelleID
  }
}
