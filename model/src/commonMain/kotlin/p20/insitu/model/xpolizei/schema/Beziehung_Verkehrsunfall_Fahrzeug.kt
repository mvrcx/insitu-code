package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlinx.serialization.Serializable

/**
 * Abbildung von Beziehungen zwischen Verkehrsunfällen und Fahrzeugen.
 */
@Serializable
public open class Beziehung_Verkehrsunfall_Fahrzeug() : Beziehung() {
  /**
   * Angabe der Gesamtzahl der Fahrer und Mitfahrer eines an einem Verkehrsunfall beteiligten
   * Fahrzeugs.
   */
  public var anzahlBenutzer: Int? = 0

  /**
   * Angabe, ob das Fahrzeug nach dem Verkehrsunfall nicht fahrbereit war.
   */
  public var nichtFahrbereit: KatalogCode214? = null

  public constructor(anzahlBenutzer: Int?, nichtFahrbereit: KatalogCode214?) : this() {
    this.anzahlBenutzer = anzahlBenutzer
    this.nichtFahrbereit = nichtFahrbereit
  }
}
