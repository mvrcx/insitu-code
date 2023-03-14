package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Packstationen sind ein Service der Deutschen Post AG. Dabei werden an zentralen Stellen
 * automatische Anlagen aufgestellt in denen Pakete, Päckchen, Warensendungen u. ä. durch die Post
 * hinterlegt und vom Adressaten rund um die Uhr abgeholt werden können. Der Adressat authentifiziert
 * sich gegenüber der Anlage mit einer Magnetkarte und der zugehörigen PIN. Die Adressierung erfolgt
 * mit folgenden Bestandteilen: Name des Empfängers, Post-Identifikationsnummer des Empfängers (wie auf
 * der Magnetkarte angegeben), Nummer der Packstation sowie Postleitzahl und Ort des
 * Packstation-Standorts.
 */
@Serializable
public open class Packstation() {
  /**
   * Postnummer des Empfängers.
   */
  public var nummerDesEmpfaengers: String? = null

  /**
   * Packstationsnummer der Packstation.
   *  
   * Beispiel: 117
   */
  public var nummerDerPackstation: String? = null

  public var pLZOrt: PLZOrt? = null

  public constructor(
    nummerDesEmpfaengers: String?,
    nummerDerPackstation: String?,
    pLZOrt: PLZOrt?
  ) : this() {
    this.nummerDesEmpfaengers = nummerDesEmpfaengers
    this.nummerDerPackstation = nummerDerPackstation
    this.pLZOrt = pLZOrt
  }
}
