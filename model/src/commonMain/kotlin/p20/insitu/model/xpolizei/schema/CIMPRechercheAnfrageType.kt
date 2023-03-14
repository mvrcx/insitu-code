package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Container für die RechercheAnfrage
 */
@Serializable
public open class CIMPRechercheAnfrageType() : CIMPAbstrakteKomplexeSuchAnfrageType() {
  /**
   * Dies wird für alle Volltextrecherchen genutzt, z.B. ANY_WORDS
   */
  public var fulltext: Fulltext? = null

  /**
   * Dies wird für eine Abfrage genutzt, bezogen auf die Fachobjekte und Beziehungen in XPolizei.
   */
  public var query: Query? = null

  public constructor(fulltext: Fulltext?, query: Query?) : this() {
    this.fulltext = fulltext
    this.query = query
  }
}
