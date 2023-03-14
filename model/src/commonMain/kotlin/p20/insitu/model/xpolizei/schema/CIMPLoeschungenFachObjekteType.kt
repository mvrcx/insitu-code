package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Container für LöschungenFachObjekte
 */
@Serializable
public open class CIMPLoeschungenFachObjekteType() : CIMPFachObjekteType() {
  public var loeschungen: CIMPFachObjekteListeType? = null

  public constructor(loeschungen: CIMPFachObjekteListeType?) : this() {
    this.loeschungen = loeschungen
  }
}
