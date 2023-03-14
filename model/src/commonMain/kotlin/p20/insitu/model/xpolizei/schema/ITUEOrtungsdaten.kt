package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.datetime.DateTimePeriod
import kotlinx.serialization.Serializable

/**
 * Angabe von speziellen ITÜ-Ortungsdaten (Azimut-Wert, Zell-ID) des Telekommunikationsanschlusses
 * sowie Angaben über die Geo-Daten des Funkmastes / der Sendeanlage.
 */
@Serializable
public open class ITUEOrtungsdaten() {
  /**
   * Angabe des Azimut-Wertes (Abstrahlwinkel in Grad) des Kommunikationsanschlusses in Relation zum
   * Funkmast/Sendeanlage.
   * Die Angabe erfolgt in Dezimalschreibweise.
   */
  public var azimutWert: Double? = 0.0

  /**
   * Angabe der der weltweit eindeutigen Global Cell-ID (GCID) des Funkmastes / der Sendeanlage.
   */
  public var gCID: String? = null

  /**
   * Zeitpunkt, zu dem die gCID des Kommunikationsanschlusses festgestellt wurde.
   */
  public var zeitpunkt: DatumZeit? = null

  /**
   * Angabe von Geodaten des Funkmastes / der Sendeanlage.
   */
  public var geokodierung: Geometrie? = null

  /**
   * Angabe der Geschwindigkeit in km/h.
   */
  public var geschwindigkeit: Double? = 0.0

  /**
   * Angabe der Standzeit in dd/hh/mm/ss.
   */
  public var standzeit: DateTimePeriod? = null

  /**
   * Angabe der Anzahl von Satelliten, mit denen geortet wurde.
   */
  public var satellitenanzahl: Int? = 0

  /**
   * Angabe zur Genauigkeit der Ortungsdaten in Metern.
   */
  public var abweichung: Double? = 0.0

  /**
   * Angabe der Himmelsrichtung, in der sich das GPS-Pack bewegt.
   */
  public var bewegungsrichtung: KatalogCode399? = null

  /**
   * Status der GPS-Packs (Bewegung, Sensoraktivität, Stillstand).
   */
  public var statusGPSPack: KatalogCode400? = null

  public var anschrift: Anschrift? = null

  public constructor(
      azimutWert: Double?,
      gCID: String?,
      zeitpunkt: DatumZeit?,
      geokodierung: Geometrie?,
      geschwindigkeit: Double?,
      standzeit: DateTimePeriod?,
      satellitenanzahl: Int?,
      abweichung: Double?,
      bewegungsrichtung: KatalogCode399?,
      statusGPSPack: KatalogCode400?,
      anschrift: Anschrift?
  ) : this() {
    this.azimutWert = azimutWert
    this.gCID = gCID
    this.zeitpunkt = zeitpunkt
    this.geokodierung = geokodierung
    this.geschwindigkeit = geschwindigkeit
    this.standzeit = standzeit
    this.satellitenanzahl = satellitenanzahl
    this.abweichung = abweichung
    this.bewegungsrichtung = bewegungsrichtung
    this.statusGPSPack = statusGPSPack
    this.anschrift = anschrift
  }
}
