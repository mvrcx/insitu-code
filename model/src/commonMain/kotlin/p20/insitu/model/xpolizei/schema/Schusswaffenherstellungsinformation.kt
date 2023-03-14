package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angaben zur Herstellung einer Schusswaffe.
 */
@Serializable
public open class Schusswaffenherstellungsinformation() {
  /**
   * Angabe des Schsswaffenherstellers.
   *
   * Es wird der Katalog aus XWaffe verwendet.
   *
   * Hersteller von erlaubnispflichtigen Waffen gemäß WaffG
   * (urn:de:xwaffe:codelisten:herstellerbezeichnung (fix)).
   */
  public var hersteller: KatalogCode290_NichtAbgeschlossen? = null

  /**
   * Hier wird das Herstellungsland im Sinne eines Landes / Gebiets abgebildet.
   *  
   * Beispiel: Deutschland
   */
  public var herstellungsstaat: KatalogCode285_NichtAbgeschlossen? = null

  /**
   * Angabe des Datums, an dem die Herstellung erfolgte.
   */
  public var herstellungsdatum: String? = null

  public constructor(
      hersteller: KatalogCode290_NichtAbgeschlossen?,
      herstellungsstaat: KatalogCode285_NichtAbgeschlossen?,
      herstellungsdatum: String?
  ) : this() {
    this.hersteller = hersteller
    this.herstellungsstaat = herstellungsstaat
    this.herstellungsdatum = herstellungsdatum
  }
}
