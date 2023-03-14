package p20.insitu.model.xpolizei.schema

import kotlin.Float
import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Die Element- / Objekt-ID des  Trefferobjekts innerhalb der Antwortnachricht.
 */
@Serializable
public open class CIMPTrefferguete() {
  /**
   * Die Element- / Objekt-ID des  Trefferobjekts innerhalb der Antwortnachricht.
   */
  public var trefferObjektID: String? = null

  public var trefferguete: Float? = 0.0f

  public var algorithmus: String? = null

  public constructor(
    trefferObjektID: String?,
    trefferguete: Float?,
    algorithmus: String?
  ) : this() {
    this.trefferObjektID = trefferObjektID
    this.trefferguete = trefferguete
    this.algorithmus = algorithmus
  }
}
