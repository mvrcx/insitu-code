package p20.insitu.catalogues.persons

import p20.insitu.catalogues.CatalogCategory
import p20.insitu.catalogues.CatalogItem
import p20.insitu.catalogues.CatalogItems
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.resources.icons.Icons
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.resources.strings.IconContentDescriptions

public val CatalogItems.Persons.Corpse: CatalogItem
    get() {
        if (_item != null) {
            return _item!!
        }
        EntityType.CORPSE.let { entityType ->
            _item = CatalogItem(
                name = "Corpse",
                category = CatalogCategory.PERSONS,
                entityType = entityType,
                shapeType = null, // TODO define a shape
                designation = { EntityTypeStrings.typeString(entityType, it) },
                iconContentDescription = {
                    IconContentDescriptions.entityType(
                        entityType,
                        it
                    )
                }
            )
        }
        return _item!!
    }

private var _item: CatalogItem? = null