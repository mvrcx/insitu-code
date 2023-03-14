package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Container für die QuittungObjekte
 */
@Serializable
public open class CIMPDatenQuittungObjekteType() {
  public var quellID: String? = null

  public var zielID: String? = null

  public var referenzID: String? = null

  public constructor(
    quellID: String?,
    zielID: String?,
    referenzID: String?
  ) : this() {
    this.quellID = quellID
    this.zielID = zielID
    this.referenzID = referenzID
  }
}
