package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Darstellung von Schuhgrößen in verschiedenen Maßeinheiten.
 */
@Serializable
public open class Schuhgroesse() {
  /**
   * Maßeinheit der Schuhgröße.
   */
  public var masseinheit: KatalogCode269_NichtAbgeschlossen? = null

  /**
   * Angabe eines Wertes oder Wertebereichs in der durch die BK Masseinheit bestimmten Einheit.
   *
   * Beispiele: 12 (m), 2 (cm)
   */
  public var wertangabe: Wertangabe? = null

  /**
   * Art, wie die Schuhgröße festgestellt wurde.
   *
   * Beispiele: gemessen, geschätzt
   */
  public var feststellungsart: KatalogCode206? = null

  public constructor(
      masseinheit: KatalogCode269_NichtAbgeschlossen?,
      wertangabe: Wertangabe?,
      feststellungsart: KatalogCode206?
  ) : this() {
    this.masseinheit = masseinheit
    this.wertangabe = wertangabe
    this.feststellungsart = feststellungsart
  }
}
