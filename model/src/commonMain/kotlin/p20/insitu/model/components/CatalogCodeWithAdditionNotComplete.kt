package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpCatalogCodeWithAdditionNotComplete

@Serializable
data class CatalogCodeWithAdditionNotComplete<C>(
    override val code: String?,
    override val name: String?,
    override val additionalValue: String?,
    override val unlistedValue: String?,
    override val catalog: Catalog
) : Component(), CatalogCode, XpCatalogCodeWithAdditionNotComplete<C> {
    override fun toString(): String {
        return (unlistedValue ?: additionalValue
        ?: name)?.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
            ?: "-"
    }
}
