package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Angaben zur Kernbereichslöschung.
 */
@Serializable
public open class Kernbereichsloeschung() {
  /**
   * Status der Kernbereichslöschung.
   */
  public var status: KatalogCode360? = null

  /**
   * Angabe von Datum und Uhrzeit zu dem der Status der Kernbereichslöschung angegeben wurde.
   */
  public var zeitpunkt: DatumZeit? = null

  public constructor(status: KatalogCode360?, zeitpunkt: DatumZeit?) : this() {
    this.status = status
    this.zeitpunkt = zeitpunkt
  }
}
