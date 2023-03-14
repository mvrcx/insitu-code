package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung_Person_Straftat() : SucheBeziehung() {
  public var motiv: List<CIMPSucheKatalogWert>? = null

  public var schusswaffengebrauch: CIMPSucheKatalogWert? = null

  public var schusswaffeMitgefuehrt: CIMPSucheKatalogWert? = null

  public var aussonderungspruefdatum: CIMPSucheDatum? = null

  public var dSStatus: SucheDatenschutzrechtlicherStatus? = null

  public var alkoholeinfluss: SucheAlkoholeinfluss? = null

  public var btMeinfluss: SucheBtMeinfluss? = null

  public var justizaktenzeichen: CIMPSucheString? = null

  public var alterZurTatzeit: SucheAltersangabe? = null

  public constructor(
      motiv: List<CIMPSucheKatalogWert>?,
      schusswaffengebrauch: CIMPSucheKatalogWert?,
      schusswaffeMitgefuehrt: CIMPSucheKatalogWert?,
      aussonderungspruefdatum: CIMPSucheDatum?,
      dSStatus: SucheDatenschutzrechtlicherStatus?,
      alkoholeinfluss: SucheAlkoholeinfluss?,
      btMeinfluss: SucheBtMeinfluss?,
      justizaktenzeichen: CIMPSucheString?,
      alterZurTatzeit: SucheAltersangabe?
  ) : this() {
    this.motiv = motiv
    this.schusswaffengebrauch = schusswaffengebrauch
    this.schusswaffeMitgefuehrt = schusswaffeMitgefuehrt
    this.aussonderungspruefdatum = aussonderungspruefdatum
    this.dSStatus = dSStatus
    this.alkoholeinfluss = alkoholeinfluss
    this.btMeinfluss = btMeinfluss
    this.justizaktenzeichen = justizaktenzeichen
    this.alterZurTatzeit = alterZurTatzeit
  }
}
