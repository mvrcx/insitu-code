package p20.insitu.resources.strings

import p20.insitu.catalogues.CatalogCategory
import p20.insitu.catalogues.CatalogSubCategory
import p20.insitu.catalogues.CatalogCategoryGroup
import p20.insitu.resources.Language

object CatalogStrings {
    fun categoryGroup(category: CatalogCategoryGroup, language: Language): String {
        return when(category){
            CatalogCategoryGroup.CRIME_SCENE_SITES -> crimeSceneSites(language)
            CatalogCategoryGroup.BUILDING_SITES -> buildingSites(language)
            CatalogCategoryGroup.OBJECTS -> objects(language)
            CatalogCategoryGroup.OTHER_SITES -> otherSites(language)
            CatalogCategoryGroup.TRACES -> traces(language)
            CatalogCategoryGroup.VEHICLES -> vehicles(language)
            CatalogCategoryGroup.WEAPONS -> weapons(language)
            CatalogCategoryGroup.BUILDING_ELEMENTS -> buildingElements(language)
            CatalogCategoryGroup.PERSONS -> persons(language)
        }
    }

    fun category(category: CatalogCategory, language: Language): String {
        return when(category){
            CatalogCategory.BUILDING_SITES -> buildingSites(language)
            CatalogCategory.ELECTRONICS -> electronics(language)
            CatalogCategory.FURNITURE -> furniture(language)
            CatalogCategory.OTHER_SITES -> otherSites(language)
            CatalogCategory.PERSONS -> persons(language)
            CatalogCategory.VEHICLES -> vehicles(language)
            CatalogCategory.BUILDING_ELEMENTS -> buildingElements(language)
            CatalogCategory.OTHER_OBJECTS -> someObjects(language)
            CatalogCategory.WEAPONS -> weapons(language)
            CatalogCategory.TRACES -> traces(language)
        }
    }

    fun subCategory(category: CatalogSubCategory, language: Language): String {
        return when(category){
            CatalogSubCategory.AIRCRAFTS -> aircrafts(language)
            CatalogSubCategory.BICYCLES -> bicycles(language)
            CatalogSubCategory.MOTOR_VEHICLES -> motorVehicles(language)
            CatalogSubCategory.RAIL_VEHICLES -> railVehicles(language)
            CatalogSubCategory.OTHER_VEHICLES -> otherVehicles(language)
            CatalogSubCategory.WATERCRAFTS -> watercraft(language)
            CatalogSubCategory.DOORS -> doors(language)
            CatalogSubCategory.WINDOWS -> windows(language)
            CatalogSubCategory.CHAIRS -> chairs(language)
            CatalogSubCategory.CLOSETS -> closets(language)
            CatalogSubCategory.TABLES -> tables(language)
            CatalogSubCategory.AMMUNITION -> ammunition(language)
            CatalogSubCategory.EXPLOSIVE_DEVICES -> explosiveDevices(language)
            CatalogSubCategory.EXPLOSIVE_SUBSTANCES -> explosiveSubstances(language)
            CatalogSubCategory.FIREARMS -> firearms(language)
            CatalogSubCategory.PORTABLE_OBJECTS -> portableObjects(language)
            CatalogSubCategory.WEAPONS_OF_MASS_DESTRUCTION -> weaponsOfMassDestruction(language)
            CatalogSubCategory.WEAPON_PARTS -> weaponParts(language)
            CatalogSubCategory.WEAPON_SYSTEMS -> weaponSystems(language)
        }
    }

    private const val aircrafts_DE = "Flugzeuge"
    private const val aircrafts_EN = "Aircrafts"
    fun aircrafts(language: Language): String {
        return when (language) {
            Language.DE -> aircrafts_DE
            Language.EN -> aircrafts_EN
        }
    }

    private const val ammunition_DE = "Munition"
    private const val ammunition_EN = "Ammunition"
    fun ammunition(language: Language): String {
        return when (language) {
            Language.DE -> ammunition_DE
            Language.EN -> ammunition_EN
        }
    }

    private const val apartment_DE = "Wohnung"
    private const val apartment_EN = "Apartment"
    fun apartment(language: Language): String {
        return when (language) {
            Language.DE -> apartment_DE
            Language.EN -> apartment_EN
        }
    }

