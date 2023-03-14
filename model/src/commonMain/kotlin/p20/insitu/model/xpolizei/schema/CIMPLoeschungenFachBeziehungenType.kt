package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Container für LöschungenFachBeziehungen
 */
@Serializable
public open class CIMPLoeschungenFachBeziehungenType() : CIMPFachBeziehungenType() {
  public var loeschungen: CIMPFachBeziehungenListeType? = null

  public constructor(loeschungen: CIMPFachBeziehungenListeType?) : this() {
    this.loeschungen = loeschungen
  }
}
