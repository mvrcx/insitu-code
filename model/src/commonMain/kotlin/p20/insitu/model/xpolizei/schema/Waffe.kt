package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Dieses abstrakte Fachobjekt stellt keine eigenständige Komponente des IMP dar und dient nur zur
 * Aufnahme von Informationen, die in allen Spezialisierungen benötigt werden.
 */
@Serializable
abstract class Waffe() : Waffe_Leer() {
  /**
   * Dieses Feld enthält ggf. Angaben zur näheren Beschreibung zur Art der Waffe.
   */
  public var bezeichnung: String? = null

  /**
   * Dieses Feld enthält Angaben über das Modell der Waffe.
   *  
   * Beispiele: Norton TP70, Firefox, 1932 Police, 87 Cheetah, Rex II, 45-1 Combat
   */
  public var modell: String? = null

  /**
   * Sämtliche legal hergestellten Waffen besitzen eine eingeschlagene, eingravierte oder gelaserte
   * Seriennummer zur Identifikation auf allen wesentlichen Waffenteilen (i. d. R. sind das Griffstück,
   * Lauf und Verschluss). Bei Kurzwaffen mit Polymergriffstück sind auch Nummern oder Strichcodes auf
   * eingegossenen Metallplättchen üblich (sogenannte 'ID-Tags'). Die Seriennummer wird in Deutschland
   * z. B. im Waffenhandelsbuch, in der Waffenbesitzkarte, im Jagdschein und / oder im Waffenschein
   * vermerkt.
   */
  public var nummernangabe: List<Nummernangabe>? = null

  /**
   * Dieses Feld enthält Angaben zur Anzahl von Waffen, Munition, Sprengstoffen, etc.
   *  
   * Beispiele:
   * - 50 Schalldämpfer gleicher Bauart.
   * - 50 Schuss gleichartige Munition
   * - 5 Schusswaffen Walther PPK
   */
  public var stueckzahl: Int? = 0

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * In diesem Attribut können Bearbeitungsspuren und Besonderheiten wie Beschädigungen, Änderungen
   * (andere Griffschalen) und Deformierungen abgebildet werden.
   */
  public var besondereMerkmale: String? = null

  /**
   * Dieses Feld enthält eine freitextliche Bemerkung zur jeweiligen Waffe.
   */
  public var bemerkung: String? = null

  public var gewicht: Gewicht? = null

  /**
   * Breite der Waffe.
   */
  public var breite: Ausmass? = null

  /**
   * Höhe der Waffe.
   */
  public var hoehe: Ausmass? = null

  /**
   * Länge der Waffe.
   */
  public var laenge: Ausmass? = null

  public var farbangabe: List<Farbangabe>? = null

  public var dokument: List<Dokument>? = null

  public var faelschung: Faelschung? = null

  public var redundanzinformation: Redundanzinformation? = null

  public var asservat: Asservat? = null

  /**
   * Angabe von sachgebundenen Hinweisen zu Waffen.
   */
  public var sachgebundenerHinweis: List<String>? = null

  public constructor(
      bezeichnung: String?,
      modell: String?,
      nummernangabe: List<Nummernangabe>?,
      stueckzahl: Int?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      besondereMerkmale: String?,
      bemerkung: String?,
      gewicht: Gewicht?,
      breite: Ausmass?,
      hoehe: Ausmass?,
      laenge: Ausmass?,
      farbangabe: List<Farbangabe>?,
      dokument: List<Dokument>?,
      faelschung: Faelschung?,
      redundanzinformation: Redundanzinformation?,
      asservat: Asservat?,
      sachgebundenerHinweis: List<String>?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.modell = modell
    this.nummernangabe = nummernangabe
    this.stueckzahl = stueckzahl
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.besondereMerkmale = besondereMerkmale
    this.bemerkung = bemerkung
    this.gewicht = gewicht
    this.breite = breite
    this.hoehe = hoehe
    this.laenge = laenge
    this.farbangabe = farbangabe
    this.dokument = dokument
    this.faelschung = faelschung
    this.redundanzinformation = redundanzinformation
    this.asservat = asservat
    this.sachgebundenerHinweis = sachgebundenerHinweis
  }
}
