package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Abbildung von Beziehungen zwischen Vorgängen und Straftaten.
 */
@Serializable
public open class Beziehung_Vorgang_Straftat() : Beziehung() {
  /**
   * Angabe, welches der Delikte in Tateinheit (im Vorgang) das Führungsdelikt ist.
   */
  public var fuehrungsdelikt: KatalogCode217? = null

  public constructor(fuehrungsdelikt: KatalogCode217?) : this() {
    this.fuehrungsdelikt = fuehrungsdelikt
  }
}
