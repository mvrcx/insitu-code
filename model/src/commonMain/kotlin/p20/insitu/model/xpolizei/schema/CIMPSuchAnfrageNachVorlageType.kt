package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Container-Element für die eigentliche Suchvorlage, bestehend aus Suchobjekten und
 * Suchbeziehungsobjekten.
 */
@Serializable
public open class CIMPSuchAnfrageNachVorlageType() : CIMPAbstrakteKomplexeSuchAnfrageType() {
  /**
   * Angabe der Suchparameter
   */
  public var suchParameter: CIMPSuchVorlageType? = null

  /**
   * Bezeichnung der Suchvorlage
   */
  public var suchVorlageName: String? = null

  public constructor(suchParameter: CIMPSuchVorlageType?, suchVorlageName: String?) : this() {
    this.suchParameter = suchParameter
    this.suchVorlageName = suchVorlageName
  }
}
