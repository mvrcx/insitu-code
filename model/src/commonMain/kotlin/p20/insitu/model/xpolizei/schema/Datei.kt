package p20.insitu.model.xpolizei.schema

import kotlin.ByteArray
import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Abbildung von Binärdaten oder URI / URL zum Download von Binärdaten.
 */
@Serializable
public open class Datei() {
  /**
   * Träger von Binärdaten.
   *
   * Beispiele.: Tonaufnahme, Lichtbild, Videoaufnahme
   */
  public var daten: ByteArray? = null

  /**
   * Abbildung eines URI / einer URL, mit dem / der die Binärdaten heruntergeladen werden können.
   */
  public var download: String? = null

  public constructor(daten: ByteArray?, download: String?) : this() {
    this.daten = daten
    this.download = download
  }
}
