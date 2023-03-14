package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Container für die ListenabgleichAnfrage
 */
@Serializable
public open class CIMPListenabgleichAnfrageType() : CIMPAbstrakteKomplexeSuchAnfrageType() {
  /**
   * Liste der Suchobjekte, die für den Listenabgleich gesucht werden
   */
  public var suchObjekteListe: CIMPSuchObjekteType? = null

  public constructor(suchObjekteListe: CIMPSuchObjekteType?) : this() {
    this.suchObjekteListe = suchObjekteListe
  }
}
