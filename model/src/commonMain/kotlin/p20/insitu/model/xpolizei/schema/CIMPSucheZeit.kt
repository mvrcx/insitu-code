package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSucheZeit() {
  public var bereich: Bereich? = null

  public var exakt: String? = null

  public var unscharf: String? = null

  public var istLeer: Boolean? = true

  public constructor(
      bereich: Bereich?,
      exakt: String?,
      unscharf: String?,
      istLeer: Boolean?
  ) : this() {
    this.bereich = bereich
    this.exakt = exakt
    this.unscharf = unscharf
    this.istLeer = istLeer
  }

  @Serializable
  public class Bereich() {
    public var von: String? = null

    public var bis: String? = null

    public constructor(von: String?, bis: String?) : this() {
      this.von = von
      this.bis = bis
    }
  }
}
