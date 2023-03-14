package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Als Betäubungsmittel werden alle Stoffe oder Zubereitungen, die in Anlage I bis III des
 * Betäubungsmittelgesetzes (BtMG) aufgelistet sind, bezeichnet.
 */
@Serializable
public open class Betaeubungsmittel() : Arznei_Betaeubungsmittel_Grundstoff() {
  /**
   * Hier wird die Art des Betäubungsmittels abgebildet.
   *
   * Beispiele: Heroin, Cannabis, Ecstasy
   */
  public var art: KatalogCode105? = null

  /**
   * Hier wird die Beschaffenheit des Betäubungsmittels abgebildet.
   *
   * Beispiele: Flüssigkeit, Kapsel, Pulver
   */
  public var beschaffenheit: KatalogCode211? = null

  /**
   * Hier werden Angaben zur Art der Verpackung des Betäubungsmittels abgebildet.
   *
   * Beispiele: Klebestreifen, Tütchen, Szenebeutel
   */
  public var verpackungsart: String? = null

  /**
   * Dieses Feld enthält Angaben zur Anzahl von Betäubungsmitteln.
   */
  public var stueckzahl: Int? = 0

  public var farbangabe: List<Farbangabe>? = null

  /**
   * Inhaltsstoffe des Betäubungsmittels.
   */
  public var zusammensetzung: List<Inhaltsstoff>? = null

  public var logo: Logo? = null

  public constructor(
      art: KatalogCode105?,
      beschaffenheit: KatalogCode211?,
      verpackungsart: String?,
      stueckzahl: Int?,
      farbangabe: List<Farbangabe>?,
      zusammensetzung: List<Inhaltsstoff>?,
      logo: Logo?
  ) : this() {
    this.art = art
    this.beschaffenheit = beschaffenheit
    this.verpackungsart = verpackungsart
    this.stueckzahl = stueckzahl
    this.farbangabe = farbangabe
    this.zusammensetzung = zusammensetzung
    this.logo = logo
  }
}
