package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Angaben der Rechtsgrundlage einer hoheitlichen Maßnahme.
 */
@Serializable
public open class Rechtsgrundlage() {
  /**
   * Rechtsgrundlage aus der StPO, die der Maßnahme zugrunde liegt.
   *
   * Beispiel: § 163b
   */
  public var strafprozessordnung: KatalogCode237? = null

  /**
   * Rechtsgrundlage aus einem Polizeigesetz, die der Maßnahme zugrunde liegt.
   *
   * Beispiel: § 42 Abs. 1 BKAG
   */
  public var polizeigesetz: KatalogCode356? = null

  /**
   * Rechtsgrundlage aus einem sonstigen Gesetz, die der Maßnahme zugrunde liegt.
   * Nicht katalogisierte Gesetze können freitextlich angegeben werden.
   *
   * Beispiel: § 49 Abs. 3 AufenthG
   */
  public var sonstigesGesetz: KatalogCode387_NichtAbgeschlossen? = null

  public constructor(
      strafprozessordnung: KatalogCode237?,
      polizeigesetz: KatalogCode356?,
      sonstigesGesetz: KatalogCode387_NichtAbgeschlossen?
  ) : this() {
    this.strafprozessordnung = strafprozessordnung
    this.polizeigesetz = polizeigesetz
    this.sonstigesGesetz = sonstigesGesetz
  }
}
