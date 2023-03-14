package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Angabe zu Nummern einer Organisation.
 */
@Serializable
public open class NummerDerOrganisation() {
  /**
   * Dieses Feld enthält Angaben zur Art der Nummer einer Organisation.
   */
  public var art: KatalogCode365_NichtAbgeschlossen? = null

  /**
   * Alphanumerische Darstellung der Nummer.
   *
   * Beispiel: 'M0104579'
   */
  public var nummer: Nummer? = null

  public constructor(art: KatalogCode365_NichtAbgeschlossen?, nummer: Nummer?) : this() {
    this.art = art
    this.nummer = nummer
  }
}
