package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * In diesem Fachobjekt können verschiedene Nummern (z. B. Steuernummer, personengebundene Nummer)
 * abgebildet werden.
 *  
 * Beispiel: Die Steuernummer ist eine vom Finanzamt vergebene Nummer, unter der jede
 * steuerpflichtige natürliche oder juristische Person / Organisation beim Finanzamt geführt wird.
 */
@Serializable
public open class Nummer() {
  /**
   * Bezeichnung der Nummer.
   *
   * Beispiele für Bevölkerungsregisternummern bei Personen sind „SOTU/HETU“ in Finnland, „PESEL“
   * und „NIP“ in Polen, „SOFI“ in den Niederlanden, ΑΡΙΘΜΟΣ ΦΟΡΟΛΟΓΙΚΟΥ ΜΗΤΡΩΟΥ (ΑΦΜ) und ΑΡΙΘΜΟΣ
   * ΜΗΤΡΩΟΥ ΚΟΙΝΩΝΙΚΗΣ ΑΣΦΑΛΙΣΗΣ (ΑΜΚΑ) in Griechenland usw.
   */
  public var bezeichnung: String? = null

  /**
   * Angabe des Nummernwertes.
   */
  public var nummernwert: String? = null

  /**
   * Angabe der Stelle, die die Nummer vergeben hat.
   */
  public var behoerde: BeteiligteStelle? = null

  public constructor(
    bezeichnung: String?,
    nummernwert: String?,
    behoerde: BeteiligteStelle?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.nummernwert = nummernwert
    this.behoerde = behoerde
  }
}
