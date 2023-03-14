package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

/**
 * Abbildung von Beziehungen zwischen Personen und Straftaten.
 */
@Serializable
public open class Beziehung_Person_Straftat() : Beziehung() {
  /**
   * Beschreibung des vermuteten Motivs.
   *
   * Beispiele:
   * - Blutrache
   * - Politischer Hintergrund / Fremdenhass
   * - Verdeckung / Verdunklung einer Straftat
   */
  public var motiv: List<KatalogCode314>? = null

  /**
   * Angaben zum Schusswaffengebrauch durch eine Person bei der Begehung einer Straftat. Erfolgt
   * keine Angabe, lag weder ein Gebrauch noch eine Drohung vor.
   *  
   */
  public var schusswaffengebrauch: KatalogCode216? = null

  /**
   * Angabe, ob die an der Straftat beteiligte Person eine Schusswaffe mitgeführt hat.
   */
  public var schusswaffeMitgefuehrt: KatalogCode217? = null

  /**
   * Hier wird das Aussonderungsprüfdatum gemäß Datenschutzregelung des jeweiligen Gesetzes
   * abgebildet. Dieses kann verändert werden, aufgrund Verlängerung oder Verkürzung der Frist und wird
   * dann überschrieben.
   */
  public var aussonderungspruefdatum: LocalDate? = null

  public var dSStatus: DatenschutzrechtlicherStatus? = null

  public var alkoholeinfluss: Alkoholeinfluss? = null

  public var btMeinfluss: BtMeinfluss? = null

  /**
   * Abbildung des Justizaktenzeichens, welches die Justiz an die Polizei übermittelt hat.
   * In diesem Feld darf nur das personenbezogene Aktenzeichen der Justiz abgebildet werden. Alle
   * weiteren Aktenzeichen, z. B. von Polizeibehörden oder verfahrensbezogene Aktenzeichen der Justiz,
   * werden in der beteiligten Stelle am Vorgang abgebildet.
   */
  public var justizaktenzeichen: String? = null

  /**
   * Angaben zum exakten oder geschätzten (Unter- und Obergrenze) Alter einer Person.
   */
  public var alterZurTatzeit: Altersangabe? = null

  public constructor(
      motiv: List<KatalogCode314>?,
      schusswaffengebrauch: KatalogCode216?,
      schusswaffeMitgefuehrt: KatalogCode217?,
      aussonderungspruefdatum: LocalDate?,
      dSStatus: DatenschutzrechtlicherStatus?,
      alkoholeinfluss: Alkoholeinfluss?,
      btMeinfluss: BtMeinfluss?,
      justizaktenzeichen: String?,
      alterZurTatzeit: Altersangabe?
  ) : this() {
    this.motiv = motiv
    this.schusswaffengebrauch = schusswaffengebrauch
    this.schusswaffeMitgefuehrt = schusswaffeMitgefuehrt
    this.aussonderungspruefdatum = aussonderungspruefdatum
    this.dSStatus = dSStatus
    this.alkoholeinfluss = alkoholeinfluss
    this.btMeinfluss = btMeinfluss
    this.justizaktenzeichen = justizaktenzeichen
    this.alterZurTatzeit = alterZurTatzeit
  }
}
