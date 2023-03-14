package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * KK zur Abbildung von datenschutzrechtlichen Status einer Person.
 */
@Serializable
public open class DatenschutzrechtlicherStatus() {
  /**
   * Hier wird der datenschutzrechtliche Status der Person gem. BKA-Gesetz abgebildet, z. B.
   * Beschuldigter, Zeuge, sonstige Person.
   */
  public var bKAG: KatalogCode215? = null

  /**
   * Hier wird der datenschutzrechtliche Status der Person gem. des jeweiligen Landespolizeigesetzes
   * abgebildet, z. B. Beschuldigter, Zeuge.
   */
  public var landespolizeigesetz: KatalogCode289_NichtAbgeschlossen? = null

  public constructor(bKAG: KatalogCode215?, landespolizeigesetz: KatalogCode289_NichtAbgeschlossen?)
      : this() {
    this.bKAG = bKAG
    this.landespolizeigesetz = landespolizeigesetz
  }
}
