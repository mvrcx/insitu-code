package p20.insitu.model.xpolizei.schema

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

/**
 * EIS-relevante Informationen zu einer Straftat (EIS = Europol Informationssystem).
 */
@Serializable
public open class EIS() {
  /**
   * Angabe des Europol-Mandatsbereichs gem. Europol Konvention.
   */
  public var europolMandatsbereich: KatalogCode309? = null

  /**
   * Datum, zu dem eine Straftat im EIS zur Aussonderung ansteht.
   */
  public var aussonderungspruefdatum: LocalDate? = null

  public constructor(europolMandatsbereich: KatalogCode309?, aussonderungspruefdatum: LocalDate?) :
      this() {
    this.europolMandatsbereich = europolMandatsbereich
    this.aussonderungspruefdatum = aussonderungspruefdatum
  }
}
