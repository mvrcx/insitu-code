package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlinx.serialization.Serializable

/**
 * Abbildung von Serien von Banknoten (z. B. erbeutetes oder erpresstes Bargeld) oder Falsifikaten.
 *
 * Pro Serie ist eine eigene Bargeldinstanz zu verwenden.
 * Serien werden wie folgt abgebildet: Ausgehend vom Attribut Seriennummer im Fachobjekt Bargeld
 * beziehungsweise der Registernummer im Fachobjekt Falschgeld werden die folgenden Seriennummern bzw.
 * Registernummern anhand der Basiskomponenten der Komponente Serie durch (N-1)-maliges Addieren des
 * Inkrement-Wertes zur Seriennummer bzw. Registernummer gebildet, wobei N der Attribute 'Anzahl'
 * entspricht. Die in den Fachobjekten Bargeld bzw. Falschgeld angegebene Serien- bzw. Registernummer
 * bildet jeweils das erste Element der Serie. Das Attribut Anzahl in der Komponente Serie gibt den
 * Gesamtumfang der Serie an.
 *
 * Beispiel:
 * Sei die Anzahl N=5 und der Wert des Inkrements I=2, dann gehören ausgehend von der Seriennummer X
 * 27453585926 folgende Banknoten zur Serie:
 * X 27453585926
 * X 27453585928
 * X 27453585930
 * X 27453585932
 * X 27453585934
 *
 * Wenn die Seriennummer mit nicht-numerischen Zeichen endet (z. B. E 90271954 A bei USD), können
 * auf diese Art und Weise keine Serien gebildet werden.
 */
@Serializable
public open class Serie() {
  /**
   * Angabe der Gesamtzahl der Elemente der Serie.
   */
  public var anzahl: Int? = 0

  /**
   * Inkrementieren: stufenweise Erhöhung eines numerischen Wertes.
   */
  public var inkrement: Int? = 0

  public constructor(anzahl: Int?, inkrement: Int?) : this() {
    this.anzahl = anzahl
    this.inkrement = inkrement
  }
}
