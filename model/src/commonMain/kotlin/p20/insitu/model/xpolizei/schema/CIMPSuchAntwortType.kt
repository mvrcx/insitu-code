package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Container für SuchAntwort
 */
@Serializable
public open class CIMPSuchAntwortType() : CIMPAntwortType() {
  /**
   * Dies Art des Ergebnisses
   */
  public var artErgebnis: CIMPErgebnisArt? = null

  /**
   * Anzahl der Treffer im Zielsystem
   */
  public var anzahl: Int? = 0

  /**
   * ID der Ergebnismenge
   */
  public var ergebnismengenID: String? = null

  /**
   * Angefragte Seite
   */
  public var seite: Int? = 0

  public var trefferguete: List<CIMPTrefferguete>? = null

  public constructor(
      artErgebnis: CIMPErgebnisArt?,
      anzahl: Int?,
      ergebnismengenID: String?,
      seite: Int?,
      trefferguete: List<CIMPTrefferguete>?
  ) : this() {
    this.artErgebnis = artErgebnis
    this.anzahl = anzahl
    this.ergebnismengenID = ergebnismengenID
    this.seite = seite
    this.trefferguete = trefferguete
  }
}
