package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angaben zu Bankkontoinformationen.
 *  
 * Ist die Bank Gegenstand polizeilicher Ermittlungen, wird diese im Fachobjekt Organisation
 * abgebildet.
 */
@Serializable
public open class Bankkontoinformation() {
  /**
   * Hier wird die Kontonummer abgebildet.
   *  
   * Bankkonten in Deutschland erhalten in der Regel eine innerhalb des jeweils kontoführenden
   * Kreditinstituts eindeutige Nummer, deren interne Strukturierung je nach Kreditinstitut abweichend
   * sein kann. Für den Zahlungsverkehr innerhalb Deutschlands sind 10-stellige Kontonummern, die aus
   * Dezimalziffern bestehen, vorgesehen. Werden bankintern kürzere Kontonummern verwendet, können
   * diese mit führenden Nullen versehen werden. Das Kreditinstitut wird im inländischen
   * Zahlungsverkehr durch eine eindeutige Bankleitzahl identifiziert (siehe Attribut Bankleitzahl).
   *
   * Im europäischen Ausland ist die Länge von Kontonummern unterschiedlich.
   * Beispiele: Österreich: bis zu 11 Stellen, Schweiz: bis zu 16 Stellen, Frankreich: 11 Stellen
   * (auch Buchstaben möglich).
   *  
   * Es ist zu erwarten, dass - unter anderem durch die Umsetzung des einheitlichen europäischen
   * Zahlungsraums SEPA (Single Europoean Payment Area) - die International Bank Account Number (IBAN)
   * mittel- bis langfristig die Angabe der herkömmlichen Kontonummern im Zahlungsverkehr ersetzen wird
   * (siehe Attribut IBAN).
   *  
   * Beispiel: 34132272
   */
  public var kontonummer: String? = null

  /**
   * Die Bankleitzahl identifiziert in Deutschland eindeutig ein Kreditinstitut. Das Attribut
   * Bankleitzahl des Fachobjekts Konto gibt somit eindeutig das kontoführende Kreditinstituts
   * innerhalb Deutschlands an. In den meisten europäischen Ländern existieren ähnliche
   * Identifizierungsnummern für kontoführende Kreditinstitute, die aber einen abweichenden Aufbau
   * haben können. Zur international eindeutigen Identifizierung einer Bank (nach § 1 KredWG:
   * Kreditinstitut) dient der BIC (Bank Identifier Code), siehe Attribut BIC.
   *  
   * In Deutschland besteht die Bankleitzahl aus 8 Dezimalziffern (wobei die ersten drei Ziffern den
   * Bankplatz der Bundesbank angeben, z. B. 701 - München).
   *  
   * Beispiele:
   * - Sparkasse Werra-Meissner: 522 500 30
   * - Commerzbank, Filiale Wiesbaden: 51040038
   */
  public var bankleitzahl: String? = null

  /**
   * Hier wird die IBAN (International Bank Account Number) des Bankkontos abgebildet.
   * Die International Bank Account Number ist eine internationale, standardisierte Notation für
   * Bankkontonummern. Die Notation wird durch die ISO-Norm 13616:2003 beschrieben.
   *  
   * Die IBAN setzt sich folgendermaßen zusammen:
   *  
   * 1. 2-stelliger Ländercode gemäß ISO 3166-1 (bestehend aus Buchstaben)
   * 2. 2-stellige Prüfziffer gemäß ISO 7064 (bestehend aus Ziffern)
   * 3. max. 30-stellige Kontoidentifikation (bestehend aus Buchstaben und / oder Ziffern)
   *  
   * Zur besseren Lesbarkeit werden die Zeichen der IBAN in papierbasierten Vorgängen,
   * beispielsweise beim Ausdruck von Kontoauszügen oder bei der Darstellung der Bankverbindung auf
   * Rechnungen, in Vierergruppen unterteilt notiert. Für elektronische Vorgänge ist eine Trennung der
   * Zeichen nach ISO 13616:2003 nicht zulässig.
   *  
   * Die IBAN kann maximal 34 Stellen umfassen. Eine deutsche IBAN hat beispielsweise immer exakt 22
   * Stellen (Schweiz 21 Stellen, Österreich 20 Stellen). Aufbau der deutschen IBAN:
   *  
   * DEpp bbbb bbbb kkkk kkkk kk
   *  
   * Dabei bedeutet:
   *  
   * DE - Länderkennzeichen für Deutschland
   * pp - zweistellige Prüfziffer
   * bbbbbbbb - die 8-stellige deutsche Bankleitzahl
   * kkkkkkkkkk - die 10-stellige Kontonummer
   *  
   * Beispiel: DE68210501700012345678
   */
  public var iBAN: String? = null

