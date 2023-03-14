package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Eine Behörde oder sonstige öffentliche Dienststelle des Bundes, der Länder, einer Kommune, der EU
 * oder eines Drittlandes.
 *  
 * Auch Auftragnehmer (z. B. Handwerker, Ärzte, Firmen, Gutachter) von öffentlichen Behörden werden
 * als beteiligte Stelle abgebildet.
 */
@Serializable
public open class BeteiligteStelle() {
  /**
   * Art der beteiligten Stelle.
   *  
   * Beispiele:
   * - Gericht
   * - Staatsanwaltschaft
   * - Kraftfahrzeugzulassungsstelle
   * - Meldebehörde
   * - Ausländerbehörde
   * - Militär
   * - Polizei
   */
  public var art: KatalogCode212_NichtAbgeschlossen? = null

  /**
   * Dieses Feld enthält Angaben zum Aktenzeichen der beteiligten Dienststelle.
   *
   * Beispiel: Az. 345/08
   *  
   * Beteiligte Stellen eines Vorgangs können mehrere Aktenzeichen vergeben.
   */
  public var aktenzeichen: List<String>? = null

  /**
   * Freitextliche Angaben zur beteiligten Stelle.
   */
  public var bemerkung: String? = null

  /**
   * Angabe des Staates (kein Bundes- oder Teilstaat), zu dem die beteiligte Stelle gehört.
   * Beispiel: Die deutsche Botschaft in London gehört zum Staat 'Deutschland', obwohl ihre
   * Anschrift im Staat 'Vereinigtes Königreich von Großbritannien und Nordirland' liegt.
   * Beispiel: Ein Führerschein wird in Deutschland von einer Stelle eines Landkreises ausgestellt.
   * Die nationale Zugehörigkeit ist aber nicht das Bundesland, sondern der Gesamtstaat 'Deutschland'.
   */
  public var nationaleZugehoerigkeit: KatalogCode208_NichtAbgeschlossen? = null

  /**
   * Katalogisierte Angabe des INPOL-Teilnehmers gem. INPOL-Manual, zu dem die beteiligte Stelle
   * gehört.
   */
  public var laenderschluessel: KatalogCode287? = null

  public var anschrift: Anschrift? = null

  public var postfach: Postfach? = null

  /**
   * Angaben über den Namen und die Erreichbarkeit des Sachbearbeiters.
   */
  public var sachbearbeiter: List<Kontakt>? = null

  /**
   * Angaben über den Namen und die Erreichbarkeit der Dienststelle. 
   */
  public var dienststelle: Kontakt? = null

  /**
   * Angaben über den Namen und die Erreichbarkeit der Organisationseinheit. 
   */
  public var organisationseinheit: Kontakt? = null

  public var behoerdenkennzeichnung: Behoerdenkennzeichnung? = null

  public constructor(
      art: KatalogCode212_NichtAbgeschlossen?,
      aktenzeichen: List<String>?,
      bemerkung: String?,
      nationaleZugehoerigkeit: KatalogCode208_NichtAbgeschlossen?,
      laenderschluessel: KatalogCode287?,
      anschrift: Anschrift?,
      postfach: Postfach?,
      sachbearbeiter: List<Kontakt>?,
      dienststelle: Kontakt?,
      organisationseinheit: Kontakt?,
      behoerdenkennzeichnung: Behoerdenkennzeichnung?
  ) : this() {
    this.art = art
    this.aktenzeichen = aktenzeichen
    this.bemerkung = bemerkung
    this.nationaleZugehoerigkeit = nationaleZugehoerigkeit
    this.laenderschluessel = laenderschluessel
    this.anschrift = anschrift
    this.postfach = postfach
    this.sachbearbeiter = sachbearbeiter
    this.dienststelle = dienststelle
    this.organisationseinheit = organisationseinheit
    this.behoerdenkennzeichnung = behoerdenkennzeichnung
  }
}
