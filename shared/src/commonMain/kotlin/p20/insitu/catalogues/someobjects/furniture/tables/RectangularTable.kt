package p20.insitu.catalogues.someobjects.furniture.tables

import p20.insitu.catalogues.CatalogCategory
import p20.insitu.catalogues.CatalogItem
import p20.insitu.catalogues.CatalogItems
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.CatalogInfo
import p20.insitu.resources.icons.Icons
import p20.insitu.resources.icons.Table
import p20.insitu.resources.shapes.Shapes
import p20.insitu.resources.shapes.furniture.tables.RectangularTable
import p20.insitu.resources.strings.CatalogItemStrings
import p20.insitu.resources.strings.IconContentDescriptions

public val CatalogItems.Furniture.Tables.RectangularTable: CatalogItem
    get() {
        if (_item != null) {
            return _item!!
        }
        _item = CatalogItem(
            name = "RectangularTable",
            catalogInfo = CatalogInfo.CATALOG_119_ART_DER_SONSTIGEN_SACHE,
            category = CatalogCategory.FURNITURE,
            entityType = EntityType.SOME_OBJECT,
            shapeType = Shapes.Furniture.Tables.RectangularTable,
            designation = { CatalogItemStrings.rectangularTable(it) },
            //subtitle = { CatalogItemStrings.parametricDimensions(it) },
            iconContentDescription = { IconContentDescriptions.table(it) },
            xpCode = "119_239"
        )
        return _item!!
    }

private var _item: CatalogItem? = null