    private const val bicycles_DE = "Fahrräder"
    private const val bicycles_EN = "Bicycles"
    fun bicycles(language: Language): String {
        return when (language) {
            Language.DE -> bicycles_DE
            Language.EN -> bicycles_EN
        }
    }

    private const val building_DE = "Gebäude"
    private const val building_EN = "Building"
    fun building(language: Language): String {
        return when (language) {
            Language.DE -> building_DE
            Language.EN -> building_EN
        }
    }

    private const val building_sites_DE = "Gebäudebereiche"
    private const val building_sites_EN = "Building Sites"
    fun buildingSites(language: Language): String {
        return when (language) {
            Language.DE -> building_sites_DE
            Language.EN -> building_sites_EN
        }
    }

    private const val building_elements_DE = "Bauteile / Innenausbauten"
    private const val building_elements_EN = "Building Elements"
    fun buildingElements(language: Language): String {
        return when (language) {
            Language.DE -> building_elements_DE
            Language.EN -> building_elements_EN
        }
    }

    private const val chairs_DE = "Stühle"
    private const val chairs_EN = "Chairs"
    fun chairs(language: Language): String {
        return when (language) {
            Language.DE -> chairs_DE
            Language.EN -> chairs_EN
        }
    }

    private const val closets_DE = "Schränke"
    private const val closets_EN = "Closets"
    fun closets(language: Language): String {
        return when (language) {
            Language.DE -> closets_DE
            Language.EN -> closets_EN
        }
    }

    private const val crime_scene_sites_DE = "Tatortbereiche"
    private const val crime_scene_sites_EN = "Crime Scene Sites"
    fun crimeSceneSites(language: Language): String {
        return when (language) {
            Language.DE -> crime_scene_sites_DE
            Language.EN -> crime_scene_sites_EN
        }
    }

    private const val doors_DE = "Türen"
    private const val doors_EN = "Doors"
    fun doors(language: Language): String {
        return when (language) {
            Language.DE -> doors_DE
            Language.EN -> doors_EN
        }
    }

    private const val electronics_DE = "Elektronische Geräte"
    private const val electronics_EN = "Electronics"
    fun electronics(language: Language): String {
        return when (language) {
            Language.DE -> electronics_DE
            Language.EN -> electronics_EN
        }
    }

    private const val evidence_sites_DE = "Spurenbereiche"
    private const val evidence_sites_EN = "Evidence Sites"
    fun evidenceSites(language: Language): String {
        return when (language) {
            Language.DE -> evidence_sites_DE
            Language.EN -> evidence_sites_EN
        }
    }

    private const val explosive_devices_DE = "Spreng- / Brandvorrichtungen"
    private const val explosive_devices_EN = "Explosive Devices"
    fun explosiveDevices(language: Language): String {
        return when (language) {
            Language.DE -> explosive_devices_DE
            Language.EN -> explosive_devices_EN
        }
    }

    private const val explosive_substances_DE = "Explosivgefährliche Stoffe"
    private const val explosive_substances_EN = "Explosive Substances"
    fun explosiveSubstances(language: Language): String {
        return when (language) {
            Language.DE -> explosive_substances_DE
            Language.EN -> explosive_substances_EN
        }
    }

    private const val firearms_DE = "Schusswaffen"
    private const val firearms_EN = "Firearms"
    fun firearms(language: Language): String {
        return when (language) {
            Language.DE -> firearms_DE
            Language.EN -> firearms_EN
        }
    }

    private const val floor_DE = "Stockwerk"
    private const val floor_EN = "Floor"
    fun floor(language: Language): String {
        return when (language) {
            Language.DE -> floor_DE
            Language.EN -> floor_EN
        }
    }

    private const val furniture_DE = "Möbel / Einrichtungsgegenstände"
    private const val furniture_EN = "Furniture"
    fun furniture(language: Language): String {
        return when (language) {
            Language.DE -> furniture_DE
            Language.EN -> furniture_EN
        }
    }

    private const val motor_vehicles_DE = "Kraftfahrzeuge"
    private const val motor_vehicles_EN = "Motor Vehicles"
    fun motorVehicles(language: Language): String {
        return when (language) {
            Language.DE -> motor_vehicles_DE
            Language.EN -> motor_vehicles_EN
        }
    }

    private const val objects_DE = "Gegenstände"
    private const val objects_EN = "Objects"
    fun objects(language: Language): String {
        return when (language) {
            Language.DE -> objects_DE
            Language.EN -> objects_EN
        }
    }

