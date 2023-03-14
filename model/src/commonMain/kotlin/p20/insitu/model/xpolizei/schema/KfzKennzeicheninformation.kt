package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Das Fachobjekt bildet die Eigenschaften eines Kfz-Kennzeichens ab und wird sowohl vom Fachobjekt
 * Zulassungsinformation als auch voFachobjekt KfzKennzeichenschild verwendet. Je nach Verwendung wird
 * in diesem Fachobjekt also das Kennzeichens eines Kfz, wie von der Zulassungsbehörde zugeteilt und in
 * der Zulassungsbescheinigung dokumentiert, oder ein Kennzeichen, wie es auf einem
 * KfzKennzeichenschild erscheint, abgebildet.
 */
@Serializable
public open class KfzKennzeicheninformation() {
  /**
   * Art des Kennzeichens.
   *
   * In Deutschland gibt es verschiedene Arten von Kfz-Kennzeichen (z. B. Saisonkennzeichen,
   * Kennzeichen für historische Fahrzeuge, Kurzzeitkennzeichen).
   *  
   *  
   * Saisonkennzeichen:
   * Vorteil dieser 1995 eingeführten Kennzeichen ist, dass An- und Abmeldung nunmehr automatisch
   * geschehen.
   */
  public var kennzeichenArt: KatalogCode109_NichtAbgeschlossen? = null

  /**
   * Das zur Zulassung gehörende Kennzeichen als Zeichenfolge. Sind nur Teile eines Kfz-Kennzeichens
   * bekannt, so wird für ein fehlendes Fragment als Platzhalter \? eingetragen.
   *  
   * Beispiele:
   * - ESW - XY 123
   * - M - \?X 8888
   *  
   * Eingabe von Saisonkennzeichen: Vorschlag 'WI - AB 123 04/10'.
   * Historische Kennzeichen sind beispielsweise als 'MZ-OO 120H' abzubilden.
   */
  public var kennzeichen: String? = null

  /**
   * Staat (kein Bundesstaat), in dem die das Kennzeichen ausgebende Stelle (siehe Zulassungsstelle)
   * ihren Sitz hat.
   *  
   * Beispiele:
   * Kennzeichen 'Y - 751 957' - Nationalität Deutschland
   *  
   * Zu klären, ob es supranationale Stellen gibt, die Zulassungen ausstellen (Abgrenzung zur
   * beteiligten Stelle).
   */
  public var nationalitaet: KatalogCode372_NichtAbgeschlossen? = null

  /**
   * Angabe über den Beginn des Betriebszeitraums eines Fahrzeugs mit Saisonkennzeichen. Der
   * Betriebszeitraum darf mindestens zwei und maximal elf Monate umfassen.
   */
  public var beginnMonatSaisonkennzeichen: String? = null

  /**
   * Angabe über das Ende des Betriebszeitraums eines Fahrzeugs mit Saisonkennzeichen. Der
   * Betriebszeitraum darf mindestens zwei und maximal elf Monate umfassen.
   */
  public var endeMonatSaisonkennzeichen: String? = null

  public constructor(
      kennzeichenArt: KatalogCode109_NichtAbgeschlossen?,
      kennzeichen: String?,
      nationalitaet: KatalogCode372_NichtAbgeschlossen?,
      beginnMonatSaisonkennzeichen: String?,
      endeMonatSaisonkennzeichen: String?
  ) : this() {
    this.kennzeichenArt = kennzeichenArt
    this.kennzeichen = kennzeichen
    this.nationalitaet = nationalitaet
    this.beginnMonatSaisonkennzeichen = beginnMonatSaisonkennzeichen
    this.endeMonatSaisonkennzeichen = endeMonatSaisonkennzeichen
  }
}
