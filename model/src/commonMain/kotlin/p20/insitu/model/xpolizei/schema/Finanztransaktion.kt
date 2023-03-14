package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * In dem Fachobjekt werden Transaktionen im Zahlungsverkehr (bar oder unbar) und sonstige
 * Geldbewegungen (zum Beispiel bare Ein- oder Auszahlungen auf Bankkonten, Bargeldübergaben zwischen
 * zwei natürlichen Personen) abgebildet.
 */
@Serializable
public open class Finanztransaktion() : Finanztransaktion_Leer() {
  /**
   * Art der Finanztransaktion.
   *  
   * Beispiele: Geldtransfer, Einzahlung, Abhebung, Überweisung
   */
  public var art: KatalogCode106? = null

  /**
   * Gemäß § 1 Kreditwesengesetz werden unter anderem folgende Arten von Bankgeschäften
   * unterschieden:
   *
   * 1. Einlagengeschäft
   * 1a. Pfandbriefgeschäft
   * 2. Kreditgeschäft
   * 3. Diskontgeschäft
   * 4. Finanzkommissionsgeschäft
   * 5. Depotgeschäft
   * 7. die Eingehung der Verpflichtung, zuvor veräußerte Darlehensforderung vor Fälligkeit
   * zurückzuerwerben
   * 8. Garantiegeschäft
   * 9. Girogeschäft
   * 10. Emissionsgeschäft
   * 11. E-Geld-Geschäft
   * 12. die Tätigkeit als zentraler Kontrahent im Sinne von Absatz 31
   *  
   * Für das Informationsmodell relevant sind vor allem das Girogeschäft (Zahlungsverkehr), das
   * Einlagengeschäft (Ein- und Auszahlungen auf eigene Konten) und das Diskontgeschäft (Ankauf von
   * Wechseln und Schecks).
   */
  public var geschaeftsart: String? = null

  /**
   * Freitextliche Erfassung des Verwendungszwecks wie zum Beispiel auf einem Überweisungsträger
   * angegeben. Der Verwendungszweck enthält oftmals Referenzen wie Rechnungs-, Vertrags- und
   * Kundennummern.
   *  
   * Beispiele:
   * - Mietzahlung August 2009
   * - Rechnungsnummer 2009/1234
   */
  public var verwendungszweck: String? = null

  /**
   * Das Feld Restbuchungstext wird benötigt, um Informationen abzubilden, die nicht eindeutig dem
   * Verwendungszweck zugeordnet werden können.
   *  
   * Beispiele:
   * - TAN-Nummern bei Überweisungen über Internet
   * - Geldautomatendaten: Nummer, Ort, Zeitpunkt der Zahlung
   * - Geschäftsstelle der Bank
   * - Adresse des Empfängers
   */
  public var restbuchungstext: String? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Datum, an dem eine Finanztransaktion gebucht wurde. Das Datum, an dem der Buchungsbetrag dem
   * Quellkonto belastet oder dem Zielkonto gutgeschrieben wurde. 
   */
  public var buchungsdatum: DatumZeit? = null

  /**
   * Saldo des Ausgangskontos nach vollständigem Abschluss der Transaktion in der Währung, in der
   * das Ausgangskonto geführt wird.
   *
   * Beispiel:
   *
   * Überweisung von 100 GBP von einem Konto, das bei einer Bank in London geführt wird auf ein
   * Euro-Konto in Deutschland. Der Saldo des Ausgangskontos nach der Transaktion beträgt 3230 GBP. Der
   * Saldo des Zielkontos beträgt nach der Transaktion 2037,45 EUR. 
   */
  public var saldoQuellkonto: Geldbetrag? = null

  /**
   * Saldo des Zielkontos nach vollständigem Abschluss der Transaktion in der Währung, in der das
   * Konto geführt wird.
   *
   * Beispiel:
   *
   * Überweisung von 100 GBP von einem Konto, das bei einer Bank in London geführt wird auf ein
   * Euro-Konto in Deutschland. Der Saldo des Ausgangskontos nach der Transaktion beträgt 3230 GBP. Der
   * Saldo des Zielkontos beträgt nach der Transaktion 2037,45 EUR. 
   */
  public var saldoZielkonto: Geldbetrag? = null

