package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Dieses Fachobjekt enthält Angaben über Kontaktinformationen für die unmittelbare Erreichbarkeit
 * einer Dienststelle, einer Organisationseinheit oder eines Sachbearbeiters innerhalb einer
 * Dienststelle.
 * Zu den Kontaktinformationen zählen Telefonnummer, Faxnummer und E-Mail-Adresse.
 *  
 * Kontaktinformationen zur mittelbaren Erreichbarkeit (Postanschrift, Hausanschrift) sind in dem
 * Fachobjekt Anschrift zu finden. Wenn die Anschrift von polizeilichem Interesse ist, z. B. bei
 * behördeninternen Ermittlungen, dann wird diese über eine Beziehung zwischen den Fachobjekten
 * Organisation und dem Adresse abgebildet.
 */
@Serializable
public open class Kontakt() {
  /**
   * Dieses Feld enthält Angaben zum Namen des Kontakts (Dienststelle, Organisationseinheit,
   * Sachbearbeiter), soweit bekannt und datenschutzrechtlich zulässig.
   */
  public var name: String? = null

  /**
   * Dieses Feld enthält Angaben zur E-Mail-Adresse des Kontakts (Dienststelle,
   * Organisationseinheit, Sachbearbeiter), soweit bekannt und datenschutzrechtlich zulässig.
   */
  public var eMail: String? = null

  /**
   * Dieses Feld enthält Angaben zur Telefonnummer des Kontakts (Dienststelle, Organisationseinheit,
   * Sachbearbeiter), soweit bekannt und datenschutzrechtlich zulässig.
   */
  public var telefonnummer: String? = null

  /**
   * Dieses Feld enthält Angaben zur Faxnummer des Kontakts (Dienststelle, Organisationseinheit,
   * Sachbearbeiter), soweit bekannt und datenschutzrechtlich zulässig.
   */
  public var faxnummer: String? = null

  /**
   * Die UID (Unique ID) ist ein für jede im System gepflegte Identität generierter und eindeutiger
   * Schlüssel. Sie bleibt über den gesamten Lebenszyklus der Identität hinweg unveränderlich.
   */
  public var uID: String? = null

  public constructor(
    name: String?,
    eMail: String?,
    telefonnummer: String?,
    faxnummer: String?,
    uID: String?
  ) : this() {
    this.name = name
    this.eMail = eMail
    this.telefonnummer = telefonnummer
    this.faxnummer = faxnummer
    this.uID = uID
  }
}
