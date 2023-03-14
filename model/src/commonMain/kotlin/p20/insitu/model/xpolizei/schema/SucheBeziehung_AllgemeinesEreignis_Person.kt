package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung_AllgemeinesEreignis_Person() : SucheBeziehung() {
  public var alterZurEreigniszeit: CIMPSucheAlterPerson? = null

  public constructor(alterZurEreigniszeit: CIMPSucheAlterPerson?) : this() {
    this.alterZurEreigniszeit = alterZurEreigniszeit
  }
}
