package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Alle Arten von Wasserfahrzeugen.
 */
@Serializable
public open class Wasserfahrzeug() : Fahrzeug() {
  /**
   * Angabe der Art des Wasserfahrzeugs.
   *  
   * Beispiele:
   *
   * - Hochseetaugliches Frachtschiff
   * - Küstenmotorschiff
   * - Fischereifahrzeug
   * - Sportboot
   */
  public var art: KatalogCode124? = null

  /**
   * Freitextliche Modellbezeichnung, wenn anwendbar.
   *  
   * Beispiel: Fregatte F125
   */
  public var modell: String? = null

  /**
   * Name des Schiffs.
   *  
   * Beispiele:
   *
   * - 'Baden-Wuerttemberg' (Neubau der Bundesmarine, Fregatte F125, Indienststellung 2014)
   * - 'F 208 Niedersachsen' (Fregatte der Bremen-Klasse F122, Bundesmarine, Quelle: www.marine.de)
   */
  public var name: String? = null

  /**
   * Ort der gewerblichen bzw. dienstrechtlichen Niederlassung eines Unternehmens, das für ein
   * Schiff als Reeder auftritt.
   */
  public var heimathafen: String? = null

  /**
   * Staat, in dessen Schiffsregister ein Schiff eingetragen ist und dessen Flagge es zu führen hat.
   */
  public var flaggenstaat: KatalogCode286_NichtAbgeschlossen? = null

  /**
   * Raummaß (als Dimensionslose Zahl), welches die Tonnage eines Schiffes bestimmt.
   *  
   * Siehe http://de.wikipedia.org/wiki/Schiffsmaße#Brutto-_und_Nettoraumzahl_.28BRZ.2C_NRZ.29
   */
  public var bruttoRaumzahl: Double? = 0.0

  /**
   * Raummaß (als Dimensionslose Zahl), welches die Tonnage eines Schiffes bestimmt.
   *
   * Siehe http://de.wikipedia.org/wiki/Schiffsmaße#Brutto-_und_Nettoraumzahl_.28BRZ.2C_NRZ.29
   */
  public var nettoRaumzahl: Double? = 0.0

  /**
   * 'Der Tiefgang eines Schiffes ist definiert als der Abstand von der Wasseroberfläche bis zum
   * tiefsten Punkt des Schiffs (i. d. R. also der Unterkante des Kiels) bei stabiler unbewegter
   * Schwimmlage in ruhigem Wasser.' Quelle: http://de.wikipedia.org/wiki/Schiffsmaße
   *
   * Der Tiefgang hängt von verschiedenen Faktoren ab (Beladung des Schiffs, Wasserdichte in
   * Abhängigkeit von Salzgehalt und Temperatur), so dass es sich eigentlich nicht um ein
   * unveränderliches Merkmal eines Wasserfahrzeugs handelt.
   */
  public var tiefgang: Ausmass? = null

  public var zulassungsinformation: List<ZulassungsinformationWasserfahrzeug>? = null

  /**
   * Angabe des Gewichts, das von einem Wasserfahrzeug getragen werden kann.
   */
  public var tragfaehigkeit: Gewicht? = null

  public constructor(
      art: KatalogCode124?,
      modell: String?,
      name: String?,
      heimathafen: String?,
      flaggenstaat: KatalogCode286_NichtAbgeschlossen?,
      bruttoRaumzahl: Double?,
      nettoRaumzahl: Double?,
      tiefgang: Ausmass?,
      zulassungsinformation: List<ZulassungsinformationWasserfahrzeug>?,
      tragfaehigkeit: Gewicht?
  ) : this() {
    this.art = art
    this.modell = modell
    this.name = name
    this.heimathafen = heimathafen
    this.flaggenstaat = flaggenstaat
    this.bruttoRaumzahl = bruttoRaumzahl
    this.nettoRaumzahl = nettoRaumzahl
    this.tiefgang = tiefgang
    this.zulassungsinformation = zulassungsinformation
    this.tragfaehigkeit = tragfaehigkeit
  }
}
