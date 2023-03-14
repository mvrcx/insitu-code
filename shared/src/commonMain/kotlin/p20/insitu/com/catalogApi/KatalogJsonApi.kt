package p20.insitu.com.catalogApi

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Catalog

@Serializable
data class KatalogJsonApi(
    var id: Long? = null,
    var katalogStatus: String? = null,
    var schluessel: String? = null,
    var gueltigAb: String? = null,
    var name: String? = null,
    var bezeichnung: String? = null,
    var version: String? = null,
    var externalSource: String? = null,
    var anwendung: List<AnwendungJsonApi>? = null
) {
    fun getCatalogInfo(): Catalog {
        return Catalog(
            schluessel ?: "",
            name,
            version
        )
    }
}
