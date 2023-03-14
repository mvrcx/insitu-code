package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angaben zum Schusswaffenzustand zum Zeitpunkt der Sicherstellung.
 */
@Serializable
public open class Schusswaffenzustandsinformation() {
  /**
   * Angabe, ob die Schusswaffe gesichert war.
   */
  public var gesichert: KatalogCode217? = null

  /**
   * Angabe, ob die Schusswaffe über eine Sicherungsfunktion verfügt.
   */
  public var sicherungVorhanden: KatalogCode217? = null

  /**
   * Angabe, in welchem Feuermodus die Schusswaffe eingestellt war.
   */
  public var artDesFeuermodus: KatalogCode367? = null

  /**
   * Angabe, ob die Schusswaffe durchgeladen war.
   */
  public var durchgeladen: KatalogCode217? = null

  /**
   * Angabe, ob der Hahn der Schusswaffe gespannt war.
   */
  public var hahnGespannt: KatalogCode217? = null

  /**
   * Angaben zum Zustand des Laufs einer Schusswaffe.
   *
   * Beispiele: Lauf blockiert, Lauf zugeschweißt
   */
  public var zustandLauf: String? = null

  /**
   * Angaben zum Zustand des Verschlusses einer Schusswaffe.
   *
   * Beispiel: Verschluss hinten eingerastet
   */
  public var zustandVerschluss: String? = null

  public constructor(
      gesichert: KatalogCode217?,
      sicherungVorhanden: KatalogCode217?,
      artDesFeuermodus: KatalogCode367?,
      durchgeladen: KatalogCode217?,
      hahnGespannt: KatalogCode217?,
      zustandLauf: String?,
      zustandVerschluss: String?
  ) : this() {
    this.gesichert = gesichert
    this.sicherungVorhanden = sicherungVorhanden
    this.artDesFeuermodus = artDesFeuermodus
    this.durchgeladen = durchgeladen
    this.hahnGespannt = hahnGespannt
    this.zustandLauf = zustandLauf
    this.zustandVerschluss = zustandVerschluss
  }
}
