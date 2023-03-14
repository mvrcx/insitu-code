package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Abbildung von Sonstigen Sachen, die im Rahmen einer TKÜ-Maßnahme betroffen sind.
 */
@Serializable
public open class Beziehung_Kommunikationsereignis_Kommunikationsanschluss() : Beziehung() {
  /**
   * Angabe der gesendeten DTMF-Daten während eines Kommunikationsereignisses.
   */
  public var dTMFDaten: List<String>? = null

  /**
   * Angabe von speziellen ITÜ-Ortungsdaten (Azimut-Wert, Zell-ID) des Telekommunikationsanschlusses
   * sowie Angaben über die Geo-Daten des Funkmastes / der Sendeanlage.
   */
  public var iTUEGeodaten: List<ITUEOrtungsdaten>? = null

  /**
   * Angabe, ob eine Nachricht (SMS / E-Mail / Instant Messaging) erfolgreich versendet oder
   * empfangen wurde, bzw. nicht zugestellt werden konnte.
   */
  public var statusNachrichtenuebertragung: KatalogCode362? = null

  public constructor(
      dTMFDaten: List<String>?,
      iTUEGeodaten: List<ITUEOrtungsdaten>?,
      statusNachrichtenuebertragung: KatalogCode362?
  ) : this() {
    this.dTMFDaten = dTMFDaten
    this.iTUEGeodaten = iTUEGeodaten
    this.statusNachrichtenuebertragung = statusNachrichtenuebertragung
  }
}
