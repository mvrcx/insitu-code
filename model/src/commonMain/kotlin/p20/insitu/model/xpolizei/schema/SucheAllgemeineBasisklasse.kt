package p20.insitu.model.xpolizei.schema

import kotlin.ByteArray
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheAllgemeineBasisklasse() {
  public var datenbesitzer: CIMPSucheString? = null

  public var datenbereich: List<CIMPSucheString>? = null

  public var benutzerInhalt: BenutzerInhalt? = null

  public var erstellungsDatum: SucheDatumZeit? = null

  public var aenderungsDatum: SucheDatumZeit? = null

  public var datenursprung: List<SucheDatenursprung>? = null

  public var geschuetzt: CIMPSucheKatalogWert? = null

  public var id: String? = null

  public var quellID: String? = null

  public var zielID: String? = null

  public constructor(
      datenbesitzer: CIMPSucheString?,
      datenbereich: List<CIMPSucheString>?,
      benutzerInhalt: BenutzerInhalt?,
      erstellungsDatum: SucheDatumZeit?,
      aenderungsDatum: SucheDatumZeit?,
      datenursprung: List<SucheDatenursprung>?,
      geschuetzt: CIMPSucheKatalogWert?,
      id: String?,
      quellID: String?,
      zielID: String?
  ) : this() {
    this.datenbesitzer = datenbesitzer
    this.datenbereich = datenbereich
    this.benutzerInhalt = benutzerInhalt
    this.erstellungsDatum = erstellungsDatum
    this.aenderungsDatum = aenderungsDatum
    this.datenursprung = datenursprung
    this.geschuetzt = geschuetzt
    this.id = id
    this.quellID = quellID
    this.zielID = zielID
  }

  @Serializable
  public class BenutzerInhalt() {
    public var any: List<ByteArray>? = null

    public constructor(any: List<ByteArray>?) : this() {
      this.any = any
    }
  }
}
