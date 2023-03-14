package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheWasserfahrzeug() : SucheFahrzeug() {
  public var art: CIMPSucheKatalogWert? = null

  public var modell: CIMPSucheString? = null

  public var name: CIMPSucheString? = null

  public var heimathafen: CIMPSucheString? = null

  public var flaggenstaat: CIMPSucheKatalogWert? = null

  public var bruttoRaumzahl: CIMPSucheNumerischerWert? = null

  public var nettoRaumzahl: CIMPSucheNumerischerWert? = null

  public var tiefgang: SucheAusmass? = null

  public var zulassungsinformation: List<SucheZulassungsinformationWasserfahrzeug>? = null

  public var tragfaehigkeit: SucheGewicht? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      modell: CIMPSucheString?,
      name: CIMPSucheString?,
      heimathafen: CIMPSucheString?,
      flaggenstaat: CIMPSucheKatalogWert?,
      bruttoRaumzahl: CIMPSucheNumerischerWert?,
      nettoRaumzahl: CIMPSucheNumerischerWert?,
      tiefgang: SucheAusmass?,
      zulassungsinformation: List<SucheZulassungsinformationWasserfahrzeug>?,
      tragfaehigkeit: SucheGewicht?
  ) : this() {
    this.art = art
    this.modell = modell
    this.name = name
    this.heimathafen = heimathafen
    this.flaggenstaat = flaggenstaat
    this.bruttoRaumzahl = bruttoRaumzahl
    this.nettoRaumzahl = nettoRaumzahl
    this.tiefgang = tiefgang
    this.zulassungsinformation = zulassungsinformation
    this.tragfaehigkeit = tragfaehigkeit
  }
}
