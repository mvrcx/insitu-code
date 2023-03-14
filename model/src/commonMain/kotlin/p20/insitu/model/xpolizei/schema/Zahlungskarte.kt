package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Als Zahlungskarten gelten:
 *
 * - Kreditkarten (z. B. VISA, Mastercard, American Express)
 * - Debitkarten (z. B. Maestro, EC-Karte)
 * - Tank- oder Kundenkarten mit Zahlungsfunktion
 * - Geldkarte (in Deutschland in der Regel mit einer Debitkarte kombiniert)
 *  
 * Die früher häufigen Eurocheque-Karten wurden nach 2002 durch Debitkarten ersetzt.
 */
@Serializable
public open class Zahlungskarte() : Zahlungskarte_Leer() {
  /**
   * Art der Zahlungskarte.
   *  
   * Folgende Arten sind zu unterscheiden:
   *  
   * - Kreditkarte
   * - Debitkarte / Scheckkarte
   * - sonstige Zahlungskarte
   */
  public var art: KatalogCode125? = null

  /**
   * Angabe, ob es sich um eine Totalfälschung, White Plastic oder eine Verfälschung handelt.
   */
  public var faelschungsart: KatalogCode283? = null

  /**
   * Ausgebende Institution der Zahlungskarte.
   * Kreditkarten werden in Deutschland üblicherweise von Banken oder Service-Gesellschaften (z. B.
   * Lufthansa AirPlus) und nicht von den Kreditkarten-Dachmarkengesellschaften (VISA, MasterCard)
   * selbst ausgegeben. Debitkarten der Organisation Maestro werden (in Deutschland) ebenfalls
   * überwiegend von Banken ausgegeben und dienen oftmals zusätzlich auch als Kontokarten (d. h. zur
   * Abhebung an Geldautomaten und zum Ausdrucken von Kontoauszügen an dafür vorgesehenen Automaten)
   * sowie als Geldkarten.
   *  
   * Bei Tank- oder Kundenkarten mit Zahlungsfunktion sind auch andere Emittenten als Banken möglich
   * (z. B. Mineralölgesellschaften bei Tankkarten).
   *  
   * Die jeweilige Dachmarke bzw. Kredit- / Debitkartenorganisation wird im
   * AttributDachmarkengesellschaft angegeben.
   *  
   * Aufgrund des Umfangs und der regelmäßigen Änderung eines eventuellen Kataloges wird hier ein
   * alphanumerisches Attribut verwendet.
   */
  public var emittent: String? = null

  /**
   * Dachmarkengesellschaft für Kredit- und Debitkarten.
   *  
   * Beispiele für Kreditkarten: VISA, MasterCard
   * Beispiel für Debitkarten: Maestro
   */
  public var dachmarkengesellschaft: KatalogCode282? = null

  /**
   * Aufgedruckte bzw. eingeprägte Nummer einer Debit- (10-stellig bei Maestro) oder Kreditkarte
   * (16-stellig bei VISA und Master, 15-stellig bei American Express).
   * Bei anderen Zahlungskarten (Tank- oder Kundenkarten) ist ggf. keine Nummer identifizierbar.
   *
   * Beispiele:
   * - 5533 2009 1873 8891
   * - 1020345689
   *
   * Es sind auch alphanumerische Nummern abbildbar.
   */
  public var nummer: String? = null

  /**
   * Dieses Attribut beschreibt die im Magnetstreifen codierte Kartennummer.
   */
  public var nummerCodiert: String? = null

  /**
   * Name des Inhabers, wie auf der Zahlungskarte angegeben.
   *  
   * Beispiel: Hans Mueller
   *  
   * Wenn der Zahlungskarteninhaber als Person von polizeilichem Interesse ist, ist dieser im
   * Fachobjekt Personalie bzw. Personenbeschreibung abzubilden.
   */
  public var name: String? = null

  /**
   * Name des Inhabers, wie im Magnetstreifen der Karte codiert.
   */
  public var nameCodiert: String? = null

  /**
   * Angabe, ob die Karte mit dem Sicherheitsmerkmal Mikroschrift ausgestattet ist.
   */
  public var merkmalMikroschrift: KatalogCode214? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Bemerkungen zur Zahlungskarte.
   *  
   * Angaben zu Besonderheiten der individuellen Karte (Aufdrucke, Beschädigungen).
   *  
   * Beispiel:
   * - Aufdruck: XYZ
   */
  public var bemerkung: String? = null

  /**
   * Ablaufdatum der Zahlungskarte. Auf Kreditkarten in der Regel in der Form Monat/Jahr (jeweils
   * zweistellig) angegeben.
   *
   * Beispiele:
   * - 11/11
   * - 09/09
   * - 10/10
   * - 12/11
   */
  public var gueltigBis: String? = null

  /**
   * Gültigkeitsbeginn einer Zahlungskarte, sofern bekannt. 
   */
  public var gueltigVon: String? = null

  /**
   * Zu einer Zahlungskarte gehörendes Konto.
   *
   * In der Regel ist das zur Zahlungskarte gehörende Konto nur bei Bankkarten (die oftmals auch als
   * Debitkarten eingesetzt werden können) ersichtlich. 
   */
  public var konto: Bankkontoinformation? = null

  /**
   * Abbildung einer Zahlungskarte, um beispielsweise bestimmte Auffälligkeiten festzuhalten. 
   */
  public var dokument: List<Dokument>? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Dieses Feld enthält ggf. freitextliche Angaben zur näheren Beschreibung zur Art der
   * Zahlungskarte.
   *
   * Beispiele: Tankkarte, Telefonkarte
   */
  public var bezeichnung: String? = null

  public var asservat: Asservat? = null

  /**
   * Dieses Feld enthält Angaben zur Anzahl von Zahlungskarten.
   */
  public var stueckzahl: Int? = 0

  /**
   * Angabe des Guthabens der Zahlungskarte.
   */
  public var guthaben: Geldbetrag? = null

  /**
   * Angabe von sachgebundenen Hinweisen zu Zahlungskarten.
   */
  public var sachgebundenerHinweis: List<String>? = null

  public constructor(
      art: KatalogCode125?,
      faelschungsart: KatalogCode283?,
      emittent: String?,
      dachmarkengesellschaft: KatalogCode282?,
      nummer: String?,
      nummerCodiert: String?,
      name: String?,
      nameCodiert: String?,
      merkmalMikroschrift: KatalogCode214?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      bemerkung: String?,
      gueltigBis: String?,
      gueltigVon: String?,
      konto: Bankkontoinformation?,
      dokument: List<Dokument>?,
      redundanzinformation: Redundanzinformation?,
      bezeichnung: String?,
      asservat: Asservat?,
      stueckzahl: Int?,
      guthaben: Geldbetrag?,
      sachgebundenerHinweis: List<String>?
  ) : this() {
    this.art = art
    this.faelschungsart = faelschungsart
    this.emittent = emittent
    this.dachmarkengesellschaft = dachmarkengesellschaft
    this.nummer = nummer
    this.nummerCodiert = nummerCodiert
    this.name = name
    this.nameCodiert = nameCodiert
    this.merkmalMikroschrift = merkmalMikroschrift
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.gueltigBis = gueltigBis
    this.gueltigVon = gueltigVon
    this.konto = konto
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.bezeichnung = bezeichnung
    this.asservat = asservat
    this.stueckzahl = stueckzahl
    this.guthaben = guthaben
    this.sachgebundenerHinweis = sachgebundenerHinweis
  }
}
