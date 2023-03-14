package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSucheDatum() {
  public var bereich: CIMPSucheDatumBereich? = null

  public var exakt: String? = null

  public var unscharf: String? = null

  public var istLeer: Boolean? = true

  public constructor(
      bereich: CIMPSucheDatumBereich?,
      exakt: String?,
      unscharf: String?,
      istLeer: Boolean?
  ) : this() {
    this.bereich = bereich
    this.exakt = exakt
    this.unscharf = unscharf
    this.istLeer = istLeer
  }
}
