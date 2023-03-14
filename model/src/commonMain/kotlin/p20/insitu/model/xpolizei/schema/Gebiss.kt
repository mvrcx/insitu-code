package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Als Gebiss bezeichnet man die Gesamtheit aller Zähne einer Person.
 */
@Serializable
public open class Gebiss() {
  /**
   * Dieses Feld enthält Angaben zu Auffälligkeiten des Gebisses.
   *
   * Beispiel: Krone, verfärbt, weitgestellt
   */
  public var auffaelligkeit: List<KatalogCode374>? = null

  public var zahn: List<Zahn>? = null

  public constructor(auffaelligkeit: List<KatalogCode374>?, zahn: List<Zahn>?) : this() {
    this.auffaelligkeit = auffaelligkeit
    this.zahn = zahn
  }
}
