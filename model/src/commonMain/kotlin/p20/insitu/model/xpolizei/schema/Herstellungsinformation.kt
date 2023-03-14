package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angaben zur Herstellung einer Sache, wie BtM, Waffe oder sonstige Sachen.
 */
@Serializable
public open class Herstellungsinformation() {
  /**
   * Hier wird die Bezeichnung des Herstellers abgebildet. Ein weltweiter Herstellerkatalog ist hier
   * nicht praktikabel.
   *
   * Beispiel: 'Fa. XY GmbH amp Co KG'
   */
  public var herstellerbezeichnung: String? = null

  /**
   * Hier wird das Herstellungsland im Sinne eines Landes / Gebiets abgebildet.
   *  
   * Beispiel: Deutschland
   */
  public var herstellungsstaat: KatalogCode285_NichtAbgeschlossen? = null

  /**
   * Datum, an dem die Herstellung erfolgte.
   */
  public var herstellungsdatum: String? = null

  public constructor(
      herstellerbezeichnung: String?,
      herstellungsstaat: KatalogCode285_NichtAbgeschlossen?,
      herstellungsdatum: String?
  ) : this() {
    this.herstellerbezeichnung = herstellerbezeichnung
    this.herstellungsstaat = herstellungsstaat
    this.herstellungsdatum = herstellungsdatum
  }
}
