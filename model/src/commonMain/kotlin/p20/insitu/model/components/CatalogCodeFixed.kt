package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpCatalogCode
import p20.insitu.model.xpolizei.schema.Code

@Serializable
data class CatalogCodeFixed<C : Code> (
    override val code: String,
    override val name: String,
    override val catalog: Catalog
) : Component(), CatalogCode, XpCatalogCode<C>{

    override fun toString(): String {
        return  name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }
}
