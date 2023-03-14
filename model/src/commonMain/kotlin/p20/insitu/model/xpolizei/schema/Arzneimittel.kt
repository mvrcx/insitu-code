package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Arzneimittel sind Stoffe oder Stoffzusammensetzungen, die zur Heilung oder zur Verhütung
 * menschlicher oder tierischer Krankheiten bestimmt sind.
 */
@Serializable
public open class Arzneimittel() : Arznei_Betaeubungsmittel_Grundstoff() {
  /**
   * Angabe der Art des Arzneimittels.
   *
   * Beispiele: Serum, Fertigarzneimittel
   */
  public var art: KatalogCode323? = null

  /**
   * Angabe zur Anzahl des Arzneimittels.
   */
  public var stueckzahl: Int? = 0

  /**
   * Angabe der Darreichungsform des Arzneimittels.
   *
   * Beispiele: Tablette, Kapsel
   */
  public var darreichungsform: KatalogCode324? = null

  /**
   * Angabe der Pharmazentralnummer.
   */
  public var pZN: String? = null

  /**
   * Angabe, ob es sich um ein Tier- oder Humanarzneimittel handelt.
   */
  public var verwendungszweck: KatalogCode325? = null

  /**
   * Angabe, ob es sich um ein Dopingmittel handelt.
   */
  public var dopingmittel: KatalogCode217? = null

  /**
   * Angabe der Chargennummer, welche Auskunft über die Produktionsserie gibt.
   */
  public var chargennummer: String? = null

  /**
   * Angabe des Verfallsdatums.
   */
  public var verfallsdatum: String? = null

  /**
   * Angabe, ob es sich um Ausweichmittel für BtM-Konsum handelt.
   */
  public var ausweichmittelBtM: KatalogCode217? = null

  public var verpackung: Verpackung? = null

  public var verboteneSubstanz: List<VerboteneSubstanz>? = null

  public var faelschung: Faelschung? = null

  /**
   * Stoffe, die in einem Arzneimittel enthalten sind.
   */
  public var wirkstoff: List<Wirkstoff>? = null

  public constructor(
      art: KatalogCode323?,
      stueckzahl: Int?,
      darreichungsform: KatalogCode324?,
      pZN: String?,
      verwendungszweck: KatalogCode325?,
      dopingmittel: KatalogCode217?,
      chargennummer: String?,
      verfallsdatum: String?,
      ausweichmittelBtM: KatalogCode217?,
      verpackung: Verpackung?,
      verboteneSubstanz: List<VerboteneSubstanz>?,
      faelschung: Faelschung?,
      wirkstoff: List<Wirkstoff>?
  ) : this() {
    this.art = art
    this.stueckzahl = stueckzahl
    this.darreichungsform = darreichungsform
    this.pZN = pZN
    this.verwendungszweck = verwendungszweck
    this.dopingmittel = dopingmittel
    this.chargennummer = chargennummer
    this.verfallsdatum = verfallsdatum
    this.ausweichmittelBtM = ausweichmittelBtM
    this.verpackung = verpackung
    this.verboteneSubstanz = verboteneSubstanz
    this.faelschung = faelschung
    this.wirkstoff = wirkstoff
  }
}