  /**
   * Hier wird der Bank-Identifier-Code (BIC) des Kreditinstituts abgebildet.
   *  
   * Der SWIFT-BIC (SWIFT ist die Abkürzung für Society for Worldwide Interbank Financial
   * Telecommunication; BIC ist die Abkürzung für Bank Identifier Code) wird umgangssprachlich auch
   * BIC-Code oder SWIFT-Code genannt, korrekt wären aber SWIFT-Adresse oder BIC.
   *  
   * Es handelt sich um einen nach ISO 9362 international standardisierten Code, mit dem weltweit
   * jeder direkt oder indirekt teilnehmende Partner eindeutig identifiziert werden kann. Er findet
   * weltweit Verwendung bei Kreditinstituten, Brokern, Lagerstellen und Unternehmen.
   *  
   * Der BIC oder SWIFT-Code hat eine Länge von 8 oder 11 alphanumerischen Zeichen und folgenden
   * Aufbau:
   *  
   * Beispiel: BBBBCCLLbbb
   *  
   * BBBB - 4-stelliger Bankcode, vom Geldinstitut frei wählbar (nur alphanumerische Zeichen)
   * CC - 2-stelliger Ländercode nach ISO 3166-1 (nur alphanumerische Zeichen)
   * LL - 2-stellige Codierung des Ortes (alphanumerische Zeichen; wenn das zweite Zeichen eine 1
   * ist, so handelt es sich um einen passiven SWIFT-Teilnehmer; wenn das zweite Zeichen eine 0 ist, so
   * handelt es sich um einen Test-BIC)
   * bbb - 3-stellige Kennzeichnung (Branch-Code) der Filiale oder Abteilung (optional, Standard:
   * 'XXX', kann weggelassen werden, andere Kennzeichen nicht; alphanumerische Zeichen)
   *  
   * Beispiele:
   * - Der SWIFT-BIC RZTIAT22263 ist der Raiffeisenbank Kitzbühel (Bankleitzahl: 36263) in
   * Österreich zugeordnet.
   * - Der SWIFT-BIC BCEELULL ist der Banque et Caisse d'Epargne de l'Etat in Luxemburg zugeordnet.
   * - Der SWIFT-BIC MARKDEFF (oder auch MARKDEFFXXX) ist der Zentrale der Deutschen (DE) Bundesbank
   * (MARK) in Frankfurt am Main (FF) zugeordnet.
   * - Der SWIFT-BIC GENODEF1JEV ist der Volksbank Jever zugeordnet. Sie befindet sich im deutschen
   * (DE) Verbund der Genossenschaftsbanken (GENO) und ist passive SWIFT-Teilnehmerin (1), also ohne
   * direkte Verbindung zum SWIFT-System.
   */
  public var bIC: String? = null

  /**
   * Hier wird der Name des Kreditinstitus und ggf. der Niederlassungsstelle, bei der das Konto
   * geführt wird, abgebildet.
   *  
   * Beispiel: Commerzbank, Filiale Wiesbaden, Wilhelmstr. 44-46
   *  
   * Bei Zahlungskarten ist der Name, wie auf der Karte angegeben, einzutragen.
   */
  public var bankname: String? = null

  /**
   * Hier wird die Ortsbezeichnung der Filiale erfasst.
   *
   * Beispiele: Hamburg, Berlin-Spandau
   */
  public var bankstandort: String? = null

  /**
   * Hier wird das Land / Gebiet erfasst, in dem sich die Filiale befindet.
   *
   * Beispiele: Luxemburg, Schweiz
   */
  public var staat: KatalogCode285_NichtAbgeschlossen? = null

  public constructor(
    kontonummer: String?,
    bankleitzahl: String?,
    iBAN: String?,
    bIC: String?,
    bankname: String?,
    bankstandort: String?,
    staat: KatalogCode285_NichtAbgeschlossen?
  ) : this() {
    this.kontonummer = kontonummer
    this.bankleitzahl = bankleitzahl
    this.iBAN = iBAN
    this.bIC = bIC
    this.bankname = bankname
    this.bankstandort = bankstandort
    this.staat = staat
  }
}
