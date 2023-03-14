package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Waffen, die als besonders zerstörerisch angesehen werden und gravierende Auswirkungen auf Leben,
 * Gegenstände und / oder Umwelt haben. Dazu zählen heute chemische, biologische, radiologische und
 * nukleare Waffen.
 */
@Serializable
public open class Massenvernichtungswaffe() : Waffe() {
  /**
   * Angabe über die Art der Massenvernichtungswaffe.
   */
  public var art: KatalogCode299? = null

  public var herstellungsinformation: Herstellungsinformation? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob die jeweilige Waffe einer Erlaubnispflicht zum Besitz
   * unterliegt oder nicht.
   */
  public var erlaubnispflicht: KatalogCode214? = null

  public constructor(
      art: KatalogCode299?,
      herstellungsinformation: Herstellungsinformation?,
      erlaubnispflicht: KatalogCode214?
  ) : this() {
    this.art = art
    this.herstellungsinformation = herstellungsinformation
    this.erlaubnispflicht = erlaubnispflicht
  }
}
