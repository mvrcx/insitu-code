package p20.insitu.model.xpolizei.schema

import kotlin.ByteArray
import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

/**
 * Allgemeine Basisklasse
 */
@Serializable
public open class AllgemeineBasisklasse() {
  /**
   * Besitzer des Fachobjekts.
   */
  public var datenbesitzer: String? = null

  /**
   * Zu adressierender Bereich im Zielsystem.
   */
  public var datenbereich: List<String>? = null

  /**
   * Es ist in jedem XPolizei-Projekt festzulegen, in welchen Fachobjekten die Verwendung des
   * benutzerdefinierten Inhalts gegebenenfalls erforderlich ist.
   *
   * Soll in Nachrichten benutzerdefinierter Inhalt verwendet werden, muss die Nachricht eine
   * projektspezifische XSD inkludieren, die einen projektspezifischen Namensraum und die zugehörigen
   * projektspezifischen Elemente definiert.
   */
  public var benutzerInhalt: BenutzerInhalt? = null

  /**
   * Erster Anlagezeitpunkt des Fachobjekts.
   *
   * Der Datentyp dateTime stellt einen spezifischen Zeitpunkt dar. Der Wertebereich von dateTime
   * entspricht dem Raum von möglichen Kombinationen aus Datum und Tageszeit wie in §5.4 von [ISO 8601]
   * definiert.
   *
   * Die Angabe der Zeitzone ist in XPolizei Pflicht!
   *
   * Beispiele:
   * Um auszudrücken dass es sich um die Coordinated Universal Time (UTC) handelt, wird der
   * Darstellung direkt ein 'Z' oder ein '+00:00' nachgestellt.
   * Der 01. März 1999 um 11:00 Uhr in London, ist folgendermaßen anzugeben:
   * 1999-03-01T11:00:00Z oder 1999-03-01T11:00:00+00:00
   *
   * Eine Lokalzeit in einer von UTC abweichenden Zeitzone, z. B. der 31. Mai 1999 um 13:20 Uhr in
   * Berlin zur Sommerzeit, ist folgendermaßen anzugeben:
   * 1999-05-31T13:20:00+02:00
   *
   * Der 02. Dezember 1999 um 14:45 Uhr in Berlin, also zur Winterzeit, ist folgendermaßen
   * anzugeben:
   * 1999-12-02T14:45:00+01:00
   */
  public var erstellungsDatum: LocalDateTime? = null

  /**
   * Letzter Aktualisierungszeitpunkt des Fachobjekts.
   *
   * Der Datentyp dateTime stellt einen spezifischen Zeitpunkt dar. Der Wertebereich von dateTime
   * entspricht dem Raum von möglichen Kombinationen aus Datum und Tageszeit wie in §5.4 von [ISO 8601]
   * definiert.
   *
   * Die Angabe der Zeitzone ist in XPolizei Pflicht!
   *
   * Beispiele:
   * Um auszudrücken, dass es sich um die Coordinated Universal Time (UTC) handelt, wird der
   * Darstellung direkt ein 'Z' oder ein '+00:00' nachgestellt.
   * Der 01. März 1999 um 11:00 Uhr in London, ist folgendermaßen anzugeben:
   * 1999-03-01T11:00:00Z oder 1999-03-01T11:00:00+00:00
   *
   * Eine Lokalzeit in einer von UTC abweichenden Zeitzone, z. B. der 31. Mai 1999 um 13:20 Uhr in
   * Berlin zur Sommerzeit, ist folgendermaßen anzugeben:
   * 1999-05-31T13:20:00+02:00
   *
   * Der 02. Dezember 1999 um 14:45 Uhr in Berlin, also zur Winterzeit, ist folgendermaßen
   * anzugeben:
   * 1999-12-02T14:45:00+01:00
   */
  public var aenderungsDatum: LocalDateTime? = null

  /**
   * Angabe des Datenursprungs und in diesem Zusammenhang stehende Besonderheiten des Fachobjekts.
   */
  public var datenursprung: List<Datenursprung>? = null

  /**
   * Dieses Feld enthält die Angabe, ob  das Fachobjekt  geschützt ist.
   */
  public var geschuetzt: KatalogCode217? = null

  /**
   * Die Objekt-ID muss innerhalb einer XML-Nachricht eindeutig sein.
   */
  public var id: String? = null

  /**
   * ID des Objekts im Quell-System.
   */
  public var quellID: String? = null

  /**
   * ID des Objekts im Ziel-System.
   */
  public var zielID: String? = null

  public constructor(
      datenbesitzer: String?,
      datenbereich: List<String>?,
      benutzerInhalt: BenutzerInhalt?,
      erstellungsDatum: LocalDateTime?,
      aenderungsDatum: LocalDateTime?,
      datenursprung: List<Datenursprung>?,
      geschuetzt: KatalogCode217?,
      id: String?,
      quellID: String?,
      zielID: String?
  ) : this() {
    this.datenbesitzer = datenbesitzer
    this.datenbereich = datenbereich
    this.benutzerInhalt = benutzerInhalt
    this.erstellungsDatum = erstellungsDatum
    this.aenderungsDatum = aenderungsDatum
    this.datenursprung = datenursprung
    this.geschuetzt = geschuetzt
    this.id = id
    this.quellID = quellID
    this.zielID = zielID
  }

  @Serializable
  public class BenutzerInhalt() {
    public var any: List<ByteArray>? = null

    public constructor(any: List<ByteArray>?) : this() {
      this.any = any
    }
  }
}
