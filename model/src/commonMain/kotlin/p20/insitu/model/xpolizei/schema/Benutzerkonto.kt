package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Als Benutzerkonto wird eine Zugangsberechtigung zu einem zugangsbeschränkten IT-System
 * bezeichnet. In der Regel ist ein Benutzerkonto genau einer natürlichen Person, die sich dem System
 * gegenüber in geeigneter Form authentisiert, zugeordnet (Nachweis durch Authentifizierung).
 * Umgekehrt besitzt eine natürliche Person meistens mehrere Benutzerkonten, z. B. für verschiedene
 * Systeme (z. B. dienstliches Benutzerkonto) oder verschiedene Berechtigungsstufen.
 *
 * Im Benutzerkonto können auch Postnummern im Attribut 'Kennung' erfasst werden (z. B. beim
 * DHL-Kundenkonto im Zusammenhang mit Packstationen).
 *  
 * Die Authentisierung kann beispielsweise mittels biometrischer Merkmale (zum Beispiel
 * Fingerabdruck, Stimmmuster, Augenhintergrund, Iris), einem Generator für Einmal-Passwörter oder
 * einem geheimen (d. h. nur dem Konteninhaber und dem System bekannten) Passwort erfolgen.
 */
@Serializable
public open class Benutzerkonto() : Benutzerkonto_Leer() {
  /**
   * Freitextliche Angaben über die Art des Benutzerkontos.
   *
   * Beispiele: Administrator, Moderator
   */
  public var bezeichnung: String? = null

  /**
   * Angabe, ob es sich bei dem Benutzerkonto um einen Fake-Account (auch 'Sockenpuppe' genannt)
   * handelt.
   *  
   * Durch die Benutzung von Mehrfachkonten wird der vermeintliche Schutz einer 'doppelten
   * Anonymität' ausgenutzt: Obwohl in vielen Fällen bereits der 'Hauptaccount' pseudonym, also keinem
   * realen Menschen zuordenbar ist, wird für unpopuläre Maßnahmen (z. B. Änderung von
   * Wikipedia-Artikeln) oder reine Störaktionen, ein Zweitkonto verwendet, um die künstliche Identität
   * des ersten und seine eventuell bereits erworbene Reputation nicht zu gefährden. Der Benutzer
   * solcher Mehrfachkonten steht weder mit seiner tatsächlichen Identität zu seinem Handeln noch mit
   * seiner pseudonymen Internet-'Identität'.
   */
  public var fakeAccount: KatalogCode214? = null

  /**
   * Dieses Objekt bildet den Login-Namen (auch Benutzername genannt) ab, welcher der Unterscheidung
   * der verschiedenen Benutzerkonten eines EDV-Systems dient. Die Kennung muss in dem EDV-System
   * eindeutig sein.
   *
   * Beispiele:
   * - bk026000
   * - BK\bk026000
   */
  public var kennung: String? = null

  /**
   * Das (geheime) Passwort des Benutzerkontos (vorausgesetzt die Authentisierung erfolgt mittels
   * Passwort) im Klartext.
   *  
   * Beispiel: SuperGeheim
   *  
   * Anmerkung: Authentisierung muss nicht notwendigerweise durch Passwort erfolgen.
   */
  public var passwort: String? = null

  /**
   * Angabe weiterer Informationen zu einem Benutzerkonto (Rechteumfang, zusätzliche
   * Sicherheitsmechanismen, etc.).
   */
  public var bemerkung: String? = null

  /**
   * Dieses Feld enthält Angaben zur Benutzer-ID.
   */
  public var benutzerID: String? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  public constructor(
      bezeichnung: String?,
      fakeAccount: KatalogCode214?,
      kennung: String?,
      passwort: String?,
      bemerkung: String?,
      benutzerID: String?,
      redundanzinformation: Redundanzinformation?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.fakeAccount = fakeAccount
    this.kennung = kennung
    this.passwort = passwort
    this.bemerkung = bemerkung
    this.benutzerID = benutzerID
    this.redundanzinformation = redundanzinformation
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
  }
}
