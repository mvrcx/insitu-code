package p20.insitu.model.components

import kotlinx.serialization.Serializable

@Serializable
data class ExternalSystemId(
    val id: String,
    val systemName: String
): Component()