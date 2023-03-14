package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Eine Adresse bildet das 'Wo' einer Örtlichkeit ab, in Form einer postalischen Adresse,
 * Geokoordinaten oder Katastereinträgen (= Wo befindet sich die Örtlichkeit?).
 * Hierbei wird u. a. von folgenden Annahmen / Beispielen ausgegangen:
 * - eine Örtlichkeit Tiefgarage (z. B. in einer Wohnanlage, die aus mehreren Häusern besteht) kann
 * mehrere Adressen (im Sinne von Anschriften) haben (Beziehung Oertlichkeit_Adresse)
 * - ein Mehrfamilienhaus mit einer Adresse (im Sinne von Anschrift) enthält mehrere Wohnungen oder
 * Räumlichkeiten / Zimmer, die als eigene Örtlichkeiten betrachtet werden können
 * - eine Adresse (im Sinne von Anschrift) 'George-Marshall-Str.20' enthält mehrere Gebäude als
 * separate Örtlichkeiten
 * - in einer Instanz des Fachobjekts Adresse darf man entweder Postfachadressen,
 * Packstationadressen oder Lage- / Postanschriften angeben
 */
@Serializable
public open class Adresse() : Adresse_Leer() {

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null
  /**
   * In diesem Feld werden freitextliche Informationen zur Adresse abgebildet.
   */
  public var bemerkung: String? = null
  public var verwaltungspolitischeKodierung: VerwaltungspolitischeKodierung? = null
  public var geokodierung: Geometrie? = null
  public var dokument: List<Dokument>? = null
  public var redundanzinformation: Redundanzinformation? = null
  public var adresstyp: Adresstyp? = null
  /**
   * Eine Region bezeichnet ein Gebiet, welches hinsichtlich eines bestimmten Aspekts (Geographie /
   * Politik / Administration / Ökonomie) eine homogene Einheit bildet.
   *
   * Beispiele:
   * Schwarzwald, sächsische Schweiz, Lüneburger Heide, Hunsrück, Mecklenburgische Seenplatte,
   * Spreewald, Bodensee, Ruhrgebiet, Rhein-Main-Gebiet, Harz
   */
  public var region: String? = null

  public constructor(
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      bemerkung: String?,
      verwaltungspolitischeKodierung: VerwaltungspolitischeKodierung?,
      geokodierung: Geometrie?,
      dokument: List<Dokument>?,
      redundanzinformation: Redundanzinformation?,
      adresstyp: Adresstyp?,
      region: String?
  ) : this() {
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.verwaltungspolitischeKodierung = verwaltungspolitischeKodierung
    this.geokodierung = geokodierung
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.adresstyp = adresstyp
    this.region = region
  }
}

