package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Container für NetzÜberschreibenAnfrageType
 */
@Serializable
public open class CIMPNetzUeberschreibenAnfrageType() {
  /**
   * Standard Nachrichtenkopf
   */
  public var nachrichtenkopf: CIMPNachrichtenKopf? = null

  public var fachobjekte: CIMPFachObjekteType? = null

  public var beziehungen: CIMPFachBeziehungenType? = null

  public constructor(
      nachrichtenkopf: CIMPNachrichtenKopf?,
      fachobjekte: CIMPFachObjekteType?,
      beziehungen: CIMPFachBeziehungenType?
  ) : this() {
    this.nachrichtenkopf = nachrichtenkopf
    this.fachobjekte = fachobjekte
    this.beziehungen = beziehungen
  }
}
