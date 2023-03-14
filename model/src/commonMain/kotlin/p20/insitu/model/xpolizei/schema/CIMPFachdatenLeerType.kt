package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class CIMPFachdatenLeerType() {
  public var objekte: CIMPFachObjekteListeType? = null

  public var beziehungen: CIMPFachBeziehungenListeType? = null

  public constructor(objekte: CIMPFachObjekteListeType?, beziehungen: CIMPFachBeziehungenListeType?)
      : this() {
    this.objekte = objekte
    this.beziehungen = beziehungen
  }
}
