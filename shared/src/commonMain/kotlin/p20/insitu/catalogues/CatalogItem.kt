package p20.insitu.catalogues

import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.CatalogInfo
import p20.insitu.resources.Language
import p20.insitu.resources.shapes.ShapeType

class CatalogItem(
    val name: String,
    val catalogInfo: CatalogInfo? = null,
    val category: CatalogCategory? = null,
    val subCategory: CatalogSubCategory? = null,
    val entityType: EntityType,
    val shapeType: ShapeType?= null,
    val designation: (language: Language) -> String,
    val subtitle: (language: Language) -> String = { "" },
    val iconContentDescription: (language: Language) -> String,
    val xpCode: String? = null,
    val geometryArgs: Map<String, Float>? = null
) {

}