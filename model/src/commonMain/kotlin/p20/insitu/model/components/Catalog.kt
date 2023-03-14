package p20.insitu.model.components

import kotlinx.serialization.Serializable

@Serializable
data class Catalog(
    val key: String,
    val name: String? = null,
    val version: String? = null
): Component() {

    fun getListUri(): String {
        return "urn:de:xpolizei:codeliste:$key"
    }

    fun getListVersionUri(): String? {
        return version?.let { v -> "urn:de:xpolizei:codeliste:$key:$v"}
    }

}