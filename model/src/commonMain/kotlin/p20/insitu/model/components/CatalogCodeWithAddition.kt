package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpCatalogCodeWithAddition

@Serializable
data class CatalogCodeWithAddition<C>(
    override val code: String?,
    override val name: String?,
    override val additionalValue: String?,
    override val catalog: Catalog
) : Component(), CatalogCode, XpCatalogCodeWithAddition<C> {
    override fun toString(): String {
        return (additionalValue
            ?: name)?.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
            ?: "-"
    }
}
