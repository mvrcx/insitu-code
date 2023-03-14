package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Container für ErweiterteSuchAnfrage
 */
@Serializable
public open class CIMPErweiterteSuchAnfrageType() : CIMPAbstrakteKomplexeSuchAnfrageType() {
  /**
   * Enthält das Suchobjekt
   */
  public var suchObjekt: CIMPSuchObjektType? = null

  public constructor(suchObjekt: CIMPSuchObjektType?) : this() {
    this.suchObjekt = suchObjekt
  }
}
