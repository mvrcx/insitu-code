package p20.insitu.catalogues.someobjects

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HelpCenter
import p20.insitu.catalogues.CatalogCategory
import p20.insitu.catalogues.CatalogItem
import p20.insitu.catalogues.CatalogItems
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.CatalogInfo
import p20.insitu.resources.strings.CatalogItemStrings
import p20.insitu.resources.strings.IconContentDescriptions

public val CatalogItems.SomeObject: CatalogItem
    get() {
        if (_item != null) {
            return _item!!
        }
        _item = CatalogItem(
            name = "SomeObject",
            catalogInfo = CatalogInfo.CATALOG_119_ART_DER_SONSTIGEN_SACHE,
            category = CatalogCategory.OTHER_OBJECTS,
            entityType = EntityType.SOME_OBJECT,
            shapeType = null,
            designation = { CatalogItemStrings.someObject(it) },
            //subtitle = { CatalogItemStrings.parametricDimensions(it) },
            iconContentDescription = { IconContentDescriptions.someObject(it) },
            xpCode = null
        )
        return _item!!
    }

private var _item: CatalogItem? = null