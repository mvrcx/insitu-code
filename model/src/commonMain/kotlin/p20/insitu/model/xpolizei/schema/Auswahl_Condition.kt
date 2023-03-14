package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class Auswahl_Condition() {
  public var numeric_Condition: CIMPSucheNumerischerWert? = null

  public var string_Condition: CIMPSucheString? = null

  public var catalog_Condition: CIMPSucheKatalogWert? = null

  public var date_Condition: CIMPSucheDatum? = null

  public var time_Condition: CIMPSucheZeit? = null

  public var binary_Data_Condition: CIMPSucheDigitaleDaten? = null

  public var gis_Condition: SucheGeometrie? = null

  public var street_Condition: CIMPSucheStrasse? = null

  public var term_Condition: CIMPSucheString? = null

  public var alphanumeric_Condition: CIMPSucheAlphanumerischerWert? = null

  public var housenumber_Condition: CIMPSucheHausnummer? = null

  public var name_Condition: CIMPSucheName? = null

  public constructor(
      numeric_Condition: CIMPSucheNumerischerWert?,
      string_Condition: CIMPSucheString?,
      catalog_Condition: CIMPSucheKatalogWert?,
      date_Condition: CIMPSucheDatum?,
      time_Condition: CIMPSucheZeit?,
      binary_Data_Condition: CIMPSucheDigitaleDaten?,
      gis_Condition: SucheGeometrie?,
      street_Condition: CIMPSucheStrasse?,
      term_Condition: CIMPSucheString?,
      alphanumeric_Condition: CIMPSucheAlphanumerischerWert?,
      housenumber_Condition: CIMPSucheHausnummer?,
      name_Condition: CIMPSucheName?
  ) : this() {
    this.numeric_Condition = numeric_Condition
    this.string_Condition = string_Condition
    this.catalog_Condition = catalog_Condition
    this.date_Condition = date_Condition
    this.time_Condition = time_Condition
    this.binary_Data_Condition = binary_Data_Condition
    this.gis_Condition = gis_Condition
    this.street_Condition = street_Condition
    this.term_Condition = term_Condition
    this.alphanumeric_Condition = alphanumeric_Condition
    this.housenumber_Condition = housenumber_Condition
    this.name_Condition = name_Condition
  }
}
