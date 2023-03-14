package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class SucheAnacapabewertung() {
  public var quellbewertung: String? = null

  public var informationsbewertung: String? = null

  public constructor(quellbewertung: String?, informationsbewertung: String?) : this() {
    this.quellbewertung = quellbewertung
    this.informationsbewertung = informationsbewertung
  }
}
