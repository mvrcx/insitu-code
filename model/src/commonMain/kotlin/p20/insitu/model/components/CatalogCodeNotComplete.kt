package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpCatalogCodeNotComplete

@Serializable
data class CatalogCodeNotComplete<C>(
    override val code: String?,
    override val name: String?,
    override val unlistedValue: String?,
    override val catalog: Catalog
) : Component(), CatalogCode, XpCatalogCodeNotComplete<C> {

    override fun toString(): String {
        return (name
            ?: unlistedValue)?.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
            ?: "-"
    }

}
