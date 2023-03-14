package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Das Objekt 'VerwaltungspolitischeKodierung' beinhaltet Informationen, die innerhalb Deutschlands
 * eine verwaltungspolitisch eindeutige Zuordnung ermöglichen.
 */
@Serializable
public open class VerwaltungspolitischeKodierung() {
  /**
   * Ein Gemeindeschlüssel ist ein Schlüssel zur Identifikation einer Gemeinde oder sonstiger
   * Gebietskörperschaften (Kreis, Bezirk, Bundesland).
   *  
   * Der Amtliche Gemeindeschlüssel (AGS) besteht aus insgesamt 8 Ziffern, die sich wie folgt
   * zusammensetzen:
   *  
   * - Die ersten beiden Ziffern bezeichnen das Bundesland (siehe untenstehende Tabelle).
   * - Der Block von der dritten bis zur fünften Ziffer identifiziert den Landkreis bzw. die
   * kreisfreie Stadt, dem die Gemeinde angehört. Die ersten fünf Stellen werden daher auch als
   * Kreisschlüssel bezeichnet. Dabei zeigt die dritte Ziffer bei Ländern, in denen Regierungsbezirke
   * bestehen oder in der Vergangenheit bestanden haben, in der Regel den Bezirk an, während sie in
   * anderen Ländern 0 ist. In Baden-Württemberg zeigt die vierte Ziffer außerdem an, zu welchem
   * Regionalverband die Gemeinde gehört.
   * - Die letzten drei Ziffern schließlich unterscheidet die Gemeinden innerhalb eines Landkreises.
   * Bei kreisfreien Städten stehen an dieser Stelle drei Nullen.
   *  
   * Beispiele:
   *  
   * 08 1 11 000 = Stuttgart
   *  
   * - 08 Baden-Württemberg
   * - 1 Regierungsbezirk Stuttgart
   * - 1 Region Stuttgart
   * - 1 Stadtkreis Stuttgart
   * - 000 (Stuttgart erhält als Stadtkreis die Gemeindeschlüsselendung 000)
   *  
   * 03 2 54 021 = Hildesheim
   *  
   * - 03 Niedersachsen
   * - 2 ehemaliger Regierungsbezirk Hannover
   * - 54 Landkreis Hildesheim
   * - 021 Stadt Hildesheim
   *  
   * 12 0 64 340 = Neuhardenberg
   *  
   * - 12 Brandenburg
   * - 0 (in Brandenburg gibt es die Verwaltungseinheit Regierungsbezirk nicht)
   * - 64 Landkreis Märkisch-Oderland
   * - 340 Gemeinde Neuhardenberg
   */
  public var gemeindeschluessel: KatalogCode371? = null

  /**
   * Die Bezeichnung eines Kreises erfolgt durch die Angabe des Kreisnamens zur Identifikation des
   * Kreises innerhalb des Bundeslandes. In Deutschland bezeichnet der Kreis eine bestimmte Region,
   * einen Stadt- oder Landkreis, z. B. Main Taunus Kreis.
   */
  public var kreis: String? = null

  /**
   * Die Bezeichnung eines Bezirks erfolgt durch die Angabe des Bezirksnamens zur Identifikation des
   * Bezirks innerhalb des Landes. In Deutschland wird mit Bezirk eine bestimmte Region bezeichnet, die
   * einem Regierungsbezirk, einem ehemaligen Regierungsbezirk oder einer anderen statistischen Einheit
   * entspricht, die zwar mehrere Kreise umfasst, jedoch kleiner als ein Bundesland ist, z. B.
   * Regierungsbezirk Mittelfranken.
   */
  public var bezirk: String? = null

  /**
   * Ein Regionalschlüssel ist ein Schlüssel zur Identifikation einer Gemeinde oder sonstiger
   * Gebietskörperschaften (Kreis, Bezirks, Bundesland).
   *  
   * Die vierstufige deutsche Gebietsgliederung wird mit dem zwölfstelligen Regionalschlüssel (RS)
   * abgebildet.
   *  
   * Die Verschlüsselung erfolgt für:
   *  
   * - die Länder in der 1. und 2. Stelle,
   * - die Regierungsbezirke in der 3. Stelle, (falls in einem Bundesland keine Regierungsbezirke
   * vorhanden sind, ist diese Stelle mit '0' besetzt),
   * - die kreisfreien Städte / Stadtkreise und Landkreise in der 4. und 5. Stelle, (in
   * Baden-Württemberg kennzeichnet die 4. Stelle auch die Zugehörigkeit zu einer Region),
   * - die Gemeindeverbände in der 6. bis 9. Stelle und
   * - die Gemeinden in der 10. bis 12. Stelle.
   *  
   * Der Regionalschlüssel enthält, zusätzlich zu dem amtlichen Gemeindeschlüssel, weitere
   * Informationen.
   */
  public var regionalschluessel: String? = null

  /**
   * Die Bezeichnung eines Bundeslandes erfolgt durch die Angabe eines Bundeslandnamens zur
   * Identifikation des Bundeslandes innerhalb des Nationalstaates. In Deutschland bezeichnet ein
   * Bundesland eine bestimmte Region und umfasst mehrere Kreise und Bezirke, z. B. Thüringen
   * (Ausnahmen bilden die sogenannten Stadtstaaten, wie z. B. die Hansestadt Hamburg).
   */
  public var bundesland: KatalogCode321? = null

  public constructor(
      gemeindeschluessel: KatalogCode371?,
      kreis: String?,
      bezirk: String?,
      regionalschluessel: String?,
      bundesland: KatalogCode321?
  ) : this() {
    this.gemeindeschluessel = gemeindeschluessel
    this.kreis = kreis
    this.bezirk = bezirk
    this.regionalschluessel = regionalschluessel
    this.bundesland = bundesland
  }
}
