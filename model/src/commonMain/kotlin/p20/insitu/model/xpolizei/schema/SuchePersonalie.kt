package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SuchePersonalie() : SucheAllgemeineBasisklasse() {
  public var art: CIMPSucheKatalogWert? = null

  public var fuehrungspersonalie: CIMPSucheKatalogWert? = null

  public var geschlecht: CIMPSucheKatalogWert? = null

  public var geburtsort: CIMPSucheString? = null

  public var geburtskreis: CIMPSucheString? = null

  public var geburtsregion: CIMPSucheString? = null

  public var geburtsstaat: CIMPSucheKatalogWert? = null

  public var staatsangehoerigkeit: List<SucheStaatsangehoerigkeit>? = null

  public var familienstand: CIMPSucheKatalogWert? = null

  public var volkszugehoerigkeit: CIMPSucheKatalogWert? = null

  public var nationalerSchulabschluss: CIMPSucheKatalogWert? = null

  public var internationalerSchulabschluss: List<CIMPSucheString>? = null

  public var erlernterBeruf: List<CIMPSucheString>? = null

  public var titel: List<CIMPSucheKatalogWert>? = null

  public var besondereFaehigkeiten: CIMPSucheString? = null

  public var oFW: CIMPSucheKatalogWert? = null

  public var personengebundenerHinweis: List<CIMPSucheKatalogWert>? = null

  public var aufenthaltsrechtlicherStatus: CIMPSucheString? = null

  public var erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var geburtsdatum: CIMPSucheDatum? = null

  public var sterbedatum: SucheDatumZeit? = null

  public var familienstandSeit: CIMPSucheDatum? = null

  public var dokument: List<SucheDokument>? = null

  public var religionszugehoerigkeit: List<SucheReligionszugehoerigkeit>? = null

  public var vorname: SucheNamensangabe? = null

  public var familienname: SucheNamensangabe? = null

  public var geburtsname: SucheNamensangabe? = null

  public var deckname: List<SucheNamensangabe>? = null

  public var fruehererName: List<SucheNamensangabe>? = null

  public var genanntname: List<SucheNamensangabe>? = null

  public var geschiedenenname: List<SucheNamensangabe>? = null

  public var kuenstlername: List<SucheNamensangabe>? = null

  public var ordensname: List<SucheNamensangabe>? = null

  public var rufname: SucheNamensangabe? = null

  public var spitzname: List<SucheNamensangabe>? = null

  public var vatersname: SucheNamensangabe? = null

  public var verwitwetenname: List<SucheNamensangabe>? = null

  public var nichtZuordenbarerName: List<SucheNamensangabe>? = null

  public var personenidentifikationsnummer: List<SuchePersonenidentifikationsnummer>? = null

  public var ermittlungsunterstuetzenderHinweis: List<SucheErmittlungsunterstuetzenderHinweis>? =
      null

  public var muttername: SucheNamensangabe? = null

  public var aufenthalt: List<SucheAufenthalt>? = null

  public var bSIHashwert: CIMPSucheString? = null

  public var fankategorie: CIMPSucheKatalogWert? = null

  public var stadionverbot: List<SucheStadionverbot>? = null

  public var alleNamen: SucheNamensangabe? = null

  public var gekreuzteNamen: CIMPSucheGekreuzteNamen? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      fuehrungspersonalie: CIMPSucheKatalogWert?,
      geschlecht: CIMPSucheKatalogWert?,
      geburtsort: CIMPSucheString?,
      geburtskreis: CIMPSucheString?,
      geburtsregion: CIMPSucheString?,
      geburtsstaat: CIMPSucheKatalogWert?,
      staatsangehoerigkeit: List<SucheStaatsangehoerigkeit>?,
      familienstand: CIMPSucheKatalogWert?,
      volkszugehoerigkeit: CIMPSucheKatalogWert?,
      nationalerSchulabschluss: CIMPSucheKatalogWert?,
      internationalerSchulabschluss: List<CIMPSucheString>?,
      erlernterBeruf: List<CIMPSucheString>?,
      titel: List<CIMPSucheKatalogWert>?,
      besondereFaehigkeiten: CIMPSucheString?,
      oFW: CIMPSucheKatalogWert?,
      personengebundenerHinweis: List<CIMPSucheKatalogWert>?,
      aufenthaltsrechtlicherStatus: CIMPSucheString?,
      erkenntnisseAusVerdeckterMassnahme: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      geburtsdatum: CIMPSucheDatum?,
      sterbedatum: SucheDatumZeit?,
      familienstandSeit: CIMPSucheDatum?,
      dokument: List<SucheDokument>?,
      religionszugehoerigkeit: List<SucheReligionszugehoerigkeit>?,
      vorname: SucheNamensangabe?,
      familienname: SucheNamensangabe?,
      geburtsname: SucheNamensangabe?,
      deckname: List<SucheNamensangabe>?,
      fruehererName: List<SucheNamensangabe>?,
      genanntname: List<SucheNamensangabe>?,
      geschiedenenname: List<SucheNamensangabe>?,
      kuenstlername: List<SucheNamensangabe>?,
      ordensname: List<SucheNamensangabe>?,
      rufname: SucheNamensangabe?,
      spitzname: List<SucheNamensangabe>?,
      vatersname: SucheNamensangabe?,
      verwitwetenname: List<SucheNamensangabe>?,
      nichtZuordenbarerName: List<SucheNamensangabe>?,
      personenidentifikationsnummer: List<SuchePersonenidentifikationsnummer>?,
      ermittlungsunterstuetzenderHinweis: List<SucheErmittlungsunterstuetzenderHinweis>?,
      muttername: SucheNamensangabe?,
      aufenthalt: List<SucheAufenthalt>?,
      bSIHashwert: CIMPSucheString?,
      fankategorie: CIMPSucheKatalogWert?,
      stadionverbot: List<SucheStadionverbot>?,
      alleNamen: SucheNamensangabe?,
      gekreuzteNamen: CIMPSucheGekreuzteNamen?
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
    this.alleNamen = alleNamen
    this.gekreuzteNamen = gekreuzteNamen
  }
}
