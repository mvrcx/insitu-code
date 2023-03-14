package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheUnterbrechung() {
  public var beginn: SucheDatumZeit? = null

  public var ende: SucheDatumZeit? = null

  public constructor(beginn: SucheDatumZeit?, ende: SucheDatumZeit?) : this() {
    this.beginn = beginn
    this.ende = ende
  }
}
