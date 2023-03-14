package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Abbildung von Fahrzeugen, die nicht zu einem der Fachobjekte Fahrrad, Kraftfahrzeug,
 * Wasserfahrzeug, Luftfahrzeug oder Schienenfahrzeug gehören.
 */
@Serializable
public open class SonstigesFahrzeug() : Fahrzeug()
