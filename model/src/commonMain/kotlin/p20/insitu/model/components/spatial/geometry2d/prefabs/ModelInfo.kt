package p20.insitu.model.components.spatial.geometry2d.prefabs

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpCatalogCodeNotComplete
import p20.insitu.model.xpolizei.schema.KatalogCode119
import p20.insitu.model.xpolizei.schema.KatalogCode119_NichtAbgeschlossen

@Serializable
data class ModelInfo(
    val modelId: String?,
    val designation: String?,
    val comment: String?,
    val type: XpCatalogCodeNotComplete<KatalogCode119_NichtAbgeschlossen>?,
    val categories: List<String>?
)
