package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSucheHausnummer() {
  public var exakt: String? = null

  public var optimiert: String? = null

  public var bereich: Bereich? = null

  public var istLeer: Boolean? = true

  public constructor(
      exakt: String?,
      optimiert: String?,
      bereich: Bereich?,
      istLeer: Boolean?
  ) : this() {
    this.exakt = exakt
    this.optimiert = optimiert
    this.bereich = bereich
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
