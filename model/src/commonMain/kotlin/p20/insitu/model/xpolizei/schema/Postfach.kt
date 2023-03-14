package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Ein Postfach ist eine Einrichtung der meisten Postunternehmen der Welt, bei denen der Kunde seine
 * Post in einem abschließbaren Fach in einer Postfiliale abholen kann. In Anlehnung daran wird in
 * E-Mail-Programmen ein Benutzerkonto häufig als Postfach bezeichnet, was hier aber nicht abgebildet
 * wird.
 *  
 * Die Postfächer sind in der Regel nummeriert. Die Postfachnummer wird in Zweiergruppen von rechts
 * gegliedert, es gibt keine führenden Nullen. Die Postanschrift lautet (nach DIN 5008) dann:
 *  
 * Max Mustermann
 * Postfach 8 15
 * 12345 Musterstadt
 *  
 * In Deutschland können größere Unternehmen auf die Angabe der Postfachnummer verzichten und
 * stattdessen eine eigene Postleitzahl bekommen. In diesem Falle wäre die Anschrift
 *  
 * Musterunternehmen
 * 12346 Musterstadt
 *  
 * ohne Hinweis auf eine Straße oder Postfachnummer.
 */
@Serializable
public open class Postfach() {
  /**
   * Hier wird die Nummer eines Postfachs abgebildet.
   */
  public var nummer: String? = null

  public var pLZOrt: PLZOrt? = null

  public constructor(nummer: String?, pLZOrt: PLZOrt?) : this() {
    this.nummer = nummer
    this.pLZOrt = pLZOrt
  }
}
