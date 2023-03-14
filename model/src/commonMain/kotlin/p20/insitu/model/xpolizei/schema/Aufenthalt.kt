package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Der Aufenthalt beschreibt die Dauer der physischen Anwesenheit des Ausländers in der
 * Bundesrepublik Deutschland. Ein Aufenthalt wird im Allgemeinen nicht durch eine Abwesenheit unter
 * sechs Monaten unterbrochen.
 */
@Serializable
public open class Aufenthalt() {
  /**
   * Der Aufenthaltsstatus beschreibt den rechtlichen Status eines Ausländers in Bezug auf dessen
   * Aufenthalt. Dies schließt sowohl die rechtmäßigen als auch den unrechtmäßigen Aufenthalt ein.
   */
  public var aufenthaltsstatus: List<Aufenthaltsstatus>? = null

  /**
   * Angaben zur Art des Aufenthaltsendes.
   */
  public var artDesAufenthaltsendes: KatalogCode390? = null

  /**
   * Angabe des Beginns des Aufenthalts.
   */
  public var beginn: String? = null

  /**
   * Angabe des Endes des Aufenthalts.
   */
  public var ende: String? = null

  /**
   * Angabe, wann der Betroffene zum ersten Mal nach Deutschland eingereist ist.
   */
  public var ersteinreise: String? = null

  public constructor(
      aufenthaltsstatus: List<Aufenthaltsstatus>?,
      artDesAufenthaltsendes: KatalogCode390?,
      beginn: String?,
      ende: String?,
      ersteinreise: String?
  ) : this() {
    this.aufenthaltsstatus = aufenthaltsstatus
    this.artDesAufenthaltsendes = artDesAufenthaltsendes
    this.beginn = beginn
    this.ende = ende
    this.ersteinreise = ersteinreise
  }
}
