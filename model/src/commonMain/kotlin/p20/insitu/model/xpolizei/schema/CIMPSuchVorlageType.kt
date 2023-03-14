package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Container für SuchVorlage
 */
@Serializable
public open class CIMPSuchVorlageType() {
  public var suchObjekte: CIMPSuchObjekteType? = null

  public var sucheBeziehungen: CIMPSuchBeziehungenType? = null

  public constructor(suchObjekte: CIMPSuchObjekteType?, sucheBeziehungen: CIMPSuchBeziehungenType?)
      : this() {
    this.suchObjekte = suchObjekte
    this.sucheBeziehungen = sucheBeziehungen
  }
}
