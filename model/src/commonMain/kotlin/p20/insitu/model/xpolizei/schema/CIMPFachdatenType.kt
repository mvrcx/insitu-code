package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Container der Fachdaten
 */
@Serializable
public open class CIMPFachdatenType() {
  public var objekte: CIMPLoeschungenFachObjekteType? = null

  public var beziehungen: CIMPLoeschungenFachBeziehungenType? = null

  public constructor(objekte: CIMPLoeschungenFachObjekteType?,
                     beziehungen: CIMPLoeschungenFachBeziehungenType?) : this() {
    this.objekte = objekte
    this.beziehungen = beziehungen
  }
}
