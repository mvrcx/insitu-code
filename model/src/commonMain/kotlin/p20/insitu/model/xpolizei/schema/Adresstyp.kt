package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Auswahl von Postfach, Packstation oder Lage_Postanschrift.
 */
@Serializable
public open class Adresstyp() {
  public var postfach: Postfach? = null

  public var packstation: Packstation? = null

  public var lage_Postanschrift: Lage_Postanschrift? = null

  public constructor(
      postfach: Postfach?,
      packstation: Packstation?,
      lage_Postanschrift: Lage_Postanschrift?
  ) : this() {
    this.postfach = postfach
    this.packstation = packstation
    this.lage_Postanschrift = lage_Postanschrift
  }
}
