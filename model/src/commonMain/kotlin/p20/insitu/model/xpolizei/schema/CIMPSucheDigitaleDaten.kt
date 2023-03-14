package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSucheDigitaleDaten() {
  public var istLeer: Boolean? = true

  public constructor(istLeer: Boolean?) : this() {
    this.istLeer = istLeer
  }
}
