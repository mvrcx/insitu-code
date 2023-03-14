package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Alle Sachen, die man nicht unter Waffe, Fahrzeug, Betäubungsmittel, Zahlungskarte, Bargeld,
 * Urkunde oder Aufzeichnung abbilden kann.
 */
@Serializable
public open class SonstigeSache() : SonstigeSache_Leer() {
  /**
   * Angabe der Art der sonstigen Sache.
   */
  public var art: KatalogCode119_NichtAbgeschlossen? = null

  /**
   * Nähere Spezifikation der Art des Gegenstandes.
   *  
   * Beispiel: Für Art wurde 'sonstiges elektrisches / elektronisches Gerät' gewählt, Beschreibung
   * könnte lauten 'elektrischer Dosenöffner Marke XY'
   */
  public var bezeichnung: String? = null

  /**
   * Die Typ- / Modellbezeichnung einer Sache, die nicht individuelles Merkmal eines Einzelstücks
   * ist.
   *  
   * Beispiel: 'Captain 55' für Weltempfänger Marke Sony
   */
  public var modell: String? = null

  /**
   * Angaben zur Anzahl von Sachen.
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
   * Beschreibung besonderer Merkmale der sonstigen Sache (z. B. Beschädigungen, Markierungen).
   *  
   * Beispiele: Display zerkratzt, Gerät nicht funktionsfähig
   */
  public var besondereMerkmale: String? = null

  /**
   * Freitextliche Bemerkungen zur sonstigen Sache, die sich nicht strukturiert beschreiben lassen.
   */
  public var bemerkung: String? = null

  /**
   * Materialien, aus denen die sonstige Sache besteht.
   */
  public var material: List<Material>? = null

  public var nummernangabe: List<Nummernangabe>? = null

  /**
   * Hersteller der sonstigen Sache.
   */
  public var herstellungsinformation: Herstellungsinformation? = null

  /**
   * Neuwert einer Sache, z. B. aufgedruckter Wert einer Telefonkarte mit Chip. 
   */
  public var neuwert: Geldbetrag? = null

  /**
   * Länge der sonstigen Sache.
   */
  public var laenge: Ausmass? = null

  /**
   * Breite der sonstigen Sache.
   */
  public var breite: Ausmass? = null

  /**
   * Höhe der sonstigen Sache.
   */
  public var hoehe: Ausmass? = null

  /**
   * Rauminhalt der sonstigen Sache.
   */
  public var volumen: Volumen? = null

  public var gewicht: Gewicht? = null

  public var farbangabe: List<Farbangabe>? = null

  /**
   * Beispielsweise Lichtbildaufnahmen eines gestohlenen Gegenstandes, z. B. wertvollen Gemäldes.
   */
  public var dokument: List<Dokument>? = null

  /**
   * Der Zeitwert bezieht sich auf den Zeitpunkt der Feststellung. 
   */
  public var zeitwert: Geldbetrag? = null

  public var faelschung: Faelschung? = null

  public var redundanzinformation: Redundanzinformation? = null

  public var asservat: Asservat? = null

  /**
   * Durchmesser einer sonstigen Sache.
   */
  public var durchmesser: Ausmass? = null

  /**
   * Angabe von sachgebundenen Hinweisen zu Sachen.
   */
  public var sachgebundenerHinweis: List<String>? = null

  public constructor(
      art: KatalogCode119_NichtAbgeschlossen?,
      bezeichnung: String?,
      modell: String?,
      stueckzahl: Int?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      besondereMerkmale: String?,
      bemerkung: String?,
      material: List<Material>?,
      nummernangabe: List<Nummernangabe>?,
      herstellungsinformation: Herstellungsinformation?,
      neuwert: Geldbetrag?,
      laenge: Ausmass?,
      breite: Ausmass?,
      hoehe: Ausmass?,
      volumen: Volumen?,
      gewicht: Gewicht?,
      farbangabe: List<Farbangabe>?,
      dokument: List<Dokument>?,
      zeitwert: Geldbetrag?,
      faelschung: Faelschung?,
      redundanzinformation: Redundanzinformation?,
      asservat: Asservat?,
      durchmesser: Ausmass?,
      sachgebundenerHinweis: List<String>?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.modell = modell
    this.stueckzahl = stueckzahl
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.besondereMerkmale = besondereMerkmale
    this.bemerkung = bemerkung
    this.material = material
    this.nummernangabe = nummernangabe
    this.herstellungsinformation = herstellungsinformation
    this.neuwert = neuwert
    this.laenge = laenge
    this.breite = breite
    this.hoehe = hoehe
    this.volumen = volumen
    this.gewicht = gewicht
    this.farbangabe = farbangabe
    this.dokument = dokument
    this.zeitwert = zeitwert
    this.faelschung = faelschung
    this.redundanzinformation = redundanzinformation
    this.asservat = asservat
    this.durchmesser = durchmesser
    this.sachgebundenerHinweis = sachgebundenerHinweis
  }
}
