package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angaben zur Religionszugehörigkeit einer Person.
 *
 * Zusätzlich besteht die Möglichkeit, anzugeben, ab bzw. bis wann oder in welchem Zeitraum die
 * Religionszugehörigkeit bestanden hat oder ob die Person zur Religion konvertiert ist.
 * Es können mehrere Religionszugehörigkeiten angeben werden.
 */
@Serializable
public open class Religionszugehoerigkeit() {
  /**
   * Angaben zur Religion einer Person.
   *
   * Beispiele: katholisch, evangelisch
   */
  public var religion: KatalogCode257_NichtAbgeschlossen? = null

  /**
   * Angabe, ob die Person zu dieser Religion konvertiert ist.
   */
  public var konvertiert: KatalogCode214? = null

  /**
   * Angabe des Datums des Endes der Religionszugehörigkeit.
   */
  public var bis: String? = null

  /**
   * Angabe des Datums des Beginns der Religionszugehörigkeit.
   */
  public var von: String? = null

  public constructor(
      religion: KatalogCode257_NichtAbgeschlossen?,
      konvertiert: KatalogCode214?,
      bis: String?,
      von: String?
  ) : this() {
    this.religion = religion
    this.konvertiert = konvertiert
    this.bis = bis
    this.von = von
  }
}
