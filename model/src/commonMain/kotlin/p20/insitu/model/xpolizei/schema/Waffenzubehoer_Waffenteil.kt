package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Waffenzubehör:
 * Unter Waffenzubehör werden bewegliche Nicht-Munitionsteile verstanden, die zwar nicht Bestandteil
 * der Waffe selbst sind, deren Gebrauch aber in unmittelbarem Zusammenhang mit einer Waffe steht.
 * (Beispiele: Magazin, Zielfernrohr)
 *  
 * Waffenteil:
 * Ein Waffenteil ist ein einzelnes Stück oder eine Baugruppe einer Waffe, ohne die die Waffe als
 * unvollständig anzusehen ist.
 * (Beispiele: Kimme, Korn)
 */
@Serializable
public open class Waffenzubehoer_Waffenteil() : Waffe() {
  /**
   * Angabe zur Art des Waffenzubehörs / Waffenteils.
   *  
   * Beispiele: Visiereinrichtung, Zweibein, etc.
   */
  public var art: KatalogCode294? = null

  public var herstellungsinformation: Herstellungsinformation? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob die jeweilige Waffe einer Erlaubnispflicht zum Besitz
   * unterliegt oder nicht.
   */
  public var erlaubnispflicht: KatalogCode214? = null

  public constructor(
      art: KatalogCode294?,
      herstellungsinformation: Herstellungsinformation?,
      erlaubnispflicht: KatalogCode214?
  ) : this() {
    this.art = art
    this.herstellungsinformation = herstellungsinformation
    this.erlaubnispflicht = erlaubnispflicht
  }
}
