package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Eine Verwendungsbeschränkung enthält die Information, ob die übermittelten Erkenntnisse /
 * Informationen zu weiteren Zwecken als nur zu denen, für die sie übermittelt wurden, verwendet werden
 * dürfen.
 */
@Serializable
public open class Verwendungsbeschraenkung() {
  /**
   * In diesem Attribut werden nur nationale (deutsche) Verwendungsbeschränkungen abgebildet.
   *  
   * Datenschutzklausel
   * • Werte:
   * o Keine Verwendungsbeschränkung
   * o Nur zur Abwehr einer unmittelbaren und ernsthaften Gefahr für die öffentliche Sicherheit
   * o Nur ohne Nennung desjenigen, der die Informationen zur Verfügung gestellt hat
   * o für Zwecke der Verhütung oder Verfolgung von Straftaten
   * o nicht als Beweis im gerichtlichen Verfahren
   * o nur nach Genehmigung desjenigen, der Information zur Verfügung gestellt hat
   * o Keine anderweitige Verwendung der Informationen gestattet
   *  
   * Mehrfachnennungen und sonstige Verwendungsbeschränkungen müssen möglich sein.
   */
  public var datenschutzklausel: List<KatalogCode279_NichtAbgeschlossen>? = null

  /**
   * Das Attribut dient der Abbildung der Verwendungsbeschränkung im Rahmen des
   * Informationsaustausches mit Europol (Europol Handling Codes).
   * Die Europol Handling Codes setzen sich aus dem Buchstaben H und einer Ziffer von 0 bis 3
   * zusammen und regeln die gestattete Verwendung bzw. Beschränkung und die obligatorischen
   * Anforderungen vor dem Gebrauch der Informationen.
   * Sie stützen sich auf international anerkannte Ausführungen im Europol-Ratsbeschluss und dem
   * Schengener Durchführungsübereinkommen (SDÜ).
   * Die Werte können auch in Kombination verwendet werden.
   * Bei Angabe des Wertes H3 muss die Möglichkeit der freitextlichen Erläuterung bestehen.
   */
  public var europolHandlingcode: List<KatalogCode288_MitZusatz>? = null

  public constructor(datenschutzklausel: List<KatalogCode279_NichtAbgeschlossen>?,
                     europolHandlingcode: List<KatalogCode288_MitZusatz>?) : this() {
    this.datenschutzklausel = datenschutzklausel
    this.europolHandlingcode = europolHandlingcode
  }
}
