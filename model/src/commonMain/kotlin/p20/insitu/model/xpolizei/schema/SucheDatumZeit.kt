package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class SucheDatumZeit() {
  public var datum: CIMPSucheDatum? = null

  public var zeit: CIMPSucheZeit? = null

  public var zeitzone: String? = null

  public constructor(
      datum: CIMPSucheDatum?,
      zeit: CIMPSucheZeit?,
      zeitzone: String?
  ) : this() {
    this.datum = datum
    this.zeit = zeit
    this.zeitzone = zeitzone
  }
}
