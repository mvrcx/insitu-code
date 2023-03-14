package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSucheName() {
  public var exakt: CIMPNormierterSuchString? = null

  public var ungleich: CIMPNormierterSuchString? = null

  public var unscharf: CIMPNormierterSuchString? = null

  public var optimiert: String? = null

  public var phonetisch: CIMPSuchePhonetisch? = null

  public var synonym: CIMPSucheSynonym? = null

  public var istLeer: Boolean? = true

  public constructor(
      exakt: CIMPNormierterSuchString?,
      ungleich: CIMPNormierterSuchString?,
      unscharf: CIMPNormierterSuchString?,
      optimiert: String?,
      phonetisch: CIMPSuchePhonetisch?,
      synonym: CIMPSucheSynonym?,
      istLeer: Boolean?
  ) : this() {
    this.exakt = exakt
    this.ungleich = ungleich
    this.unscharf = unscharf
    this.optimiert = optimiert
    this.phonetisch = phonetisch
    this.synonym = synonym
    this.istLeer = istLeer
  }
}
