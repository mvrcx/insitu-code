package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlin.Int
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSucheIntegerWert() {
  public var exakt: Int? = 0

  public var bereich: Bereich? = null

  public var istLeer: Boolean? = true

  public constructor(
      exakt: Int?,
      bereich: Bereich?,
      istLeer: Boolean?
  ) : this() {
    this.exakt = exakt
    this.bereich = bereich
    this.istLeer = istLeer
  }

  @Serializable
  public class Bereich() {
    public var von: Int? = 0

    public var bis: Int? = 0

    public constructor(von: Int?, bis: Int?) : this() {
      this.von = von
      this.bis = bis
    }
  }
}
