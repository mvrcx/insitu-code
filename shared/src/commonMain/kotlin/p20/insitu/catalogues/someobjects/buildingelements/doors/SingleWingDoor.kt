package p20.insitu.catalogues.someobjects.buildingelements.doors

import p20.insitu.catalogues.CatalogCategory
import p20.insitu.catalogues.CatalogItem
import p20.insitu.catalogues.CatalogItems
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.CatalogInfo
import p20.insitu.resources.icons.Icons
import p20.insitu.resources.icons.SingleWingDoor
import p20.insitu.resources.strings.CatalogItemStrings
import p20.insitu.resources.strings.IconContentDescriptions

public val CatalogItems.BuildingElements.Doors.SingleWingDoor: CatalogItem
    get() {
        if (_item != null) {
            return _item!!
        }
        _item = CatalogItem(
            name = "OneWingDoor",
            catalogInfo = CatalogInfo.CATALOG_119_ART_DER_SONSTIGEN_SACHE,
            category = CatalogCategory.BUILDING_ELEMENTS,
            entityType = EntityType.DOOR,
            //shapeType = Shapes.BuildingElements.Doors.OneWingDoor,
            designation = { CatalogItemStrings.singleWingDoor(it) },
            //subtitle = { CatalogItemStrings.parametricDimensions(it) },
            iconContentDescription = { IconContentDescriptions.door(it) },
            xpCode = "119_244"
        )
        return _item!!
    }

private var _item: CatalogItem? = null