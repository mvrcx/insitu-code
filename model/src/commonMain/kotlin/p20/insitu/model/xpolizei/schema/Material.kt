package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angabe des Materials einer Sache.
 *
 * Bei Sachen, die aus mehreren Materialien bestehen, können mehrere Instanzen der Kernkomponente
 * verwendet werden, wobei der Anteil der einzelnen Materialien (in Prozent) angegeben werden kann.
 */
@Serializable
public open class Material() {
  /**
   * Angabe der Art des Materials.
   *  
   * Beispiele: Metall, Aluminium, Eisen, Buntmetall, Holz
   */
  public var art: KatalogCode242_NichtAbgeschlossen? = null

  /**
   * Genaue Bezeichnung des Materials in Ergänzung zur Art.
   *  
   * Beispiel: Bei der Art 'Holz' könnte die Bezeichnung 'Eiche' lauten
   */
  public var bezeichnung: String? = null

  /**
   * Besteht eine Sache aus mehreren Materialien, kann hier der Anteil des jeweiligen Materials an
   * der gesamten Sache (bezogen auf die Masse) angegeben werden.
   */
  public var anteilInProzent: Double? = 0.0

  /**
   * Freitextliche Anmerkung zu Besonderheiten des Materials (zum Beispiel Bearbeitung).
   *  
   * Beispiel: Art des Materials 'Metall', Bezeichnung 'Aluminium', Bemerkung 'eloxiert'
   */
  public var bemerkung: String? = null

  public constructor(
      art: KatalogCode242_NichtAbgeschlossen?,
      bezeichnung: String?,
      anteilInProzent: Double?,
      bemerkung: String?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.anteilInProzent = anteilInProzent
    this.bemerkung = bemerkung
  }
}
