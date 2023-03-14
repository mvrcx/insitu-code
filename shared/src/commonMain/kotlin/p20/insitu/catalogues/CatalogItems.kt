package p20.insitu.catalogues

import p20.insitu.catalogues.persons.Corpse
import p20.insitu.catalogues.persons.Person
import p20.insitu.catalogues.sites.*
import p20.insitu.catalogues.someobjects.SomeObject
import p20.insitu.catalogues.someobjects.buildingelements.doors.SingleWingDoor
import p20.insitu.catalogues.someobjects.furniture.tables.RectangularTable
import p20.insitu.catalogues.traces.DNA
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.resources.icons.Icons
import p20.insitu.resources.strings.IconContentDescriptions

object CatalogItems {

    object BuildingElements {
        object Doors
        object Windows
    }

    object Electronics
    object Furniture {
        object Chairs
        object Closets
        object Tables
    }

    object Persons
    object Sites
    object Traces


    suspend fun getItems(
        category: CatalogCategory,
        catalogRepo: CatalogRepo
    ): List<CatalogItem> {
        val items = mutableListOf<CatalogItem>()
        val customItems = getCustomItems(category)
        items.addAll(customItems)
        items.addAll(
            getGenericItems(
                category,
                customItems.mapNotNull { it.xpCode }.distinct(),
                catalogRepo
            )
        )
        return items
    }

    suspend fun getItems(
        subCategory: CatalogSubCategory,
        catalogRepo: CatalogRepo
    ): List<CatalogItem> {
        val items = mutableListOf<CatalogItem>()
        val customItems = getCustomItems(subCategory)
        items.addAll(customItems)
        items.addAll(
            getGenericItems(
                subCategory,
                customItems.mapNotNull { it.xpCode }.distinct(),
                catalogRepo
            )
        )
        return items
    }

    private fun getCustomItems(category: CatalogCategory): List<CatalogItem> {
        return when (category) {
            CatalogCategory.BUILDING_SITES -> listOf(
                Sites.Building,
                Sites.Apartment,
                Sites.Floor,
                Sites.Room
            )
            CatalogCategory.OTHER_SITES -> listOf(
                Sites.SomeSite
            )
            CatalogCategory.OTHER_OBJECTS -> listOf(
                SomeObject
            )
            CatalogCategory.TRACES -> listOf(
                Traces.DNA
            )
            CatalogCategory.PERSONS -> listOf(
                Persons.Person,
                Persons.Corpse
            )
            else -> listOf()
        }
    }

    private fun getCustomItems(subCategory: CatalogSubCategory): List<CatalogItem> {
        return when (subCategory) {
            CatalogSubCategory.CHAIRS -> listOf(
                // TODO
            )
            CatalogSubCategory.CLOSETS -> listOf(
                // TODO
            )
            CatalogSubCategory.TABLES -> listOf(
                Furniture.Tables.RectangularTable
            )
            CatalogSubCategory.DOORS -> listOf(
                BuildingElements.Doors.SingleWingDoor
            )
            else -> listOf()
        }
    }

    private suspend fun getGenericItems(
        category: CatalogCategory,
        codesToExclude: List<String>,
        catalogRepo: CatalogRepo
    ): List<CatalogItem> {
        val genericItems = mutableListOf<CatalogItem>()
        category.catalogInfo?.let { catalogInfo ->
            category.entityType?.let { entityType ->
                catalogRepo.getCatalogValues(catalogInfo)
                    .filter { !codesToExclude.contains(it.code) }
                    .forEach { catalogCode ->
                        genericItems.add(
                            CatalogItem(
                                name = "${catalogCode.name}",
                                catalogInfo = catalogInfo,
                                category = category,
                                subCategory = null,
                                entityType = entityType,
                                shapeType = null,
                                designation = { catalogCode.toString() },
                                //subtitle = { CatalogItemStrings.customizableDimensions(it) },
                                iconContentDescription = { IconContentDescriptions.genericObject(it) },
                                xpCode = catalogCode.code
                            )
                        )
                    }
            }
        }
        return genericItems
    }

    private suspend fun getGenericItems(
        subCategory: CatalogSubCategory,
        codesToExclude: List<String>,
        catalogRepo: CatalogRepo
    ): List<CatalogItem> {
        val genericItems = mutableListOf<CatalogItem>()
        subCategory.catalogInfo?.let { catalogInfo ->
            catalogRepo.getCatalogValues(catalogInfo)
                .filter { !codesToExclude.contains(it.code) }
                .forEach { catalogCode ->
                    genericItems.add(
                        CatalogItem(
                            name = "${catalogCode.name}",
                            catalogInfo = catalogInfo,
                            category = subCategory.baseCategory,
                            subCategory = subCategory,
                            entityType = subCategory.entityType,
                            shapeType = null,
                            designation = { catalogCode.toString() },
                            //subtitle = { CatalogItemStrings.customizableDimensions(it) },
                            iconContentDescription = { IconContentDescriptions.genericObject(it) },
                            xpCode = catalogCode.code
                        )
                    )
                }
        }
        return genericItems
    }

}