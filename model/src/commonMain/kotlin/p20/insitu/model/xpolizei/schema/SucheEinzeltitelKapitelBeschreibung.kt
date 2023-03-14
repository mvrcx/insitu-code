package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheEinzeltitelKapitelBeschreibung() {
  public var einzeltitelKapitel: CIMPSucheString? = null

  public var textauswertung: CIMPSucheString? = null

  public constructor(einzeltitelKapitel: CIMPSucheString?, textauswertung: CIMPSucheString?) :
      this() {
    this.einzeltitelKapitel = einzeltitelKapitel
    this.textauswertung = textauswertung
  }
}
