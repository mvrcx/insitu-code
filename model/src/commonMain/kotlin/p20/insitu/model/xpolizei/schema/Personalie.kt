package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Dieses Fachobjekt enthält Angaben zur Personalie.
 */
@Serializable
public open class Personalie() : Personalie_Leer() {
  /**
   * Dieses Feld enthält Angaben zur Personalienart.
   *
   * Beispiel: Alias-Personalie, rechtmäßige Personalie
   */
  public var art: KatalogCode117? = null

  /**
   * Personalie, unter der die Personalien von beispielsweise Beschuldigten oder bereits
   * verurteilten Tätern in polizeilichen Systemen geführt wird.
   *
   * Beispiel: Einem Tatverdächtigen können mehrere Aliaspersonalien zugeordnet werden. Unter einer
   * dieser Personalien (der Führungspersonalie) wird der Tatvärdächtige in polizeiichen Systemen
   * geführt.
   */
  public var fuehrungspersonalie: KatalogCode217? = null

  /**
   * Angabe des Geschlechtes einer Person.
   *  
   * Beispiele: männlich, weiblich, unbekannt
   */
  public var geschlecht: KatalogCode255? = null

  /**
   * Angabe des Namens des Geburtsortes.
   */
  public var geburtsort: String? = null

  /**
   * Angaben zum Geburtskreis der Person.
   *  
   * Beispiele: Kreis xyz
   */
  public var geburtskreis: String? = null

  /**
   * Region im Sinne eines geographischen Gebietes ist ein zunächst unspezifischer Raumbegriff, der
   * erst durch einen intentional hergestellten Kontext konkretisiert und damit begreifbar wird.
   *
   * Beispiele: Sauerland, Taunus, Thüringer Toskana, blaue Adria
   */
  public var geburtsregion: String? = null

  /**
   * Angaben zum Geburtsland / -gebiet der Person.
   *  
   * Beispiele: Deutschland, Frankreich
   */
  public var geburtsstaat: KatalogCode285_NichtAbgeschlossen? = null

  /**
   * Dieses Feld enthält Angaben über die Staatsangehörigkeiten der Person.
   *  
   * Beispiele: Deutschland, Türkei
   */
  public var staatsangehoerigkeit: List<Staatsangehoerigkeit>? = null

  /**
   * Angaben über den Familienstand der Person.
   *  
   * Beispiele: ledig, verheiratet
   *  
   * Von polizeilichem Interesse ist lediglich der letzte Familienstand der Personalie.
   */
  public var familienstand: KatalogCode254? = null

  /**
   * Angaben über die Volkszugehörigkeit der Personalie.
   *  
   * Beispiele: Baske, Este, Südtiroler
   */
  public var volkszugehoerigkeit: KatalogCode251_NichtAbgeschlossen? = null

  /**
   * Angaben über einen deutschen Schulabschluss.
   *
   * Beispiele: Abitur, Hauptschulabschluss
   *  
   * Es wird nur der höchste erreichte Schulabschluss angegeben.
   *  
   * Die Einbindung als unscharfe Codeliste ermöglicht die freitextliche Spezifizierung von
   * Schulabschlüssen.
   */
  public var nationalerSchulabschluss: KatalogCode258_MitZusatz? = null

  /**
   * Angaben über einen nicht deutschen Schulabschluss.
   */
  public var internationalerSchulabschluss: List<String>? = null

  /**
   * Angaben über den oder die erlernten Beruf(e) einer Person.
   *  
   * Beispiele: Maurer, Dachdecker, Verwaltungswirt
   */
  public var erlernterBeruf: List<String>? = null

  /**
   * Angaben über den akademischen Grad.
   *  
   * Beispiele: Diplom, Doktor
   */
  public var titel: List<KatalogCode252_MitZusatz_NichtAbgeschlossen>? = null

  /**
   * Bezeichnung eines herausragenden Könnens, das entweder über die bei einer Tätigkeit oder
   * Ausbildung erworbenen Kenntnisse hinausragt, oder außerhalb einer Tätigkeit oder Ausbildung
   * erworben wurde.
   *  
   * Alle Fähigkeiten werden in ein Feld eingetragen.
   *  
   * Beispiele: musikalisch begabt, schneller Läufer, Schlangenmensch, guter Kletterer, Fertigkeiten
   * in der Herstellung oder im Umgang mit Sprengstoffen und Waffen.
   */
  public var besondereFaehigkeiten: String? = null

  /**
   * Hier wird die Information, dass eine Person keinen festen Wohnsitz hat, abgelegt.
   */
  public var oFW: KatalogCode217? = null

  /**
   * Angaben zu bestimmten Hinweisen zur Gefährlichkeit einer Person.
   *
   * Beispiele: gewalttätig, bewaffnet, BtM-Konsument, Ansteckungsgefahr.
   */
  public var personengebundenerHinweis: List<KatalogCode256>? = null

