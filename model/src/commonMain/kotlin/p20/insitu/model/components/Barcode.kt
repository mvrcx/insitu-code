package p20.insitu.model.components

import kotlinx.serialization.Serializable

@Serializable
data class Barcode(
    val message: String,
    val format: String
): Component()