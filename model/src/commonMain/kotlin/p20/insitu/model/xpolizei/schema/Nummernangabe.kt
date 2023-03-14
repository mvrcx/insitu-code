package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Eine von einem Besitzer, Eigentümer, Nutzer, Händler oder Hersteller angebrachte alphanumerische
 * Kennzeichnung.
 *
 * Beispiele: Inventarnummer, Seriennummer
 */
@Serializable
public open class Nummernangabe() {
  /**
   * Alphanumerische Darstellung der Nummer.
   *  
   * Beispiel: M0104579
   */
  public var nummer: String? = null

  /**
   * Bezeichnung der numerischen Kennzeichnung.
   *  
   * Beispiel: Inventarnummer
   */
  public var bezeichnung: String? = null

  /**
   * Angabe, ob es sich bei der Nummer um eine Individualnummer handelt.
   */
  public var individualnummer: KatalogCode217? = null

  public constructor(
    nummer: String?,
    bezeichnung: String?,
    individualnummer: KatalogCode217?
  ) : this() {
    this.nummer = nummer
    this.bezeichnung = bezeichnung
    this.individualnummer = individualnummer
  }
}
