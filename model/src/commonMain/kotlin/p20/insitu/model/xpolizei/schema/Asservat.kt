package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Abbildung von spezifischen Eigenschaften amtlich verwahrter Gegenstände und Spuren.
 */
@Serializable
public open class Asservat() {
  /**
   * Durch den Sachbearbeiter vergebene Nummer gem. Asservierungssystem des Bundeskriminalamtes.
   */
  public var fachlicheAsservatennummer: String? = null

  /**
   * Landesseitig einmalig vergebene, technisch erzeugte ID zur Identifizierung des Asservates.
   */
  public var asservatenID: String? = null

  /**
   * Hinweis, ob von dem jeweiligen Asservat Gefahren ausgehen.
   *
   * Beispiele: giftig, geladene Schusswaffe etc.
   */
  public var gefahrenhinweis: String? = null

  /**
   * Hinweis, ob bei dem jeweiligen Asservat Besonderheiten bzgl. Transport und / oder Lagerung
   * beachtet werden müssen.
   *
   * Beispiele: zerbrechlich, nur stehend etc.
   */
  public var transportUndLagerhinweis: String? = null

  /**
   * Angabe, ob das Asservat im Rahmen der KT-Untersuchung beschädigt werden darf.
   */
  public var beschaedigungserlaubnis: KatalogCode217? = null

  /**
   * Angabe, ob ein Asservat Gegenstand einer KT-Untersuchung ist.
   */
  public var kTUntersuchung: KatalogCode217? = null

  /**
   * Aktueller Lagerstatus des Asservates.
   */
  public var lagerstatus: KatalogCode331? = null

  /**
   * Dieses Feld enthält Angaben zum Zweck der Asservierung.
   * Details zum jeweiligen Zweck der Asservierung sind über die Fachobjekte abzubilden.
   */
  public var zweckDerAsservierung: List<KatalogCode369>? = null

  /**
   * Angabe der UN-Nummer.
   */
  public var uNNummer: KatalogCode349? = null

  /**
   * Angabe der Nummer zur Kennzeichnung der Gefahr.
   */
  public var gefahrgutnummer: KatalogCode395? = null

  /**
   * Abbildung der Dateigröße des digitalen Asservats.
   */
  public var dateigroesse: Speichergroesse? = null

  /**
   * In diesem Attribut wird die Art der Sicherung erfasst.
   *
   * Beispiele: Abformung, Folienabzug
   */
  public var sicherungsart: KatalogCode405_NichtAbgeschlossen? = null

  public constructor(
      fachlicheAsservatennummer: String?,
      asservatenID: String?,
      gefahrenhinweis: String?,
      transportUndLagerhinweis: String?,
      beschaedigungserlaubnis: KatalogCode217?,
      kTUntersuchung: KatalogCode217?,
      lagerstatus: KatalogCode331?,
      zweckDerAsservierung: List<KatalogCode369>?,
      uNNummer: KatalogCode349?,
      gefahrgutnummer: KatalogCode395?,
      dateigroesse: Speichergroesse?,
      sicherungsart: KatalogCode405_NichtAbgeschlossen?
  ) : this() {
    this.fachlicheAsservatennummer = fachlicheAsservatennummer
    this.asservatenID = asservatenID
    this.gefahrenhinweis = gefahrenhinweis
    this.transportUndLagerhinweis = transportUndLagerhinweis
    this.beschaedigungserlaubnis = beschaedigungserlaubnis
    this.kTUntersuchung = kTUntersuchung
    this.lagerstatus = lagerstatus
    this.zweckDerAsservierung = zweckDerAsservierung
    this.uNNummer = uNNummer
    this.gefahrgutnummer = gefahrgutnummer
    this.dateigroesse = dateigroesse
    this.sicherungsart = sicherungsart
  }
}
