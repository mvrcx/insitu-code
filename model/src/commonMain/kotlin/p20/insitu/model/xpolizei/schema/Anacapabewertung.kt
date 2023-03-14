package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Die Firma, die in den 70ern zum ersten Mal 'Intelligence Analysis'-Kurse für die Polizei in
 * Amerika angeboten hat, hieß 'Anacapa Sciences'. Deshalb wurde die Methode so genannt.
 */
@Serializable
public open class Anacapabewertung() {
  /**
   * Erfahrungen mit der Quelle einer polizeilich relevanten Information (Zuverlässigkeit).
   *  
   * A - absolut zuverlässige Quelle
   * B - überwiegend zuverlässige Quelle
   * C - Quelle hat bereits falsche Informationen übermittelt - gilt als eher unzuverlässig
   * X - kann nicht bewertet werden - keine Erfahrungswerte
   */
  public var quellbewertung: String? = null

  /**
   * Der Ursprung der Information und wie die Information die Quelle erreichte (Wahrheitsgehalt).
   *  
   * 1 Die Information ist ohne Zweifel wahr.
   * 2 Die Quelle hatte direkten Zugang zur Information.
   * 3 Information vom Hörensagen, die sich mit vorhandenen Informationen deckt.
   * 4 Information vom Hörensagen, die in dieser Weise noch nicht vorliegt und deshalb nicht
   * bewertet werden kann.
   */
  public var informationsbewertung: String? = null

  public constructor(quellbewertung: String?, informationsbewertung: String?) : this() {
    this.quellbewertung = quellbewertung
    this.informationsbewertung = informationsbewertung
  }
}
