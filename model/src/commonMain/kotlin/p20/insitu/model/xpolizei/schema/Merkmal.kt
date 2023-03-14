package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Hier werden körperliche Merkmale einer Person abgebildet, also keine Verhaltensweisen oder
 * Gewohnheiten. Dazu gehören auch fehlende Körperteile.
 */
@Serializable
public open class Merkmal() {
  /**
   * Dieses Feld enthält einen Katalog mit der genauen Bezeichnung des Merkmals.
   */
  public var bezeichnung: KatalogCode243_NichtAbgeschlossen? = null

  /**
   * Angabe des Körperteils, auf dem sich das Merkmal befindet.
   */
  public var lage: Koerperteilangabe? = null

  /**
   * Dieses Feld enthält eine freitextliche Bemerkung zum Merkmal.
   */
  public var bemerkung: String? = null

  public constructor(
      bezeichnung: KatalogCode243_NichtAbgeschlossen?,
      lage: Koerperteilangabe?,
      bemerkung: String?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.lage = lage
    this.bemerkung = bemerkung
  }
}
