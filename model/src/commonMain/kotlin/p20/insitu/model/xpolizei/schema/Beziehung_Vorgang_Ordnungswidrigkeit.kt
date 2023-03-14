package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Abbildung von Beziehungen zwischen Vorgängen und Ordnungswidrigkeiten.
 */
@Serializable
public open class Beziehung_Vorgang_Ordnungswidrigkeit() : Beziehung() {
  /**
   * Angabe, welche der Ordnungswidrigkeiten in Tateinheit (im Vorgang) das Führungsdelikt ist.
   */
  public var fuehrungsdelikt: KatalogCode217? = null

  public constructor(fuehrungsdelikt: KatalogCode217?) : this() {
    this.fuehrungsdelikt = fuehrungsdelikt
  }
}
