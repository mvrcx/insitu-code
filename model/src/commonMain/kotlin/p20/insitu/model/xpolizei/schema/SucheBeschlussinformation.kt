package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeschlussinformation() {
  public var beschluss: SucheDokument? = null

  public var beginn: CIMPSucheDatum? = null

  public var ende: CIMPSucheDatum? = null

  public constructor(
      beschluss: SucheDokument?,
      beginn: CIMPSucheDatum?,
      ende: CIMPSucheDatum?
  ) : this() {
    this.beschluss = beschluss
    this.beginn = beginn
    this.ende = ende
  }
}
