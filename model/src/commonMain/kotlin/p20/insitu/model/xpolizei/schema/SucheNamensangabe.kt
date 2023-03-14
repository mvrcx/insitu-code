package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheNamensangabe() {
  public var bezeichnung: CIMPSucheName? = null

  public var abweichendeSchreibweise: List<CIMPSucheName>? = null

  public constructor(bezeichnung: CIMPSucheName?, abweichendeSchreibweise: List<CIMPSucheName>?) :
      this() {
    this.bezeichnung = bezeichnung
    this.abweichendeSchreibweise = abweichendeSchreibweise
  }
}
