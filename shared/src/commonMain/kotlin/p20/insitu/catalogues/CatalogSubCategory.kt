package p20.insitu.catalogues

import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.CatalogInfo

enum class CatalogSubCategory(
    val baseCategory: CatalogCategory,
    val catalogInfo: CatalogInfo?,
    val entityType: EntityType
) {
    // Building elements
    DOORS(
        CatalogCategory.BUILDING_ELEMENTS,
        null,
        EntityType.DOOR
    ),
    WINDOWS(
        CatalogCategory.BUILDING_ELEMENTS,
        null,
        EntityType.WINDOW
    ),

    // Furniture
    CHAIRS(
        CatalogCategory.FURNITURE,
        null,
        EntityType.SOME_OBJECT
    ),
    CLOSETS(
        CatalogCategory.FURNITURE,
        null,
        EntityType.SOME_OBJECT
    ),
    TABLES(
        CatalogCategory.FURNITURE,
        null,
        EntityType.SOME_OBJECT
    ),

    // Vehicles
    AIRCRAFTS(
        CatalogCategory.VEHICLES,
        CatalogInfo.CATALOG_114_ART_DES_LUFTFAHRZEUGS,
        EntityType.AIRCRAFT
    ),
    BICYCLES(
        CatalogCategory.VEHICLES,
        CatalogInfo.CATALOG_328_ART_DES_FAHRRADS,
        EntityType.BICYCLE
    ),
    MOTOR_VEHICLES(
        CatalogCategory.VEHICLES,
        CatalogInfo.CATALOG_113_ART_DES_KRAFTFAHRZEUGS,
        EntityType.MOTOR_VEHICLE
    ),
    RAIL_VEHICLES(
        CatalogCategory.VEHICLES,
        CatalogInfo.CATALOG_118_ART_DES_SCHIENENFAHRZEUGS,
        EntityType.RAIL_VEHICLE
    ),
    OTHER_VEHICLES(
        CatalogCategory.VEHICLES,
        null,
        EntityType.SOME_VEHICLE
    ),
    WATERCRAFTS(
        CatalogCategory.VEHICLES,
        CatalogInfo.CATALOG_124_ART_DES_WASSERFAHRZEUGS,
        EntityType.WATERCRAFT
    ),

    // Weapons
    AMMUNITION(
        CatalogCategory.WEAPONS,
        CatalogInfo.CATALOG_292_ART_DER_MUNITION,
        EntityType.AMMUNITION
    ),
    EXPLOSIVE_DEVICES(
        CatalogCategory.WEAPONS,
        CatalogInfo.CATALOG_300_ART_DER_SPRENG_BRANDVORRICHTUNG,
        EntityType.EXPLOSIVE_DEVICE
    ),
    EXPLOSIVE_SUBSTANCES(
        CatalogCategory.WEAPONS,
        CatalogInfo.CATALOG_307_ART_DES_EXPLOSIONSGEFAEHRLICHEN_STOFFES,
        EntityType.EXPLOSIVE_DEVICE
    ),
    FIREARMS(
        CatalogCategory.WEAPONS,
        CatalogInfo.CATALOG_291_ART_DER_SCHUSSWAFFE,
        EntityType.FIREARM
    ),
    PORTABLE_OBJECTS(
        CatalogCategory.WEAPONS,
        CatalogInfo.CATALOG_293_ART_DES_TRAGBAREN_GEGENSTANDS,
        EntityType.PORTABLE_OBJECT
    ),
    WEAPONS_OF_MASS_DESTRUCTION(
        CatalogCategory.WEAPONS,
        CatalogInfo.CATALOG_299_ART_DER_MASSENVERNICHTUNGSWAFFE,
        EntityType.WEAPON_OF_MASS_DESTRUCTION
    ),
    WEAPON_PARTS(
        CatalogCategory.WEAPONS,
        CatalogInfo.CATALOG_294_ART_DES_WAFFENZUBEHOERS_TEILS,
        EntityType.WEAPON_PART
    ),
    WEAPON_SYSTEMS(
        CatalogCategory.WEAPONS,
        CatalogInfo.CATALOG_297_ART_DES_WAFFENSYSTEMS,
        EntityType.WEAPON_SYSTEM
    )
    ;

}