package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlin.Double
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSucheNumerischerWert() {
  public var exakt: Double? = 0.0

  public var bereich: Bereich? = null

  public var istLeer: Boolean? = true

  public constructor(
      exakt: Double?,
      bereich: Bereich?,
      istLeer: Boolean?
  ) : this() {
    this.exakt = exakt
    this.bereich = bereich
    this.istLeer = istLeer
  }

  @Serializable
  public class Bereich() {
    public var von: Double? = 0.0

    public var bis: Double? = 0.0

    public constructor(von: Double?, bis: Double?) : this() {
      this.von = von
      this.bis = bis
    }
  }
}
