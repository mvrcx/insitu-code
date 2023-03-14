package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Als Waffensystem wird militärisches Großgerät - vor allem bewaffnete Fahrzeuge - bezeichnet.
 * Mindestens ein Teil des Waffensystems ist die eigentliche Waffe, z. B. Kanone eines Kampfpanzers.
 */
@Serializable
public open class Waffensystem() : Waffe() {
  /**
   * Angabe zur Art des Waffensystems.
   *  
   * Beispiele: Haubitze, Mörser, etc.
   */
  public var art: KatalogCode297? = null

  public var herstellungsinformation: Herstellungsinformation? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob die jeweilige Waffe einer Erlaubnispflicht zum Besitz
   * unterliegt oder nicht.
   */
  public var erlaubnispflicht: KatalogCode214? = null

  public constructor(
      art: KatalogCode297?,
      herstellungsinformation: Herstellungsinformation?,
      erlaubnispflicht: KatalogCode214?
  ) : this() {
    this.art = art
    this.herstellungsinformation = herstellungsinformation
    this.erlaubnispflicht = erlaubnispflicht
  }
}
