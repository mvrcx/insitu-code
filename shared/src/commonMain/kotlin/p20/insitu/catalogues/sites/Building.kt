package p20.insitu.catalogues.sites

import p20.insitu.catalogues.CatalogCategory
import p20.insitu.catalogues.CatalogItem
import p20.insitu.catalogues.CatalogItems
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.CatalogInfo
import p20.insitu.resources.icons.Icons
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.resources.strings.IconContentDescriptions

public val CatalogItems.Sites.Building: CatalogItem
    get() {
        if (_item != null) {
            return _item!!
        }
        EntityType.BUILDING.let { entityType ->
            _item = CatalogItem(
                name = "Building",
                catalogInfo = CatalogInfo.CATALOG_115_ART_DER_OERTLICHKEIT,
                category = CatalogCategory.BUILDING_SITES,
                entityType = entityType,
                designation = { EntityTypeStrings.typeString(entityType, it) },
                iconContentDescription = {
                    IconContentDescriptions.entityType(
                        entityType,
                        it
                    )
                },
                xpCode = "115_305"
            )
        }
        return _item!!
    }

private var _item: CatalogItem? = null