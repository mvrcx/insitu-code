package p20.insitu.catalogues.traces

import p20.insitu.catalogues.CatalogCategory
import p20.insitu.catalogues.CatalogItem
import p20.insitu.catalogues.CatalogItems
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.CatalogInfo
import p20.insitu.resources.icons.DNA
import p20.insitu.resources.icons.Icons
import p20.insitu.resources.strings.CatalogItemStrings
import p20.insitu.resources.strings.IconContentDescriptions

public val CatalogItems.Traces.DNA: CatalogItem
    get() {
        if (_item != null) {
            return _item!!
        }
        _item = CatalogItem(
            name = "DNA",
            catalogInfo = CatalogInfo.CATALOG_120_ART_DER_MATERIELLEN_SPUR,
            category = CatalogCategory.TRACES,
            entityType = EntityType.DNA_TRACE,
            shapeType = null,
            designation = { CatalogItemStrings.dnaTrace(it) },
            //subtitle = { CatalogItemStrings.parametricDimensions(it) },
            iconContentDescription = { IconContentDescriptions.dnaTrace(it) },
            xpCode = null
        )
        return _item!!
    }

private var _item: CatalogItem? = null