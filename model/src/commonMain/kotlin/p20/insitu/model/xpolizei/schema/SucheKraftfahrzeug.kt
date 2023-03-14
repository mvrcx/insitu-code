package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheKraftfahrzeug() : SucheFahrzeug() {
  public var art: CIMPSucheKatalogWert? = null

  public var marke: CIMPSucheKatalogWert? = null

  public var fahrzeugidentifizierungsnummer: CIMPSucheString? = null

  public var aufbau: CIMPSucheKatalogWert? = null

  public var typschluessel: CIMPSucheString? = null

  public var herstellerschluessel: CIMPSucheString? = null

  public var stilllegung: CIMPSucheDatum? = null

  public var erstzulassung: CIMPSucheDatum? = null

  public var zulassungsinformation: List<SucheZulassungsinformationKfz>? = null

  public var zulaessigesGesamtgewicht: SucheGewicht? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      marke: CIMPSucheKatalogWert?,
      fahrzeugidentifizierungsnummer: CIMPSucheString?,
      aufbau: CIMPSucheKatalogWert?,
      typschluessel: CIMPSucheString?,
      herstellerschluessel: CIMPSucheString?,
      stilllegung: CIMPSucheDatum?,
      erstzulassung: CIMPSucheDatum?,
      zulassungsinformation: List<SucheZulassungsinformationKfz>?,
      zulaessigesGesamtgewicht: SucheGewicht?
  ) : this() {
    this.art = art
    this.marke = marke
    this.fahrzeugidentifizierungsnummer = fahrzeugidentifizierungsnummer
    this.aufbau = aufbau
    this.typschluessel = typschluessel
    this.herstellerschluessel = herstellerschluessel
    this.stilllegung = stilllegung
    this.erstzulassung = erstzulassung
    this.zulassungsinformation = zulassungsinformation
    this.zulaessigesGesamtgewicht = zulaessigesGesamtgewicht
  }
}