  /**
   * Analog zu XAuslaender 1.0 wird im Fachobjekt Personalie ein neues alphanumerisches, optionales
   * Attribut 'AufenthaltsrechtlicherStatus' aufgenommen.
   *  
   * Beispiele:
   * - Ausbildung
   * - besondere Aufenthaltsrechte
   * - Erwerbstätigkeit
   * - familiäre Gründe
   * - Humanitäre, völkerrechtliche, politische Gründe
   * - Integration
   * - Sonstige
   */
  public var aufenthaltsrechtlicherStatus: String? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Dieses Feld enthält freitextliche Angaben zur Personalie, die über die vorhandenen Attribute
   * hinausgehen.
   */
  public var bemerkung: String? = null

  /**
   * Angabe des Geburtsdatums einer Personalie.
   */
  public var geburtsdatum: String? = null

  /**
   * Angabe des Todeszeitpunktes.
   */
  public var sterbedatum: DatumZeit? = null

  /**
   * Angaben zum Familienstand einer Personalie. 
   */
  public var familienstandSeit: String? = null

  public var dokument: List<Dokument>? = null

  public var religionszugehoerigkeit: List<Religionszugehoerigkeit>? = null

  /**
   * Alle Vornamen, die Bestandteil einer Personalie sind. Es werden alle Vornamen hintereinander
   * eingetragen.
   *
   * Beispiel: Heinz Dieter Isabell 
   */
  public var vorname: Namensangabe? = null

  /**
   * Angabe des oder der Familiennamen. Es werden alle Familiennamen inkl. Namensbestandteile
   * hintereinander eingetragen.
   *
   * Beispiele: Mustermann 
   */
  public var familienname: Namensangabe? = null

  /**
   * Geburtsname der Person. Es werden alle Geburtsnamen inkl. der Namensbestandteile hintereinander
   * eingetragen.
   *
   * Beispiele: Freifrau von und zu Musterfrau 
   */
  public var geburtsname: Namensangabe? = null

  /**
   * Name, der zur Verschleierung der Identität einer Person dient.
   */
  public var deckname: List<Namensangabe>? = null

  /**
   * Der Familienname, den eine Person früher, zum Beispiel während einer Vorehe, geführt hat, und
   * auf den sie bei einer Namensänderung zurückgreifen kann; frühere Namen sind bei der Beurteilung
   * von Namenserklärungen von Bedeutung. 
   */
  public var fruehererName: List<Namensangabe>? = null

  /**
   * Genanntname der Person.
   */
  public var genanntname: List<Namensangabe>? = null

  /**
   * Vor der Scheidung geführter Familienname.
   *
   * Beispiel: Kaiser, geschiedene Müller
   */
  public var geschiedenenname: List<Namensangabe>? = null

  /**
   * Künstlername der Person.
   */
  public var kuenstlername: List<Namensangabe>? = null

  /**
   * Der Ordensname ist der beim Eintritt in eine religiöse Gemeinschaft (Ordensgemeinschaft)
   * angenommene Name, der im Orden an die Stelle des bürgerlichen Namens tritt.
   */
  public var ordensname: List<Namensangabe>? = null

  /**
   * Bei Verwendung mehrerer Vornamen wird der Vorname, mit dem die Person hauptsächlich angeredet
   * (gerufen) wird, als Rufname bezeichnet.
   */
  public var rufname: Namensangabe? = null

  /**
   * Spitzname der Person.
   */
  public var spitzname: List<Namensangabe>? = null

  /**
   * Namensbestandteil, der einen Namen des Vaters des Namensträgers beinhaltet und ggf. mit einem
   * Zusatz gebildet wird.
   */
  public var vatersname: Namensangabe? = null

  /**
   * Vor dem Tod des Ehepartners geführter Familienname.
   *
   * Beispiel: Kaiser, verwitwete Müller
   */
  public var verwitwetenname: List<Namensangabe>? = null

  /**
   * Name, der nicht zweifelsfrei einer anderen Namensart zugeordnet werden kann.
   */
  public var nichtZuordenbarerName: List<Namensangabe>? = null

  public var personenidentifikationsnummer: List<Personenidentifikationsnummer>? = null

  public var ermittlungsunterstuetzenderHinweis: List<ErmittlungsunterstuetzenderHinweis>? = null

  /**
   * Namensbestandteil, der einen Namen der Mutter des Namensträgers beinhaltet und ggf. mit einem
   * Zusatz gebildet wird.
   */
  public var muttername: Namensangabe? = null

  public var aufenthalt: List<Aufenthalt>? = null

  /**
   * Der BSI-Hashwert ist das Ergebnis der mit einer Hashfunktion berechneten Informationen einer
   * Personalie wie Vorname, Nachname, Geburtsdatum etc., welcher die personenbezogenen Daten dieser
   * Person anonymisiert.
   */
  public var bSIHashwert: String? = null

