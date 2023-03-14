package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Allgemeine und abstrakte Beziehungsklasse.
 */
@Serializable
abstract class Beziehung() : Beziehung_Leer() {
  /**
   * Hier wird der jeweilige Katalog hinterlegt, der für die abzubildende Beziehung gilt, z. B. bei
   * Personalie_Organisation der Katalog mit den Werten wie Unterstützer, Kunde, Finanzier, Teilhaber,
   * Führungsebene usw.
   */
  public var rolle: KatalogCode001? = null

  /**
   * Nähere Bezeichnung des Rollenwertes, z. B. bei Nutzer hier Beifahrer oder bei Führungsebene
   * hier Abteilungsleiter.
   *  
   */
  public var bezeichnung: String? = null

  /**
   * Möglichkeit der Referenz auf Quellen (andere Fachobjekte des IMP), die dazu dienen den
   * fachlichen Zusammenhang zu verifizieren.
   *
   * Beispiel: Person ist Tatverdächtiger einer Straftat aufgrund des Ergebnisses einer hoheitlichen
   * Maßnahme (KT-Untersuchung).
   *  
   * Dies ermöglicht auf XML-Ebene die Verwendung von ternären (und höheren) Beziehungskonstrukten.
   */
  public var quellreferenz: List<String>? = null

  /**
   * Angabe, ob die Richtung einer Beziehung eine fachliche Bedeutung hat.
   */
  public var richtungsrelevant: KatalogCode217? = null

  /**
   * Angabe, ob die mit der Beziehung verknüpften Fachobjekte EIS-relevant sind oder nicht.
   */
  public var eISRelevanz: KatalogCode217? = null

  /**
   * Weitere freitextliche Angaben zur Beziehung.
   */
  public var bemerkung: String? = null

  public var anacapabewertung: Anacapabewertung? = null

  /**
   * Gültigkeitsbeginn der Beziehung.
   */
  public var beginndatum: DatumZeit? = null

  /**
   * Gültigkeitsende der Beziehung
   */
  public var enddatum: DatumZeit? = null

  /**
   * Angabe, ob und welche Bedeutung die Information für das Ermittlungsverfahren hat.
   */
  public var ermittlungsrelevanz: KatalogCode359? = null

  /**
   * Die Angabe der ID dient der Zuordnung des ersten Fachobjekts dieser Beziehung.
   * id1_quellID muss identisch sein mit der ID des Fachobjekts im Quellsystem.
   */
  public var id1_quellID: String? = null

  /**
   * Die Angabe der ID dient der Zuordnung des ersten Fachobjekts dieser Beziehung in der
   * XML-Nachricht.
   * id1 muss identisch sein mit der ID des Fachobjekts in der XML-Nachricht.
   */
  public var id1_xmlID: String? = null

  /**
   * Die Angabe der ID dient der Zuordnung des ersten Fachobjekts dieser Beziehung.
   * id1_zielID muss identisch sein mit der ID des Fachobjekts im Zielsystem.
   */
  public var id1_zielID: String? = null

  /**
   * Die Angabe der ID dient der Zuordnung des zweiten Fachobjekts dieser Beziehung.
   * id2_quellID muss identisch sein mit der ID des Fachobjekts im Quellsystem.
   */
  public var id2_quellID: String? = null

  /**
   * Die Angabe der ID dient der Zuordnung des zweiten Fachobjekts dieser Beziehung in der
   * XML-Nachricht.
   * id2 muss identisch sein mit der ID des Fachobjekts in der XML-Nachricht.
   */
  public var id2_xmlID: String? = null

  /**
   * Die Angabe der ID dient der Zuordnung des zweiten Fachobjekts dieser Beziehung.
   * id2_zielID muss identisch sein mit der ID des Fachobjekts im Zielsystem.
   */
  public var id2_zielID: String? = null

  public constructor(
      rolle: KatalogCode001?,
      bezeichnung: String?,
      quellreferenz: List<String>?,
      richtungsrelevant: KatalogCode217?,
      eISRelevanz: KatalogCode217?,
      bemerkung: String?,
      anacapabewertung: Anacapabewertung?,
      beginndatum: DatumZeit?,
      enddatum: DatumZeit?,
      ermittlungsrelevanz: KatalogCode359?,
      id1_quellID: String?,
      id1_xmlID: String?,
      id1_zielID: String?,
      id2_quellID: String?,
      id2_xmlID: String?,
      id2_zielID: String?
  ) : this() {
    this.rolle = rolle
    this.bezeichnung = bezeichnung
    this.quellreferenz = quellreferenz
    this.richtungsrelevant = richtungsrelevant
    this.eISRelevanz = eISRelevanz
    this.bemerkung = bemerkung
    this.anacapabewertung = anacapabewertung
    this.beginndatum = beginndatum
    this.enddatum = enddatum
    this.ermittlungsrelevanz = ermittlungsrelevanz
    this.id1_quellID = id1_quellID
    this.id1_xmlID = id1_xmlID
    this.id1_zielID = id1_zielID
    this.id2_quellID = id2_quellID
    this.id2_xmlID = id2_xmlID
    this.id2_zielID = id2_zielID
  }
}
