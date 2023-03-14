package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSucheStrasse() {
  public var exakt: CIMPNormierterSuchString? = null

  public var ungleich: String? = null

  public var unscharf: CIMPNormierterSuchString? = null

  public var optimiert: String? = null

  public var phonetisch: CIMPSuchePhonetisch? = null

  public var synonym: CIMPSucheSynonym? = null

  public var istLeer: Boolean? = true

  public constructor(
      exakt: CIMPNormierterSuchString?,
      ungleich: String?,
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
