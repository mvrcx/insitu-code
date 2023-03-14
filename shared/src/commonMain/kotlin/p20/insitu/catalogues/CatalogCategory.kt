package p20.insitu.catalogues

import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.CatalogInfo

enum class CatalogCategory(
    val subCategories: List<CatalogSubCategory> = listOf(),
    val catalogInfo: CatalogInfo? = null,
    val entityType: EntityType? = null
) {
    // Building sites
    BUILDING_SITES,

    // Other Sites
    OTHER_SITES,

    // Persons
    PERSONS,

    // Vehicles
    VEHICLES(
        subCategories = listOf(
            CatalogSubCategory.AIRCRAFTS,
            CatalogSubCategory.BICYCLES,
            CatalogSubCategory.MOTOR_VEHICLES,
            CatalogSubCategory.RAIL_VEHICLES,
            CatalogSubCategory.OTHER_VEHICLES,
            CatalogSubCategory.WATERCRAFTS
        )
    ),

    // Building elements
    BUILDING_ELEMENTS(
        subCategories = listOf(
            CatalogSubCategory.DOORS,
            CatalogSubCategory.WINDOWS
        )
    ),

    // Objects
    ELECTRONICS(
        subCategories = listOf(
            // TODO
        )
    ),
    FURNITURE(
        subCategories = listOf(
            CatalogSubCategory.CHAIRS,
            CatalogSubCategory.CLOSETS,
            CatalogSubCategory.TABLES
        )
    ),
    OTHER_OBJECTS(
        catalogInfo = CatalogInfo.CATALOG_119_ART_DER_SONSTIGEN_SACHE,
        entityType = EntityType.SOME_OBJECT
    ),

    // Weapons
    WEAPONS(
        subCategories = listOf(
            CatalogSubCategory.AMMUNITION,
            CatalogSubCategory.EXPLOSIVE_DEVICES,
            CatalogSubCategory.EXPLOSIVE_SUBSTANCES,
            CatalogSubCategory.FIREARMS,
            CatalogSubCategory.PORTABLE_OBJECTS,
            CatalogSubCategory.WEAPONS_OF_MASS_DESTRUCTION,
            CatalogSubCategory.WEAPON_PARTS,
            CatalogSubCategory.WEAPON_SYSTEMS
        )
    ),

    // Traces
    TRACES(
        catalogInfo = CatalogInfo.CATALOG_120_ART_DER_MATERIELLEN_SPUR,
        entityType = EntityType.PHYSICAL_TRACE
    )
    ;

    fun hasSubCategories(): Boolean {
        return this.subCategories.isNotEmpty()
    }

}