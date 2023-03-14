package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Als Software bezeichnet man die Gesamtheit aller Mittel, die in Form von Programmen und
 * Dokumentationen für den Betrieb von Computern und weiteren elektronischen Datenverarbeitungsanlagen
 * zur Verfügung stehen.
 *
 * Beispiele: MS Office, iOS
 */
@Serializable
public open class Software() : Software_Leer() {
  /**
   * Als Schadsoftware bezeichnet man Computerprogramme, die entwickelt wurden, um unerwünschte und
   * gegebenenfalls schädliche Funktionen auszuführen.
   *
   * Beispiele: Computervirus, Passwortsniffer, Ransomware, Trojaner, Computerwurm
   */
  public var schadsoftware: KatalogCode217? = null

  /**
   * Angabe der Bezeichnung der Software.
   */
  public var bezeichnung: String? = null

  /**
   * Eine Programmiersprache ist eine formale Sprache zur Formulierung von Datenstrukturen und
   * Algorithmen, d. h. von Rechenvorschriften, die von einem Computer ausgeführt werden können. Die
   * Programmiersprache betrifft sowohl das im Rechner eingespeicherte Programm als auch dessen
   * Bedienung.
   *
   * Beispiele: Java, Python
   */
  public var programmiersprache: String? = null

  /**
   * Abbildung der Softwareversion.
   */
  public var version: String? = null

  public var redundanzinformation: Redundanzinformation? = null

  public var hashinformation: List<Hashinformation>? = null

  public constructor(
      schadsoftware: KatalogCode217?,
      bezeichnung: String?,
      programmiersprache: String?,
      version: String?,
      redundanzinformation: Redundanzinformation?,
      hashinformation: List<Hashinformation>?
  ) : this() {
    this.schadsoftware = schadsoftware
    this.bezeichnung = bezeichnung
    this.programmiersprache = programmiersprache
    this.version = version
    this.redundanzinformation = redundanzinformation
    this.hashinformation = hashinformation
  }
}
