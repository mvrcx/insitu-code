package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Munition ist ein nicht fest mit einer Waffe oder Werkzeug verbundenes Teil, welches den
 * eigentlichen Wirkungsträger der betreffenden Waffe darstellt. Munition entfaltet oft erst in
 * beträchtlicher Entfernung zur Waffe, zumindest jedoch außerhalb der Waffe oder des Werkzeuges ihre
 * Wirkung. Die Waffe oder das Werkzeug kann dabei nur als Gerätschaft betrachtet werden, mit deren
 * Hilfe die Munition bestimmungsgemäß zum Einsatz kommt.
 */
@Serializable
public open class Munition() : Waffe() {
  /**
   * Angaben zur Art der Munition.
   *  
   * Beispiel: Handfeuerwaffenpatrone, etc.
   */
  public var art: KatalogCode292? = null

  /**
   * Angabe des Kalibers der Munition.
   *  
   * Es wird der jeweils gültige XWaffe Katalog
   * (urn:de:xwaffe:codelisten:munitionsbezeichnungkaliber (fix)) verwendet.
   */
  public var kaliberXWaffe: KatalogCode295_NichtAbgeschlossen? = null

  /**
   * Der Bodenstempel ist eine auf dem Hülsenboden der Patrone eingeschlagene Kennzeichnung. Diese
   * kann sowohl alphanumerische Zeichen als auch Sonderzeichen (z. B. Nato-Kreuz, Stern, Adler)
   * enthalten. Daneben können auch andere Informationen, wie beispielsweise Kaliber, Hersteller,
   * Herstellungsland und Herstellungsjahr, Bestandteil des Bodenstempels sein. Diese Angaben sind
   * jedoch strukturiert in den dafür vorgesehenen Attributen ('Kaliber') bzw. Fachobjekten
   * ('Herstellerinformation') abzubilden.
   */
  public var bodenstempel: String? = null

  /**
   * Festlegung der Waffenkategorie gemäß EU-Waffenrichtlinie (Kat. A - D).
   */
  public var eUKategorie: KatalogCode306? = null

  public var herstellungsinformation: Herstellungsinformation? = null

  /**
   * Grobe Angabe zum Kaliber.
   */
  public var kaliber: KatalogCode329? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob die jeweilige Waffe einer Erlaubnispflicht zum Besitz
   * unterliegt oder nicht.
   */
  public var erlaubnispflicht: KatalogCode214? = null

  public constructor(
      art: KatalogCode292?,
      kaliberXWaffe: KatalogCode295_NichtAbgeschlossen?,
      bodenstempel: String?,
      eUKategorie: KatalogCode306?,
      herstellungsinformation: Herstellungsinformation?,
      kaliber: KatalogCode329?,
      erlaubnispflicht: KatalogCode214?
  ) : this() {
    this.art = art
    this.kaliberXWaffe = kaliberXWaffe
    this.bodenstempel = bodenstempel
    this.eUKategorie = eUKategorie
    this.herstellungsinformation = herstellungsinformation
    this.kaliber = kaliber
    this.erlaubnispflicht = erlaubnispflicht
  }
}