  /**
   * Betrag der Finanztransaktion in der Währung des Ausgangs- oder Zielkontos.
   * Bei Überweisungen in einen anderen Währungsraum (z. B. GBP nach EUR) kann die Angabe in GBP
   * oder EUR erfolgen und entspricht entweder dem Betrag in GBP der dem GBP-Konto belastet wurde, oder
   * dem Betrag in EUR, der dem EUR-Konto gutgeschrieben wurde.
   *
   * Beispiel:
   * Überweisung von 100 GBP auf ein in EUR geführtes Konto.
   * Dem GBP-Konto wurden 100 GBP belastet, dem EUR-Konto wurden 116 EUR gutgeschrieben. Der
   * Buchungsbetrag kann als 100 GBP oder 116 EUR angegeben werden. 
   */
  public var transaktionsbetrag: Geldbetrag? = null

  /**
   * Das Valuta-Datum wird auch als Wertstellungsdatum bezeichnet.
   *
   * Das Datum, an dem eine Gutschrift zinswirksam wird. Das Valutadatum kann vom Buchungsdatum
   * abweichen. 
   */
  public var valutadatum: DatumZeit? = null

  /**
   * Datum der Finanztransaktion.
   *
   * Beispiel:
   * Transaktionsart ist Auszahlung / Barabhebung an einem Geldautomaten, das Transaktionsdatum ist
   * dann das Datum des Tages, an dem die Auszahlung stattgefunden hat (zum Beispiel auch ein Sonn-
   * oder Feiertag). Die Verbuchung der Auszahlung erfolgt in der Regel erst am ersten folgenden
   * Werktag. Transaktions- und Buchungsdatum sind unterschiedlich. 
   */
  public var transaktionsdatum: DatumZeit? = null

  public var dokument: List<Dokument>? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Der Purpose Code entspricht dem aus dem DTA-Verfahren bereits bekannten Textschlüssel und
   * stellt die 'Art der Zahlung' in kodierter Form dar. Überweisungen und Lastschriften können anhand
   * des Purpose Code identifiziert und automatisiert klassifiziert bzw. zugeordnet werden.
   * Zahlungspflichtiger und -empfänger sowie die an der Zahlungsabwicklung beteiligten
   * Zahlungsdienstleister können anhand eines Purpose Code Zahlungen (z. B. Gehaltszahlungen)
   * automatisiert identifizieren und beispielsweise die Information zur automatisierten Berechnung von
   * Kontoführungsentgelten oder Einräumung von Dispositionskrediten nutzen.
   * Für die SEPA-Überweisung werden für die Kennzeichnung der Überweisungsart vierstellige
   * Alpha-Codes verwendet.
   */
  public var sEPAPurposeCode: KatalogCode310? = null

  /**
   * Angabe einer Identifizierungsnummer, welche die Transaktion eindeutig zuordenbar macht.
   *
   * Beispiel:
   * Bei Bitcoin entspricht diese der Blockchain, d. h. dem digital signierten Datensatz.
   */
  public var transaktionsID: String? = null

  public constructor(
      art: KatalogCode106?,
      geschaeftsart: String?,
      verwendungszweck: String?,
      restbuchungstext: String?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      buchungsdatum: DatumZeit?,
      saldoQuellkonto: Geldbetrag?,
      saldoZielkonto: Geldbetrag?,
      transaktionsbetrag: Geldbetrag?,
      valutadatum: DatumZeit?,
      transaktionsdatum: DatumZeit?,
      dokument: List<Dokument>?,
      redundanzinformation: Redundanzinformation?,
      sEPAPurposeCode: KatalogCode310?,
      transaktionsID: String?
  ) : this() {
    this.art = art
    this.geschaeftsart = geschaeftsart
    this.verwendungszweck = verwendungszweck
    this.restbuchungstext = restbuchungstext
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.buchungsdatum = buchungsdatum
    this.saldoQuellkonto = saldoQuellkonto
    this.saldoZielkonto = saldoZielkonto
    this.transaktionsbetrag = transaktionsbetrag
    this.valutadatum = valutadatum
    this.transaktionsdatum = transaktionsdatum
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.sEPAPurposeCode = sEPAPurposeCode
    this.transaktionsID = transaktionsID
  }
}
