package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class Condition() {
  public var `field`: String? = null

  public var auswahl_Condition: Auswahl_Condition? = null

  public constructor(`field`: String?, auswahl_Condition: Auswahl_Condition?) : this() {
    this.`field` = `field`
    this.auswahl_Condition = auswahl_Condition
  }
}