    private const val other_sites_DE = "Sonstige Bereiche"
    private const val other_sites_EN = "Other Sites"
    fun otherSites(language: Language): String {
        return when (language) {
            Language.DE -> other_sites_DE
            Language.EN -> other_sites_EN
        }
    }

    private const val other_vehicles_DE = "Sonstige Fahrzeuge"
    private const val other_vehicles_EN = "Other Vehicles"
    fun otherVehicles(language: Language): String {
        return when (language) {
            Language.DE -> other_vehicles_DE
            Language.EN -> other_vehicles_EN
        }
    }

    private const val persons_DE = "Personen"
    private const val persons_EN = "Persons"
    fun persons(language: Language): String {
        return when (language) {
            Language.DE -> persons_DE
            Language.EN -> persons_EN
        }
    }

    private const val portable_objects_DE = "Tragbare Gegenstände"
    private const val portable_objects_EN = "Portable Objects"
    fun portableObjects(language: Language): String {
        return when (language) {
            Language.DE -> portable_objects_DE
            Language.EN -> portable_objects_EN
        }
    }

    private const val rail_vehicles_DE = "Schienenfahrzeuge"
    private const val rail_vehicles_EN = "Rail vehicles"
    fun railVehicles(language: Language): String {
        return when (language) {
            Language.DE -> rail_vehicles_DE
            Language.EN -> rail_vehicles_EN
        }
    }

    private const val room_DE = "Raum"
    private const val room_EN = "Room"
    fun room(language: Language): String {
        return when (language) {
            Language.DE -> room_DE
            Language.EN -> room_EN
        }
    }

    private const val some_objects_DE = "Sonstige Gegenstände"
    private const val some_objects_EN = "Objects"
    fun someObjects(language: Language): String {
        return when (language) {
            Language.DE -> some_objects_DE
            Language.EN -> some_objects_EN
        }
    }

    private const val tables_DE = "Tische"
    private const val tables_EN = "Tables"
    fun tables(language: Language): String {
        return when (language) {
            Language.DE -> tables_DE
            Language.EN -> tables_EN
        }
    }

    private const val traces_DE = "Spuren"
    private const val traces_EN = "Traces"
    fun traces(language: Language): String {
        return when (language) {
            Language.DE -> traces_DE
            Language.EN -> traces_EN
        }
    }


    private const val vehicles_DE = "Fahrzeuge"
    private const val vehicles_EN = "Vehicles"
    fun vehicles(language: Language): String {
        return when (language) {
            Language.DE -> vehicles_DE
            Language.EN -> vehicles_EN
        }
    }

    private const val watercraft_DE = "Wasserfahrzeuge"
    private const val watercraft_EN = "Watercraft"
    fun watercraft(language: Language): String {
        return when (language) {
            Language.DE -> watercraft_DE
            Language.EN -> watercraft_EN
        }
    }

    private const val weapon_DE = "Waffen"
    private const val weapon_EN = "Weapons"
    fun weapons(language: Language): String {
        return when (language) {
            Language.DE -> weapon_DE
            Language.EN -> weapon_EN
        }
    }

    private const val weapon_parts_DE = "Waffenteile"
    private const val weapon_parts_EN = "Weapon Parts"
    fun weaponParts(language: Language): String {
        return when (language) {
            Language.DE -> weapon_parts_DE
            Language.EN -> weapon_parts_EN
        }
    }

    private const val weapons_of_mass_destruction_DE = "Massenvernichtungswaffen"
    private const val weapons_of_mass_destruction_EN = "Weapons of Mass Destruction"
    fun weaponsOfMassDestruction(language: Language): String {
        return when (language) {
            Language.DE -> weapons_of_mass_destruction_DE
            Language.EN -> weapons_of_mass_destruction_EN
        }
    }

    private const val weapon_systems_DE = "Waffensysteme"
    private const val weapon_systems_EN = "Weapon Systems"
    fun weaponSystems(language: Language): String {
        return when (language) {
            Language.DE -> weapon_systems_DE
            Language.EN -> weapon_systems_EN
        }
    }

    private const val windows_DE = "Fenster"
    private const val windows_EN = "Windows"
    fun windows(language: Language): String {
        return when (language) {
            Language.DE -> windows_DE
            Language.EN -> windows_EN
        }
    }
}