package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlinx.datetime.DateTimePeriod
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSucheDuration() {
  public var exakt: DateTimePeriod? = null

  public var bereich: Bereich? = null

  public var istLeer: Boolean? = true

  public constructor(
      exakt: DateTimePeriod?,
      bereich: Bereich?,
      istLeer: Boolean?
  ) : this() {
    this.exakt = exakt
    this.bereich = bereich
    this.istLeer = istLeer
  }

  @Serializable
  public class Bereich() {
    public var von: DateTimePeriod? = null

    public var bis: DateTimePeriod? = null

    public constructor(von: DateTimePeriod?, bis: DateTimePeriod?) : this() {
      this.von = von
      this.bis = bis
    }
  }
}
