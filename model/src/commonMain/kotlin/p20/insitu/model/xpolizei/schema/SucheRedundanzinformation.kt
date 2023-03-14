package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheRedundanzinformation() {
  public var teilnehmeranker: SucheTeilnehmeranker? = null

  public var verbundanker: SucheVerbundanker? = null

  public var obIGueltigAb: CIMPSucheDatum? = null

  public constructor(
      teilnehmeranker: SucheTeilnehmeranker?,
      verbundanker: SucheVerbundanker?,
      obIGueltigAb: CIMPSucheDatum?
  ) : this() {
    this.teilnehmeranker = teilnehmeranker
    this.verbundanker = verbundanker
    this.obIGueltigAb = obIGueltigAb
  }
}
