package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Ausgangsstoffe, die häufig zur unerlaubten Herstellung von Betäubungsmitteln, Suchtstoffen oder
 * psychotropen Substanzen verwendet werden, einschließlich Mischungen und Naturprodukte, die derartige
 * Stoffe enthalten (Drogenausgangsstoffe).
 */
@Serializable
public open class Grundstoff() : Arznei_Betaeubungsmittel_Grundstoff() {
  /**
   * Angabe der Art des Grundstoffs.
   *
   * Beispiele: Aceton, Benzaldehyd
   */
  public var art: KatalogCode313? = null

  public constructor(art: KatalogCode313?) : this() {
    this.art = art
  }
}
