package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung_Verkehrsunfall_Person() : SucheBeziehung() {
  public var aussonderungspruefdatum: CIMPSucheDatum? = null

  public var ordnungsnummer: CIMPSucheString? = null

  public var fahrerlaubnisVorhanden: CIMPSucheKatalogWert? = null

  public var verletzungsgrad: CIMPSucheKatalogWert? = null

  public var schaden: SucheGeldbetrag? = null

  public var unfallflucht: CIMPSucheKatalogWert? = null

  public var unfallursache: List<CIMPSucheKatalogWert>? = null

  public var verkehrsbeteiligungPersonenbezogen: CIMPSucheKatalogWert? = null

  public var verkehrsbeteiligungFahrzeugbezogen: CIMPSucheKatalogWert? = null

  public var gefahrgutangabe: SucheGefahrgut? = null

  public var alkoholeinfluss: SucheAlkoholeinfluss? = null

  public constructor(
      aussonderungspruefdatum: CIMPSucheDatum?,
      ordnungsnummer: CIMPSucheString?,
      fahrerlaubnisVorhanden: CIMPSucheKatalogWert?,
      verletzungsgrad: CIMPSucheKatalogWert?,
      schaden: SucheGeldbetrag?,
      unfallflucht: CIMPSucheKatalogWert?,
      unfallursache: List<CIMPSucheKatalogWert>?,
      verkehrsbeteiligungPersonenbezogen: CIMPSucheKatalogWert?,
      verkehrsbeteiligungFahrzeugbezogen: CIMPSucheKatalogWert?,
      gefahrgutangabe: SucheGefahrgut?,
      alkoholeinfluss: SucheAlkoholeinfluss?
  ) : this() {
    this.aussonderungspruefdatum = aussonderungspruefdatum
    this.ordnungsnummer = ordnungsnummer
    this.fahrerlaubnisVorhanden = fahrerlaubnisVorhanden
    this.verletzungsgrad = verletzungsgrad
    this.schaden = schaden
    this.unfallflucht = unfallflucht
    this.unfallursache = unfallursache
    this.verkehrsbeteiligungPersonenbezogen = verkehrsbeteiligungPersonenbezogen
    this.verkehrsbeteiligungFahrzeugbezogen = verkehrsbeteiligungFahrzeugbezogen
    this.gefahrgutangabe = gefahrgutangabe
    this.alkoholeinfluss = alkoholeinfluss
  }
}
