package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angaben von Behördenkennzeichnungen oder Dienststellenschlüsseln.
 */
@Serializable
public open class Behoerdenkennzeichnung() {
  /**
   * Freitextliche Angaben von Behördenkennzeichnungen oder Dienststellenschlüsseln.
   */
  public var bezeichnung: String? = null

  /**
   * Katalogisierte Angaben von Behördenkennzeichnungen oder Dienststellenschlüsseln.
   */
  public var behoerdenkatalog: KatalogCode389? = null

  public constructor(bezeichnung: String?, behoerdenkatalog: KatalogCode389?) : this() {
    this.bezeichnung = bezeichnung
    this.behoerdenkatalog = behoerdenkatalog
  }
}
