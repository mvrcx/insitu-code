package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Die Personenidentifikationsnummer (PIN) ist eine nationale Identifikationsnummer, die eine Person
 * in einem bestimmten Kontext eindeutig identifiziert (z. B. Steuernummer, Sozialversicherungsnummer,
 * Bevölkerungsregisternummer usw.).
 *
 * Beispiele hierfür sind 'SOTU/HETU' in Finnland, 'PESEL' und 'NIP' in Polen, 'SOFI' in den
 * Niederlanden, 'ΑΡΙΘΜΟΣ ΦΟΡΟΛΟΓΙΚΟΥ ΜΗΤΡΩΟΥ (ΑΦΜ)' und 'ΑΡΙΘΜΟΣ ΜΗΤΡΩΟΥ ΚΟΙΝΩΝΙΚΗΣ ΑΣΦΑΛΙΣΗΣ (ΑΜΚΑ)'
 * in Griechenland,  usw.
 *
 * Diese Nummern können sich auch auf Urkunden / Dokumenten befinden. Es handelt sich dabei nicht um
 * eine Dokumentennummer, z. B. eines Reisepasses, Personalausweises, Führerscheins, die sich ändern
 * kann, wenn das Dokument ausgewechselt wird und welche einem Dokument physisch zugeordnet ist, und
 * nicht dem Inhaber des Dokuments.
 */
@Serializable
public open class Personenidentifikationsnummer() {
  /**
   * Alphanumerische Darstellung der Nummer.
   *
   * Beispiel: 'M0104579'
   */
  public var nummer: Nummer? = null

  /**
   * Dieses Feld enthält Angaben zur Art der Personenidentifikationsnummer.
   */
  public var art: KatalogCode322_NichtAbgeschlossen? = null

  public constructor(nummer: Nummer?, art: KatalogCode322_NichtAbgeschlossen?) : this() {
    this.nummer = nummer
    this.art = art
  }
}