  /**
   * Einordnung von Sportfans durch die Polizei in Kategorien, die auf Festlegungen der
   * Arbeitsgemeinschaft "Sport und Sicherheit" basieren.
   */
  public var fankategorie: KatalogCode413? = null

  /**
   * Angabe, ob ein Stadionverbot gegen eine Person ausgesprochen wurde.
   */
  public var stadionverbot: List<Stadionverbot>? = null

  public constructor(
      art: KatalogCode117?,
      fuehrungspersonalie: KatalogCode217?,
      geschlecht: KatalogCode255?,
      geburtsort: String?,
      geburtskreis: String?,
      geburtsregion: String?,
      geburtsstaat: KatalogCode285_NichtAbgeschlossen?,
      staatsangehoerigkeit: List<Staatsangehoerigkeit>?,
      familienstand: KatalogCode254?,
      volkszugehoerigkeit: KatalogCode251_NichtAbgeschlossen?,
      nationalerSchulabschluss: KatalogCode258_MitZusatz?,
      internationalerSchulabschluss: List<String>?,
      erlernterBeruf: List<String>?,
      titel: List<KatalogCode252_MitZusatz_NichtAbgeschlossen>?,
      besondereFaehigkeiten: String?,
      oFW: KatalogCode217?,
      personengebundenerHinweis: List<KatalogCode256>?,
      aufenthaltsrechtlicherStatus: String?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      bemerkung: String?,
      geburtsdatum: String?,
      sterbedatum: DatumZeit?,
      familienstandSeit: String?,
      dokument: List<Dokument>?,
      religionszugehoerigkeit: List<Religionszugehoerigkeit>?,
      vorname: Namensangabe?,
      familienname: Namensangabe?,
      geburtsname: Namensangabe?,
      deckname: List<Namensangabe>?,
      fruehererName: List<Namensangabe>?,
      genanntname: List<Namensangabe>?,
      geschiedenenname: List<Namensangabe>?,
      kuenstlername: List<Namensangabe>?,
      ordensname: List<Namensangabe>?,
      rufname: Namensangabe?,
      spitzname: List<Namensangabe>?,
      vatersname: Namensangabe?,
      verwitwetenname: List<Namensangabe>?,
      nichtZuordenbarerName: List<Namensangabe>?,
      personenidentifikationsnummer: List<Personenidentifikationsnummer>?,
      ermittlungsunterstuetzenderHinweis: List<ErmittlungsunterstuetzenderHinweis>?,
      muttername: Namensangabe?,
      aufenthalt: List<Aufenthalt>?,
      bSIHashwert: String?,
      fankategorie: KatalogCode413?,
      stadionverbot: List<Stadionverbot>?
  ) : this() {
    this.art = art
    this.fuehrungspersonalie = fuehrungspersonalie
    this.geschlecht = geschlecht
    this.geburtsort = geburtsort
    this.geburtskreis = geburtskreis
    this.geburtsregion = geburtsregion
    this.geburtsstaat = geburtsstaat
    this.staatsangehoerigkeit = staatsangehoerigkeit
    this.familienstand = familienstand
    this.volkszugehoerigkeit = volkszugehoerigkeit
    this.nationalerSchulabschluss = nationalerSchulabschluss
    this.internationalerSchulabschluss = internationalerSchulabschluss
    this.erlernterBeruf = erlernterBeruf
    this.titel = titel
    this.besondereFaehigkeiten = besondereFaehigkeiten
    this.oFW = oFW
    this.personengebundenerHinweis = personengebundenerHinweis
    this.aufenthaltsrechtlicherStatus = aufenthaltsrechtlicherStatus
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.geburtsdatum = geburtsdatum
    this.sterbedatum = sterbedatum
    this.familienstandSeit = familienstandSeit
    this.dokument = dokument
    this.religionszugehoerigkeit = religionszugehoerigkeit
    this.vorname = vorname
    this.familienname = familienname
    this.geburtsname = geburtsname
    this.deckname = deckname
    this.fruehererName = fruehererName
    this.genanntname = genanntname
    this.geschiedenenname = geschiedenenname
    this.kuenstlername = kuenstlername
    this.ordensname = ordensname
    this.rufname = rufname
    this.spitzname = spitzname
    this.vatersname = vatersname
    this.verwitwetenname = verwitwetenname
    this.nichtZuordenbarerName = nichtZuordenbarerName
    this.personenidentifikationsnummer = personenidentifikationsnummer
    this.ermittlungsunterstuetzenderHinweis = ermittlungsunterstuetzenderHinweis
    this.muttername = muttername
    this.aufenthalt = aufenthalt
    this.bSIHashwert = bSIHashwert
    this.fankategorie = fankategorie
    this.stadionverbot = stadionverbot
  }
}
