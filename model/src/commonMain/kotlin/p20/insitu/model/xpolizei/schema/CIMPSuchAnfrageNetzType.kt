package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlinx.serialization.Serializable

/**
 * Container für SuchAnfrageNetz
 */
@Serializable
public open class CIMPSuchAnfrageNetzType() : CIMPLesenAnfrageType() {
  /**
   * In Abbildung 9 XSP-Handbuch  sind die von der dunkel eingefärbten Personalie in der Mitte mit
   * einer Lesetiefe von 1 erreichbaren Objekte dunkel eingefärbt dargestellt. Es sind die Objekte
   * "Vorgang", "Straftat" und "Fahrzeug". 
   * Unter Berücksichtigung der Regel, dass jedes Objekt der Fachdaten eine Beziehung zu einem
   * Vorgang hat, ergibt sich somit, dass bei Lesetiefe 2 alle Objekte eines Vorgangs erfasst werden.
   * Bei einer Suche werden keine Daten-Quittungen erzeugt. Die Antwort enthält die gefundenen
   * Fachdaten, sowie Angaben zur Art der Ergebnisübertragung und dem Gesamtumfang der Ergebnismenge
   */
  public var leseTiefe: Int? = 0

  public constructor(leseTiefe: Int?) : this() {
    this.leseTiefe = leseTiefe
  }
}
