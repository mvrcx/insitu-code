package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlin.Int
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSucheAlterPerson() {
  public var exakt: Int? = null

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
    public var von: Int? = null

    public var bis: Int? = null

    public constructor(von: Int?, bis: Int?) : this() {
      this.von = von
      this.bis = bis
    }
  }
}
